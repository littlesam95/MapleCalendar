package com.bodan.maplecalendar.presentation.calendar

sealed class CalendarUiEvent {

    data class NetworkErrorEvent(val message: String = "네트워크에 문제가 있습니다.") : CalendarUiEvent()
}
