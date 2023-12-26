package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.calendar.CalendarUiEvent
import com.bodan.maplecalendar.presentation.lobby.LobbyUiEvent
import com.bodan.maplecalendar.presentation.setting.SettingUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val _characterOcid = MutableStateFlow<String?>(null)
    val characterOcid = _characterOcid.asStateFlow()

    private val _characterLevel = MutableStateFlow<Int?>(null)
    val characterLevel = _characterLevel.asStateFlow()

    private val _characterClass = MutableStateFlow<String?>(null)
    val characterClass = _characterClass.asStateFlow()

    private val _characterWorld = MutableStateFlow<String?>(null)
    val characterWorld = _characterWorld.asStateFlow()

    private val _characterGuild = MutableStateFlow<String?>(null)
    val characterGuild = _characterGuild.asStateFlow()

    private val _characterPower = MutableStateFlow<String?>(null)
    val characterPower = _characterPower.asStateFlow()

    private val _characterInfo = MutableStateFlow<String?>(null)
    val characterInfo = _characterInfo.asStateFlow()

    private val _lobbyUiEvent = MutableSharedFlow<LobbyUiEvent>()
    val lobbyUiEvent = _lobbyUiEvent.asSharedFlow()

    private val _calendarUiEvent = MutableSharedFlow<CalendarUiEvent>()
    val calendarUiEvent = _calendarUiEvent.asSharedFlow()

    private val _settingUiEvent = MutableSharedFlow<SettingUiEvent>()
    val settingUiEvent = _settingUiEvent.asSharedFlow()

    init {
        setCharacterName()
        getCharacterOcid()
    }

    private fun setCharacterName() {
        MainApplication.mySharedPreferences.setNickname("characterName", "한달해")
        _characterName.value = MainApplication.mySharedPreferences.getNickname("characterName", "")
    }

    private fun getCharacterOcid() {
        viewModelScope.launch {
            val characterOcidResponse =
                maplestoryRepository.getCharacterOcid(characterName = _characterName.value)
            when (characterOcidResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterOcidResponse.characterOcid?.let { characterOcid ->
                        _characterOcid.value = characterOcid.ocid
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
                _characterOcid.value?.let {
                    maplestoryRepository.getCharacterBasic(
                        ocid = it,
                        date = "2023-12-25"
                    )
                } ?: return@launch

            when (characterBasicResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterBasicResponse.characterBasic?.let { characterBasic ->
                        _characterLevel.value = characterBasic.characterLevel
                        _characterClass.value = characterBasic.characterClass
                        _characterWorld.value = characterBasic.worldName
                        _characterGuild.value = characterBasic.characterGuildName
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
                _characterOcid.value?.let {
                    maplestoryRepository.getCharacterPower(
                        ocid = it,
                        date = "2023-12-25"
                    )
                } ?: return@launch

            when (characterStatResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterStatResponse.characterStat?.let { characterStat ->
                        characterStat.finalStats.forEach { finalStat ->
                            if (finalStat.statName == "전투력") {
                                _characterPower.value = finalStat.statValue
                            }
                        }
                        _characterInfo.value = "닉네임: ${_characterName.value}, 레벨: ${_characterLevel.value}, 월드: ${_characterWorld.value}, 길드: ${_characterGuild.value}, 전투력: ${_characterPower.value}"
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
}