package com.bodan.maplecalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.dto.CharacterDojang
import com.bodan.maplecalendar.data.dto.CharacterItemEquipment
import com.bodan.maplecalendar.data.dto.CharacterPopularity
import com.bodan.maplecalendar.data.dto.CharacterUnion
import com.bodan.maplecalendar.data.repository.MaplestoryRepository
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.presentation.ItemEquipmentDataGenerator.itemEquipmentDataSet
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertAttackSpeedFormat
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertCommaFormat
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertDojangFormat
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertPercentFormat
import com.bodan.maplecalendar.presentation.PowerFormatConverter.convertPowerFormat
import com.bodan.maplecalendar.presentation.character.CharacterUiEvent
import com.bodan.maplecalendar.presentation.character.CharacterUiState
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiEvent
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState
import com.bodan.maplecalendar.presentation.equipment.OnItemEquipmentClickListener
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel(), OnItemEquipmentClickListener {

    private val maplestoryRepository: MaplestoryRepository = MaplestoryRepositoryImpl()

    private val dateFormatConverter = DateFormatConverter()

    private val todayFormatted = MutableStateFlow<String>("")

    private val currentYear = MutableStateFlow<Int>(0)

    private val currentMonth = MutableStateFlow<Int>(0)

    private val today = MutableStateFlow<String>("")

    private val currentMinute = MutableStateFlow<Int>(-1)

    private val searchDate = MutableStateFlow<String>("")

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val characterOcid = MutableStateFlow<String?>(null)

    private val _characterBasic = MutableStateFlow<CharacterBasic?>(null)
    val characterBasic = _characterBasic.asStateFlow()

    private val _characterLevel = MutableStateFlow<String>("")
    val characterLevel = _characterLevel.asStateFlow()

    private val _characterPower = MutableStateFlow<String>("")
    val characterPower = _characterPower.asStateFlow()

    private val _characterDefaultStatData = MutableStateFlow<List<CharacterUiState.CharacterDefaultStat>>(listOf())
    val characterDefaultStatData = _characterDefaultStatData.asStateFlow()

    private val _characterMainStatData = MutableStateFlow<List<CharacterUiState.CharacterMainStat>>(listOf())
    val characterMainStatData = _characterMainStatData.asStateFlow()

    private val characterCooltimeReduceSec = MutableStateFlow<String>("")

    private val characterCooltimeReducePercent = MutableStateFlow<String>("")

    private val _characterEtcStatData = MutableStateFlow<List<CharacterUiState.CharacterEtcStat>>(listOf())
    val characterEtcStatData = _characterEtcStatData.asStateFlow()

    private val characterUnion = MutableStateFlow<CharacterUnion?>(null)

    private val _characterUnionLevel = MutableStateFlow<String>("")
    val characterUnionLevel = _characterUnionLevel.asStateFlow()

    private val characterPopularity = MutableStateFlow<CharacterPopularity?>(null)

    private val _characterPopularityPoint = MutableStateFlow<String>("")
    val characterPopularityPoint = _characterPopularityPoint.asStateFlow()

    private val characterDojang = MutableStateFlow<CharacterDojang?>(null)

    private val _characterDojangBestFloor = MutableStateFlow<String>("")
    val characterDojangBestFloor = _characterDojangBestFloor.asStateFlow()

    private val characterItemEquipment = MutableStateFlow<CharacterItemEquipment?>(null)

    private val _characterItemEquipmentData = MutableStateFlow<List<EquipmentUiState>>(listOf())
    val characterItemEquipmentData = _characterItemEquipmentData.asStateFlow()

    private val _characterLastItemEquipmentDefault = MutableStateFlow<EquipmentUiState.EquipmentDefault?>(null)
    val characterLastItemEquipmentDefault = _characterLastItemEquipmentDefault.asStateFlow()

    private val _characterUiEvent = MutableSharedFlow<CharacterUiEvent>()
    val characterUiEvent = _characterUiEvent.asSharedFlow()

    private val _equipmentUiEvent = MutableSharedFlow<EquipmentUiEvent>()
    val equipmentUiEvent = _equipmentUiEvent.asSharedFlow()

    override fun onItemEquipmentDefaultClicked(equipmentUiState: EquipmentUiState.EquipmentDefault) {
        viewModelScope.launch {
            _characterLastItemEquipmentDefault.value = equipmentUiState
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentDefault)
        }
    }

    override fun onItemEquipmentAndroidClicked(equipmentUiState: EquipmentUiState.EquipmentAndroid) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentAndroid)
        }
    }

    override fun onItemEquipmentBadgeClicked(equipmentUiState: EquipmentUiState.EquipmentBadge) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentBadge)
        }
    }

    override fun onItemEquipmentEmblemClicked(equipmentUiState: EquipmentUiState.EquipmentEmblem) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentEmblem)
        }
    }

    override fun onItemEquipmentHeartClicked(equipmentUiState: EquipmentUiState.EquipmentHeart) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentHeart)
        }
    }

    override fun onItemEquipmentPocketClicked(equipmentUiState: EquipmentUiState.EquipmentPocket) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentPocket)
        }
    }

    override fun onItemEquipmentSeedringClicked(equipmentUiState: EquipmentUiState.EquipmentSeedring) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentSeedring)
        }
    }

    override fun onItemEquipmentShieldClicked(equipmentUiState: EquipmentUiState.EquipmentShield) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentShield)
        }
    }

    override fun onItemEquipmentSubweaponClicked(equipmentUiState: EquipmentUiState.EquipmentSubweapon) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentSubweapon)
        }
    }

    override fun onItemEquipmentWeaponClicked(equipmentUiState: EquipmentUiState.EquipmentWeapon) {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentWeapon)
        }
    }

    private fun setToday(): Deferred<Unit> {
        val deferred = viewModelScope.async {
            todayFormatted.value = dateFormatConverter.todayFormatted()
            currentYear.value = dateFormatConverter.todayYear()
            currentMonth.value = dateFormatConverter.todayMonth()
            today.value = dateFormatConverter.todayOtherFormatted()
            currentMinute.value =
                ((dateFormatConverter.todayHour()) * 60 + dateFormatConverter.todayMinute())
            searchDate.value = when (currentMinute.value) {
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
                    getCharacterUnion()
                    getCharacterPopularity()
                    getCharacterDojang()
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
                        date = searchDate.value
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
                        date = searchDate.value
                    )
                } ?: return@launch

            when (characterStatResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterStatResponse.characterStat?.let { characterStat ->
                        val newCharacterDefaultStatData =
                            MutableList(3 * 2) { CharacterUiState.CharacterDefaultStat("", "") }
                        val newCharacterMainStatData =
                            MutableList(8 * 2) { CharacterUiState.CharacterMainStat("", "") }
                        val newCharacterEtcStatData =
                            MutableList(6 * 2) { CharacterUiState.CharacterEtcStat("", "") }

                        characterStat.finalStats.forEach { finalStat ->
                            when (finalStat.statName) {
                                "전투력" -> {
                                    _characterPower.value = convertPowerFormat(finalStat.statValue)
                                }

                                "STR" -> {
                                    newCharacterDefaultStatData[2] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "STR",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "DEX" -> {
                                    newCharacterDefaultStatData[3] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "DEX",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "INT" -> {
                                    newCharacterDefaultStatData[4] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "INT",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "LUK" -> {
                                    newCharacterDefaultStatData[5] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "LUK",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "HP" -> {
                                    newCharacterDefaultStatData[0] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "HP",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "MP" -> {
                                    newCharacterDefaultStatData[1] =
                                        CharacterUiState.CharacterDefaultStat(
                                            "MP",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "최대 스탯공격력" -> {
                                    newCharacterMainStatData[0] =
                                        CharacterUiState.CharacterMainStat(
                                            "스탯 공격력",
                                            convertPowerFormat(finalStat.statValue)
                                        )
                                }

                                "데미지" -> {
                                    newCharacterMainStatData[1] =
                                        CharacterUiState.CharacterMainStat(
                                            "데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "최종 데미지" -> {
                                    newCharacterMainStatData[2] =
                                        CharacterUiState.CharacterMainStat(
                                            "최종 데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "보스 몬스터 데미지" -> {
                                    newCharacterMainStatData[3] =
                                        CharacterUiState.CharacterMainStat(
                                            "보스 몬스터 데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "방어율 무시" -> {
                                    newCharacterMainStatData[4] =
                                        CharacterUiState.CharacterMainStat(
                                            "방어율 무시",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "일반 몬스터 데미지" -> {
                                    newCharacterMainStatData[5] =
                                        CharacterUiState.CharacterMainStat(
                                            "일반 몬스터 데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "공격력" -> {
                                    newCharacterMainStatData[6] =
                                        CharacterUiState.CharacterMainStat(
                                            "공격력",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "크리티컬 확률" -> {
                                    newCharacterMainStatData[7] =
                                        CharacterUiState.CharacterMainStat(
                                            "크리티컬 확률",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "마력" -> {
                                    newCharacterMainStatData[8] =
                                        CharacterUiState.CharacterMainStat(
                                            "마력",
                                            convertCommaFormat(finalStat.statValue)
                                        )
                                }

                                "크리티컬 데미지" -> {
                                    newCharacterMainStatData[9] =
                                        CharacterUiState.CharacterMainStat(
                                            "크리티컬 데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "재사용 대기시간 감소 (초)" -> {
                                    characterCooltimeReduceSec.value = "${finalStat.statValue}초"
                                }

                                "재사용 대기시간 감소 (%)" -> {
                                    characterCooltimeReducePercent.value =
                                        convertPercentFormat(finalStat.statValue)
                                }

                                "버프 지속시간" -> {
                                    newCharacterMainStatData[11] =
                                        CharacterUiState.CharacterMainStat(
                                            "버프 지속시간",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "재사용 대기시간 미적용" -> {
                                    newCharacterMainStatData[12] =
                                        CharacterUiState.CharacterMainStat(
                                            "재사용 대기시간 미적용",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "속성 내성 무시" -> {
                                    newCharacterMainStatData[13] =
                                        CharacterUiState.CharacterMainStat(
                                            "속성 내성 무시",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "상태이상 추가 데미지" -> {
                                    newCharacterMainStatData[14] =
                                        CharacterUiState.CharacterMainStat(
                                            "상태이상 추가 데미지",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "소환수 지속시간 증가" -> {
                                    newCharacterMainStatData[15] =
                                        CharacterUiState.CharacterMainStat(
                                            "소환수 지속시간 증가",
                                            convertPercentFormat(finalStat.statValue)
                                        )
                                }

                                "메소 획득량" -> {
                                    newCharacterEtcStatData[0] = CharacterUiState.CharacterEtcStat(
                                        "메소 획득량",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "스타포스" -> {
                                    newCharacterEtcStatData[1] = CharacterUiState.CharacterEtcStat(
                                        "스타포스",
                                        convertCommaFormat(finalStat.statValue)
                                    )
                                }

                                "아이템 드롭률" -> {
                                    newCharacterEtcStatData[2] = CharacterUiState.CharacterEtcStat(
                                        "아이템 드롭률",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "아케인포스" -> {
                                    newCharacterEtcStatData[3] = CharacterUiState.CharacterEtcStat(
                                        "아케인포스",
                                        convertCommaFormat(finalStat.statValue)
                                    )
                                }

                                "추가 경험치 획득" -> {
                                    newCharacterEtcStatData[4] = CharacterUiState.CharacterEtcStat(
                                        "추가 경험치 획득",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "어센틱포스" -> {
                                    newCharacterEtcStatData[5] = CharacterUiState.CharacterEtcStat(
                                        "어센틱포스",
                                        convertCommaFormat(finalStat.statValue)
                                    )
                                }

                                "방어력" -> {
                                    newCharacterEtcStatData[6] = CharacterUiState.CharacterEtcStat(
                                        "방어력",
                                        convertCommaFormat(finalStat.statValue)
                                    )
                                }

                                "상태이상 내성" -> {
                                    newCharacterEtcStatData[7] = CharacterUiState.CharacterEtcStat(
                                        "상태이상 내성",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "이동속도" -> {
                                    newCharacterEtcStatData[8] = CharacterUiState.CharacterEtcStat(
                                        "이동속도",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "점프력" -> {
                                    newCharacterEtcStatData[9] = CharacterUiState.CharacterEtcStat(
                                        "점프력",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "스탠스" -> {
                                    newCharacterEtcStatData[10] = CharacterUiState.CharacterEtcStat(
                                        "스탠스",
                                        convertPercentFormat(finalStat.statValue)
                                    )
                                }

                                "공격 속도" -> {
                                    newCharacterEtcStatData[11] = CharacterUiState.CharacterEtcStat(
                                        "공격 속도",
                                        convertAttackSpeedFormat(finalStat.statValue)
                                    )
                                }
                            }
                        }
                        newCharacterMainStatData[10] = CharacterUiState.CharacterMainStat(
                            "재사용 대기시간 감소",
                            "${characterCooltimeReduceSec.value} / ${characterCooltimeReducePercent.value}"
                        )
                        _characterDefaultStatData.value = newCharacterDefaultStatData
                        _characterMainStatData.value = newCharacterMainStatData
                        _characterEtcStatData.value = newCharacterEtcStatData
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
                    date = searchDate.value
                )
            } ?: return@launch

            when (characterItemEquipmentResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterItemEquipmentResponse.characterItemEquipment?.let { characterItemEquipment ->
                        this@CharacterViewModel.characterItemEquipment.value = characterItemEquipment
                        _characterItemEquipmentData.value = itemEquipmentDataSet(characterItemEquipment.itemEquipments)
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

    private fun getCharacterUnion() {
        viewModelScope.launch {
            val characterUnionResponse = characterOcid.value?.let {
                maplestoryRepository.getCharacterUnion(
                    ocid = it,
                    date = searchDate.value
                )
            } ?: return@launch

            when (characterUnionResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterUnionResponse.characterUnion?.let { characterUnion ->
                        this@CharacterViewModel.characterUnion.value = characterUnion
                        _characterUnionLevel.value = characterUnion.characterUnionLevel.toString()
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

    private fun getCharacterPopularity() {
        viewModelScope.launch {
            val characterPopularityResponse = characterOcid.value?.let {
                maplestoryRepository.getCharacterPopularity(
                    ocid = it,
                    date = searchDate.value
                )
            } ?: return@launch

            when (characterPopularityResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterPopularityResponse.characterPopularity?.let { characterPopularity ->
                        this@CharacterViewModel.characterPopularity.value = characterPopularity
                        _characterPopularityPoint.value =
                            characterPopularity.characterPopularity.toString()
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

    private fun getCharacterDojang() {
        viewModelScope.launch {
            val characterDojangResponse = characterOcid.value?.let {
                maplestoryRepository.getCharacterDojang(
                    ocid = it,
                    date = searchDate.value
                )
            } ?: return@launch

            when (characterDojangResponse.status) {
                ResponseStatus.SUCCESS -> {
                    characterDojangResponse.characterDojang?.let { characterDojang ->
                        this@CharacterViewModel.characterDojang.value = characterDojang
                        _characterDojangBestFloor.value =
                            convertDojangFormat(characterDojang.characterDojangBestFloor)
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