package com.bodan.maplecalendar.presentation.equipment

import java.util.UUID

sealed class EquipmentDetailUiState(val id: String = UUID.randomUUID().toString()) {

    data class EquipmentDetailOption(
        val optionType: String,
        val totalOption: String,
        val baseOption: String,
        val addOption: String? = null,
        val etcOption: String? = null,
        val starforceOption: String? = null,
        val exceptionalOption: String? = null
    ) : EquipmentDetailUiState() {
        val isZero: Boolean = if (totalOption.last() == '%') (totalOption == "0%") else (totalOption == "0")
        val isForced: Boolean = (totalOption != baseOption)
    }
}