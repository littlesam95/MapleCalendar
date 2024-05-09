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
import kotlin.math.max

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

        private val potentialGradeMap =
            mapOf("null" to 0, "레어" to 1, "에픽" to 2, "유니크" to 3, "레전드리" to 4)

        val itemSoul: String? = when (itemSoulName) {
            null -> null

            else -> "${itemSoulName.split("의").first()}의"
        }
        val itemFinalName: String? = when (itemScrollUpgrade) {
            "0" -> itemName

            else -> when (itemGender) {
                null -> "$itemName (+${itemScrollUpgrade})"

                else -> "$itemName (${itemGender}) (+${itemScrollUpgrade})"
            }
        }
        val isReqLevZero: Boolean = when (itemBaseOption.itemBaseBaseEquipmentLevel) {
            "0" -> true

            else -> false
        }
        val itemClassified: String =
            "${MainApplication.myContext().resources.getString(R.string.text_equipment_classified)} $itemEquipmentPart"
        val isAbleToUpgrade: Boolean =
            ((itemScrollUpgrade != "0") || (itemScrollUpgradableCount != "0"))
        val itemUpgradeable: String =
            "${MainApplication.myContext().resources.getString(R.string.text_equipment_scroll_upgradeable_count)} $itemScrollUpgradableCount"
        val itemResilience: String =
            "(${MainApplication.myContext().resources.getString(R.string.text_equipment_scroll_resilience_count)} ${itemScrollResilienceCount})"
        val isGoldenHammerUsed: Boolean = (itemGoldenHammerFlag == "적용")
        val itemCuttable: String =
            "${MainApplication.myContext().resources.getString(R.string.text_cuttable_count)} ${itemCuttableCount}회"
        val isItemCuttable: Boolean = (itemCuttableCount != "255")
        val potentialIcon: Int = when (potentialOptionGrade) {
            "레어" -> R.drawable.ic_potential_rare

            "에픽" -> R.drawable.ic_potential_epic

            "유니크" -> R.drawable.ic_potential_unique

            "레전드리" -> R.drawable.ic_potential_legendary

            else -> 0
        }
        val potentialOptionGradeColor: Int = when (potentialOptionGrade) {
            "레어" -> R.color.equipment_rare

            "에픽" -> R.color.equipment_epic

            "유니크" -> R.color.equipment_unique

            "레전드리" -> R.color.equipment_legendary

            else -> R.color.white
        }
        val additionalPotentialIcon: Int = when (additionalPotentialOptionGrade) {
            "레어" -> R.drawable.ic_potential_rare

            "에픽" -> R.drawable.ic_potential_epic

            "유니크" -> R.drawable.ic_potential_unique

            "레전드리" -> R.drawable.ic_potential_legendary

            else -> 0
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
        val isSuperior: Boolean = when {
            itemName.isNullOrEmpty() -> false

            itemName.contains("헬리시움 정예") -> true

            itemName.contains("노바 히아데스") -> true

            itemName.contains("노바 헤르메스") -> true

            itemName.contains("노바 케이론") -> true

            itemName.contains("노바 리카온") -> true

            itemName.contains("노바 알테어") -> true

            itemName.contains("타일런트 히아데스") -> true

            itemName.contains("타일런트 헤르메스") -> true

            itemName.contains("타일런트 케이론") -> true

            itemName.contains("타일런트 리카온") -> true

            itemName.contains("타일런트 알테어") -> true

            else -> false
        }
        val isStarforceScrollUsed: Boolean = when (itemStarforceScrollFlag) {
            "사용" -> true

            else -> false
        }
        val maxStarforceValue: Int = when (equipmentSlot) {
            "훈장", "뱃지", "엠블렘", "포켓 아이템" -> {
                0
            }

            "보조무기" -> {
                if (itemEquipmentPart == "방패") getItemMaxStarforce() else 0
            }

            else -> {
                if (equipmentSlot.contains("반지")) {
                    if (itemSpecialRingLevel == "0") getItemMaxStarforce() else 0
                } else {
                    getItemMaxStarforce()
                }
            }
        }
        val maxPotentialGrade: String? = getMaxPotential()
        val itemIcon: Int = getItemIconBackground()
        val itemIconTag: Int = getItemIconTagBackground()
        val isFirstStarforceVisible: Boolean = (maxStarforceValue >= 1)
        val isSecondStarforceVisible: Boolean = (maxStarforceValue >= 16)
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

        private fun getMaxPotential(): String? {
            val potential = potentialGradeMap.getValue(potentialOptionGrade.toString())
            val additionalPotential =
                potentialGradeMap.getValue(additionalPotentialOptionGrade.toString())

            return when (max(potential, additionalPotential)) {
                1 -> "(레어 아이템)"

                2 -> "(에픽 아이템)"

                3 -> "(유니크 아이템)"

                4 -> "(레전드리 아이템)"

                else -> null
            }
        }

        private fun getItemIconBackground(): Int {
            val potential = potentialGradeMap.getValue(potentialOptionGrade.toString())
            val additionalPotential =
                potentialGradeMap.getValue(additionalPotentialOptionGrade.toString())

            return when (max(potential, additionalPotential)) {
                1 -> R.drawable.shape_equipment_slot_rare

                2 -> R.drawable.shape_equipment_slot_epic

                3 -> R.drawable.shape_equipment_slot_unique

                4 -> R.drawable.shape_equipment_slot_legendary

                else -> R.drawable.shape_equipment_slot5
            }
        }

        private fun getItemIconTagBackground(): Int {
            val potential = potentialGradeMap.getValue(potentialOptionGrade.toString())
            val additionalPotential =
                potentialGradeMap.getValue(additionalPotentialOptionGrade.toString())

            return when (max(potential, additionalPotential)) {
                1 -> R.drawable.shape_grade_rare_tag

                2 -> R.drawable.shape_grade_epic_tag

                3 -> R.drawable.shape_grade_unique_tag

                4 -> R.drawable.shape_grade_legendary_tag

                else -> 0
            }
        }

        private fun getItemMaxStarforce(): Int {
            when (isSuperior) {
                true -> {
                    when (itemName) {
                        null -> return 0

                        else -> {
                            return when (itemBaseOption.itemBaseBaseEquipmentLevel.toInt()) {
                                in 0..95 -> 3

                                in 95..107 -> 5

                                in 108..117 -> 8

                                in 118..127 -> 10

                                in 128..137 -> 12

                                else -> 15
                            }
                        }
                    }
                }

                false -> {
                    when (itemName) {
                        null -> return 0

                        else -> {
                            when (isStarforceScrollUsed) {
                                true -> return 15

                                false -> {
                                    when {
                                        itemName.contains("크로스 링") -> return 0

                                        itemName.contains("엔젤릭 블레스") -> return 0

                                        itemName.contains("시그너스의 코히누르") -> return 0

                                        itemName.contains("앱솔루트 링") -> return 0

                                        itemName.contains("퍼스트 링") -> return 0

                                        itemName.contains("오로라 링") -> return 0

                                        itemName.contains("오닉스 링") -> return 0

                                        itemName.contains("벤전스 링") -> return 0

                                        itemName.contains("코스모스 링") -> return 0

                                        itemName.contains("SS급 마스터 쥬얼링") -> return 0

                                        itemName.contains("결속의 반지") -> return 0

                                        itemName.contains("카오스 링") -> return 0

                                        itemName.contains("테네브리스 원정대 반지") -> return 0

                                        itemName.contains("글로리온 링") -> return 0

                                        itemName.contains("어웨이크 링") -> return 0

                                        itemName.contains("이터널 플레임 링") -> return 0

                                        itemName.contains("어비스 헌터스 링") -> return 0

                                        itemName.contains("제로 그라테스링") -> return 0

                                        itemName.contains("크리티컬링") -> return 0

                                        itemName.contains("오닉스 펜던트") -> return 0

                                        !isAbleToUpgrade -> return 0

                                        else -> {
                                            return when (itemBaseOption.itemBaseBaseEquipmentLevel.toInt()) {
                                                in 0..95 -> 5

                                                in 95..107 -> 8

                                                in 108..117 -> 10

                                                in 118..127 -> 15

                                                in 128..137 -> 20

                                                else -> 25
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}