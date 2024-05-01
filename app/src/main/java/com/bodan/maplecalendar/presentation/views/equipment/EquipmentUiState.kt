package com.bodan.maplecalendar.presentation.views.equipment

import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.domain.entity.ItemAddOption
import com.bodan.maplecalendar.domain.entity.ItemBaseOption
import com.bodan.maplecalendar.domain.entity.ItemEtcOption
import com.bodan.maplecalendar.domain.entity.ItemExceptionalOption
import com.bodan.maplecalendar.domain.entity.ItemStarforceOption
import com.bodan.maplecalendar.domain.entity.ItemTotalOption
import java.util.UUID

sealed class EquipmentUiState(val id: String = UUID.randomUUID().toString()) {

    data class EquipmentOption(
        val itemTitle: String? = null,
        val itemEquipmentPart: String = "",
        val equipmentSlot: String = "",
        val itemName: String? = null,
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
        val itemSpecialRingLevel: String? = null,
        val itemDateExpire: String? = null
    ) : EquipmentUiState() {
        val itemSoul: String? = when (itemSoulName) {
            null -> null

            else -> "${itemSoulName.split("의").first()}의"
        }
        val itemFinalName: String? = when (itemScrollUpgrade) {
            "0" -> itemName

            else -> "$itemName (+${itemScrollUpgrade})"
        }
        val itemClassified: String =
            "${MainApplication.myContext().resources.getString(R.string.text_equipment_classified)} $itemEquipmentPart"
        val isAbleToUpgrade: Boolean = ((itemScrollUpgrade != "0") || (itemScrollUpgradableCount != "0"))
        val itemUpgradeable: String =
            "${MainApplication.myContext().resources.getString(R.string.text_equipment_scroll_upgradeable_count)} $itemScrollUpgradableCount"
        val itemResilience: String =
            "(${MainApplication.myContext().resources.getString(R.string.text_equipment_scroll_resilience_count)} ${itemScrollResilienceCount})"
        val isGoldenHammerUsed: Boolean = (itemGoldenHammerFlag == "적용")
        val itemCuttable: String =
            "${MainApplication.myContext().resources.getString(R.string.text_cuttable_count)} ${itemCuttableCount}회"
        val isItemCuttable: Boolean = (itemCuttableCount != "255")
        val potentialOptionGradeColor: Int = when (potentialOptionGrade) {
            "레어" -> R.color.equipment_rare

            "에픽" -> R.color.equipment_epic

            "유니크" -> R.color.equipment_unique

            "레전드리" -> R.color.equipment_legendary

            else -> R.color.white
        }
        val additionalPotentialOptionGradeColor: Int = when (additionalPotentialOptionGrade) {
            "레어" -> R.color.equipment_rare

            "에픽" -> R.color.equipment_epic

            "유니크" -> R.color.equipment_unique

            "레전드리" -> R.color.equipment_legendary

            else -> R.color.white
        }
        val additionalFinalPotentialOptionFirst: String? = when (additionalPotentialOptionFirst) {
            null -> null

            else -> " + $additionalPotentialOptionFirst"
        }
        val additionalFinalPotentialOptionSecond: String? = when (additionalPotentialOptionSecond) {
            null -> null

            else -> " + $additionalPotentialOptionSecond"
        }
        val additionalFinalPotentialOptionThird: String? = when (additionalPotentialOptionThird) {
            null -> null

            else -> " + $additionalPotentialOptionThird"
        }
        val seedringDescription: String? = when (itemSpecialRingLevel) {
            "0" -> null

            else -> "$itemName ${itemSpecialRingLevel}레벨"
        }
        val slotBackgroundDrawable: Int = when (itemTitle) {
            null -> {
                R.drawable.shape_equipment_background
            }

            "RING" -> {
                R.drawable.shape_equipment_slot1
            }

            "PENDANT" -> {
                R.drawable.shape_equipment_slot2
            }

            "WEAPON" -> {
                R.drawable.shape_equipment_slot3
            }

            "SUB\nWEAPON" -> {
                R.drawable.shape_equipment_slot3
            }

            "EMBLEM" -> {
                R.drawable.shape_equipment_slot2
            }

            "BADGE" -> {
                R.drawable.shape_equipment_slot2
            }

            "MEDAL" -> {
                R.drawable.shape_equipment_slot2
            }

            "ANDROID" -> {
                R.drawable.shape_equipment_slot5
            }

            "HEART" -> {
                R.drawable.shape_equipment_slot5
            }

            else -> {
                R.drawable.shape_equipment_slot4
            }
        }
    }
}