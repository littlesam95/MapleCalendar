package com.bodan.maplecalendar.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class OcidEntity(
    @Json(name = "ocid")
    val ocid: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class BasicEntity(
    @Json(name = "character_name")
    val characterName: String = "",

    @Json(name = "world_name")
    val worldName: String = "",

    @Json(name = "character_gender")
    val characterGender: String = "",

    @Json(name = "character_class")
    val characterClass: String = "",

    @Json(name = "character_level")
    val characterLevel: Int = 0,

    @Json(name = "character_guild_name")
    val characterGuildName: String? = null,

    @Json(name = "character_image")
    val characterImage: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class StatEntity(
    @Json(name = "final_stat")
    val finalStats: List<FinalStatEntity>
)

@Keep
@JsonClass(generateAdapter = true)
data class FinalStatEntity(
    @Json(name = "stat_name")
    val statName: String,

    @Json(name = "stat_value")
    val statValue: String?
)

@Keep
@JsonClass(generateAdapter = true)
data class ItemEquipmentEntity(
    @Json(name = "item_equipment")
    val itemEquipments: List<EquipmentEntity>,

    @Json(name = "item_equipment_preset_1")
    val itemEquipmentsFirstPreset: List<EquipmentEntity>,

    @Json(name = "item_equipment_preset_2")
    val itemEquipmentsSecondPreset: List<EquipmentEntity>,

    @Json(name = "item_equipment_preset_3")
    val itemEquipmentsThirdPreset: List<EquipmentEntity>,

    @Json(name = "title")
    val itemTitle: TitleEntity?
)

@Keep
@JsonClass(generateAdapter = true)
data class EquipmentEntity(
    @Json(name = "item_equipment_part")
    val itemEquipmentPart: String,

    @Json(name = "item_equipment_slot")
    val equipmentSlot: String,

    @Json(name = "item_name")
    val itemName: String,

    @Json(name = "item_icon")
    val itemIcon: String,

    @Json(name = "item_description")
    val itemDescription: String?,

    @Json(name = "item_shape_name")
    val itemShapeName: String,

    @Json(name = "item_shape_icon")
    val itemShapeIcon: String,

    @Json(name = "item_gender")
    val itemGender: String?,

    @Json(name = "item_total_option")
    val itemTotalOption: TotalOptionEntity,

    @Json(name = "item_base_option")
    val itemBaseOption: BaseOptionEntity,

    @Json(name = "potential_option_grade")
    val potentialOptionGrade: String?,

    @Json(name = "additional_potential_option_grade")
    val additionalPotentialOptionGrade: String?,

    @Json(name = "potential_option_1")
    val potentialOptionFirst: String?,

    @Json(name = "potential_option_2")
    val potentialOptionSecond: String?,

    @Json(name = "potential_option_3")
    val potentialOptionThird: String?,

    @Json(name = "additional_potential_option_1")
    val additionalPotentialOptionFirst: String?,

    @Json(name = "additional_potential_option_2")
    val additionalPotentialOptionSecond: String?,

    @Json(name = "additional_potential_option_3")
    val additionalPotentialOptionThird: String?,

    @Json(name = "equipment_level_increase")
    val equipmentLevelIncrease: String,

    @Json(name = "item_exceptional_option")
    val itemExceptionalOption: ExceptionalOptionEntity,

    @Json(name = "item_add_option")
    val itemAddOption: AddOptionEntity,

    @Json(name = "growth_exp")
    val itemGrowthExp: Int,

    @Json(name = "growth_level")
    val itemGrowthLevel: Int,

    @Json(name = "scroll_upgrade")
    val itemScrollUpgrade: String,

    @Json(name = "cuttable_count")
    val itemCuttableCount: String,

    @Json(name = "golden_hammer_flag")
    val itemGoldenHammerFlag: String,

    @Json(name = "scroll_resilience_count")
    val itemScrollResilienceCount: String,

    @Json(name = "scroll_upgradeable_count")
    val itemScrollUpgradableCount: String,

    @Json(name = "soul_name")
    val itemSoulName: String?,

    @Json(name = "soul_option")
    val itemSoulOption: String?,

    @Json(name = "item_etc_option")
    val itemEtcOption: EtcOptionEntity,

    @Json(name = "starforce")
    val itemStarforce: String,

    @Json(name = "starforce_scroll_flag")
    val itemStarforceScrollFlag: String,

    @Json(name = "item_starforce_option")
    val itemStarforceOption: StarforceOptionEntity,

    @Json(name = "special_ring_level")
    val itemSpecialRingLevel: Int,

    @Json(name = "date_expire")
    val itemDateExpire: String?
)

@Keep
@JsonClass(generateAdapter = true)
data class TotalOptionEntity(
    @Json(name = "str")
    val itemTotalStr: String = "",

    @Json(name = "dex")
    val itemTotalDex: String = "",

    @Json(name = "int")
    val itemTotalInt: String = "",

    @Json(name = "luk")
    val itemTotalLuk: String = "",

    @Json(name = "max_hp")
    val itemTotalMaxHp: String = "",

    @Json(name = "max_mp")
    val itemTotalMaxMp: String = "",

    @Json(name = "attack_power")
    val itemTotalAttackPower: String = "",

    @Json(name = "magic_power")
    val itemTotalMagicPower: String = "",

    @Json(name = "armor")
    val itemTotalArmor: String = "",

    @Json(name = "speed")
    val itemTotalSpeed: String = "",

    @Json(name = "jump")
    val itemTotalJump: String = "",

    @Json(name = "boss_damage")
    val itemTotalBossDamage: String = "",

    @Json(name = "ignore_monster_armor")
    val itemTotalIgnoreMonsterArmor: String = "",

    @Json(name = "all_stat")
    val itemTotalAllStat: String = "",

    @Json(name = "damage")
    val itemTotalDamage: String = "",

    @Json(name = "equipment_level_decrease")
    val itemTotalEquipmentLevelDecrease: String = "",

    @Json(name = "max_hp_rate")
    val itemTotalMaxHpRate: String = "",

    @Json(name = "max_mp_rate")
    val itemTotalMaxMpRate: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class BaseOptionEntity(
    @Json(name = "str")
    val itemBaseStr: String = "",

    @Json(name = "dex")
    val itemBaseDex: String = "",

    @Json(name = "int")
    val itemBaseInt: String = "",

    @Json(name = "luk")
    val itemBaseLuk: String = "",

    @Json(name = "max_hp")
    val itemBaseMaxHp: String = "",

    @Json(name = "max_mp")
    val itemBaseMaxMp: String = "",

    @Json(name = "attack_power")
    val itemBaseAttackPower: String = "",

    @Json(name = "magic_power")
    val itemBaseMagicPower: String = "",

    @Json(name = "armor")
    val itemBaseArmor: String = "",

    @Json(name = "speed")
    val itemBaseSpeed: String = "",

    @Json(name = "jump")
    val itemBaseJump: String = "",

    @Json(name = "boss_damage")
    val itemBaseBossDamage: String = "",

    @Json(name = "ignore_monster_armor")
    val itemBaseIgnoreMonsterArmor: String = "",

    @Json(name = "all_stat")
    val itemBaseAllStat: String = "",

    @Json(name = "max_hp_rate")
    val itemBaseMaxHpRate: String = "",

    @Json(name = "max_mp_rate")
    val itemBaseMaxMpRate: String = "",

    @Json(name = "base_equipment_level")
    val itemBaseBaseEquipmentLevel: String = "",
)

@Keep
@JsonClass(generateAdapter = true)
data class ExceptionalOptionEntity(
    @Json(name = "str")
    val itemExceptionalStr: String = "",

    @Json(name = "dex")
    val itemExceptionalDex: String = "",

    @Json(name = "int")
    val itemExceptionalInt: String = "",

    @Json(name = "luk")
    val itemExceptionalLuk: String = "",

    @Json(name = "max_hp")
    val itemExceptionalMaxHp: String = "",

    @Json(name = "max_mp")
    val itemExceptionalMaxMp: String = "",

    @Json(name = "attack_power")
    val itemExceptionalAttackPower: String = "",

    @Json(name = "magic_power")
    val itemExceptionalMagicPower: String = "",
)

@Keep
@JsonClass(generateAdapter = true)
data class AddOptionEntity(
    @Json(name = "str")
    val itemAddStr: String = "",

    @Json(name = "dex")
    val itemAddDex: String = "",

    @Json(name = "int")
    val itemAddInt: String = "",

    @Json(name = "luk")
    val itemAddLuk: String = "",

    @Json(name = "max_hp")
    val itemAddMaxHp: String = "",

    @Json(name = "max_mp")
    val itemAddMaxMp: String = "",

    @Json(name = "attack_power")
    val itemAddAttackPower: String = "",

    @Json(name = "magic_power")
    val itemAddMagicPower: String = "",

    @Json(name = "armor")
    val itemAddArmor: String = "",

    @Json(name = "speed")
    val itemAddSpeed: String = "",

    @Json(name = "jump")
    val itemAddJump: String = "",

    @Json(name = "boss_damage")
    val itemAddBossDamage: String = "",

    @Json(name = "damage")
    val itemAddDamage: String = "",

    @Json(name = "all_stat")
    val itemAddAllStat: String = "",

    @Json(name = "equipment_level_decrease")
    val itemAddEquipmentLevelDecrease: String = "",
)

@Keep
@JsonClass(generateAdapter = true)
data class StarforceOptionEntity(
    @Json(name = "str")
    val itemStarforceStr: String = "",

    @Json(name = "dex")
    val itemStarforceDex: String = "",

    @Json(name = "int")
    val itemStarforceInt: String = "",

    @Json(name = "luk")
    val itemStarforceLuk: String = "",

    @Json(name = "max_hp")
    val itemStarforceMaxHp: String = "",

    @Json(name = "max_mp")
    val itemStarforceMaxMp: String = "",

    @Json(name = "attack_power")
    val itemStarforceAttackPower: String = "",

    @Json(name = "magic_power")
    val itemStarforceMagicPower: String = "",

    @Json(name = "armor")
    val itemStarforceArmor: String = "",

    @Json(name = "speed")
    val itemStarforceSpeed: String = "",

    @Json(name = "jump")
    val itemStarforceJump: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class EtcOptionEntity(
    @Json(name = "str")
    val itemEtcStr: String = "",

    @Json(name = "dex")
    val itemEtcDex: String = "",

    @Json(name = "int")
    val itemEtcInt: String = "",

    @Json(name = "luk")
    val itemEtcLuk: String = "",

    @Json(name = "max_hp")
    val itemEtcMaxHp: String = "",

    @Json(name = "max_mp")
    val itemEtcMaxMp: String = "",

    @Json(name = "attack_power")
    val itemEtcAttackPower: String = "",

    @Json(name = "magic_power")
    val itemEtcMagicPower: String = "",

    @Json(name = "armor")
    val itemEtcArmor: String = "",

    @Json(name = "speed")
    val itemEtcSpeed: String = "",

    @Json(name = "jump")
    val itemEtcJump: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class TitleEntity(
    @Json(name = "title_name")
    val itemTitleName: String,

    @Json(name = "title_icon")
    val itemTitleIcon: String,

    @Json(name = "title_description")
    val itemTitleDescription: String,

    @Json(name = "date_expire")
    val itemTitleDateExpire: String?,

    @Json(name = "date_option_expire")
    val itemTitleDateOptionExpire: String?
)

@Keep
@JsonClass(generateAdapter = true)
data class UnionEntity(
    @Json(name = "union_level")
    val characterUnionLevel: Int = 0,

    @Json(name = "union_grade")
    val characterUnionGrade: String = "",

    @Json(name = "union_artifact_level")
    val characterUnionArtifactLevel: Int? = null,

    @Json(name = "union_artifact_exp")
    val characterUnionArtifactExp: Int? = null,

    @Json(name = "union_artifact_point")
    val characterUnionArtifactPoint: Int? = null,
)

@Keep
@JsonClass(generateAdapter = true)
data class PopularityEntity(
    @Json(name = "popularity")
    val characterPopularity: Int = 0
)

@Keep
@JsonClass(generateAdapter = true)
data class DojangEntity(
    @Json(name = "dojang_best_floor")
    val characterDojangBestFloor: Int = 0
)

@Keep
@JsonClass(generateAdapter = true)
data class HyperStatEntity(
    @Json(name = "hyper_stat_preset_1")
    val hyperStatFirstPreset: List<HyperStatInfoEntity>,

    @Json(name = "hyper_stat_preset_1_remain_point")
    val hyperStatFirstPresetRemainPoint: Int,

    @Json(name = "hyper_stat_preset_2")
    val hyperStatSecondPreset: List<HyperStatInfoEntity>,

    @Json(name = "hyper_stat_preset_2_remain_point")
    val hyperStatSecondPresetRemainPoint: Int,

    @Json(name = "hyper_stat_preset_3")
    val hyperStatThirdPreset: List<HyperStatInfoEntity>,

    @Json(name = "hyper_stat_preset_3_remain_point")
    val hyperStatThirdPresetRemainPoint: Int
)

@Keep
@JsonClass(generateAdapter = true)
data class HyperStatInfoEntity(
    @Json(name = "stat_type")
    val statType: String,

    @Json(name = "stat_point")
    val statPoint: Int?,

    @Json(name = "stat_level")
    val statLevel: Int,

    @Json(name = "stat_increase")
    val statIncrease: String?
)

@Keep
@JsonClass(generateAdapter = true)
data class AbilityEntity(
    @Json(name = "remain_fame")
    val remainFame: Int,

    @Json(name = "ability_preset_1")
    val abilityFirstPreset: AbilityPresetEntity,

    @Json(name = "ability_preset_2")
    val abilitySecondPreset: AbilityPresetEntity,

    @Json(name = "ability_preset_3")
    val abilityThirdPreset: AbilityPresetEntity
)

@Keep
@JsonClass(generateAdapter = true)
data class AbilityPresetEntity(
    @Json(name = "ability_preset_grade")
    val abilityPresetGrade: String,

    @Json(name = "ability_info")
    val abilityInfo: List<AbilityInfoEntity>
)

@Keep
@JsonClass(generateAdapter = true)
data class AbilityInfoEntity(
    @Json(name = "ability_no")
    val abilityNo: String,

    @Json(name = "ability_grade")
    val abilityGrade: String,

    @Json(name = "ability_value")
    val abilityValue: String
)

@Keep
@JsonClass(generateAdapter = true)
data class SkillEntity(
    @Json(name = "character_class")
    val characterClass: String,

    @Json(name = "character_skill_grade")
    val characterSkillGrade: String?,

    @Json(name = "character_skill")
    val characterSkill: List<SkillInfoEntity>
)

@Keep
@JsonClass(generateAdapter = true)
data class SkillInfoEntity(
    @Json(name = "skill_name")
    val skillName: String,

    @Json(name = "skill_description")
    val skillDescription: String,

    @Json(name = "skill_level")
    val skillLevel: Int,

    @Json(name = "skill_effect")
    val skillEffect: String?,

    @Json(name = "skill_effect_next")
    val skillEffectNext: String?,

    @Json(name = "skill_icon")
    val skillIcon: String
)

@Keep
@JsonClass(generateAdapter = true)
data class LinkSkillEntity(
    @Json(name = "character_link_skill_preset_1")
    val characterLinkSkillFirstPreset: List<LinkSkillInfoEntity>,

    @Json(name = "character_link_skill_preset_2")
    val characterLinkSkillSecondPreset: List<LinkSkillInfoEntity>,

    @Json(name = "character_link_skill_preset_3")
    val characterLinkSkillThirdPreset: List<LinkSkillInfoEntity>,

    @Json(name = "character_owned_link_skill")
    val characterOwnedLinkSkill: LinkSkillInfoEntity
)

@Keep
@JsonClass(generateAdapter = true)
data class LinkSkillInfoEntity(
    @Json(name = "skill_name")
    val skillName: String,

    @Json(name = "skill_description")
    val skillDescription: String,

    @Json(name = "skill_level")
    val skillLevel: Int,

    @Json(name = "skill_effect")
    val skillEffect: String?,

    @Json(name = "skill_icon")
    val skillIcon: String
)

@Keep
@JsonClass(generateAdapter = true)
data class AndroidEntity(
    @Json(name = "android_preset_1")
    val androidFirstPreset: AndroidInfoEntity?,

    @Json(name = "android_preset_2")
    val androidSecondPreset: AndroidInfoEntity?,

    @Json(name = "android_preset_3")
    val androidThirdPreset: AndroidInfoEntity?
)

@Keep
@JsonClass(generateAdapter = true)
data class AndroidInfoEntity(
    @Json(name = "android_name")
    val androidName: String,

    @Json(name = "android_nickname")
    val androidNickname: String,

    @Json(name = "android_icon")
    val androidIcon: String,

    @Json(name = "android_description")
    val androidDescription: String,

    @Json(name = "android_gender")
    val androidGender: String,

    @Json(name = "android_grade")
    val androidGrade: String,

    @Json(name = "android_skin_name")
    val androidSkinName: String?,

    @Json(name = "android_hair")
    val androidHair: AndroidHairEntity,

    @Json(name = "android_face")
    val androidFace: AndroidFaceEntity,

    @Json(name = "android_ear_sensor_clip_flag")
    val androidEarSensorClipFlag: String,

    @Json(name = "android_non_humanoid_flag")
    val androidNonHumanoidFlag: String,

    @Json(name = "android_shop_usable_flag")
    val androidShopUsableFlag: String
)

@Keep
@JsonClass(generateAdapter = true)
data class AndroidHairEntity(
    @Json(name = "hair_name")
    val hairName: String?,

    @Json(name = "base_color")
    val baseColor: String?,

    @Json(name = "mix_color")
    val mixColor: String?,

    @Json(name = "mix_rate")
    val mixRate: String
)

@Keep
@JsonClass(generateAdapter = true)
data class AndroidFaceEntity(
    @Json(name = "face_name")
    val faceName: String?,

    @Json(name = "base_color")
    val baseColor: String?,

    @Json(name = "mix_color")
    val mixColor: String?,

    @Json(name = "mix_rate")
    val mixRate: String
)

@Keep
@JsonClass(generateAdapter = true)
data class CashItemEntity(
    @Json(name = "cash_item_equipment_base")
    val cashItemEquipmentBase: List<CashItemInfoEntity>,

    @Json(name = "cash_item_equipment_preset_1")
    val cashItemEquipmentFirstPreset: List<CashItemInfoEntity>,

    @Json(name = "cash_item_equipment_preset_2")
    val cashItemEquipmentSecondPreset: List<CashItemInfoEntity>,

    @Json(name = "cash_item_equipment_preset_3")
    val cashItemEquipmentThirdPreset: List<CashItemInfoEntity>,

    @Json(name = "additional_cash_item_equipment_base")
    val additionalCashItemEquipmentBase: List<CashItemInfoEntity>,

    @Json(name = "additional_cash_item_equipment_preset_1")
    val additionalCashItemEquipmentFirstPreset: List<CashItemInfoEntity>,

    @Json(name = "additional_cash_item_equipment_preset_2")
    val additionalCashItemEquipmentSecondPreset: List<CashItemInfoEntity>,

    @Json(name = "additional_cash_item_equipment_preset_3")
    val additionalCashItemEquipmentThirdPreset: List<CashItemInfoEntity>
)

@Keep
@JsonClass(generateAdapter = true)
data class CashItemInfoEntity(
    @Json(name = "cash_item_equipment_part")
    val cashItemEquipmentPart: String,

    @Json(name = "cash_item_equipment_slot")
    val cashItemEquipmentSlot: String,

    @Json(name = "cash_item_name")
    val cashItemName: String,

    @Json(name = "cash_item_icon")
    val cashItemIcon: String,

    @Json(name = "cash_item_description")
    val cashItemDescription: String?,

    @Json(name = "cash_item_option")
    val cashItemOption: List<CashItemOptionEntity>,

    @Json(name = "date_expire")
    val dateExpire: String?,

    @Json(name = "date_option_expire")
    val dateOptionExpire: String?,

    @Json(name = "cash_item_label")
    val cashItemLabel: String?,

    @Json(name = "cash_item_coloring_prism")
    val cashItemColoringPrism: CashItemColoringPrismEntity?,

    @Json(name = "item_gender")
    val itemGender: String?
)

@Keep
@JsonClass(generateAdapter = true)
data class CashItemOptionEntity(
    @Json(name = "option_type")
    val optionType: String,

    @Json(name = "option_value")
    val optionValue: String
)

@Keep
@JsonClass(generateAdapter = true)
data class CashItemColoringPrismEntity(
    @Json(name = "color_range")
    val colorRange: String,

    @Json(name = "hue")
    val hue: Long,

    @Json(name = "saturation")
    val saturation: Long,

    @Json(name = "value")
    val value: Long
)