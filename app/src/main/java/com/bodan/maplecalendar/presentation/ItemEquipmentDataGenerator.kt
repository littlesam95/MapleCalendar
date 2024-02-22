package com.bodan.maplecalendar.presentation

import com.bodan.maplecalendar.data.dto.ItemEquipment
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState

object ItemEquipmentDataGenerator {

    private fun itemEquipmentDefault(itemEquipment: ItemEquipment, title: String): EquipmentUiState.EquipmentDefault {
        return EquipmentUiState.EquipmentDefault(
            itemTitle = title,
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemExceptionalOption = itemEquipment.itemExceptionalOption,
            itemAddOption = itemEquipment.itemAddOption,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemStarforce = itemEquipment.itemStarforce,
            itemStarforceScrollFlag = itemEquipment.itemStarforceScrollFlag,
            itemStarforceOption = itemEquipment.itemStarforceOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentWeapon(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentWeapon {
        return EquipmentUiState.EquipmentWeapon(
            itemTitle = "WEAPON",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemExceptionalOption = itemEquipment.itemExceptionalOption,
            itemAddOption = itemEquipment.itemAddOption,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemSoulName = itemEquipment.itemSoulName,
            itemSoulOption = itemEquipment.itemSoulOption,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemStarforce = itemEquipment.itemStarforce,
            itemStarforceScrollFlag = itemEquipment.itemStarforceScrollFlag,
            itemStarforceOption = itemEquipment.itemStarforceOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentSubweapon(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentSubweapon {
        return EquipmentUiState.EquipmentSubweapon(
            itemTitle = "SUB\nWEAPON",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentShield(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentShield {
        return EquipmentUiState.EquipmentShield(
            itemTitle = "SUB\nWEAPON",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemStarforce = itemEquipment.itemStarforce,
            itemStarforceScrollFlag = itemEquipment.itemStarforceScrollFlag,
            itemStarforceOption = itemEquipment.itemStarforceOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentSeedring(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentSeedring {
        return EquipmentUiState.EquipmentSeedring(
            itemTitle = "RING",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemSpecialRingLevel = itemEquipment.itemSpecialRingLevel.toString(),
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentPocket(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentPocket {
        return EquipmentUiState.EquipmentPocket(
            itemTitle = "POCKET",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemAddOption = itemEquipment.itemAddOption,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentHeart(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentHeart {
        return EquipmentUiState.EquipmentHeart(
            itemTitle = "HEART",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemExceptionalOption = itemEquipment.itemExceptionalOption,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemStarforce = itemEquipment.itemStarforce,
            itemStarforceScrollFlag = itemEquipment.itemStarforceScrollFlag,
            itemStarforceOption = itemEquipment.itemStarforceOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentEmblem(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentEmblem {
        return EquipmentUiState.EquipmentEmblem(
            itemTitle = "EMBLEM",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            potentialOptionGrade = itemEquipment.potentialOptionGrade,
            additionalPotentialOptionGrade = itemEquipment.additionalPotentialOptionGrade,
            potentialOptionFirst = itemEquipment.potentialOptionFirst,
            potentialOptionSecond = itemEquipment.potentialOptionSecond,
            potentialOptionThird = itemEquipment.additionalPotentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.potentialOptionThird,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemScrollUpgrade = itemEquipment.itemScrollUpgrade,
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemScrollResilienceCount = itemEquipment.itemScrollResilienceCount,
            itemScrollUpgradableCount = itemEquipment.itemScrollUpgradableCount,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    private fun itemEquipmentBadge(itemEquipment: ItemEquipment): EquipmentUiState.EquipmentBadge {
        return EquipmentUiState.EquipmentBadge(
            itemTitle = "BADGE",
            itemEquipmentPart = itemEquipment.itemEquipmentPart,
            equipmentSlot = itemEquipment.equipmentSlot,
            itemName = itemEquipment.itemName,
            itemDescription = itemEquipment.itemDescription,
            itemShapeName = itemEquipment.itemShapeName,
            itemShapeIcon = itemEquipment.itemShapeIcon,
            itemGender = itemEquipment.itemGender,
            itemTotalOption = itemEquipment.itemTotalOption,
            itemBaseOption = itemEquipment.itemBaseOption,
            equipmentLevelIncrease = itemEquipment.equipmentLevelIncrease,
            itemGrowthExp = itemEquipment.itemGrowthExp.toString(),
            itemGrowthLevel = itemEquipment.itemGrowthLevel.toString(),
            itemCuttableCount = itemEquipment.itemCuttableCount,
            itemGoldenHammerFlag = itemEquipment.itemGoldenHammerFlag,
            itemEtcOption = itemEquipment.itemEtcOption,
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    fun itemEquipmentDataSet(itemEquipments: List<ItemEquipment>): List<EquipmentUiState> {
        val newItemEquipmentData = MutableList<EquipmentUiState>(6 * 5) {
            EquipmentUiState.EquipmentDefault()
        }
        itemEquipments.forEach { itemEquipment ->
            when (itemEquipment.equipmentSlot) {
                "모자" -> {
                    newItemEquipmentData[2] = itemEquipmentDefault(itemEquipment, "CAP")
                }

                "얼굴장식" -> {
                    newItemEquipmentData[7] = itemEquipmentDefault(itemEquipment, "FORE\nHEAD")
                }

                "눈장식" -> {
                    newItemEquipmentData[12] = itemEquipmentDefault(itemEquipment, "EYE\nACC")
                }

                "귀고리" -> {
                    newItemEquipmentData[13] = itemEquipmentDefault(itemEquipment, "EAR\nACC")
                }

                "상의" -> {
                    newItemEquipmentData[17] = itemEquipmentDefault(itemEquipment, "CLOTHES")
                }

                "하의" -> {
                    newItemEquipmentData[22] = itemEquipmentDefault(itemEquipment, "PANTS")
                }

                "신발" -> {
                    newItemEquipmentData[27] = itemEquipmentDefault(itemEquipment, "SHOES")
                }

                "장갑" -> {
                    newItemEquipmentData[23] = itemEquipmentDefault(itemEquipment, "GLOVES")
                }

                "망토" -> {
                    newItemEquipmentData[24] = itemEquipmentDefault(itemEquipment, "CAPE")
                }

                "보조무기" -> {
                    when (itemEquipment.itemEquipmentPart) {
                        "방패" -> {
                            newItemEquipmentData[19] = itemEquipmentShield(itemEquipment)
                        }

                        else -> {
                            newItemEquipmentData[19] = itemEquipmentSubweapon(itemEquipment)
                        }
                    }
                }

                "무기" -> {
                    newItemEquipmentData[16] = itemEquipmentWeapon(itemEquipment)
                }

                "반지1" -> {
                    when (itemEquipment.itemSpecialRingLevel) {
                        0 -> {
                            newItemEquipmentData[15] = itemEquipmentDefault(itemEquipment, "RING")
                        }

                        else -> {
                            newItemEquipmentData[15] = itemEquipmentSeedring(itemEquipment)
                        }
                    }
                }

                "반지2" -> {
                    when (itemEquipment.itemSpecialRingLevel) {
                        0 -> {
                            newItemEquipmentData[10] = itemEquipmentDefault(itemEquipment, "RING")
                        }

                        else -> {
                            newItemEquipmentData[10] = itemEquipmentSeedring(itemEquipment)
                        }
                    }
                }

                "반지3" -> {
                    when (itemEquipment.itemSpecialRingLevel) {
                        0 -> {
                            newItemEquipmentData[5] = itemEquipmentDefault(itemEquipment, "RING")
                        }

                        else -> {
                            newItemEquipmentData[5] = itemEquipmentSeedring(itemEquipment)
                        }
                    }
                }

                "반지4" -> {
                    when (itemEquipment.itemSpecialRingLevel) {
                        0 -> {
                            newItemEquipmentData[0] = itemEquipmentDefault(itemEquipment, "RING")
                        }

                        else -> {
                            newItemEquipmentData[0] = itemEquipmentSeedring(itemEquipment)
                        }
                    }
                }

                "펜던트" -> {
                    newItemEquipmentData[11] = itemEquipmentDefault(itemEquipment, "PENDANT")
                }

                "훈장" -> {
                    newItemEquipmentData[14] = itemEquipmentDefault(itemEquipment, "MEDAL")
                }

                "벨트" -> {
                    newItemEquipmentData[21] = itemEquipmentDefault(itemEquipment, "BELT")
                }

                "어깨장식" -> {
                    newItemEquipmentData[18] = itemEquipmentDefault(itemEquipment, "SHOULDER")
                }

                "포켓 아이템" -> {
                    newItemEquipmentData[20] = itemEquipmentPocket(itemEquipment)
                }

                "기계 심장" -> {
                    newItemEquipmentData[29] = itemEquipmentHeart(itemEquipment)
                }

                "뱃지" -> {
                    newItemEquipmentData[9] = itemEquipmentBadge(itemEquipment)
                }

                "엠블렘" -> {
                    newItemEquipmentData[4] = itemEquipmentEmblem(itemEquipment)
                }

                "펜던트2" -> {
                    newItemEquipmentData[6] = itemEquipmentDefault(itemEquipment, "PENDANT")
                }
            }
        }

        return newItemEquipmentData
    }
}