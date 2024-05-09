package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterItemEquipment(
    val itemEquipments: List<ItemEquipment>,
    val itemEquipmentsFirstPreset: List<ItemEquipment>,
    val itemEquipmentsSecondPreset: List<ItemEquipment>,
    val itemEquipmentsThirdPreset: List<ItemEquipment>,
    val itemTitle: ItemTitle?
)