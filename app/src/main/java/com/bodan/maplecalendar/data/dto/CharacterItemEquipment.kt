package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CharacterItemEquipment(
    @Json(name = "item_equipment")
    val itemEquipments: List<ItemEquipment>,

    @Json(name = "title")
    val itemTitle: ItemTitle?
)
