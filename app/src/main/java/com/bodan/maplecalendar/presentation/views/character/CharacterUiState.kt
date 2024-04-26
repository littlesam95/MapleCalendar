package com.bodan.maplecalendar.presentation.views.character

import java.util.UUID

sealed class CharacterUiState(val id: String = UUID.randomUUID().toString()) {

    data class CharacterDefaultStat(
        val statTitle: String,
        val statValue: String
    ) : CharacterUiState()

    data class CharacterMainStat(
        val statTitle: String,
        val statValue: String
    ) : CharacterUiState()

    data class CharacterEtcStat(
        val statTitle: String,
        val statValue: String
    ) : CharacterUiState()

    companion object {
        const val DEFAULT_STAT_VIEW_TYPE = 1
        const val MAIN_STAT_VIEW_TYPE = 2
        const val ETC_STAT_VIEW_TYPE = 3
    }
}