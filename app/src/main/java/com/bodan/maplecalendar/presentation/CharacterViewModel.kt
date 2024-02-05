package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.character.CharacterUiEvent
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val characterOcid = MutableStateFlow<String?>(null)

    private val _characterBasic = MutableStateFlow<CharacterBasic?>(null)
    val characterBasic = _characterBasic.asStateFlow()

    private val _characterUiEvent = MutableSharedFlow<CharacterUiEvent>()
    val characterUiEvent = _characterUiEvent.asSharedFlow()

    private val _equipmentUiEvent = MutableSharedFlow<EquipmentUiEvent>()
    val equipmentUiEvent = _equipmentUiEvent.asSharedFlow()

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
                        this@CharacterViewModel.characterOcid.value = characterOcid.ocid
                    }
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
}