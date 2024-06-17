package com.bodan.maplecalendar.presentation.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.CharacterAndroidInfo
import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.domain.entity.CharacterBasic
import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.CharacterSkill
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo
import com.bodan.maplecalendar.domain.usecase.GetCharacterBasicUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterDojangUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterItemEquipmentUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterPopularityUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterStatUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterUnionUseCase
import com.bodan.maplecalendar.presentation.utils.ItemEquipmentDataGenerator.itemEquipmentDataSet
import com.bodan.maplecalendar.presentation.utils.ItemEquipmentDetailOptionGenerator.itemEquipmentDetailOptionSet
import com.bodan.maplecalendar.presentation.utils.PowerFormatConverter.convertDojangFormat
import com.bodan.maplecalendar.presentation.utils.PowerFormatConverter.convertPercentFormat
import com.bodan.maplecalendar.presentation.utils.PowerFormatConverter.convertPowerFormat
import com.bodan.maplecalendar.domain.entity.Status
import com.bodan.maplecalendar.domain.usecase.GetCharacterAbilityUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterAndroidUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterHyperStatUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterLinkSkillUseCase
import com.bodan.maplecalendar.domain.usecase.GetCharacterSkillUseCase
import com.bodan.maplecalendar.domain.usecase.SetCharacterNameUseCase
import com.bodan.maplecalendar.domain.usecase.SetCharacterOcidUseCase
import com.bodan.maplecalendar.domain.usecase.SetSearchDateUseCase
import com.bodan.maplecalendar.presentation.utils.SkillGenerator.hyperSkillGrades
import com.bodan.maplecalendar.presentation.utils.SkillGenerator.skillGrades
import com.bodan.maplecalendar.presentation.utils.StatGenerator.getDefaultStats
import com.bodan.maplecalendar.presentation.utils.StatGenerator.getEtcStats
import com.bodan.maplecalendar.presentation.utils.StatGenerator.getMainStats
import com.bodan.maplecalendar.presentation.views.character.CharacterUiEvent
import com.bodan.maplecalendar.presentation.views.character.CharacterUiState
import com.bodan.maplecalendar.presentation.views.character.OnCharacterClickListener
import com.bodan.maplecalendar.presentation.views.equipment.EquipmentDetailUiState
import com.bodan.maplecalendar.presentation.views.equipment.EquipmentUiEvent
import com.bodan.maplecalendar.presentation.views.equipment.EquipmentUiState
import com.bodan.maplecalendar.presentation.views.equipment.OnItemEquipmentClickListener
import com.bodan.maplecalendar.presentation.views.skill.OnSkillClickListener
import com.bodan.maplecalendar.presentation.views.skill.SkillUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterBasicUseCase: GetCharacterBasicUseCase,
    private val getCharacterStatUseCase: GetCharacterStatUseCase,
    private val getCharacterItemEquipmentUseCase: GetCharacterItemEquipmentUseCase,
    private val getCharacterUnionUseCase: GetCharacterUnionUseCase,
    private val getCharacterPopularityUseCase: GetCharacterPopularityUseCase,
    private val getCharacterDojangUseCase: GetCharacterDojangUseCase,
    private val getCharacterHyperStatUseCase: GetCharacterHyperStatUseCase,
    private val getCharacterAbilityUseCase: GetCharacterAbilityUseCase,
    private val getCharacterSkillUseCase: GetCharacterSkillUseCase,
    private val getCharacterLinkSkillUseCase: GetCharacterLinkSkillUseCase,
    private val getCharacterAndroidUseCase: GetCharacterAndroidUseCase,
    private val setCharacterNameUseCase: SetCharacterNameUseCase,
    private val setCharacterOcidUseCase: SetCharacterOcidUseCase,
    private val setSearchDateUseCase: SetSearchDateUseCase
) : ViewModel(), OnItemEquipmentClickListener, OnCharacterClickListener, OnSkillClickListener {

    private val _characterName = MutableStateFlow<String>("")
    val characterName = _characterName.asStateFlow()

    private val _characterBasic = MutableStateFlow<CharacterBasic?>(null)
    val characterBasic = _characterBasic.asStateFlow()

    private val _characterLevel = MutableStateFlow<String>("")
    val characterLevel = _characterLevel.asStateFlow()

    private val _characterPower = MutableStateFlow<String>("")
    val characterPower = _characterPower.asStateFlow()

    private val _characterDefaultStatData =
        MutableStateFlow<List<CharacterUiState.CharacterDefaultStat>>(listOf())
    val characterDefaultStatData = _characterDefaultStatData.asStateFlow()

    private val _characterMainStatData =
        MutableStateFlow<List<CharacterUiState.CharacterMainStat>>(listOf())
    val characterMainStatData = _characterMainStatData.asStateFlow()

    private val characterCooltimeReduceSec = MutableStateFlow<String>("")

    private val characterCooltimeReducePercent = MutableStateFlow<String>("")

    private val _characterEtcStatData =
        MutableStateFlow<List<CharacterUiState.CharacterEtcStat>>(listOf())
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

    private val _characterItemEquipmentData =
        MutableStateFlow<List<EquipmentUiState.EquipmentOption>>(listOf())
    val characterItemEquipmentData = _characterItemEquipmentData.asStateFlow()

    private val _characterItemEquipmentPreset = MutableStateFlow<Int>(0)
    val characterItemEquipmentPreset = _characterItemEquipmentPreset.asStateFlow()

    private val _characterLastItemEquipment =
        MutableStateFlow<EquipmentUiState.EquipmentOption?>(null)
    val characterLastItemEquipment = _characterLastItemEquipment.asStateFlow()

    private val _characterLastItemEquipmentOptions =
        MutableStateFlow<List<EquipmentDetailUiState?>?>(null)
    val characterListItemEquipmentOptions = _characterLastItemEquipmentOptions.asStateFlow()

    private val isCharacterItemEquipmentSelected = MutableStateFlow<Boolean>(false)

    private val _characterHyperStat = MutableStateFlow<CharacterHyperStat?>(null)
    val characterHyperStat = _characterHyperStat.asStateFlow()

    private val _characterHyperStatRemainPoint = MutableStateFlow<String>("0")
    val characterHyperStatRemainPoint = _characterHyperStatRemainPoint.asStateFlow()

    private val _characterAbility = MutableStateFlow<CharacterAbility?>(null)
    val characterAbility = _characterAbility.asStateFlow()

    private val _characterSkills = MutableStateFlow<List<CharacterSkill>>(listOf())
    val characterSkills = _characterSkills.asStateFlow()

    private val _characterSelectedSkill = MutableStateFlow<CharacterSkillInfo?>(null)
    val characterSelectedSkill = _characterSelectedSkill.asStateFlow()

    private val _characterHyperSkills = MutableStateFlow<List<CharacterSkill>>(listOf())
    val characterHyperSkills = _characterHyperSkills.asStateFlow()

    private val _characterLinkSkills = MutableStateFlow<List<List<CharacterSkillInfo>>>(listOf())
    val characterLinkSkills = _characterLinkSkills.asStateFlow()

    private val _characterOwnedLinkSkill = MutableStateFlow<CharacterSkillInfo?>(null)
    val characterOwnedLinkSkill = _characterOwnedLinkSkill.asStateFlow()

    private val characterAndroids = MutableStateFlow<List<CharacterAndroidInfo?>>(listOf())

    private val _characterUiEvent = MutableSharedFlow<CharacterUiEvent>()
    val characterUiEvent = _characterUiEvent.asSharedFlow()

    private val _equipmentUiEvent = MutableSharedFlow<EquipmentUiEvent>()
    val equipmentUiEvent = _equipmentUiEvent.asSharedFlow()

    private val _skillUiEvent = MutableSharedFlow<SkillUiEvent>()
    val skillUiEvent = _skillUiEvent.asSharedFlow()

    override fun onItemEquipmentClicked(item: EquipmentUiState.EquipmentOption) {
        if ((!isCharacterItemEquipmentSelected.value) && (item.itemName != null)) {
            viewModelScope.launch {
                async {
                    _equipmentUiEvent.emit(EquipmentUiEvent.WaitItemEquipmentDetail)
                }.await()
                async {
                    isCharacterItemEquipmentSelected.value = true
                    _characterLastItemEquipment.value = null
                    _characterLastItemEquipmentOptions.value = null
                    _characterLastItemEquipment.value = item
                    if (item.itemTitle != "ANDROID") {
                        _characterLastItemEquipmentOptions.value = itemEquipmentDetailOptionSet(
                            item.itemTotalOption,
                            item.itemBaseOption,
                            item.itemAddOption,
                            item.itemEtcOption,
                            item.itemStarforceOption,
                            item.itemExceptionalOption
                        )
                    }
                }.await()
                async {
                    when (item.itemTitle) {
                        "ANDROID" -> _equipmentUiEvent.emit(EquipmentUiEvent.GetAndroidDetail)

                        else -> _equipmentUiEvent.emit(EquipmentUiEvent.GetItemEquipmentDetail)
                    }
                }.await()
            }
        }
    }

    override fun onItemEquipmentDetailClicked() {
        viewModelScope.launch {
            _equipmentUiEvent.emit(EquipmentUiEvent.CloseItemEquipmentDetail)
            isCharacterItemEquipmentSelected.value = false
        }
    }

    override fun onHyperStatClicked() {
        viewModelScope.launch {
            _characterUiEvent.emit(CharacterUiEvent.GetHyperStat)
        }
    }

    override fun onAbilityClicked() {
        viewModelScope.launch {
            _characterUiEvent.emit(CharacterUiEvent.GetAbility)
        }
    }

    override fun onSkillClicked(skillInfo: CharacterSkillInfo) {
        viewModelScope.launch {
            if (_characterSelectedSkill.value == null) {
                when (skillInfo.skillName) {
                    "링크 매니지먼트" -> _skillUiEvent.emit(SkillUiEvent.GetLinkSkill)

                    else -> {
                        _characterSelectedSkill.value = skillInfo
                        _skillUiEvent.emit(SkillUiEvent.GetSkillDetail)
                    }
                }
            }
        }
    }

    override fun onHyperSkillClicked(skillInfo: CharacterSkillInfo) {
        viewModelScope.launch {
            if (_characterSelectedSkill.value == null) {
                _characterSelectedSkill.value = skillInfo
                _skillUiEvent.emit(SkillUiEvent.GetHyperSkillDetail)
            }
        }
    }

    override fun onLinkSkillClicked(skillInfo: CharacterSkillInfo) {
        viewModelScope.launch {
            if (_characterSelectedSkill.value == null) {
                _characterSelectedSkill.value = skillInfo
                _skillUiEvent.emit(SkillUiEvent.GetLinkSkillDetail)
            }
        }
    }

    private suspend fun getCharacterName(): Flow<String> = flow {
        val name = setCharacterNameUseCase.getCharacterName().first()
        emit(name)
    }

    private suspend fun getCharacterOcid(): Flow<String> = flow {
        val ocid = setCharacterOcidUseCase.getCharacterOcid().first()
        emit(ocid)
    }

    private suspend fun getSearchDate(): Flow<String?> = flow {
        val date = setSearchDateUseCase.getSearchDate().first()
        emit(date)
    }

    private fun setCharacterBasic(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterBasicResponse =
                getCharacterBasicUseCase.getCharacterBasic(ocid, searchDate)
            when (characterBasicResponse.status) {
                Status.SUCCESS -> {
                    characterBasicResponse.data?.let { characterBasic ->
                        _characterBasic.value = characterBasic
                        _characterLevel.value = characterBasic.characterLevel
                    }
                }

                else -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterStat(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterStatResponse = getCharacterStatUseCase.getCharacterStat(ocid, searchDate)
            when (characterStatResponse.status) {
                Status.SUCCESS -> {
                    characterStatResponse.data?.let { finalStats ->
                        val newCharacterDefaultStatData = getDefaultStats(finalStats)
                        val newCharacterMainStatData = getMainStats(finalStats)
                        val newCharacterEtcStatData = getEtcStats(finalStats)

                        finalStats.forEach { finalStat ->
                            when (finalStat.statName) {
                                "전투력" -> {
                                    _characterPower.value = convertPowerFormat(finalStat.statValue)
                                }

                                "재사용 대기시간 감소 (초)" -> {
                                    characterCooltimeReduceSec.value = "${finalStat.statValue}초"
                                }

                                "재사용 대기시간 감소 (%)" -> {
                                    characterCooltimeReducePercent.value =
                                        convertPercentFormat(finalStat.statValue)
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

                else -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterEquipment(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterItemEquipmentResponse =
                getCharacterItemEquipmentUseCase.getCharacterItemEquipment(ocid, searchDate)
            when (characterItemEquipmentResponse.status) {
                Status.SUCCESS -> {
                    characterItemEquipmentResponse.data?.let { characterItemEquipment ->
                        this@CharacterViewModel.characterItemEquipment.value =
                            characterItemEquipment
                        _characterItemEquipmentData.value =
                            itemEquipmentDataSet(characterItemEquipment.itemEquipmentsFirstPreset)
                        _characterItemEquipmentPreset.value = 1
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterUnion(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterUnionResponse =
                getCharacterUnionUseCase.getCharacterUnion(ocid, searchDate)
            when (characterUnionResponse.status) {
                Status.SUCCESS -> {
                    characterUnionResponse.data?.let { characterUnion ->
                        this@CharacterViewModel.characterUnion.value = characterUnion
                        _characterUnionLevel.value = characterUnion.characterUnionLevel.toString()
                    }
                }

                else -> {
                    _characterUiEvent.emit(CharacterUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterPopularity(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterPopularityResponse =
                getCharacterPopularityUseCase.getCharacterPopularity(ocid, searchDate)
            when (characterPopularityResponse.status) {
                Status.SUCCESS -> {
                    characterPopularityResponse.data?.let { characterPopularity ->
                        this@CharacterViewModel.characterPopularity.value = characterPopularity
                        _characterPopularityPoint.value =
                            characterPopularity.characterPopularity.toString()
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterDojang(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterDojangResponse =
                getCharacterDojangUseCase.getCharacterDojang(ocid, searchDate)
            when (characterDojangResponse.status) {
                Status.SUCCESS -> {
                    characterDojangResponse.data?.let { characterDojang ->
                        this@CharacterViewModel.characterDojang.value = characterDojang
                        _characterDojangBestFloor.value =
                            convertDojangFormat(characterDojang.characterDojangBestFloor)
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterHyperStat(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterHyperStatResponse =
                getCharacterHyperStatUseCase.getCharacterHyperStat(ocid, searchDate)
            when (characterHyperStatResponse.status) {
                Status.SUCCESS -> {
                    characterHyperStatResponse.data?.let { characterHyperStat ->
                        this@CharacterViewModel._characterHyperStat.value = characterHyperStat
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterAbility(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterAbilityResponse =
                getCharacterAbilityUseCase.getCharacterAbility(ocid, searchDate)
            when (characterAbilityResponse.status) {
                Status.SUCCESS -> {
                    characterAbilityResponse.data?.let { characterAbility ->
                        this@CharacterViewModel._characterAbility.value = characterAbility
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterSkill(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val newCharacterSkills = mutableListOf<CharacterSkill>()
            for (grade in skillGrades) {
                val characterSkillResponse =
                    getCharacterSkillUseCase.getCharacterSkill(ocid, searchDate, grade)
                when (characterSkillResponse.status) {
                    Status.SUCCESS -> {
                        characterSkillResponse.data?.let { characterSkill ->
                            if (characterSkill.characterSkillGrade != null) {
                                newCharacterSkills.add(characterSkill)
                            }
                        }
                    }

                    else -> {
                        _skillUiEvent.emit(SkillUiEvent.InternalServerError)
                    }
                }
            }

            _characterSkills.value = newCharacterSkills

            val newCharacterHyperSkills = mutableListOf<CharacterSkill>()
            for (grade in hyperSkillGrades) {
                val characterSkillResponse =
                    getCharacterSkillUseCase.getCharacterSkill(ocid, searchDate, grade)
                when (characterSkillResponse.status) {
                    Status.SUCCESS -> {
                        characterSkillResponse.data?.let { characterSkill ->
                            if (characterSkill.characterSkillGrade != null) {
                                newCharacterHyperSkills.add(characterSkill)
                            }
                        }
                    }

                    else -> {
                        _skillUiEvent.emit(SkillUiEvent.InternalServerError)
                    }
                }
            }

            _characterHyperSkills.value = newCharacterHyperSkills
        }
    }

    private fun setCharacterLinkSkill(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterLinkSkillResponse =
                getCharacterLinkSkillUseCase.getCharacterLinkSkill(ocid, searchDate)
            when (characterLinkSkillResponse.status) {
                Status.SUCCESS -> {
                    characterLinkSkillResponse.data?.let { characterLinkSkill ->
                        _characterLinkSkills.value = characterLinkSkill.characterLinkSkills
                        _characterOwnedLinkSkill.value = characterLinkSkill.characterOwnedLinkSkill
                    }
                }

                else -> {
                    _skillUiEvent.emit(SkillUiEvent.InternalServerError)
                }
            }
        }
    }

    private fun setCharacterAndroid(ocid: String, searchDate: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterAndroidResponse =
                getCharacterAndroidUseCase.getCharacterAndroid(ocid, searchDate)
            when (characterAndroidResponse.status) {
                Status.SUCCESS -> {
                    characterAndroidResponse.data?.let { characterAndroid ->
                        characterAndroids.value = characterAndroid.androids
                        characterAndroids.value[0]?.let { androidInfo ->
                            val newCharacterItemEquipmentData =
                                _characterItemEquipmentData.value.toMutableList()
                            newCharacterItemEquipmentData[28] = EquipmentUiState.EquipmentOption(
                                itemTitle = "ANDROID",
                                itemEquipmentPart = "안드로이드",
                                equipmentSlot = "안드로이드",
                                itemName = androidInfo.androidName,
                                itemShapeIcon = androidInfo.androidIcon,
                                itemDescription = androidInfo.androidDescription,
                                itemScrollUpgradableCount = androidInfo.androidGrade,
                                potentialOptionFirst = androidInfo.androidHair.hairName,
                                potentialOptionSecond = androidInfo.androidFace.faceName,
                                potentialOptionThird = androidInfo.androidSkinName
                            )
                            _characterItemEquipmentData.value = newCharacterItemEquipmentData
                        }
                    }
                }

                else -> {
                    _equipmentUiEvent.emit(EquipmentUiEvent.InternalServerError)
                }
            }
        }
    }

    fun initState() {
        viewModelScope.launch(Dispatchers.IO) {
            _characterName.value = getCharacterName().first()
            launch {
                setCharacterBasic(getCharacterOcid().first(), getSearchDate().first())
                setCharacterStat(getCharacterOcid().first(), getSearchDate().first())
                setCharacterEquipment(getCharacterOcid().first(), getSearchDate().first())
                setCharacterUnion(getCharacterOcid().first(), getSearchDate().first())
                setCharacterPopularity(getCharacterOcid().first(), getSearchDate().first())
                setCharacterDojang(getCharacterOcid().first(), getSearchDate().first())
                setCharacterHyperStat(getCharacterOcid().first(), getSearchDate().first())
                setCharacterAbility(getCharacterOcid().first(), getSearchDate().first())
                setCharacterSkill(getCharacterOcid().first(), getSearchDate().first())
                setCharacterLinkSkill(getCharacterOcid().first(), getSearchDate().first())
            }.join()
            launch {
                setCharacterAndroid(getCharacterOcid().first(), getSearchDate().first())
            }
        }
    }

    fun setCharacterEquipmentFirstPreset() {
        characterItemEquipment.value?.let { characterItemEquipment ->
            _characterItemEquipmentData.value =
                itemEquipmentDataSet(characterItemEquipment.itemEquipmentsFirstPreset)
            characterAndroids.value[0]?.let { androidInfo ->
                val newCharacterItemEquipmentData =
                    _characterItemEquipmentData.value.toMutableList()
                newCharacterItemEquipmentData[28] = EquipmentUiState.EquipmentOption(
                    itemTitle = "ANDROID",
                    itemEquipmentPart = "안드로이드",
                    equipmentSlot = "안드로이드",
                    itemName = androidInfo.androidName,
                    itemShapeIcon = androidInfo.androidIcon,
                    itemDescription = androidInfo.androidDescription,
                    itemScrollUpgradableCount = androidInfo.androidGrade,
                    potentialOptionFirst = androidInfo.androidHair.hairName,
                    potentialOptionSecond = androidInfo.androidFace.faceName,
                    potentialOptionThird = androidInfo.androidSkinName
                )
                _characterItemEquipmentData.value = newCharacterItemEquipmentData
            }
            _characterItemEquipmentPreset.value = 1
        }
    }

    fun setCharacterEquipmentSecondPreset() {
        characterItemEquipment.value?.let { characterItemEquipment ->
            _characterItemEquipmentData.value =
                itemEquipmentDataSet(characterItemEquipment.itemEquipmentsSecondPreset)
            characterAndroids.value[1]?.let { androidInfo ->
                val newCharacterItemEquipmentData =
                    _characterItemEquipmentData.value.toMutableList()
                newCharacterItemEquipmentData[28] = EquipmentUiState.EquipmentOption(
                    itemTitle = "ANDROID",
                    itemEquipmentPart = "안드로이드",
                    equipmentSlot = "안드로이드",
                    itemName = androidInfo.androidName,
                    itemShapeIcon = androidInfo.androidIcon,
                    itemDescription = androidInfo.androidDescription,
                    itemScrollUpgradableCount = androidInfo.androidGrade,
                    potentialOptionFirst = androidInfo.androidHair.hairName,
                    potentialOptionSecond = androidInfo.androidFace.faceName,
                    potentialOptionThird = androidInfo.androidSkinName
                )
                _characterItemEquipmentData.value = newCharacterItemEquipmentData
            }
            _characterItemEquipmentPreset.value = 2
        }
    }

    fun setCharacterEquipmentThirdPreset() {
        characterItemEquipment.value?.let { characterItemEquipment ->
            _characterItemEquipmentData.value =
                itemEquipmentDataSet(characterItemEquipment.itemEquipmentsThirdPreset)
            characterAndroids.value[2]?.let { androidInfo ->
                val newCharacterItemEquipmentData =
                    _characterItemEquipmentData.value.toMutableList()
                newCharacterItemEquipmentData[28] = EquipmentUiState.EquipmentOption(
                    itemTitle = "ANDROID",
                    itemEquipmentPart = "안드로이드",
                    equipmentSlot = "안드로이드",
                    itemName = androidInfo.androidName,
                    itemShapeIcon = androidInfo.androidIcon,
                    itemDescription = androidInfo.androidDescription,
                    itemScrollUpgradableCount = androidInfo.androidGrade,
                    potentialOptionFirst = androidInfo.androidHair.hairName,
                    potentialOptionSecond = androidInfo.androidFace.faceName,
                    potentialOptionThird = androidInfo.androidSkinName
                )
                _characterItemEquipmentData.value = newCharacterItemEquipmentData
            }
            _characterItemEquipmentPreset.value = 3
        }
    }

    fun setCharacterHyperStatRemainPoint(preset: Int) {
        _characterHyperStat.value?.let { hyperStat ->
            _characterHyperStatRemainPoint.value =
                hyperStat.hyperStatRemainPoints[preset].toString()
        }
    }

    fun closeHyperStat() {
        viewModelScope.launch {
            _characterUiEvent.emit(CharacterUiEvent.CloseHyperStat)
        }
    }

    fun closeAbility() {
        viewModelScope.launch {
            _characterUiEvent.emit(CharacterUiEvent.CloseAbility)
        }
    }

    fun closeSkillDetail() {
        viewModelScope.launch {
            if (_characterSelectedSkill.value != null) {
                _characterSelectedSkill.value = null
                _skillUiEvent.emit(SkillUiEvent.CloseSkillDetail)
            }
        }
    }

    fun goToHyperSkill() {
        viewModelScope.launch {
            _skillUiEvent.emit(SkillUiEvent.GetHyperSkill)
        }
    }

    fun closeHyperSkill() {
        viewModelScope.launch {
            _skillUiEvent.emit(SkillUiEvent.CloseHyperSkill)
        }
    }

    fun closeLinkSkill() {
        viewModelScope.launch {
            _skillUiEvent.emit(SkillUiEvent.CloseLinkSkill)
        }
    }
}