package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CharacterItemEquipment(
    @Json(name = "item_equipment")
    val itemEquipments: List<ItemEquipment>,

    @Json(name = "title")
    val itemTitle: ItemTitle
)
