package com.bodan.maplecalendar.presentation.views.equipment

import java.util.UUID

sealed class EquipmentDetailUiState(val id: String = UUID.randomUUID().toString()) {

    data class EquipmentDetailOption(
        val optionType: String,
        val totalOption: String,
        val baseOption: String,
        val addOption: String = "",
        val etcOption: String = "",
        val starforceOption: String = "",
        val exceptionalOption: String = ""
    ) : EquipmentDetailUiState() {
        val isMinus: Boolean = when (etcOption) {
            "" -> false

            else -> (etcOption.first() == '-')
        }
        val isZero: Boolean = (totalOption.first() == '0')
        val isForced: Boolean = (totalOption != baseOption)
    }
}