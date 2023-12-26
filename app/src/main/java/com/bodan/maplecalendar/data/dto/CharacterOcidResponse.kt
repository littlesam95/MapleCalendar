package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterOcidResponse(
    val status: ResponseStatus,
    val characterOcid: CharacterOcid?
)