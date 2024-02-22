package com.bodan.maplecalendar.data.dto

import com.bodan.maplecalendar.data.ResponseStatus

data class CharacterPopularityResponse(
    val status: ResponseStatus,
    val characterPopularity: CharacterPopularity?
)