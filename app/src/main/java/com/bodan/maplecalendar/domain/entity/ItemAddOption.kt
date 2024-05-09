package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemAddOption(
    val itemAddStr: String = "",
    val itemAddDex: String = "",
    val itemAddInt: String = "",
    val itemAddLuk: String = "",
    val itemAddMaxHp: String = "",
    val itemAddMaxMp: String = "",
    val itemAddAttackPower: String = "",
    val itemAddMagicPower: String = "",
    val itemAddArmor: String = "",
    val itemAddSpeed: String = "",
    val itemAddJump: String = "",
    val itemAddBossDamage: String = "",
    val itemAddDamage: String = "",
    val itemAddAllStat: String = "",
    val itemAddEquipmentLevelDecrease: String = "",
)