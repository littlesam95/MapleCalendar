package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ItemEquipment(
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
    val itemTotalOption: ItemTotalOption,

    @Json(name = "item_base_option")
    val itemBaseOption: ItemBaseOption,

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
    val itemExceptionalOption: ItemExceptionalOption,

    @Json(name = "item_add_option")
    val itemAddOption: ItemAddOption,

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
    val itemEtcOption: ItemEtcOption,

    @Json(name = "starforce")
    val itemStarforce: String,

    @Json(name = "starforce_scroll_flag")
    val itemStarforceScrollFlag: String,

    @Json(name = "item_starforce_option")
    val itemStarforceOption: ItemStarforceOption,

    @Json(name = "special_ring_level")
    val itemSpecialRingLevel: Int,

    @Json(name = "date_expire")
    val itemDateExpire: String?
)
