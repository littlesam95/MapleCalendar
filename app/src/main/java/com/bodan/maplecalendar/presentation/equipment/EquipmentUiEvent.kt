package com.bodan.maplecalendar.presentation.equipment

sealed class EquipmentUiEvent {

    data object BadRequest : EquipmentUiEvent()

    data object UnauthorizedStatus : EquipmentUiEvent()

    data object Forbidden : EquipmentUiEvent()

    data object TooManyRequests : EquipmentUiEvent()

    data object InternalServerError : EquipmentUiEvent()

    data object SetDarkMode : EquipmentUiEvent()
}