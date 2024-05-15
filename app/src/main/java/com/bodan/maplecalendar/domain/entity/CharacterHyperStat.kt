package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterHyperStat(
    val hyperStats: List<List<CharacterHyperStatInfo>>,
    val hyperStatRemainPoints: List<Int>
)
