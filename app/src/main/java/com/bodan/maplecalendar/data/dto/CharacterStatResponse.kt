package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterStatResponse(
    val status: ResponseStatus,
    val characterStat: CharacterStat?
)
