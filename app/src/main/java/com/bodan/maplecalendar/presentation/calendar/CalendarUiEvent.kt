package com.bodan.maplecalendar.presentation.calendar

sealed class CalendarUiEvent {

    data object BadRequest : CalendarUiEvent()

    data object UnauthorizedStatus : CalendarUiEvent()

    data object Forbidden : CalendarUiEvent()

    data object TooManyRequests : CalendarUiEvent()

    data object InternalServerError : CalendarUiEvent()

    data object GetEventsOfDate : CalendarUiEvent()

    data object CloseEventsOfDate : CalendarUiEvent()

    data object StartEventUrl : CalendarUiEvent()

    data object SetDarkMode : CalendarUiEvent()
}
