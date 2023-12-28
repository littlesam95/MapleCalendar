package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertPowerFormat
import com.bodan.maplecalendar.presentation.calendar.CalendarUiEvent
import com.bodan.maplecalendar.presentation.lobby.EventItem
import com.bodan.maplecalendar.presentation.lobby.EventType
import com.bodan.maplecalendar.presentation.lobby.LobbyUiEvent
import com.bodan.maplecalendar.presentation.setting.CharacterNameValidState
import com.bodan.maplecalendar.presentation.setting.SettingUiEvent
import com.bodan.maplecalendar.presentation.setting.SettingUiState
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class MainViewModel : ViewModel() {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val db = Firebase.firestore

    private val _today = MutableStateFlow<String>("")
    val today = _today.asStateFlow()

    private val _todayFormatted = MutableStateFlow<String>("")
    val todayFormatted = _todayFormatted.asStateFlow()

    private val yesterdayFormatted = MutableStateFlow<String>("")

    private val _eventItems = MutableStateFlow<List<EventItem>>(listOf())
    val eventItems = _eventItems.asStateFlow()

    private val _eventEnd = MutableStateFlow<Int>(0)
    val eventEnd = _eventEnd.asStateFlow()

    private val _alarmContent = MutableStateFlow<String>("")
    val alarmContent = _alarmContent.asStateFlow()

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val _newCharacterName = MutableStateFlow<String>("")
    val newCharacterName = _newCharacterName

    private val characterOcid = MutableStateFlow<String?>(null)

    private val _characterLevel = MutableStateFlow<Int?>(null)
    val characterLevel = _characterLevel.asStateFlow()

    private val _characterClass = MutableStateFlow<String?>(null)
    val characterClass = _characterClass.asStateFlow()

    private val _characterWorld = MutableStateFlow<String?>(null)
    val characterWorld = _characterWorld.asStateFlow()

    private val _characterGuild = MutableStateFlow<String?>(null)
    val characterGuild = _characterGuild.asStateFlow()

    private val _characterImage = MutableStateFlow<String?>(null)
    val characterImage = _characterImage.asStateFlow()

    private val _characterPower = MutableStateFlow<String?>(null)
    val characterPower = _characterPower.asStateFlow()

    private val _lobbyUiEvent = MutableSharedFlow<LobbyUiEvent>()
    val lobbyUiEvent = _lobbyUiEvent.asSharedFlow()

    private val _calendarUiEvent = MutableSharedFlow<CalendarUiEvent>()
    val calendarUiEvent = _calendarUiEvent.asSharedFlow()

    private val _settingUiEvent = MutableSharedFlow<SettingUiEvent>()
    val settingUiEvent = _settingUiEvent.asSharedFlow()

    private val _settingUiState = MutableStateFlow<SettingUiState>(SettingUiState())
    val settingUiState = _settingUiState.asStateFlow()

    init {
        runBlocking {
            setToday().await()
        }
        setCharacterName()
        getCharacterOcid()
        setEventList()
    }

    fun setToday(): Deferred<Unit> {
        val deferred = viewModelScope.async {
            val yesterdayTime = LocalDateTime.now().plusDays(-1)
            val todayTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE
            yesterdayFormatted.value = yesterdayTime.format(formatter)
            _todayFormatted.value = todayTime.format(formatter)

            val otherFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
            _today.value = "${yesterdayTime.format(otherFormatter)} ${getDayOfWeek()}요일"
        }

        return deferred
    }

    private fun getDayOfWeek(): String {
        when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            1 -> {
                return MainApplication.myContext().getString(R.string.text_sunday)
            }

            2 -> {
                return MainApplication.myContext().getString(R.string.text_monday)
            }

            3 -> {
                return MainApplication.myContext().getString(R.string.text_tuesday)
            }

            4 -> {
                return MainApplication.myContext().getString(R.string.text_wednesday)
            }

            5 -> {
                return MainApplication.myContext().getString(R.string.text_thursday)
            }

            6 -> {
                return MainApplication.myContext().getString(R.string.text_friday)
            }
        }

        return MainApplication.myContext().getString(R.string.text_saturday)
    }

    private fun initCharacterInfo() {
        _characterName.value = ""
        characterOcid.value = null
        _characterLevel.value = null
        _characterClass.value = null
        _characterWorld.value = null
        _characterGuild.value = null
        _characterImage.value = null
        _characterPower.value = null
    }

    private fun setCharacterName() {
        if (MainApplication.mySharedPreferences.getNickname("characterName", "") == "") {
            MainApplication.mySharedPreferences.setNickname("characterName", "아델")
        }
        _characterName.value = MainApplication.mySharedPreferences.getNickname("characterName", "")
    }

    private fun getCharacterOcid() {
        Timber.d("Today: ${yesterdayFormatted.value}")
        viewModelScope.launch {
            val characterOcidResponse =
                maplestoryRepository.getCharacterOcid(characterName = _characterName.value)
            when (characterOcidResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterOcidResponse.characterOcid?.let { characterOcid ->
                        this@MainViewModel.characterOcid.value = characterOcid.ocid
                    }
                    getCharacterBasic()
                    getCharacterPower()
                }

                ResponseStatus.BAD_REQUEST -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun getCharacterBasic() {
        viewModelScope.launch {
            val characterBasicResponse =
                characterOcid.value?.let {
                    maplestoryRepository.getCharacterBasic(
                        ocid = it,
                        date = yesterdayFormatted.value
                    )
                } ?: return@launch

            when (characterBasicResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterBasicResponse.characterBasic?.let { characterBasic ->
                        _characterLevel.value = characterBasic.characterLevel
                        _characterClass.value = characterBasic.characterClass
                        _characterWorld.value = characterBasic.worldName
                        _characterGuild.value = characterBasic.characterGuildName
                        _characterImage.value = characterBasic.characterImage
                    }
                }

                ResponseStatus.BAD_REQUEST -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun getCharacterPower() {
        viewModelScope.launch {
            val characterStatResponse =
                characterOcid.value?.let {
                    maplestoryRepository.getCharacterPower(
                        ocid = it,
                        date = yesterdayFormatted.value
                    )
                } ?: return@launch

            when (characterStatResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterStatResponse.characterStat?.let { characterStat ->
                        characterStat.finalStats.forEach { finalStat ->
                            if (finalStat.statName == "전투력") {
                                _characterPower.value = convertPowerFormat(finalStat.statValue)
                            }
                        }
                    }
                }

                ResponseStatus.BAD_REQUEST -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _lobbyUiEvent.emit(LobbyUiEvent.InternalServerError)
                }
            }
        }
    }

    fun setEventList() {
        val newEvents = mutableListOf<EventItem>()
        db.collection("EventList")
            .get()
            .addOnSuccessListener { result ->
                for (element in result) {
                    val newEvent = EventItem(
                        eventName = element.data["eventName"].toString(),
                        eventIat = element.data["eventIat"].toString(),
                        eventExp = element.data["eventExp"].toString(),
                        eventType = when (element.data["eventType"].toString()) {
                            "BURNING" -> {
                                EventType.BURNING
                            }

                            "COORDINATE" -> {
                                EventType.COORDINATE
                            }

                            "PCROOM" -> {
                                EventType.PCROOM
                            }

                            "COINSHOP" -> {
                                EventType.COINSHOP
                            }

                            "CASH" -> {
                                EventType.CASH
                            }

                            "WORLDLEAP" -> {
                                EventType.WORLDLEAP
                            }

                            "EVENTWORLD" -> {
                                EventType.EVENTWORLD
                            }

                            "HUNTING" -> {
                                EventType.HUNTING
                            }

                            else -> {
                                EventType.DEFAULT
                            }
                        }
                    )
                    newEvents.add(newEvent)
                    if (newEvent.eventExp == _todayFormatted.value) {
                        _eventEnd.value += 1
                    }
                }
                _eventItems.value = newEvents.sortedBy { eventItem ->
                    eventItem.eventExp
                }
                _alarmContent.value = "${_eventEnd.value}${
                    MainApplication.myContext().getString(R.string.message_alarm_event_end)
                }"
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _lobbyUiEvent.emit(LobbyUiEvent.InternalServerError)
                }
            }
        Timber.d("Set Events")
    }

    fun changeCharacterName() {
        viewModelScope.launch {
            _settingUiEvent.emit(SettingUiEvent.ChangeCharacterName)
        }
    }

    fun validateCharacterName(characterName: CharSequence) {
        if (characterName.isBlank()) {
            _settingUiState.update { uiState ->
                uiState.copy(characterNameValidState = CharacterNameValidState.NONE)
            }
        } else {
            _settingUiState.update { uiState ->
                uiState.copy(characterNameValidState = CharacterNameValidState.VALID)
            }
        }
    }

    fun submitChangeCharacterName() {
        viewModelScope.launch {
            _characterName.value = _newCharacterName.value
            _newCharacterName.value = ""
            MainApplication.mySharedPreferences.setNickname("characterName", _characterName.value)
            _settingUiEvent.emit(SettingUiEvent.CloseChangeCharacterName)
            initCharacterInfo()
            runBlocking {
                setToday().await()
            }
            setCharacterName()
            getCharacterOcid()
            setEventList()
        }
    }

    fun setPushNotification() {
        viewModelScope.launch {
            _settingUiEvent.emit(SettingUiEvent.SetPushNotification)
        }
    }

    fun setCallAlarm() {
        viewModelScope.launch {
            _settingUiEvent.emit(SettingUiEvent.AllowPushNotification)
        }
    }

    fun setCancelAlarm() {
        viewModelScope.launch {
            _settingUiEvent.emit(SettingUiEvent.CancelPushNotification)
        }
    }
}