package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.data.model.ItemEquipmentEntity
import com.bodan.maplecalendar.domain.entity.ItemAddOption
import com.bodan.maplecalendar.domain.entity.ItemBaseOption
import com.bodan.maplecalendar.domain.entity.ItemEquipment
import com.bodan.maplecalendar.domain.entity.ItemEtcOption
import com.bodan.maplecalendar.domain.entity.ItemExceptionalOption
import com.bodan.maplecalendar.domain.entity.ItemStarforceOption
import com.bodan.maplecalendar.domain.entity.ItemTitle
import com.bodan.maplecalendar.domain.entity.ItemTotalOption

object CharacterItemEquipmentMapper {

    operator fun invoke(itemEquipmentEntity: ItemEquipmentEntity): CharacterItemEquipment {
        val itemEquipments = mutableListOf<ItemEquipment>()
        val itemEquipmentsFirstPreset = mutableListOf<ItemEquipment>()
        val itemEquipmentsSecondPreset = mutableListOf<ItemEquipment>()
        val itemEquipmentsThirdPreset = mutableListOf<ItemEquipment>()
        val itemTitle = itemEquipmentEntity.itemTitle?.let { title ->
            ItemTitle(
                itemTitleName = title.itemTitleName,
                itemTitleIcon = title.itemTitleIcon,
                itemTitleDescription = title.itemTitleDescription,
                itemTitleDateExpire = title.itemTitleDateExpire,
                itemTitleDateOptionExpire = title.itemTitleDateOptionExpire
            )
        }

        itemEquipmentEntity.itemEquipments.forEach { equipment ->
            val totalOption = ItemTotalOption(
                itemTotalStr = equipment.itemTotalOption.itemTotalStr,
                itemTotalDex = equipment.itemTotalOption.itemTotalDex,
                itemTotalInt = equipment.itemTotalOption.itemTotalInt,
                itemTotalLuk = equipment.itemTotalOption.itemTotalLuk,
                itemTotalMaxHp = equipment.itemTotalOption.itemTotalMaxHp,
                itemTotalMaxMp = equipment.itemTotalOption.itemTotalMaxMp,
                itemTotalAttackPower = equipment.itemTotalOption.itemTotalAttackPower,
                itemTotalMagicPower = equipment.itemTotalOption.itemTotalMagicPower,
                itemTotalArmor = equipment.itemTotalOption.itemTotalArmor,
                itemTotalSpeed = equipment.itemTotalOption.itemTotalSpeed,
                itemTotalJump = equipment.itemTotalOption.itemTotalJump,
                itemTotalBossDamage = equipment.itemTotalOption.itemTotalBossDamage,
                itemTotalIgnoreMonsterArmor = equipment.itemTotalOption.itemTotalIgnoreMonsterArmor,
                itemTotalAllStat = equipment.itemTotalOption.itemTotalAllStat,
                itemTotalDamage = equipment.itemTotalOption.itemTotalDamage,
                itemTotalEquipmentLevelDecrease = equipment.itemTotalOption.itemTotalEquipmentLevelDecrease,
                itemTotalMaxHpRate = equipment.itemTotalOption.itemTotalMaxHpRate,
                itemTotalMaxMpRate = equipment.itemTotalOption.itemTotalMaxMpRate
            )
            val baseOption = ItemBaseOption(
                itemBaseStr = equipment.itemBaseOption.itemBaseStr,
                itemBaseDex = equipment.itemBaseOption.itemBaseDex,
                itemBaseInt = equipment.itemBaseOption.itemBaseInt,
                itemBaseLuk = equipment.itemBaseOption.itemBaseLuk,
                itemBaseMaxHp = equipment.itemBaseOption.itemBaseMaxHp,
                itemBaseMaxMp = equipment.itemBaseOption.itemBaseMaxMp,
                itemBaseAttackPower = equipment.itemBaseOption.itemBaseAttackPower,
                itemBaseMagicPower = equipment.itemBaseOption.itemBaseMagicPower,
                itemBaseArmor = equipment.itemBaseOption.itemBaseArmor,
                itemBaseSpeed = equipment.itemBaseOption.itemBaseSpeed,
                itemBaseJump = equipment.itemBaseOption.itemBaseJump,
                itemBaseBossDamage = equipment.itemBaseOption.itemBaseBossDamage,
                itemBaseIgnoreMonsterArmor = equipment.itemBaseOption.itemBaseIgnoreMonsterArmor,
                itemBaseAllStat = equipment.itemBaseOption.itemBaseAllStat,
                itemBaseMaxHpRate = equipment.itemBaseOption.itemBaseMaxHpRate,
                itemBaseMaxMpRate = equipment.itemBaseOption.itemBaseMaxMpRate,
                itemBaseBaseEquipmentLevel = equipment.itemBaseOption.itemBaseBaseEquipmentLevel
            )
            val exceptionalOption = ItemExceptionalOption(
                itemExceptionalStr = equipment.itemExceptionalOption.itemExceptionalStr,
                itemExceptionalDex = equipment.itemExceptionalOption.itemExceptionalDex,
                itemExceptionalInt = equipment.itemExceptionalOption.itemExceptionalInt,
                itemExceptionalLuk = equipment.itemExceptionalOption.itemExceptionalLuk,
                itemExceptionalMaxHp = equipment.itemExceptionalOption.itemExceptionalMaxHp,
                itemExceptionalMaxMp = equipment.itemExceptionalOption.itemExceptionalMaxMp,
                itemExceptionalAttackPower = equipment.itemExceptionalOption.itemExceptionalAttackPower,
                itemExceptionalMagicPower = equipment.itemExceptionalOption.itemExceptionalMagicPower
            )
            val addOption = ItemAddOption(
                itemAddStr = equipment.itemAddOption.itemAddStr,
                itemAddDex = equipment.itemAddOption.itemAddDex,
                itemAddInt = equipment.itemAddOption.itemAddInt,
                itemAddLuk = equipment.itemAddOption.itemAddLuk,
                itemAddMaxHp = equipment.itemAddOption.itemAddMaxHp,
                itemAddMaxMp = equipment.itemAddOption.itemAddMaxMp,
                itemAddAttackPower = equipment.itemAddOption.itemAddAttackPower,
                itemAddMagicPower = equipment.itemAddOption.itemAddMagicPower,
                itemAddArmor = equipment.itemAddOption.itemAddArmor,
                itemAddSpeed = equipment.itemAddOption.itemAddSpeed,
                itemAddJump = equipment.itemAddOption.itemAddJump,
                itemAddBossDamage = equipment.itemAddOption.itemAddBossDamage,
                itemAddDamage = equipment.itemAddOption.itemAddDamage,
                itemAddAllStat = equipment.itemAddOption.itemAddAllStat,
                itemAddEquipmentLevelDecrease = equipment.itemAddOption.itemAddEquipmentLevelDecrease
            )
            val etcOption = ItemEtcOption(
                itemEtcStr = equipment.itemEtcOption.itemEtcStr,
                itemEtcDex = equipment.itemEtcOption.itemEtcDex,
                itemEtcInt = equipment.itemEtcOption.itemEtcInt,
                itemEtcLuk = equipment.itemEtcOption.itemEtcLuk,
                itemEtcMaxHp = equipment.itemEtcOption.itemEtcMaxHp,
                itemEtcMaxMp = equipment.itemEtcOption.itemEtcMaxMp,
                itemEtcAttackPower = equipment.itemEtcOption.itemEtcAttackPower,
                itemEtcMagicPower = equipment.itemEtcOption.itemEtcMagicPower,
                itemEtcArmor = equipment.itemEtcOption.itemEtcArmor,
                itemEtcSpeed = equipment.itemEtcOption.itemEtcSpeed,
                itemEtcJump = equipment.itemEtcOption.itemEtcJump
            )
            val starforceOption = ItemStarforceOption(
                itemStarforceStr = equipment.itemStarforceOption.itemStarforceStr,
                itemStarforceDex = equipment.itemStarforceOption.itemStarforceDex,
                itemStarforceInt = equipment.itemStarforceOption.itemStarforceInt,
                itemStarforceLuk = equipment.itemStarforceOption.itemStarforceLuk,
                itemStarforceMaxHp = equipment.itemStarforceOption.itemStarforceMaxHp,
                itemStarforceMaxMp = equipment.itemStarforceOption.itemStarforceMaxMp,
                itemStarforceAttackPower = equipment.itemStarforceOption.itemStarforceAttackPower,
                itemStarforceMagicPower = equipment.itemStarforceOption.itemStarforceMagicPower,
                itemStarforceArmor = equipment.itemStarforceOption.itemStarforceArmor,
                itemStarforceSpeed = equipment.itemStarforceOption.itemStarforceSpeed,
                itemStarforceJump = equipment.itemStarforceOption.itemStarforceJump
            )

            itemEquipments.add(
                ItemEquipment(
                    itemEquipmentPart = equipment.itemEquipmentPart,
                    equipmentSlot = equipment.equipmentSlot,
                    itemName = equipment.itemName,
                    itemIcon = equipment.itemIcon,
                    itemDescription = equipment.itemDescription,
                    itemShapeName = equipment.itemShapeName,
                    itemShapeIcon = equipment.itemShapeIcon,
                    itemGender = equipment.itemGender,
                    itemTotalOption = totalOption,
                    itemBaseOption = baseOption,
                    potentialOptionGrade = equipment.potentialOptionGrade,
                    additionalPotentialOptionGrade = equipment.additionalPotentialOptionGrade,
                    potentialOptionFirst = equipment.potentialOptionFirst,
                    potentialOptionSecond = equipment.potentialOptionSecond,
                    potentialOptionThird = equipment.potentialOptionThird,
                    additionalPotentialOptionFirst = equipment.additionalPotentialOptionFirst,
                    additionalPotentialOptionSecond = equipment.additionalPotentialOptionSecond,
                    additionalPotentialOptionThird = equipment.additionalPotentialOptionThird,
                    equipmentLevelIncrease = equipment.equipmentLevelIncrease,
                    itemExceptionalOption = exceptionalOption,
                    itemAddOption = addOption,
                    itemGrowthExp = equipment.itemGrowthExp,
                    itemGrowthLevel = equipment.itemGrowthLevel,
                    itemScrollUpgrade = equipment.itemScrollUpgrade,
                    itemCuttableCount = equipment.itemCuttableCount,
                    itemGoldenHammerFlag = equipment.itemGoldenHammerFlag,
                    itemScrollResilienceCount = equipment.itemScrollResilienceCount,
                    itemScrollUpgradableCount = equipment.itemScrollUpgradableCount,
                    itemSoulName = equipment.itemSoulName,
                    itemSoulOption = equipment.itemSoulOption,
                    itemEtcOption = etcOption,
                    itemStarforce = equipment.itemStarforce,
                    itemStarforceScrollFlag = equipment.itemStarforceScrollFlag,
                    itemStarforceOption = starforceOption,
                    itemSpecialRingLevel = equipment.itemSpecialRingLevel,
                    itemDateExpire = equipment.itemDateExpire
                )
            )
        }

        itemEquipmentEntity.itemEquipmentsFirstPreset.forEach { equipment ->
            val totalOption = ItemTotalOption(
                itemTotalStr = equipment.itemTotalOption.itemTotalStr,
                itemTotalDex = equipment.itemTotalOption.itemTotalDex,
                itemTotalInt = equipment.itemTotalOption.itemTotalInt,
                itemTotalLuk = equipment.itemTotalOption.itemTotalLuk,
                itemTotalMaxHp = equipment.itemTotalOption.itemTotalMaxHp,
                itemTotalMaxMp = equipment.itemTotalOption.itemTotalMaxMp,
                itemTotalAttackPower = equipment.itemTotalOption.itemTotalAttackPower,
                itemTotalMagicPower = equipment.itemTotalOption.itemTotalMagicPower,
                itemTotalArmor = equipment.itemTotalOption.itemTotalArmor,
                itemTotalSpeed = equipment.itemTotalOption.itemTotalSpeed,
                itemTotalJump = equipment.itemTotalOption.itemTotalJump,
                itemTotalBossDamage = equipment.itemTotalOption.itemTotalBossDamage,
                itemTotalIgnoreMonsterArmor = equipment.itemTotalOption.itemTotalIgnoreMonsterArmor,
                itemTotalAllStat = equipment.itemTotalOption.itemTotalAllStat,
                itemTotalDamage = equipment.itemTotalOption.itemTotalDamage,
                itemTotalEquipmentLevelDecrease = equipment.itemTotalOption.itemTotalEquipmentLevelDecrease,
                itemTotalMaxHpRate = equipment.itemTotalOption.itemTotalMaxHpRate,
                itemTotalMaxMpRate = equipment.itemTotalOption.itemTotalMaxMpRate
            )
            val baseOption = ItemBaseOption(
                itemBaseStr = equipment.itemBaseOption.itemBaseStr,
                itemBaseDex = equipment.itemBaseOption.itemBaseDex,
                itemBaseInt = equipment.itemBaseOption.itemBaseInt,
                itemBaseLuk = equipment.itemBaseOption.itemBaseLuk,
                itemBaseMaxHp = equipment.itemBaseOption.itemBaseMaxHp,
                itemBaseMaxMp = equipment.itemBaseOption.itemBaseMaxMp,
                itemBaseAttackPower = equipment.itemBaseOption.itemBaseAttackPower,
                itemBaseMagicPower = equipment.itemBaseOption.itemBaseMagicPower,
                itemBaseArmor = equipment.itemBaseOption.itemBaseArmor,
                itemBaseSpeed = equipment.itemBaseOption.itemBaseSpeed,
                itemBaseJump = equipment.itemBaseOption.itemBaseJump,
                itemBaseBossDamage = equipment.itemBaseOption.itemBaseBossDamage,
                itemBaseIgnoreMonsterArmor = equipment.itemBaseOption.itemBaseIgnoreMonsterArmor,
                itemBaseAllStat = equipment.itemBaseOption.itemBaseAllStat,
                itemBaseMaxHpRate = equipment.itemBaseOption.itemBaseMaxHpRate,
                itemBaseMaxMpRate = equipment.itemBaseOption.itemBaseMaxMpRate,
                itemBaseBaseEquipmentLevel = equipment.itemBaseOption.itemBaseBaseEquipmentLevel
            )
            val exceptionalOption = ItemExceptionalOption(
                itemExceptionalStr = equipment.itemExceptionalOption.itemExceptionalStr,
                itemExceptionalDex = equipment.itemExceptionalOption.itemExceptionalDex,
                itemExceptionalInt = equipment.itemExceptionalOption.itemExceptionalInt,
                itemExceptionalLuk = equipment.itemExceptionalOption.itemExceptionalLuk,
                itemExceptionalMaxHp = equipment.itemExceptionalOption.itemExceptionalMaxHp,
                itemExceptionalMaxMp = equipment.itemExceptionalOption.itemExceptionalMaxMp,
                itemExceptionalAttackPower = equipment.itemExceptionalOption.itemExceptionalAttackPower,
                itemExceptionalMagicPower = equipment.itemExceptionalOption.itemExceptionalMagicPower
            )
            val addOption = ItemAddOption(
                itemAddStr = equipment.itemAddOption.itemAddStr,
                itemAddDex = equipment.itemAddOption.itemAddDex,
                itemAddInt = equipment.itemAddOption.itemAddInt,
                itemAddLuk = equipment.itemAddOption.itemAddLuk,
                itemAddMaxHp = equipment.itemAddOption.itemAddMaxHp,
                itemAddMaxMp = equipment.itemAddOption.itemAddMaxMp,
                itemAddAttackPower = equipment.itemAddOption.itemAddAttackPower,
                itemAddMagicPower = equipment.itemAddOption.itemAddMagicPower,
                itemAddArmor = equipment.itemAddOption.itemAddArmor,
                itemAddSpeed = equipment.itemAddOption.itemAddSpeed,
                itemAddJump = equipment.itemAddOption.itemAddJump,
                itemAddBossDamage = equipment.itemAddOption.itemAddBossDamage,
                itemAddDamage = equipment.itemAddOption.itemAddDamage,
                itemAddAllStat = equipment.itemAddOption.itemAddAllStat,
                itemAddEquipmentLevelDecrease = equipment.itemAddOption.itemAddEquipmentLevelDecrease
            )
            val etcOption = ItemEtcOption(
                itemEtcStr = equipment.itemEtcOption.itemEtcStr,
                itemEtcDex = equipment.itemEtcOption.itemEtcDex,
                itemEtcInt = equipment.itemEtcOption.itemEtcInt,
                itemEtcLuk = equipment.itemEtcOption.itemEtcLuk,
                itemEtcMaxHp = equipment.itemEtcOption.itemEtcMaxHp,
                itemEtcMaxMp = equipment.itemEtcOption.itemEtcMaxMp,
                itemEtcAttackPower = equipment.itemEtcOption.itemEtcAttackPower,
                itemEtcMagicPower = equipment.itemEtcOption.itemEtcMagicPower,
                itemEtcArmor = equipment.itemEtcOption.itemEtcArmor,
                itemEtcSpeed = equipment.itemEtcOption.itemEtcSpeed,
                itemEtcJump = equipment.itemEtcOption.itemEtcJump
            )
            val starforceOption = ItemStarforceOption(
                itemStarforceStr = equipment.itemStarforceOption.itemStarforceStr,
                itemStarforceDex = equipment.itemStarforceOption.itemStarforceDex,
                itemStarforceInt = equipment.itemStarforceOption.itemStarforceInt,
                itemStarforceLuk = equipment.itemStarforceOption.itemStarforceLuk,
                itemStarforceMaxHp = equipment.itemStarforceOption.itemStarforceMaxHp,
                itemStarforceMaxMp = equipment.itemStarforceOption.itemStarforceMaxMp,
                itemStarforceAttackPower = equipment.itemStarforceOption.itemStarforceAttackPower,
                itemStarforceMagicPower = equipment.itemStarforceOption.itemStarforceMagicPower,
                itemStarforceArmor = equipment.itemStarforceOption.itemStarforceArmor,
                itemStarforceSpeed = equipment.itemStarforceOption.itemStarforceSpeed,
                itemStarforceJump = equipment.itemStarforceOption.itemStarforceJump
            )

            itemEquipmentsFirstPreset.add(
                ItemEquipment(
                    itemEquipmentPart = equipment.itemEquipmentPart,
                    equipmentSlot = equipment.equipmentSlot,
                    itemName = equipment.itemName,
                    itemIcon = equipment.itemIcon,
                    itemDescription = equipment.itemDescription,
                    itemShapeName = equipment.itemShapeName,
                    itemShapeIcon = equipment.itemShapeIcon,
                    itemGender = equipment.itemGender,
                    itemTotalOption = totalOption,
                    itemBaseOption = baseOption,
                    potentialOptionGrade = equipment.potentialOptionGrade,
                    additionalPotentialOptionGrade = equipment.additionalPotentialOptionGrade,
                    potentialOptionFirst = equipment.potentialOptionFirst,
                    potentialOptionSecond = equipment.potentialOptionSecond,
                    potentialOptionThird = equipment.potentialOptionThird,
                    additionalPotentialOptionFirst = equipment.additionalPotentialOptionFirst,
                    additionalPotentialOptionSecond = equipment.additionalPotentialOptionSecond,
                    additionalPotentialOptionThird = equipment.additionalPotentialOptionThird,
                    equipmentLevelIncrease = equipment.equipmentLevelIncrease,
                    itemExceptionalOption = exceptionalOption,
                    itemAddOption = addOption,
                    itemGrowthExp = equipment.itemGrowthExp,
                    itemGrowthLevel = equipment.itemGrowthLevel,
                    itemScrollUpgrade = equipment.itemScrollUpgrade,
                    itemCuttableCount = equipment.itemCuttableCount,
                    itemGoldenHammerFlag = equipment.itemGoldenHammerFlag,
                    itemScrollResilienceCount = equipment.itemScrollResilienceCount,
                    itemScrollUpgradableCount = equipment.itemScrollUpgradableCount,
                    itemSoulName = equipment.itemSoulName,
                    itemSoulOption = equipment.itemSoulOption,
                    itemEtcOption = etcOption,
                    itemStarforce = equipment.itemStarforce,
                    itemStarforceScrollFlag = equipment.itemStarforceScrollFlag,
                    itemStarforceOption = starforceOption,
                    itemSpecialRingLevel = equipment.itemSpecialRingLevel,
                    itemDateExpire = equipment.itemDateExpire
                )
            )
        }

        itemEquipmentEntity.itemEquipmentsSecondPreset.forEach { equipment ->
            val totalOption = ItemTotalOption(
                itemTotalStr = equipment.itemTotalOption.itemTotalStr,
                itemTotalDex = equipment.itemTotalOption.itemTotalDex,
                itemTotalInt = equipment.itemTotalOption.itemTotalInt,
                itemTotalLuk = equipment.itemTotalOption.itemTotalLuk,
                itemTotalMaxHp = equipment.itemTotalOption.itemTotalMaxHp,
                itemTotalMaxMp = equipment.itemTotalOption.itemTotalMaxMp,
                itemTotalAttackPower = equipment.itemTotalOption.itemTotalAttackPower,
                itemTotalMagicPower = equipment.itemTotalOption.itemTotalMagicPower,
                itemTotalArmor = equipment.itemTotalOption.itemTotalArmor,
                itemTotalSpeed = equipment.itemTotalOption.itemTotalSpeed,
                itemTotalJump = equipment.itemTotalOption.itemTotalJump,
                itemTotalBossDamage = equipment.itemTotalOption.itemTotalBossDamage,
                itemTotalIgnoreMonsterArmor = equipment.itemTotalOption.itemTotalIgnoreMonsterArmor,
                itemTotalAllStat = equipment.itemTotalOption.itemTotalAllStat,
                itemTotalDamage = equipment.itemTotalOption.itemTotalDamage,
                itemTotalEquipmentLevelDecrease = equipment.itemTotalOption.itemTotalEquipmentLevelDecrease,
                itemTotalMaxHpRate = equipment.itemTotalOption.itemTotalMaxHpRate,
                itemTotalMaxMpRate = equipment.itemTotalOption.itemTotalMaxMpRate
            )
            val baseOption = ItemBaseOption(
                itemBaseStr = equipment.itemBaseOption.itemBaseStr,
                itemBaseDex = equipment.itemBaseOption.itemBaseDex,
                itemBaseInt = equipment.itemBaseOption.itemBaseInt,
                itemBaseLuk = equipment.itemBaseOption.itemBaseLuk,
                itemBaseMaxHp = equipment.itemBaseOption.itemBaseMaxHp,
                itemBaseMaxMp = equipment.itemBaseOption.itemBaseMaxMp,
                itemBaseAttackPower = equipment.itemBaseOption.itemBaseAttackPower,
                itemBaseMagicPower = equipment.itemBaseOption.itemBaseMagicPower,
                itemBaseArmor = equipment.itemBaseOption.itemBaseArmor,
                itemBaseSpeed = equipment.itemBaseOption.itemBaseSpeed,
                itemBaseJump = equipment.itemBaseOption.itemBaseJump,
                itemBaseBossDamage = equipment.itemBaseOption.itemBaseBossDamage,
                itemBaseIgnoreMonsterArmor = equipment.itemBaseOption.itemBaseIgnoreMonsterArmor,
                itemBaseAllStat = equipment.itemBaseOption.itemBaseAllStat,
                itemBaseMaxHpRate = equipment.itemBaseOption.itemBaseMaxHpRate,
                itemBaseMaxMpRate = equipment.itemBaseOption.itemBaseMaxMpRate,
                itemBaseBaseEquipmentLevel = equipment.itemBaseOption.itemBaseBaseEquipmentLevel
            )
            val exceptionalOption = ItemExceptionalOption(
                itemExceptionalStr = equipment.itemExceptionalOption.itemExceptionalStr,
                itemExceptionalDex = equipment.itemExceptionalOption.itemExceptionalDex,
                itemExceptionalInt = equipment.itemExceptionalOption.itemExceptionalInt,
                itemExceptionalLuk = equipment.itemExceptionalOption.itemExceptionalLuk,
                itemExceptionalMaxHp = equipment.itemExceptionalOption.itemExceptionalMaxHp,
                itemExceptionalMaxMp = equipment.itemExceptionalOption.itemExceptionalMaxMp,
                itemExceptionalAttackPower = equipment.itemExceptionalOption.itemExceptionalAttackPower,
                itemExceptionalMagicPower = equipment.itemExceptionalOption.itemExceptionalMagicPower
            )
            val addOption = ItemAddOption(
                itemAddStr = equipment.itemAddOption.itemAddStr,
                itemAddDex = equipment.itemAddOption.itemAddDex,
                itemAddInt = equipment.itemAddOption.itemAddInt,
                itemAddLuk = equipment.itemAddOption.itemAddLuk,
                itemAddMaxHp = equipment.itemAddOption.itemAddMaxHp,
                itemAddMaxMp = equipment.itemAddOption.itemAddMaxMp,
                itemAddAttackPower = equipment.itemAddOption.itemAddAttackPower,
                itemAddMagicPower = equipment.itemAddOption.itemAddMagicPower,
                itemAddArmor = equipment.itemAddOption.itemAddArmor,
                itemAddSpeed = equipment.itemAddOption.itemAddSpeed,
                itemAddJump = equipment.itemAddOption.itemAddJump,
                itemAddBossDamage = equipment.itemAddOption.itemAddBossDamage,
                itemAddDamage = equipment.itemAddOption.itemAddDamage,
                itemAddAllStat = equipment.itemAddOption.itemAddAllStat,
                itemAddEquipmentLevelDecrease = equipment.itemAddOption.itemAddEquipmentLevelDecrease
            )
            val etcOption = ItemEtcOption(
                itemEtcStr = equipment.itemEtcOption.itemEtcStr,
                itemEtcDex = equipment.itemEtcOption.itemEtcDex,
                itemEtcInt = equipment.itemEtcOption.itemEtcInt,
                itemEtcLuk = equipment.itemEtcOption.itemEtcLuk,
                itemEtcMaxHp = equipment.itemEtcOption.itemEtcMaxHp,
                itemEtcMaxMp = equipment.itemEtcOption.itemEtcMaxMp,
                itemEtcAttackPower = equipment.itemEtcOption.itemEtcAttackPower,
                itemEtcMagicPower = equipment.itemEtcOption.itemEtcMagicPower,
                itemEtcArmor = equipment.itemEtcOption.itemEtcArmor,
                itemEtcSpeed = equipment.itemEtcOption.itemEtcSpeed,
                itemEtcJump = equipment.itemEtcOption.itemEtcJump
            )
            val starforceOption = ItemStarforceOption(
                itemStarforceStr = equipment.itemStarforceOption.itemStarforceStr,
                itemStarforceDex = equipment.itemStarforceOption.itemStarforceDex,
                itemStarforceInt = equipment.itemStarforceOption.itemStarforceInt,
                itemStarforceLuk = equipment.itemStarforceOption.itemStarforceLuk,
                itemStarforceMaxHp = equipment.itemStarforceOption.itemStarforceMaxHp,
                itemStarforceMaxMp = equipment.itemStarforceOption.itemStarforceMaxMp,
                itemStarforceAttackPower = equipment.itemStarforceOption.itemStarforceAttackPower,
                itemStarforceMagicPower = equipment.itemStarforceOption.itemStarforceMagicPower,
                itemStarforceArmor = equipment.itemStarforceOption.itemStarforceArmor,
                itemStarforceSpeed = equipment.itemStarforceOption.itemStarforceSpeed,
                itemStarforceJump = equipment.itemStarforceOption.itemStarforceJump
            )

            itemEquipmentsSecondPreset.add(
                ItemEquipment(
                    itemEquipmentPart = equipment.itemEquipmentPart,
                    equipmentSlot = equipment.equipmentSlot,
                    itemName = equipment.itemName,
                    itemIcon = equipment.itemIcon,
                    itemDescription = equipment.itemDescription,
                    itemShapeName = equipment.itemShapeName,
                    itemShapeIcon = equipment.itemShapeIcon,
                    itemGender = equipment.itemGender,
                    itemTotalOption = totalOption,
                    itemBaseOption = baseOption,
                    potentialOptionGrade = equipment.potentialOptionGrade,
                    additionalPotentialOptionGrade = equipment.additionalPotentialOptionGrade,
                    potentialOptionFirst = equipment.potentialOptionFirst,
                    potentialOptionSecond = equipment.potentialOptionSecond,
                    potentialOptionThird = equipment.potentialOptionThird,
                    additionalPotentialOptionFirst = equipment.additionalPotentialOptionFirst,
                    additionalPotentialOptionSecond = equipment.additionalPotentialOptionSecond,
                    additionalPotentialOptionThird = equipment.additionalPotentialOptionThird,
                    equipmentLevelIncrease = equipment.equipmentLevelIncrease,
                    itemExceptionalOption = exceptionalOption,
                    itemAddOption = addOption,
                    itemGrowthExp = equipment.itemGrowthExp,
                    itemGrowthLevel = equipment.itemGrowthLevel,
                    itemScrollUpgrade = equipment.itemScrollUpgrade,
                    itemCuttableCount = equipment.itemCuttableCount,
                    itemGoldenHammerFlag = equipment.itemGoldenHammerFlag,
                    itemScrollResilienceCount = equipment.itemScrollResilienceCount,
                    itemScrollUpgradableCount = equipment.itemScrollUpgradableCount,
                    itemSoulName = equipment.itemSoulName,
                    itemSoulOption = equipment.itemSoulOption,
                    itemEtcOption = etcOption,
                    itemStarforce = equipment.itemStarforce,
                    itemStarforceScrollFlag = equipment.itemStarforceScrollFlag,
                    itemStarforceOption = starforceOption,
                    itemSpecialRingLevel = equipment.itemSpecialRingLevel,
                    itemDateExpire = equipment.itemDateExpire
                )
            )
        }

        itemEquipmentEntity.itemEquipmentsThirdPreset.forEach { equipment ->
            val totalOption = ItemTotalOption(
                itemTotalStr = equipment.itemTotalOption.itemTotalStr,
                itemTotalDex = equipment.itemTotalOption.itemTotalDex,
                itemTotalInt = equipment.itemTotalOption.itemTotalInt,
                itemTotalLuk = equipment.itemTotalOption.itemTotalLuk,
                itemTotalMaxHp = equipment.itemTotalOption.itemTotalMaxHp,
                itemTotalMaxMp = equipment.itemTotalOption.itemTotalMaxMp,
                itemTotalAttackPower = equipment.itemTotalOption.itemTotalAttackPower,
                itemTotalMagicPower = equipment.itemTotalOption.itemTotalMagicPower,
                itemTotalArmor = equipment.itemTotalOption.itemTotalArmor,
                itemTotalSpeed = equipment.itemTotalOption.itemTotalSpeed,
                itemTotalJump = equipment.itemTotalOption.itemTotalJump,
                itemTotalBossDamage = equipment.itemTotalOption.itemTotalBossDamage,
                itemTotalIgnoreMonsterArmor = equipment.itemTotalOption.itemTotalIgnoreMonsterArmor,
                itemTotalAllStat = equipment.itemTotalOption.itemTotalAllStat,
                itemTotalDamage = equipment.itemTotalOption.itemTotalDamage,
                itemTotalEquipmentLevelDecrease = equipment.itemTotalOption.itemTotalEquipmentLevelDecrease,
                itemTotalMaxHpRate = equipment.itemTotalOption.itemTotalMaxHpRate,
                itemTotalMaxMpRate = equipment.itemTotalOption.itemTotalMaxMpRate
            )
            val baseOption = ItemBaseOption(
                itemBaseStr = equipment.itemBaseOption.itemBaseStr,
                itemBaseDex = equipment.itemBaseOption.itemBaseDex,
                itemBaseInt = equipment.itemBaseOption.itemBaseInt,
                itemBaseLuk = equipment.itemBaseOption.itemBaseLuk,
                itemBaseMaxHp = equipment.itemBaseOption.itemBaseMaxHp,
                itemBaseMaxMp = equipment.itemBaseOption.itemBaseMaxMp,
                itemBaseAttackPower = equipment.itemBaseOption.itemBaseAttackPower,
                itemBaseMagicPower = equipment.itemBaseOption.itemBaseMagicPower,
                itemBaseArmor = equipment.itemBaseOption.itemBaseArmor,
                itemBaseSpeed = equipment.itemBaseOption.itemBaseSpeed,
                itemBaseJump = equipment.itemBaseOption.itemBaseJump,
                itemBaseBossDamage = equipment.itemBaseOption.itemBaseBossDamage,
                itemBaseIgnoreMonsterArmor = equipment.itemBaseOption.itemBaseIgnoreMonsterArmor,
                itemBaseAllStat = equipment.itemBaseOption.itemBaseAllStat,
                itemBaseMaxHpRate = equipment.itemBaseOption.itemBaseMaxHpRate,
                itemBaseMaxMpRate = equipment.itemBaseOption.itemBaseMaxMpRate,
                itemBaseBaseEquipmentLevel = equipment.itemBaseOption.itemBaseBaseEquipmentLevel
            )
            val exceptionalOption = ItemExceptionalOption(
                itemExceptionalStr = equipment.itemExceptionalOption.itemExceptionalStr,
                itemExceptionalDex = equipment.itemExceptionalOption.itemExceptionalDex,
                itemExceptionalInt = equipment.itemExceptionalOption.itemExceptionalInt,
                itemExceptionalLuk = equipment.itemExceptionalOption.itemExceptionalLuk,
                itemExceptionalMaxHp = equipment.itemExceptionalOption.itemExceptionalMaxHp,
                itemExceptionalMaxMp = equipment.itemExceptionalOption.itemExceptionalMaxMp,
                itemExceptionalAttackPower = equipment.itemExceptionalOption.itemExceptionalAttackPower,
                itemExceptionalMagicPower = equipment.itemExceptionalOption.itemExceptionalMagicPower
            )
            val addOption = ItemAddOption(
                itemAddStr = equipment.itemAddOption.itemAddStr,
                itemAddDex = equipment.itemAddOption.itemAddDex,
                itemAddInt = equipment.itemAddOption.itemAddInt,
                itemAddLuk = equipment.itemAddOption.itemAddLuk,
                itemAddMaxHp = equipment.itemAddOption.itemAddMaxHp,
                itemAddMaxMp = equipment.itemAddOption.itemAddMaxMp,
                itemAddAttackPower = equipment.itemAddOption.itemAddAttackPower,
                itemAddMagicPower = equipment.itemAddOption.itemAddMagicPower,
                itemAddArmor = equipment.itemAddOption.itemAddArmor,
                itemAddSpeed = equipment.itemAddOption.itemAddSpeed,
                itemAddJump = equipment.itemAddOption.itemAddJump,
                itemAddBossDamage = equipment.itemAddOption.itemAddBossDamage,
                itemAddDamage = equipment.itemAddOption.itemAddDamage,
                itemAddAllStat = equipment.itemAddOption.itemAddAllStat,
                itemAddEquipmentLevelDecrease = equipment.itemAddOption.itemAddEquipmentLevelDecrease
            )
            val etcOption = ItemEtcOption(
                itemEtcStr = equipment.itemEtcOption.itemEtcStr,
                itemEtcDex = equipment.itemEtcOption.itemEtcDex,
                itemEtcInt = equipment.itemEtcOption.itemEtcInt,
                itemEtcLuk = equipment.itemEtcOption.itemEtcLuk,
                itemEtcMaxHp = equipment.itemEtcOption.itemEtcMaxHp,
                itemEtcMaxMp = equipment.itemEtcOption.itemEtcMaxMp,
                itemEtcAttackPower = equipment.itemEtcOption.itemEtcAttackPower,
                itemEtcMagicPower = equipment.itemEtcOption.itemEtcMagicPower,
                itemEtcArmor = equipment.itemEtcOption.itemEtcArmor,
                itemEtcSpeed = equipment.itemEtcOption.itemEtcSpeed,
                itemEtcJump = equipment.itemEtcOption.itemEtcJump
            )
            val starforceOption = ItemStarforceOption(
                itemStarforceStr = equipment.itemStarforceOption.itemStarforceStr,
                itemStarforceDex = equipment.itemStarforceOption.itemStarforceDex,
                itemStarforceInt = equipment.itemStarforceOption.itemStarforceInt,
                itemStarforceLuk = equipment.itemStarforceOption.itemStarforceLuk,
                itemStarforceMaxHp = equipment.itemStarforceOption.itemStarforceMaxHp,
                itemStarforceMaxMp = equipment.itemStarforceOption.itemStarforceMaxMp,
                itemStarforceAttackPower = equipment.itemStarforceOption.itemStarforceAttackPower,
                itemStarforceMagicPower = equipment.itemStarforceOption.itemStarforceMagicPower,
                itemStarforceArmor = equipment.itemStarforceOption.itemStarforceArmor,
                itemStarforceSpeed = equipment.itemStarforceOption.itemStarforceSpeed,
                itemStarforceJump = equipment.itemStarforceOption.itemStarforceJump
            )

            itemEquipmentsThirdPreset.add(
                ItemEquipment(
                    itemEquipmentPart = equipment.itemEquipmentPart,
                    equipmentSlot = equipment.equipmentSlot,
                    itemName = equipment.itemName,
                    itemIcon = equipment.itemIcon,
                    itemDescription = equipment.itemDescription,
                    itemShapeName = equipment.itemShapeName,
                    itemShapeIcon = equipment.itemShapeIcon,
                    itemGender = equipment.itemGender,
                    itemTotalOption = totalOption,
                    itemBaseOption = baseOption,
                    potentialOptionGrade = equipment.potentialOptionGrade,
                    additionalPotentialOptionGrade = equipment.additionalPotentialOptionGrade,
                    potentialOptionFirst = equipment.potentialOptionFirst,
                    potentialOptionSecond = equipment.potentialOptionSecond,
                    potentialOptionThird = equipment.potentialOptionThird,
                    additionalPotentialOptionFirst = equipment.additionalPotentialOptionFirst,
                    additionalPotentialOptionSecond = equipment.additionalPotentialOptionSecond,
                    additionalPotentialOptionThird = equipment.additionalPotentialOptionThird,
                    equipmentLevelIncrease = equipment.equipmentLevelIncrease,
                    itemExceptionalOption = exceptionalOption,
                    itemAddOption = addOption,
                    itemGrowthExp = equipment.itemGrowthExp,
                    itemGrowthLevel = equipment.itemGrowthLevel,
                    itemScrollUpgrade = equipment.itemScrollUpgrade,
                    itemCuttableCount = equipment.itemCuttableCount,
                    itemGoldenHammerFlag = equipment.itemGoldenHammerFlag,
                    itemScrollResilienceCount = equipment.itemScrollResilienceCount,
                    itemScrollUpgradableCount = equipment.itemScrollUpgradableCount,
                    itemSoulName = equipment.itemSoulName,
                    itemSoulOption = equipment.itemSoulOption,
                    itemEtcOption = etcOption,
                    itemStarforce = equipment.itemStarforce,
                    itemStarforceScrollFlag = equipment.itemStarforceScrollFlag,
                    itemStarforceOption = starforceOption,
                    itemSpecialRingLevel = equipment.itemSpecialRingLevel,
                    itemDateExpire = equipment.itemDateExpire
                )
            )
        }

        return CharacterItemEquipment(
            itemEquipments = itemEquipments,
            itemEquipmentsFirstPreset = itemEquipmentsFirstPreset,
            itemEquipmentsSecondPreset = itemEquipmentsSecondPreset,
            itemEquipmentsThirdPreset = itemEquipmentsThirdPreset,
            itemTitle = itemTitle
        )
    }
}