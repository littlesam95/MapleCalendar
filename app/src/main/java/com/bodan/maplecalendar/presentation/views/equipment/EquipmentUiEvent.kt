package com.bodan.maplecalendar.presentation.views.equipment

sealed class EquipmentUiEvent {

    data object WaitItemEquipmentDetail : EquipmentUiEvent()

    data object GetItemEquipmentDetail : EquipmentUiEvent()

    data object CloseItemEquipmentDetail : EquipmentUiEvent()

    data object BadRequest : EquipmentUiEvent()

    data object UnauthorizedStatus : EquipmentUiEvent()

    data object Forbidden : EquipmentUiEvent()

    data object TooManyRequests : EquipmentUiEvent()

    data object InternalServerError : EquipmentUiEvent()

    data object SetDarkMode : EquipmentUiEvent()
}