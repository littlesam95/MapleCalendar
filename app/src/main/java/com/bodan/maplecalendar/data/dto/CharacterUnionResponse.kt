package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterUnionResponse(
    val status: ResponseStatus,
    val characterUnion: CharacterUnion?
)
