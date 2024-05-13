package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterHyperStat(
    val hyperStatFirstPreset: List<CharacterHyperStatInfo>,
    val hyperStatFirstPresetRemainPoint: Int,
    val hyperStatSecondPreset: List<CharacterHyperStatInfo>,
    val hyperStatSecondPresetRemainPoint: Int,
    val hyperStatThirdPreset: List<CharacterHyperStatInfo>,
    val hyperStatThirdPresetRemainPoint: Int
)
