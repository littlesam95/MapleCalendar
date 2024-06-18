package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterCashItem(
    val cashItemEquipmentBase: List<CharacterCashItemInfo>,
    val cashItemEquipmentPresets: List<List<CharacterCashItemInfo>>,
    val additionalCashItemEquipmentBase: List<CharacterCashItemInfo>,
    val additionalCashItemEquipmentPresets: List<List<CharacterCashItemInfo>>
)