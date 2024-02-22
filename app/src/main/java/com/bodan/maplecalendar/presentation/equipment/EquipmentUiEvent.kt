package com.bodan.maplecalendar.presentation.equipment

sealed class EquipmentUiEvent {

    data object GetItemEquipmentDefault : EquipmentUiEvent()

    data object GetItemEquipmentAndroid : EquipmentUiEvent()

    data object GetItemEquipmentBadge : EquipmentUiEvent()

    data object GetItemEquipmentEmblem : EquipmentUiEvent()

    data object GetItemEquipmentHeart : EquipmentUiEvent()

    data object GetItemEquipmentPocket : EquipmentUiEvent()

    data object GetItemEquipmentSeedring : EquipmentUiEvent()

    data object GetItemEquipmentShield : EquipmentUiEvent()

    data object GetItemEquipmentSubweapon : EquipmentUiEvent()

    data object GetItemEquipmentWeapon : EquipmentUiEvent()

    data object BadRequest : EquipmentUiEvent()

    data object UnauthorizedStatus : EquipmentUiEvent()

    data object Forbidden : EquipmentUiEvent()

    data object TooManyRequests : EquipmentUiEvent()

    data object InternalServerError : EquipmentUiEvent()

    data object SetDarkMode : EquipmentUiEvent()
}