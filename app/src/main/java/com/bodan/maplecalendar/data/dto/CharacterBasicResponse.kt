package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterBasicResponse(
    val status: ResponseStatus,
    val characterBasic: CharacterBasic?
)
