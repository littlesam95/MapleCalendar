package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemTotalOption(
    val itemTotalStr: String = "",
    val itemTotalDex: String = "",
    val itemTotalInt: String = "",
    val itemTotalLuk: String = "",
    val itemTotalMaxHp: String = "",
    val itemTotalMaxMp: String = "",
    val itemTotalAttackPower: String = "",
    val itemTotalMagicPower: String = "",
    val itemTotalArmor: String = "",
    val itemTotalSpeed: String = "",
    val itemTotalJump: String = "",
    val itemTotalBossDamage: String = "",
    val itemTotalIgnoreMonsterArmor: String = "",
    val itemTotalAllStat: String = "",
    val itemTotalDamage: String = "",
    val itemTotalEquipmentLevelDecrease: String = "",
    val itemTotalMaxHpRate: String = "",
    val itemTotalMaxMpRate: String = ""
)