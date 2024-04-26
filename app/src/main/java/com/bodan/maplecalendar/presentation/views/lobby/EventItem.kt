package com.bodan.maplecalendar.presentation.views.lobby

import java.util.UUID

data class EventItem(
    val eventId: UUID = UUID.randomUUID(),
    val eventName: String,
    val eventIat: String,
    val eventExp: String,
    val eventType: EventType,
    val eventUrl: String,
    val eventImage: String
)

enum class EventType {
    PCROOM, BURNING, COINSHOP, CASH, WORLDLEAP, EVENTWORLD, HUNTING, COORDINATE, DEFAULT, SPECIALSUNDAY
}