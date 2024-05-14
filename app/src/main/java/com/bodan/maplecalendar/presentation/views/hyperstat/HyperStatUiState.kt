package com.bodan.maplecalendar.presentation.views.hyperstat

import com.bodan.maplecalendar.domain.entity.CharacterHyperStatInfo
import java.util.UUID

sealed class HyperStatUiState(val id: String = UUID.randomUUID().toString()) {

    data class HyperStatInfo(
        val statType: String,
        val statLevel: String,
    ) : HyperStatUiState()
}