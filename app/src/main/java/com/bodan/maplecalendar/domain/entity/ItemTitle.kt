package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
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
