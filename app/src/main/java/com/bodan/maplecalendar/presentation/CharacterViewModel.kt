package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.dto.CharacterItemEquipment
import com.bodan.maplecalendar.data.dto.CharacterStat
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.character.CharacterUiEvent
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiEvent
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val dateFormatConverter = DateFormatConverter()

    private val todayFormatted = MutableStateFlow<String>("")

    private val _currentYear = MutableStateFlow<Int>(0)
    val currentYear = _currentYear.asStateFlow()

    private val _currentMonth = MutableStateFlow<Int>(0)
    val currentMonth = _currentMonth.asStateFlow()

    private val _today = MutableStateFlow<String>("")
    val today = _today.asStateFlow()

    private val currentMinute = MutableStateFlow<Int>(-1)

    private val _searchDate = MutableStateFlow<String>("")
    val searchDate = _searchDate.asStateFlow()

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val characterOcid = MutableStateFlow<String?>(null)

    private val _characterBasic = MutableStateFlow<CharacterBasic?>(null)
    val characterBasic = _characterBasic.asStateFlow()

    private val _characterStat = MutableStateFlow<CharacterStat?>(null)
    val characterStat = _characterStat.asStateFlow()

    private val _characterItemEquipment = MutableStateFlow<CharacterItemEquipment?>(null)
    val characterItemEquipment = _characterItemEquipment.asStateFlow()

    private val _characterUiEvent = MutableSharedFlow<CharacterUiEvent>()
    val characterUiEvent = _characterUiEvent.asSharedFlow()

    private val _equipmentUiEvent = MutableSharedFlow<EquipmentUiEvent>()
    val equipmentUiEvent = _equipmentUiEvent.asSharedFlow()

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

    private fun setCharacterName() {
        _characterName.value = MainApplication.mySharedPreferences.getNickname("characterName", "")
    }

    private fun getCharacterOcid() {
        viewModelScope.launch {
            val characterOcidResponse =
                maplestoryRepository.getCharacterOcid(characterName = _characterName.value)
            when (characterOcidResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterOcidResponse.characterOcid?.let { characterOcid ->
                        this@CharacterViewModel.characterOcid.value = characterOcid.ocid
                    }
                    getCharacterBasic()
                }

                ResponseStatus.BAD_REQUEST -> {
                    _characterUiEvent.emit(CharacterUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _characterUiEvent.emit(CharacterUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _characterUiEvent.emit(CharacterUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _characterUiEvent.emit(CharacterUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
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
                        _characterBasic.value = CharacterBasic(
                            characterLevel = characterBasic.characterLevel,
                            characterClass = characterBasic.characterClass,
                            worldName = characterBasic.worldName,
                            characterGuildName = characterBasic.characterGuildName,
                            characterImage = characterBasic.characterImage,
                            characterGender = characterBasic.characterGender
                        )
                    }
                    getCharacterStat()
                }

                ResponseStatus.BAD_REQUEST -> {
                    _characterUiEvent.emit(CharacterUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _characterUiEvent.emit(CharacterUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _characterUiEvent.emit(CharacterUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _characterUiEvent.emit(CharacterUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun getCharacterStat() {
        viewModelScope.launch {
            val characterStatResponse =
                characterOcid.value?.let {
                    maplestoryRepository.getCharacterPower(
                        ocid = it,
                        date = _searchDate.value
                    )
                } ?: return@launch

            when (characterStatResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterStatResponse.characterStat?.let { characterStat ->
                        _characterStat.value = characterStat
                    }
                    getCharacterEquipment()
                }

                ResponseStatus.BAD_REQUEST -> {
                    _characterUiEvent.emit(CharacterUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _characterUiEvent.emit(CharacterUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _characterUiEvent.emit(CharacterUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _characterUiEvent.emit(CharacterUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun getCharacterEquipment() {
        viewModelScope.launch {
            val characterItemEquipmentResponse = characterOcid.value?.let {
                maplestoryRepository.getCharacterItemEquipment(
                    ocid = it,
                    date = _searchDate.value
                )
            } ?: return@launch

            when (characterItemEquipmentResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterItemEquipmentResponse.characterItemEquipment?.let { characterItemEquipment ->
                        _characterItemEquipment.value = characterItemEquipment
                    }
                }

                ResponseStatus.BAD_REQUEST -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.BadRequest)
                }

                ResponseStatus.UNAUTHORIZED_STATUS -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.UnauthorizedStatus)
                }

                ResponseStatus.FORBIDDEN -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.Forbidden)
                }

                ResponseStatus.TOO_MANY_REQUESTS -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.TooManyRequests)
                }

                ResponseStatus.INTERNAL_SERVER_ERROR -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    fun initState() {
        viewModelScope.launch {
            setToday().await()
            setCharacterName()
            getCharacterOcid()
        }
    }
}