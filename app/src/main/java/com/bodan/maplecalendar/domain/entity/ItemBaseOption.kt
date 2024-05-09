package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemBaseOption(
    val itemBaseStr: String = "",
    val itemBaseDex: String = "",
    val itemBaseInt: String = "",
    val itemBaseLuk: String = "",
    val itemBaseMaxHp: String = "",
    val itemBaseMaxMp: String = "",
    val itemBaseAttackPower: String = "",
    val itemBaseMagicPower: String = "",
    val itemBaseArmor: String = "",
    val itemBaseSpeed: String = "",
    val itemBaseJump: String = "",
    val itemBaseBossDamage: String = "",
    val itemBaseIgnoreMonsterArmor: String = "",
    val itemBaseAllStat: String = "",
    val itemBaseMaxHpRate: String = "",
    val itemBaseMaxMpRate: String = "",
    val itemBaseBaseEquipmentLevel: String = "",
)