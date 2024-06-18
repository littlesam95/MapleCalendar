package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterCashItemInfo(
    val cashItemEquipmentPart: String,
    val cashItemEquipmentSlot: String,
    val cashItemName: String,
    val cashItemIcon: String,
    val cashItemDescription: String,
    val cashItemOption: List<CharacterCashItemOption>,
    val dateExpire: String,
    val dateOptionExpire: String,
    val cashItemLabel: String,
    val cashItemColoringPrism: CharacterCashItemColoringPrism,
    val itemGender: String
)