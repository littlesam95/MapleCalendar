package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class ItemTitle(
    @Json(name = "title_name")
    val itemTitleName: String,

    @Json(name = "title_icon")
    val itemTitleIcon: String,

    @Json(name = "title_description")
    val itemTitleDescription: String,

    @Json(name = "date_expire")
    val itemTitleDateExpire: String?,

    @Json(name = "date_option_expire")
    val itemTitleDateOptionExpire: String?
)
