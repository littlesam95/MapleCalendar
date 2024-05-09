package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class ItemTitle(
    val itemTitleName: String,
    val itemTitleIcon: String,
    val itemTitleDescription: String,
    val itemTitleDateExpire: String?,
    val itemTitleDateOptionExpire: String?
)