package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.EventListReader
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.calendar.CalendarUiEvent
import com.bodan.maplecalendar.presentation.calendar.CalendarUiState
import com.bodan.maplecalendar.presentation.calendar.DayType
import com.bodan.maplecalendar.presentation.calendar.OnDateClickListener
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiEvent
import com.bodan.maplecalendar.presentation.lobby.EventItem
import com.bodan.maplecalendar.presentation.lobby.LobbyUiEvent
import com.bodan.maplecalendar.presentation.lobby.OnEventClickListener
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
import java.util.Calendar

class MainViewModel : ViewModel(), OnDateClickListener, OnEventClickListener {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val dateFormatConverter = DateFormatConverter()

    private val eventListReader = EventListReader()

    private val days = listOf<String>("일", "월", "화", "수", "목", "금", "토")

    private val _currentYear = MutableStateFlow<Int>(0)
    val currentYear = _currentYear.asStateFlow()

    private val _currentMonth = MutableStateFlow<Int>(0)
    val currentMonth = _currentMonth.asStateFlow()

    private val _today = MutableStateFlow<String>("")
    val today = _today.asStateFlow()

    private val todayFormatted = MutableStateFlow<String>("")

    private val _searchDate = MutableStateFlow<String>("")
    val searchDate = _searchDate.asStateFlow()

    private val currentMinute = MutableStateFlow<Int>(-1)

    private val _eventItems = MutableStateFlow<List<EventItem>>(listOf())
    val eventItems = _eventItems.asStateFlow()

    private val _eventUrl = MutableStateFlow<String>("")
    val eventUrl = _eventUrl.asStateFlow()

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

    private val _characterGender = MutableStateFlow<String?>(null)
    val characterGender = _characterGender.asStateFlow()

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

    private val _equipmentUiEvent = MutableSharedFlow<EquipmentUiEvent>()
    val equipmentUiEvent = _equipmentUiEvent.asSharedFlow()

    override fun onClicked(calendarDate: CalendarUiState.CalendarDate) {
        val date = calendarDate.name
        _specificDate.value = "${_currentYear.value}년 ${_currentMonth.value}월 ${date}일"
        val specificDay =
            _currentYear.value.toString().padStart(4, '0') + "-" + _currentMonth.value.toString()
                .padStart(2, '0') + "-" + date.padStart(2, '0')

        viewModelScope.launch {
            _calendarUiEvent.emit(CalendarUiEvent.GetEventsOfDate)
            val eventListOfDate = async { eventListReader.getEventList(specificDay) }.await()
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

    override fun onEventClicked(eventUrl: String) {
        _eventUrl.value = eventUrl
        viewModelScope.launch {
            _lobbyUiEvent.emit(LobbyUiEvent.StartEventUrl)
            _calendarUiEvent.emit(CalendarUiEvent.StartEventUrl)
        }
    }

    private fun setToday(): Deferred<Unit> {
        val deferred = viewModelScope.async {
            todayFormatted.value = dateFormatConverter.todayFormatted()
            _currentYear.value = dateFormatConverter.todayYear()
            _currentMonth.value = dateFormatConverter.todayMonth()
            _today.value = dateFormatConverter.todayOtherFormatted()
            currentMinute.value =
                ((dateFormatConverter.todayHour()) * 60 + dateFormatConverter.todayMinute())
            _searchDate.value = when (currentMinute.value) {
                in 0..60 -> dateFormatConverter.twoDaysAgoFormatted()

                else -> dateFormatConverter.yesterdayFormatted()
            }
        }

        return deferred
    }

    private fun initCharacterInfo() {
        _characterName.value = ""
        characterOcid.value = null
        _characterLevel.value = null
        _characterClass.value = null
        _characterWorld.value = null
        _characterGuild.value = null
        _characterImage.value = null
        _characterGender.value = null
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
                        date = _searchDate.value
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
                        _characterGender.value = characterBasic.characterGender
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
            val eventList = async { eventListReader.getEventList(todayFormatted.value) }.await()
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
            MutableList(7 * 7) { CalendarUiState.CalendarDate(DayType.DEFAULT, "") }

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

    fun initState() {
        viewModelScope.launch {
            setToday().await()
            setCharacterName()
            getCharacterOcid()
            setEventList()
            setCalendarDate()
        }
    }

    fun goToCharacter() {
        viewModelScope.launch {
            _lobbyUiEvent.emit(LobbyUiEvent.GoToCharacter)
        }
    }

    fun setDarkMode() {
        viewModelScope.launch {
            _lobbyUiEvent.emit(LobbyUiEvent.SetDarkMode)
            _calendarUiEvent.emit(CalendarUiEvent.SetDarkMode)
            _settingUiEvent.emit(SettingUiEvent.SetDarkMode)
        }
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