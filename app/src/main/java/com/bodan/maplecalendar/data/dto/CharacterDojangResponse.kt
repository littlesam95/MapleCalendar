package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterDojangResponse(
    val status: ResponseStatus,
    val characterDojang: CharacterDojang?
)