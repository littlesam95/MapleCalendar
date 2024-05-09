package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemEquipment(
    val itemEquipmentPart: String,
    val equipmentSlot: String,
    val itemName: String,
    val itemIcon: String,
    val itemDescription: String?,
    val itemShapeName: String,
    val itemShapeIcon: String,
    val itemGender: String?,
    val itemTotalOption: ItemTotalOption,
    val itemBaseOption: ItemBaseOption,
    val potentialOptionGrade: String?,
    val additionalPotentialOptionGrade: String?,
    val potentialOptionFirst: String?,
    val potentialOptionSecond: String?,
    val potentialOptionThird: String?,
    val additionalPotentialOptionFirst: String?,
    val additionalPotentialOptionSecond: String?,
    val additionalPotentialOptionThird: String?,
    val equipmentLevelIncrease: String,
    val itemExceptionalOption: ItemExceptionalOption,
    val itemAddOption: ItemAddOption,
    val itemGrowthExp: Int,
    val itemGrowthLevel: Int,
    val itemScrollUpgrade: String,
    val itemCuttableCount: String,
    val itemGoldenHammerFlag: String,
    val itemScrollResilienceCount: String,
    val itemScrollUpgradableCount: String,
    val itemSoulName: String?,
    val itemSoulOption: String?,
    val itemEtcOption: ItemEtcOption,
    val itemStarforce: String,
    val itemStarforceScrollFlag: String,
    val itemStarforceOption: ItemStarforceOption,
    val itemSpecialRingLevel: Int,
    val itemDateExpire: String?
)