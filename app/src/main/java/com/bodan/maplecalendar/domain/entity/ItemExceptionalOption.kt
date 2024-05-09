package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemExceptionalOption(
    val itemExceptionalStr: String = "",
    val itemExceptionalDex: String = "",
    val itemExceptionalInt: String = "",
    val itemExceptionalLuk: String = "",
    val itemExceptionalMaxHp: String = "",
    val itemExceptionalMaxMp: String = "",
    val itemExceptionalAttackPower: String = "",
    val itemExceptionalMagicPower: String = "",
)