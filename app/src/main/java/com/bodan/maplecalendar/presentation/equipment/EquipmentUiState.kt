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
        val itemTitle: String = "",
        val itemEquipmentPart: String = "",
        val equipmentSlot: String = "",
        val itemName: String = "",
        val itemDescription: String? = null,
        val itemShapeName: String = "",
        val itemShapeIcon: String? = null,
        val itemGender: String? = null,
        val itemTotalOption: ItemTotalOption = ItemTotalOption(),
        val itemBaseOption: ItemBaseOption = ItemBaseOption(),
        val potentialOptionGrade: String? = null,
        val additionalPotentialOptionGrade: String? = null,
        val potentialOptionFirst: String? = null,
        val potentialOptionSecond: String? = null,
        val potentialOptionThird: String? = null,
        val additionalPotentialOptionFirst: String? = null,
        val additionalPotentialOptionSecond: String? = null,
        val additionalPotentialOptionThird: String? = null,
        val equipmentLevelIncrease: String = "",
        val itemExceptionalOption: ItemExceptionalOption = ItemExceptionalOption(),
        val itemAddOption: ItemAddOption = ItemAddOption(),
        val itemGrowthExp: String = "",
        val itemGrowthLevel: String = "",
        val itemScrollUpgrade: String = "",
        val itemCuttableCount: String = "",
        val itemGoldenHammerFlag: String = "",
        val itemScrollResilienceCount: String = "",
        val itemScrollUpgradableCount: String = "",
        val itemSoulName: String? = null,
        val itemSoulOption: String? = null,
        val itemEtcOption: ItemEtcOption = ItemEtcOption(),
        val itemStarforce: String = "",
        val itemStarforceScrollFlag: String = "",
        val itemStarforceOption: ItemStarforceOption = ItemStarforceOption(),
        val itemDateExpire: String? = null
    ) : EquipmentUiState()

    data class EquipmentWeapon(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
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
        val equipmentLevelIncrease: String?,
        val itemExceptionalOption: ItemExceptionalOption,
        val itemAddOption: ItemAddOption,
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
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
    ) : EquipmentUiState()

    data class EquipmentEmblem(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val potentialOptionGrade: String?,
        val additionalPotentialOptionGrade: String?,
        val potentialOptionFirst: String?,
        val potentialOptionSecond: String?,
        val potentialOptionThird: String?,
        val additionalPotentialOptionFirst: String?,
        val additionalPotentialOptionSecond: String?,
        val additionalPotentialOptionThird: String?,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemDateExpire: String?
    ) : EquipmentUiState()

    data class EquipmentShield(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
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
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
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
    ) : EquipmentUiState()

    data class EquipmentSubweapon(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val potentialOptionGrade: String?,
        val additionalPotentialOptionGrade: String?,
        val potentialOptionFirst: String?,
        val potentialOptionSecond: String?,
        val potentialOptionThird: String?,
        val additionalPotentialOptionFirst: String?,
        val additionalPotentialOptionSecond: String?,
        val additionalPotentialOptionThird: String?,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
        val itemScrollUpgrade: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemScrollResilienceCount: String,
        val itemScrollUpgradableCount: String,
        val itemDateExpire: String?
    ) : EquipmentUiState()

    data class EquipmentBadge(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val equipmentLevelIncrease: String,
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemEtcOption: ItemEtcOption,
        val itemDateExpire: String?
    ) : EquipmentUiState()

    data class EquipmentPocket(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
        val itemGender: String?,
        val itemTotalOption: ItemTotalOption,
        val itemBaseOption: ItemBaseOption,
        val equipmentLevelIncrease: String,
        val itemAddOption: ItemAddOption,
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
        val itemCuttableCount: String,
        val itemGoldenHammerFlag: String,
        val itemEtcOption: ItemEtcOption,
        val itemDateExpire: String?
    ) : EquipmentUiState()

    data class EquipmentAndroid(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
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
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
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
    ) : EquipmentUiState()

    data class EquipmentHeart(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
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
        val itemGrowthExp: String,
        val itemGrowthLevel: String,
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
    ) : EquipmentUiState()

    data class EquipmentSeedring(
        val itemTitle: String,
        val itemEquipmentPart: String,
        val equipmentSlot: String,
        val itemName: String,
        val itemDescription: String?,
        val itemShapeName: String,
        val itemShapeIcon: String?,
        val itemTotalOption: ItemTotalOption,
        val itemSpecialRingLevel: String,
        val itemDateExpire: String?
    ) : EquipmentUiState()

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