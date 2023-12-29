package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.EventListReader
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertPowerFormat
import com.bodan.maplecalendar.presentation.calendar.CalendarUiEvent
import com.bodan.maplecalendar.presentation.calendar.CalendarUiState
import com.bodan.maplecalendar.presentation.calendar.DayType
import com.bodan.maplecalendar.presentation.calendar.OnDateClickListener
import com.bodan.maplecalendar.presentation.lobby.EventItem
import com.bodan.maplecalendar.presentation.lobby.LobbyUiEvent
import com.bodan.maplecalendar.presentation.setting.CharacterNameValidState
import com.bodan.maplecalendar.presentation.setting.SettingUiEvent
import com.bodan.maplecalendar.presentation.setting.SettingUiState
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

class MainViewModel : ViewModel(), OnDateClickListener {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val eventListReader = EventListReader()

    private val days = listOf<String>("일", "월", "화", "수", "목", "금", "토")

    private val _currentYear = MutableStateFlow<Int>(0)
    val currentYear = _currentYear.asStateFlow()

    private val _currentMonth = MutableStateFlow<Int>(0)
    val currentMonth = _currentMonth.asStateFlow()

    private val _today = MutableStateFlow<String>("")
    val today = _today.asStateFlow()

    private val _todayFormatted = MutableStateFlow<String>("")
    val todayFormatted = _todayFormatted.asStateFlow()

    private val yesterdayFormatted = MutableStateFlow<String>("")

    private val _eventItems = MutableStateFlow<List<EventItem>>(listOf())
    val eventItems = _eventItems.asStateFlow()

    private val _specificDate = MutableStateFlow<String>("")
    val specificDate = _specificDate.asStateFlow()

    private val _eventItemsOfDate = MutableStateFlow<List<EventItem>>(listOf())
    val eventItemsOfDate = _eventItemsOfDate.asStateFlow()

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

    private val _calendarData = MutableStateFlow<List<CalendarUiState>>(listOf())
    val calendarData = _calendarData.asStateFlow()

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
        setCalendarDate()
    }

    override fun onClicked(calendarDate: CalendarUiState.CalendarDate) {
        val date = calendarDate.name
        _specificDate.value = "${_currentYear.value}년 ${_currentMonth.value}월 ${date}일"
        val specificDay =
            _currentYear.value.toString().padStart(4, '0') + "-" + _currentMonth.value.toString()
                .padStart(2, '0') + "-" + date.padStart(2, '0')

        viewModelScope.launch {
            _calendarUiEvent.emit(CalendarUiEvent.GetEventsOfDate)
            val eventListOfDate = async { eventListReader.getEventListOfDate(specificDay) }.await()
            if (eventListOfDate != null) {
                _eventItemsOfDate.value = eventListOfDate.sortedBy { eventItem ->
                    eventItem.eventExp
                }
                Timber.d("${_eventItemsOfDate.value}")
            } else {
                _calendarUiEvent.emit(CalendarUiEvent.InternalServerError)
            }
        }
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

    private fun setEventList() {
        viewModelScope.launch {
            val eventList = async { eventListReader.getEventList() }.await()
            if (eventList != null) {
                _eventItems.value = eventList.sortedBy { eventItem ->
                    eventItem.eventExp
                }
            } else {
                viewModelScope.launch {
                    _lobbyUiEvent.emit(LobbyUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCalendarDate() {
        val newCalendar = Calendar.getInstance()
        val newCalendarData: MutableList<CalendarUiState> =
            MutableList(7 * 7) { CalendarUiState.CalendarHeader(DayType.DEFAULT, "") }

        for (index in days.indices) {
            when (index) {
                0 -> {
                    newCalendarData[0] = CalendarUiState.CalendarHeader(DayType.SUNDAY, days[0])
                }

                6 -> {
                    newCalendarData[6] = CalendarUiState.CalendarHeader(DayType.SATURDAY, days[6])
                }

                else -> {
                    newCalendarData[index] =
                        CalendarUiState.CalendarHeader(DayType.DEFAULT, days[index])
                }
            }
        }

        var nowDate = 1
        newCalendar.set(_currentYear.value, _currentMonth.value - 1, nowDate)
        while (true) {
            Timber.d(
                "${newCalendar.get(Calendar.YEAR)}년 ${newCalendar.get(Calendar.MONTH) + 1}월 ${
                    newCalendar.get(
                        Calendar.DATE
                    )
                }일"
            )
            val nowWeek = newCalendar.get(Calendar.WEEK_OF_MONTH)
            Timber.d("Now Week: $nowWeek")
            when (val nowDay = newCalendar.get(Calendar.DAY_OF_WEEK)) {
                1 -> {
                    newCalendarData[(nowWeek * 7) + nowDay - 1] = CalendarUiState.CalendarDate(
                        DayType.SUNDAY,
                        newCalendar.get(Calendar.DATE).toString()
                    )
                }

                7 -> {
                    newCalendarData[(nowWeek * 7) + nowDay - 1] = CalendarUiState.CalendarDate(
                        DayType.SATURDAY,
                        newCalendar.get(Calendar.DATE).toString()
                    )
                }

                else -> {
                    newCalendarData[(nowWeek * 7) + nowDay - 1] = CalendarUiState.CalendarDate(
                        DayType.DEFAULT,
                        newCalendar.get(Calendar.DATE).toString()
                    )
                }
            }

            nowDate++
            if (nowDate > newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                break
            }

            newCalendar.set(_currentYear.value, _currentMonth.value - 1, nowDate)
        }

        _calendarData.value = newCalendarData
        Timber.d("${_calendarData.value}")
    }

    fun setToday(): Deferred<Unit> {
        val deferred = viewModelScope.async {
            val yesterdayTime = LocalDateTime.now().plusDays(-1)
            val todayTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE
            yesterdayFormatted.value = yesterdayTime.format(formatter)
            _todayFormatted.value = todayTime.format(formatter)
            _currentYear.value = todayTime.year
            _currentMonth.value = todayTime.monthValue

            val otherFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
            _today.value = "${todayTime.format(otherFormatter)} ${getDayOfWeek()}요일"
        }

        return deferred
    }

    fun setPrevMonth() {
        _currentMonth.value -= 1
        if (_currentMonth.value == 0) {
            _currentYear.value -= 1
            _currentMonth.value = 12
        }
        setCalendarDate()
    }

    fun setNextMonth() {
        _currentMonth.value += 1
        if (_currentMonth.value == 13) {
            _currentYear.value += 1
            _currentMonth.value = 1
        }
        setCalendarDate()
    }

    fun closeEventsOfDate() {
        viewModelScope.launch {
            _calendarUiEvent.emit(CalendarUiEvent.CloseEventsOfDate)
            _eventItemsOfDate.value = listOf()
        }
    }

    fun changeCharacterName() {
        viewModelScope.launch {
            _settingUiEvent.emit(SettingUiEvent.ChangeCharacterName)
            _newCharacterName.value = ""
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