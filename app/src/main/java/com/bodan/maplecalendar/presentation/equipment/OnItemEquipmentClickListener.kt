package com.bodan.maplecalendar.presentation.equipment

interface OnItemEquipmentClickListener {

    fun onItemEquipmentDefaultClicked(equipmentUiState: EquipmentUiState.EquipmentDefault)

    fun onItemEquipmentAndroidClicked(equipmentUiState: EquipmentUiState.EquipmentAndroid)

    fun onItemEquipmentBadgeClicked(equipmentUiState: EquipmentUiState.EquipmentBadge)

    fun onItemEquipmentEmblemClicked(equipmentUiState: EquipmentUiState.EquipmentEmblem)

    fun onItemEquipmentHeartClicked(equipmentUiState: EquipmentUiState.EquipmentHeart)

    fun onItemEquipmentPocketClicked(equipmentUiState: EquipmentUiState.EquipmentPocket)

    fun onItemEquipmentSeedringClicked(equipmentUiState: EquipmentUiState.EquipmentSeedring)

    fun onItemEquipmentShieldClicked(equipmentUiState: EquipmentUiState.EquipmentShield)

    fun onItemEquipmentSubweaponClicked(equipmentUiState: EquipmentUiState.EquipmentSubweapon)

    fun onItemEquipmentWeaponClicked(equipmentUiState: EquipmentUiState.EquipmentWeapon)
}