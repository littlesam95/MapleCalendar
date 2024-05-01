package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterItemEquipment(
    val itemEquipments: List<ItemEquipment>,
    val itemTitle: ItemTitle?
)