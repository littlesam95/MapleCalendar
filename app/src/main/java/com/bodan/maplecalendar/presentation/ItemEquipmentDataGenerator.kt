package com.bodan.maplecalendar.presentation

import com.bodan.maplecalendar.data.dto.ItemEquipment
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState

object ItemEquipmentDataGenerator {

    private fun itemEquipmentOptionSet(
        itemEquipment: ItemEquipment,
        title: String
    ): EquipmentUiState.EquipmentOption {
        return EquipmentUiState.EquipmentOption(
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
            potentialOptionThird = itemEquipment.potentialOptionThird,
            additionalPotentialOptionFirst = itemEquipment.additionalPotentialOptionFirst,
            additionalPotentialOptionSecond = itemEquipment.additionalPotentialOptionSecond,
            additionalPotentialOptionThird = itemEquipment.additionalPotentialOptionThird,
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
            itemSpecialRingLevel = itemEquipment.itemSpecialRingLevel.toString(),
            itemDateExpire = itemEquipment.itemDateExpire
        )
    }

    fun itemEquipmentDataSet(itemEquipments: List<ItemEquipment>): List<EquipmentUiState.EquipmentOption> {
        val newItemEquipmentData = arrayListOf<EquipmentUiState.EquipmentOption>(
            EquipmentUiState.EquipmentOption(
                itemTitle = "RING"
            ),
            EquipmentUiState.EquipmentOption(),
            EquipmentUiState.EquipmentOption(
                itemTitle = "CAP"
            ),
            EquipmentUiState.EquipmentOption(),
            EquipmentUiState.EquipmentOption(
                itemTitle = "EMBLEM"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "RING"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "PENDANT"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "FORE\nHEAD"
            ),
            EquipmentUiState.EquipmentOption(),
            EquipmentUiState.EquipmentOption(
                itemTitle = "BADGE"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "RING"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "PENDANT"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "EYE\nACC"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "EAR\nACC"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "MEDAL"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "RING"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "WEAPON"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "CLOTHES"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "SHOULDER"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "SUB\nWEAPON"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "POCKET"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "BELT"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "PANTS"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "GLOVES"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "CAPE"
            ),
            EquipmentUiState.EquipmentOption(),
            EquipmentUiState.EquipmentOption(),
            EquipmentUiState.EquipmentOption(
                itemTitle = "SHOES"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "ANDROID"
            ),
            EquipmentUiState.EquipmentOption(
                itemTitle = "HEART"
            ),
        ).toMutableList()
        itemEquipments.forEach { itemEquipment ->
            when (itemEquipment.equipmentSlot) {
                "모자" -> {
                    newItemEquipmentData[2] = itemEquipmentOptionSet(itemEquipment, "CAP")
                }

                "얼굴장식" -> {
                    newItemEquipmentData[7] = itemEquipmentOptionSet(itemEquipment, "FORE\nHEAD")
                }

                "눈장식" -> {
                    newItemEquipmentData[12] = itemEquipmentOptionSet(itemEquipment, "EYE\nACC")
                }

                "귀고리" -> {
                    newItemEquipmentData[13] = itemEquipmentOptionSet(itemEquipment, "EAR\nACC")
                }

                "상의" -> {
                    newItemEquipmentData[17] = itemEquipmentOptionSet(itemEquipment, "CLOTHES")
                }

                "하의" -> {
                    newItemEquipmentData[22] = itemEquipmentOptionSet(itemEquipment, "PANTS")
                }

                "신발" -> {
                    newItemEquipmentData[27] = itemEquipmentOptionSet(itemEquipment, "SHOES")
                }

                "장갑" -> {
                    newItemEquipmentData[23] = itemEquipmentOptionSet(itemEquipment, "GLOVES")
                }

                "망토" -> {
                    newItemEquipmentData[24] = itemEquipmentOptionSet(itemEquipment, "CAPE")
                }

                "보조무기" -> {
                    newItemEquipmentData[19] = itemEquipmentOptionSet(itemEquipment, "SUB\nWEAPON")
                }

                "무기" -> {
                    newItemEquipmentData[16] = itemEquipmentOptionSet(itemEquipment, "WEAPON")
                }

                "반지1" -> {
                    newItemEquipmentData[15] = itemEquipmentOptionSet(itemEquipment, "RING")
                }

                "반지2" -> {
                    newItemEquipmentData[10] = itemEquipmentOptionSet(itemEquipment, "RING")
                }

                "반지3" -> {
                    newItemEquipmentData[5] = itemEquipmentOptionSet(itemEquipment, "RING")
                }

                "반지4" -> {
                    newItemEquipmentData[0] = itemEquipmentOptionSet(itemEquipment, "RING")
                }

                "펜던트" -> {
                    newItemEquipmentData[11] = itemEquipmentOptionSet(itemEquipment, "PENDANT")
                }

                "훈장" -> {
                    newItemEquipmentData[14] = itemEquipmentOptionSet(itemEquipment, "MEDAL")
                }

                "벨트" -> {
                    newItemEquipmentData[21] = itemEquipmentOptionSet(itemEquipment, "BELT")
                }

                "어깨장식" -> {
                    newItemEquipmentData[18] = itemEquipmentOptionSet(itemEquipment, "SHOULDER")
                }

                "포켓 아이템" -> {
                    newItemEquipmentData[20] = itemEquipmentOptionSet(itemEquipment, "POCKET")
                }

                "기계 심장" -> {
                    newItemEquipmentData[29] = itemEquipmentOptionSet(itemEquipment, "HEART")
                }

                "뱃지" -> {
                    newItemEquipmentData[9] = itemEquipmentOptionSet(itemEquipment, "BADGE")
                }

                "엠블렘" -> {
                    newItemEquipmentData[4] = itemEquipmentOptionSet(itemEquipment, "EMBLEM")
                }

                "펜던트2" -> {
                    newItemEquipmentData[6] = itemEquipmentOptionSet(itemEquipment, "PENDANT")
                }
            }
        }

        return newItemEquipmentData
    }
}