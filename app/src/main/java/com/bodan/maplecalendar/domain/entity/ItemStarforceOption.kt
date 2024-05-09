package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemStarforceOption(
    val itemStarforceStr: String = "",
    val itemStarforceDex: String = "",
    val itemStarforceInt: String = "",
    val itemStarforceLuk: String = "",
    val itemStarforceMaxHp: String = "",
    val itemStarforceMaxMp: String = "",
    val itemStarforceAttackPower: String = "",
    val itemStarforceMagicPower: String = "",
    val itemStarforceArmor: String = "",
    val itemStarforceSpeed: String = "",
    val itemStarforceJump: String = ""
)