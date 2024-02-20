package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.dto.CharacterItemEquipment
import com.bodan.maplecalendar.data.dto.CharacterStat
import com.bodan.maplecalendar.data.dto.CharacterStatInfo
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertPowerFormat
import com.bodan.maplecalendar.presentation.character.CharacterUiEvent
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiEvent
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

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

    private val _characterLevel = MutableStateFlow<String>("")
    val characterLevel = _characterLevel.asStateFlow()

    private val _characterStat = MutableStateFlow<CharacterStat?>(null)
    val characterStat = _characterStat.asStateFlow()

    private val _characterStatInfo = MutableStateFlow<CharacterStatInfo>(CharacterStatInfo())
    val characterStatInfo = _characterStatInfo.asStateFlow()

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
                    getCharacterStat()
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
                        _characterLevel.value = characterBasic.characterLevel.toString()
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
                        characterStat.finalStats.forEach { finalStat ->
                            when (finalStat.statName) {
                                "전투력" -> {
                                    _characterStatInfo.update {
                                        it.copy(characterPower = convertPowerFormat(finalStat.statValue))
                                    }
                                    Timber.d(_characterStatInfo.value.characterPower)
                                }

                                "STR" -> {
                                    _characterStatInfo.value.characterStr = finalStat.statValue
                                }

                                "DEX" -> {
                                    _characterStatInfo.value.characterDex = finalStat.statValue
                                }

                                "INT" -> {
                                    _characterStatInfo.value.characterInt = finalStat.statValue
                                }

                                "LUK" -> {
                                    _characterStatInfo.value.characterLuk = finalStat.statValue
                                }

                                "HP" -> {
                                    _characterStatInfo.value.characterHp = finalStat.statValue
                                }

                                "MP" -> {
                                    _characterStatInfo.value.characterMp = finalStat.statValue
                                }

                                "최대 스탯공격력" -> {
                                    _characterStatInfo.value.characterStatPower =
                                        convertPowerFormat(finalStat.statValue)
                                }

                                "데미지" -> {
                                    _characterStatInfo.value.characterDamage = finalStat.statValue
                                }

                                "최종 데미지" -> {
                                    _characterStatInfo.value.characterFinalDamage = finalStat.statValue
                                }

                                "보스 몬스터 데미지" -> {
                                    _characterStatInfo.value.characterBossDamage = finalStat.statValue
                                }

                                "방어율 무시" -> {
                                    _characterStatInfo.value.characterIgnoreMonsterArmor =
                                        finalStat.statValue
                                }

                                "일반 몬스터 데미지" -> {
                                    _characterStatInfo.value.characterNormalDamage = finalStat.statValue
                                }

                                "공격력" -> {
                                    _characterStatInfo.value.characterAttackPower = finalStat.statValue
                                }

                                "크리티컬 확률" -> {
                                    _characterStatInfo.value.characterCriticalRate = finalStat.statValue
                                }

                                "마력" -> {
                                    _characterStatInfo.value.characterMagicPower = finalStat.statValue
                                }

                                "크리티컬 데미지" -> {
                                    _characterStatInfo.value.characterCriticalDamage = finalStat.statValue
                                }

                                "재사용 대기시간 감소 (초)" -> {
                                    _characterStatInfo.value.characterCooltimeReduceSec =
                                        finalStat.statValue
                                }

                                "재사용 대기시간 감소 (%)" -> {
                                    _characterStatInfo.value.characterCooltimeReducePercent =
                                        finalStat.statValue
                                }

                                "버프 지속시간" -> {
                                    _characterStatInfo.value.characterBuffPersistTime = finalStat.statValue
                                }

                                "재사용 대기시간 미적용" -> {
                                    _characterStatInfo.value.characterCooltimeCancel = finalStat.statValue
                                }

                                "속성 내성 무시" -> {
                                    _characterStatInfo.value.characterIgnoreElementResist =
                                        finalStat.statValue
                                }

                                "상태이상 추가 데미지" -> {
                                    _characterStatInfo.value.characterCrowdControlDamage =
                                        finalStat.statValue
                                }

                                "소환수 지속시간 증가" -> {
                                    _characterStatInfo.value.characterSummonTimeIncrease =
                                        finalStat.statValue
                                }

                                "메소 획득량" -> {
                                    _characterStatInfo.value.characterMesoDrop = finalStat.statValue
                                }

                                "스타포스" -> {
                                    _characterStatInfo.value.characterStarforce = finalStat.statValue
                                }

                                "아이템 드롭률" -> {
                                    _characterStatInfo.value.characterItemDrop = finalStat.statValue
                                }

                                "아케인포스" -> {
                                    _characterStatInfo.value.characterArcaneForce = finalStat.statValue
                                }

                                "추가 경험치 획득" -> {
                                    _characterStatInfo.value.characterExpUp = finalStat.statValue
                                }

                                "어센틱포스" -> {
                                    _characterStatInfo.value.characterAuthenticForce = finalStat.statValue
                                }

                                "방어력" -> {
                                    _characterStatInfo.value.characterArmor = finalStat.statValue
                                }

                                "상태이상 내성" -> {
                                    _characterStatInfo.value.characterIgnoreElementResist =
                                        finalStat.statValue
                                }

                                "이동속도" -> {
                                    _characterStatInfo.value.characterSpeed = finalStat.statValue
                                }

                                "점프력" -> {
                                    _characterStatInfo.value.characterJump = finalStat.statValue
                                }

                                "스탠스" -> {
                                    _characterStatInfo.value.characterStance = finalStat.statValue
                                }

                                "공격 속도" -> {
                                    _characterStatInfo.value.characterAttackSpeed = finalStat.statValue
                                }
                            }
                        }
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