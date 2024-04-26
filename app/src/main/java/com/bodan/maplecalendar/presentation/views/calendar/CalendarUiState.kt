package com.bodan.maplecalendar.presentation.views.calendar

import com.bodan.maplecalendar.R
import java.util.UUID

sealed class CalendarUiState(val id: String = UUID.randomUUID().toString()) {

    data class CalendarHeader(
        val type: DayType,
        val name: String,
        val backgroundResId: Int = R.drawable.shape_calendar_header
    ) : CalendarUiState()

    data class CalendarDate(
        val type: DayType,
        val name: String,
        val backgroundResId: Int = R.drawable.shape_calendar_date
    ) : CalendarUiState()

    companion object {
        const val HEADER_VIEW_TYPE = 1
        const val DATE_VIEW_TYPE = 2
    }
}

enum class DayType {
    SATURDAY, SUNDAY, DEFAULT
}