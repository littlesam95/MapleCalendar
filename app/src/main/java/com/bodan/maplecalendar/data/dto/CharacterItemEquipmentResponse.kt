package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterItemEquipmentResponse(
    val status: ResponseStatus,
    val characterItemEquipment: CharacterItemEquipment?
)
