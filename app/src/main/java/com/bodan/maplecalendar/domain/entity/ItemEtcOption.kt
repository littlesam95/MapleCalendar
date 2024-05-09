package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemEtcOption(
    val itemEtcStr: String = "",
    val itemEtcDex: String = "",
    val itemEtcInt: String = "",
    val itemEtcLuk: String = "",
    val itemEtcMaxHp: String = "",
    val itemEtcMaxMp: String = "",
    val itemEtcAttackPower: String = "",
    val itemEtcMagicPower: String = "",
    val itemEtcArmor: String = "",
    val itemEtcSpeed: String = "",
    val itemEtcJump: String = ""
)