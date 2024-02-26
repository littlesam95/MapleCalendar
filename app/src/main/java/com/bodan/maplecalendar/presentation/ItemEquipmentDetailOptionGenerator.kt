package com.bodan.maplecalendar.presentation

import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.data.dto.ItemAddOption
import com.bodan.maplecalendar.data.dto.ItemBaseOption
import com.bodan.maplecalendar.data.dto.ItemEtcOption
import com.bodan.maplecalendar.data.dto.ItemExceptionalOption
import com.bodan.maplecalendar.data.dto.ItemStarforceOption
import com.bodan.maplecalendar.data.dto.ItemTotalOption
import com.bodan.maplecalendar.presentation.equipment.EquipmentDetailUiState

object ItemEquipmentDetailOptionGenerator {

    fun itemEquipmentDetailOptionSet(
        totalOption: ItemTotalOption,
        baseOption: ItemBaseOption,
        addOption: ItemAddOption,
        etcOption: ItemEtcOption,
        starforceOption: ItemStarforceOption,
        exceptionalOption: ItemExceptionalOption
    ): List<EquipmentDetailUiState> {
        return arrayListOf<EquipmentDetailUiState> (
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_str),
                totalOption = totalOption.itemTotalStr,
                baseOption = baseOption.itemBaseStr,
                addOption = when (addOption.itemAddStr) {
                    "0" -> ""

                    else -> "+${addOption.itemAddStr}"
                },
                etcOption = when (etcOption.itemEtcStr.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcStr

                    else -> "+${etcOption.itemEtcStr}"
                },
                starforceOption = when (starforceOption.itemStarforceStr) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceStr}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalStr) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalStr}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_dex),
                totalOption = totalOption.itemTotalDex,
                baseOption = baseOption.itemBaseDex,
                addOption = when (addOption.itemAddDex) {
                    "0" -> ""

                    else -> "+${addOption.itemAddDex}"
                },
                etcOption = when (etcOption.itemEtcDex.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcDex

                    else -> "+${etcOption.itemEtcDex}"
                },
                starforceOption = when (starforceOption.itemStarforceDex) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceDex}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalDex) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalDex}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_int),
                totalOption = totalOption.itemTotalInt,
                baseOption = baseOption.itemBaseInt,
                addOption = when (addOption.itemAddInt) {
                    "0" -> ""

                    else -> "+${addOption.itemAddInt}"
                },
                etcOption = when (etcOption.itemEtcInt.first()) {
                    '0'-> ""

                    '-' -> etcOption.itemEtcInt

                    else -> "+${etcOption.itemEtcInt}"
                },
                starforceOption = when (starforceOption.itemStarforceInt) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceInt}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalInt) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalInt}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_luk),
                totalOption = totalOption.itemTotalLuk,
                baseOption = baseOption.itemBaseLuk,
                addOption = when (addOption.itemAddLuk) {
                    "0" -> ""

                    else -> "+${addOption.itemAddLuk}"
                },
                etcOption = when (etcOption.itemEtcLuk.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcLuk

                    else -> "+${etcOption.itemEtcLuk}"
                },
                starforceOption = when (starforceOption.itemStarforceLuk) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceLuk}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalLuk) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalLuk}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_maxhp),
                totalOption = totalOption.itemTotalMaxHp,
                baseOption = baseOption.itemBaseMaxHp,
                addOption = when (addOption.itemAddMaxHp) {
                    "0" -> ""

                    else -> "+${addOption.itemAddMaxHp}"
                },
                etcOption = when (etcOption.itemEtcMaxHp.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcMaxHp

                    else -> "+${etcOption.itemEtcMaxHp}"
                },
                starforceOption = when (starforceOption.itemStarforceMaxHp) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceMaxHp}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalMaxHp) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalMaxHp}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_maxmp),
                totalOption = totalOption.itemTotalMaxMp,
                baseOption = baseOption.itemBaseMaxMp,
                addOption = when (addOption.itemAddMaxMp) {
                    "0" -> ""

                    else -> "+${addOption.itemAddMaxMp}"
                },
                etcOption = when (etcOption.itemEtcMaxMp.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcMaxMp

                    else -> "+${etcOption.itemEtcMaxMp}"
                },
                starforceOption = when (starforceOption.itemStarforceMaxMp) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceMaxMp}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalMaxMp) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalMaxMp}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_maxhp_rate),
                totalOption = "${totalOption.itemTotalMaxHpRate}%",
                baseOption = "${baseOption.itemBaseMaxHpRate}%"
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_maxmp_rate),
                totalOption = "${totalOption.itemTotalMaxMpRate}%",
                baseOption = "${baseOption.itemBaseMaxMpRate}%"
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_attack_power),
                totalOption = totalOption.itemTotalAttackPower,
                baseOption = baseOption.itemBaseAttackPower,
                addOption = when (addOption.itemAddAttackPower) {
                    "0" -> ""

                    else -> "+${addOption.itemAddAttackPower}"
                },
                etcOption = when (etcOption.itemEtcAttackPower.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcAttackPower

                    else -> "+${etcOption.itemEtcAttackPower}"
                },
                starforceOption = when (starforceOption.itemStarforceAttackPower) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceAttackPower}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalAttackPower) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalAttackPower}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_magic_power),
                totalOption = totalOption.itemTotalMagicPower,
                baseOption = baseOption.itemBaseMagicPower,
                addOption = when (addOption.itemAddMagicPower) {
                    "0" -> ""

                    else -> "+${addOption.itemAddMagicPower}"
                },
                etcOption = when (etcOption.itemEtcMagicPower.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcMagicPower

                    else -> "+${etcOption.itemEtcMagicPower}"
                },
                starforceOption = when (starforceOption.itemStarforceMagicPower) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceMagicPower}"
                },
                exceptionalOption = when (exceptionalOption.itemExceptionalMagicPower) {
                    "0" -> ""

                    else -> "+${exceptionalOption.itemExceptionalMagicPower}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_boss_damage),
                totalOption = "${totalOption.itemTotalBossDamage}%",
                baseOption = "${baseOption.itemBaseBossDamage}%",
                addOption = when (addOption.itemAddBossDamage) {
                    "0" -> ""

                    else -> "+${addOption.itemAddBossDamage}%"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_ignore_monster_armor),
                totalOption = "${totalOption.itemTotalIgnoreMonsterArmor}%",
                baseOption = "${baseOption.itemBaseIgnoreMonsterArmor}%"
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_armor),
                totalOption = totalOption.itemTotalArmor,
                baseOption = baseOption.itemBaseArmor,
                addOption = when (addOption.itemAddArmor) {
                    "0" -> ""

                    else -> "+${addOption.itemAddArmor}"
                },
                etcOption = when (etcOption.itemEtcArmor.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcArmor

                    else -> "+${etcOption.itemEtcArmor}"
                },
                starforceOption = when (starforceOption.itemStarforceArmor) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceArmor}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_speed),
                totalOption = totalOption.itemTotalSpeed,
                baseOption = baseOption.itemBaseSpeed,
                addOption = when (addOption.itemAddSpeed) {
                    "0" -> ""

                    else -> "+${addOption.itemAddSpeed}"
                },
                etcOption = when (etcOption.itemEtcSpeed.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcSpeed

                    else -> "+${etcOption.itemEtcSpeed}"
                },
                starforceOption = when (starforceOption.itemStarforceSpeed) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceSpeed}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_jump),
                totalOption = totalOption.itemTotalJump,
                baseOption = baseOption.itemBaseJump,
                addOption = when (addOption.itemAddJump) {
                    "0" -> ""

                    else -> "+${addOption.itemAddJump}"
                },
                etcOption = when (etcOption.itemEtcJump.first()) {
                    '0' -> ""

                    '-' -> etcOption.itemEtcJump

                    else -> "+${etcOption.itemEtcJump}"
                },
                starforceOption = when (starforceOption.itemStarforceJump) {
                    "0" -> ""

                    else -> "+${starforceOption.itemStarforceJump}"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_damage),
                totalOption = "${totalOption.itemTotalDamage}%",
                baseOption = "0%",
                addOption = when (addOption.itemAddDamage) {
                    "0" -> ""

                    else -> "+${addOption.itemAddDamage}%"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_all_stat),
                totalOption = "${totalOption.itemTotalAllStat}%",
                baseOption = "${baseOption.itemBaseAllStat}%",
                addOption = when (addOption.itemAddAllStat) {
                    "0" -> ""

                    else -> "+${addOption.itemAddAllStat}%"
                }
            ),
            EquipmentDetailUiState.EquipmentDetailOption(
                optionType = MainApplication.myContext().getString(R.string.text_equipment_equipment_level_decrease),
                totalOption = totalOption.itemTotalEquipmentLevelDecrease,
                baseOption = addOption.itemAddEquipmentLevelDecrease
            )
        ).toList()
    }
}