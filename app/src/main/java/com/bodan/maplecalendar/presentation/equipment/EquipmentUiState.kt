package com.bodan.maplecalendar.presentation.equipment

import com.bodan.maplecalendar.data.dto.ItemAddOption
import com.bodan.maplecalendar.data.dto.ItemBaseOption
import com.bodan.maplecalendar.data.dto.ItemEtcOption
import com.bodan.maplecalendar.data.dto.ItemExceptionalOption
import com.bodan.maplecalendar.data.dto.ItemStarforceOption
import com.bodan.maplecalendar.data.dto.ItemTotalOption
import java.util.UUID

sealed class EquipmentUiState(val id: String = UUID.randomUUID().toString()) {

    data class EquipmentDefault(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
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
        val itemEtcOption: ItemEtcOption,
        val itemStarforce: String,
        val itemStarforceScrollFlag: String,
        val itemStarforceOption: ItemStarforceOption,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentWeapon(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
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
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentEmblem(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentShield(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemEtcOption: ItemEtcOption,
        val itemStarforce: String,
        val itemStarforceScrollFlag: String,
        val itemStarforceOption: ItemStarforceOption,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentSubweapon(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentBadge(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemEtcOption: ItemEtcOption,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentPocket(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val equipmentLevelIncrease: String,
        val itemAddOption: ItemAddOption,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemEtcOption: ItemEtcOption,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentAndroid(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
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
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentHeart(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val potentialOptionGrade: String,
        val additionalPotentialOptionGrade: String,
        val potentialOptionFirst: String,
        val potentialOptionSecond: String,
        val potentialOptionThird: String,
        val additionalPotentialOptionFirst: String,
        val additionalPotentialOptionSecond: String,
        val additionalPotentialOptionThird: String,
        val equipmentLevelIncrease: String,
        val itemExceptionalOption: ItemExceptionalOption,
        val itemGrowthExp: Int,
        val itemGrowthLevel: Int,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemEtcOption: ItemEtcOption,
        val itemStarforce: String,
        val itemStarforceScrollFlag: String,
        val itemStarforceOption: ItemStarforceOption,
        val itemDateExpire: String?
    ): EquipmentUiState()

    data class EquipmentSeedring(
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String,
        val itemTotalOption: ItemTotalOption,
        val itemSpecialRingLevel: Int,
        val itemDateExpire: String?
    ): EquipmentUiState()

    companion object {
        const val DEFAULT_VIEW_TYPE = 1
        const val WEAPON_VIEW_TYPE = 2
        const val EMBLEM_VIEW_TYPE = 3
        const val SHIELD_VIEW_TYPE = 4
        const val SUBWEAPON_VIEW_TYPE = 5
        const val BADGE_VIEW_TYPE = 6
        const val POCKET_VIEW_TYPE = 7
        const val ANDROID_VIEW_TYPE = 8
        const val HEART_VIEW_TYPE = 9
        const val SEEDRING_VIEW_TYPE = 10
    }
}

enum class EquipmentType {
    DEFAULT, WEAPON, EMBLEM, SHIELD, SUBWEAPON, BADGE, POCKET, ANDROID, HEART, SEEDRING
}