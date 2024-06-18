package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.CashItemEntity
import com.bodan.maplecalendar.data.model.CashItemInfoEntity
import com.bodan.maplecalendar.domain.entity.CharacterCashItem
import com.bodan.maplecalendar.domain.entity.CharacterCashItemColoringPrism
import com.bodan.maplecalendar.domain.entity.CharacterCashItemInfo
import com.bodan.maplecalendar.domain.entity.CharacterCashItemOption

object CharacterCashItemMapper {

    private fun getCashItemInfos(cashItemInfos: List<CashItemInfoEntity>): List<CharacterCashItemInfo> {
        val result = mutableListOf<CharacterCashItemInfo>()

        cashItemInfos.forEach { cashItemInfo ->
            val newCashItemOptions = mutableListOf<CharacterCashItemOption>()
            cashItemInfo.cashItemOption.forEach { option ->
                newCashItemOptions.add(
                    CharacterCashItemOption(
                        optionType = option.optionType,
                        optionValue = option.optionValue
                    )
                )
            }

            result.add(
                CharacterCashItemInfo(
                    cashItemEquipmentPart = cashItemInfo.cashItemEquipmentPart,
                    cashItemEquipmentSlot = cashItemInfo.cashItemEquipmentSlot,
                    cashItemName = cashItemInfo.cashItemName,
                    cashItemIcon = cashItemInfo.cashItemIcon,
                    cashItemDescription = cashItemInfo.cashItemDescription,
                    cashItemOption = newCashItemOptions,
                    dateExpire = cashItemInfo.dateExpire,
                    dateOptionExpire = cashItemInfo.dateOptionExpire,
                    cashItemLabel = cashItemInfo.cashItemLabel,
                    cashItemColoringPrism = when (cashItemInfo.cashItemColoringPrism) {
                        null -> null

                        else -> CharacterCashItemColoringPrism(
                            colorRange = cashItemInfo.cashItemColoringPrism.colorRange,
                            hue = cashItemInfo.cashItemColoringPrism.hue.toString(),
                            saturation = cashItemInfo.cashItemColoringPrism.saturation.toString(),
                            value = cashItemInfo.cashItemColoringPrism.value.toString()
                        )
                    },
                    itemGender = cashItemInfo.itemGender
                )
            )
        }

        return result.toList()
    }

    operator fun invoke(cashItemEntity: CashItemEntity): CharacterCashItem {
        val newCashItemEquipmentBase = mutableListOf<CharacterCashItemInfo>()
        val newCashItemEquipmentPresets = mutableListOf<List<CharacterCashItemInfo>>()
        val newAdditionalCashItemEquipmentBase = mutableListOf<CharacterCashItemInfo>()
        val newAdditionalCashItemEquipmentPresets = mutableListOf<List<CharacterCashItemInfo>>()

        cashItemEntity.cashItemEquipmentBase.forEach { cashItemInfo ->
            val newCashItemOptions = mutableListOf<CharacterCashItemOption>()
            cashItemInfo.cashItemOption.forEach { option ->
                newCashItemOptions.add(
                    CharacterCashItemOption(
                        optionType = option.optionType,
                        optionValue = option.optionValue
                    )
                )
            }

            newCashItemEquipmentBase.add(
                CharacterCashItemInfo(
                    cashItemEquipmentPart = cashItemInfo.cashItemEquipmentPart,
                    cashItemEquipmentSlot = cashItemInfo.cashItemEquipmentSlot,
                    cashItemName = cashItemInfo.cashItemName,
                    cashItemIcon = cashItemInfo.cashItemIcon,
                    cashItemDescription = cashItemInfo.cashItemDescription,
                    cashItemOption = newCashItemOptions,
                    dateExpire = cashItemInfo.dateExpire,
                    dateOptionExpire = cashItemInfo.dateOptionExpire,
                    cashItemLabel = cashItemInfo.cashItemLabel,
                    cashItemColoringPrism = when (cashItemInfo.cashItemColoringPrism) {
                        null -> null

                        else -> CharacterCashItemColoringPrism(
                            colorRange = cashItemInfo.cashItemColoringPrism.colorRange,
                            hue = cashItemInfo.cashItemColoringPrism.hue.toString(),
                            saturation = cashItemInfo.cashItemColoringPrism.saturation.toString(),
                            value = cashItemInfo.cashItemColoringPrism.value.toString()
                        )
                    },
                    itemGender = cashItemInfo.itemGender
                )
            )
        }

        newCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.cashItemEquipmentFirstPreset)
        )
        newCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.cashItemEquipmentSecondPreset)
        )
        newCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.cashItemEquipmentThirdPreset)
        )

        cashItemEntity.additionalCashItemEquipmentBase.forEach { cashItemInfo ->
            val newCashItemOptions = mutableListOf<CharacterCashItemOption>()
            cashItemInfo.cashItemOption.forEach { option ->
                newCashItemOptions.add(
                    CharacterCashItemOption(
                        optionType = option.optionType,
                        optionValue = option.optionValue
                    )
                )
            }

            newAdditionalCashItemEquipmentBase.add(
                CharacterCashItemInfo(
                    cashItemEquipmentPart = cashItemInfo.cashItemEquipmentPart,
                    cashItemEquipmentSlot = cashItemInfo.cashItemEquipmentSlot,
                    cashItemName = cashItemInfo.cashItemName,
                    cashItemIcon = cashItemInfo.cashItemIcon,
                    cashItemDescription = cashItemInfo.cashItemDescription,
                    cashItemOption = newCashItemOptions,
                    dateExpire = cashItemInfo.dateExpire,
                    dateOptionExpire = cashItemInfo.dateOptionExpire,
                    cashItemLabel = cashItemInfo.cashItemLabel,
                    cashItemColoringPrism = when (cashItemInfo.cashItemColoringPrism) {
                        null -> null

                        else -> CharacterCashItemColoringPrism(
                            colorRange = cashItemInfo.cashItemColoringPrism.colorRange,
                            hue = cashItemInfo.cashItemColoringPrism.hue.toString(),
                            saturation = cashItemInfo.cashItemColoringPrism.saturation.toString(),
                            value = cashItemInfo.cashItemColoringPrism.value.toString()
                        )
                    },
                    itemGender = cashItemInfo.itemGender
                )
            )
        }

        newAdditionalCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.additionalCashItemEquipmentFirstPreset)
        )
        newAdditionalCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.additionalCashItemEquipmentSecondPreset)
        )
        newAdditionalCashItemEquipmentPresets.add(
            getCashItemInfos(cashItemEntity.additionalCashItemEquipmentThirdPreset)
        )

        return CharacterCashItem(
            cashItemEquipmentBase = newCashItemEquipmentBase,
            cashItemEquipmentPresets = newCashItemEquipmentPresets,
            additionalCashItemEquipmentBase = newAdditionalCashItemEquipmentBase,
            additionalCashItemEquipmentPresets = newAdditionalCashItemEquipmentPresets
        )
    }
}