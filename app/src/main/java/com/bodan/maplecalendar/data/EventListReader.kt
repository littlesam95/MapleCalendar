package com.bodan.maplecalendar.data

import android.annotation.SuppressLint
import com.bodan.maplecalendar.presentation.lobby.EventItem
import com.bodan.maplecalendar.presentation.lobby.EventType
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
class EventListReader {

    private val db = Firebase.firestore
    private val formatter = SimpleDateFormat("yyyy-MM-dd")

    suspend fun getEventList(): List<EventItem>? {
        val newEvents = mutableListOf<EventItem>()
        var flag = true

        db.collection("EventList")
            .get()
            .addOnSuccessListener { result ->
                for (element in result) {
                    val newEvent = EventItem(
                        eventName = element.data["eventName"].toString(),
                        eventIat = element.data["eventIat"].toString(),
                        eventExp = element.data["eventExp"].toString(),
                        eventType = when (element.data["eventType"].toString()) {
                            "BURNING" -> {
                                EventType.BURNING
                            }

                            "COORDINATE" -> {
                                EventType.COORDINATE
                            }

                            "PCROOM" -> {
                                EventType.PCROOM
                            }

                            "COINSHOP" -> {
                                EventType.COINSHOP
                            }

                            "CASH" -> {
                                EventType.CASH
                            }

                            "WORLDLEAP" -> {
                                EventType.WORLDLEAP
                            }

                            "EVENTWORLD" -> {
                                EventType.EVENTWORLD
                            }

                            "HUNTING" -> {
                                EventType.HUNTING
                            }

                            else -> {
                                EventType.DEFAULT
                            }
                        },
                        eventUrl = element.data["eventUrl"].toString(),
                        eventImage = element.data["eventImage"].toString()
                    )
                    newEvents.add(newEvent)
                }
            }
            .addOnFailureListener {
                flag = false
            }.await()

        return if (flag) newEvents else null
    }

    suspend fun getEventListOfDate(specificDay: String): List<EventItem>? {
        val newEvents = mutableListOf<EventItem>()
        var flag = true

        db.collection("EventList")
            .get()
            .addOnSuccessListener { result ->
                for (element in result) {
                    val iat = formatter.parse(element.data["eventIat"].toString())
                    val exp = formatter.parse(element.data["eventExp"].toString())
                    val compareToIat = iat?.compareTo(formatter.parse(specificDay))
                    val compareToExp = exp?.compareTo(formatter.parse(specificDay))
                    if ((compareToIat != null) && (compareToExp != null)) {
                        if ((compareToIat < 0) && (compareToExp > 0)) {
                            val newEvent = EventItem(
                                eventName = element.data["eventName"].toString(),
                                eventIat = element.data["eventIat"].toString(),
                                eventExp = element.data["eventExp"].toString(),
                                eventType = when (element.data["eventType"].toString()) {
                                    "BURNING" -> {
                                        EventType.BURNING
                                    }

                                    "COORDINATE" -> {
                                        EventType.COORDINATE
                                    }

                                    "PCROOM" -> {
                                        EventType.PCROOM
                                    }

                                    "COINSHOP" -> {
                                        EventType.COINSHOP
                                    }

                                    "CASH" -> {
                                        EventType.CASH
                                    }

                                    "WORLDLEAP" -> {
                                        EventType.WORLDLEAP
                                    }

                                    "EVENTWORLD" -> {
                                        EventType.EVENTWORLD
                                    }

                                    "HUNTING" -> {
                                        EventType.HUNTING
                                    }

                                    else -> {
                                        EventType.DEFAULT
                                    }
                                },
                                eventUrl = element.data["eventUrl"].toString(),
                                eventImage = element.data["eventImage"].toString()
                            )
                            newEvents.add(newEvent)
                            Timber.d("Event: $newEvent")
                        }
                    }
                }
            }
            .addOnFailureListener {
                flag = false
            }.await()

        return if (flag) newEvents else null
    }

    suspend fun getPendingEvents(today: String): Int {
        var countPendingEvents = 0
        var flag = true

        db.collection("EventList")
            .get()
            .addOnSuccessListener { result ->
                for (element in result) {
                    if (element.data["eventExp"].toString() == today) {
                        countPendingEvents++
                        Timber.d(element.data["eventName"].toString())
                    }
                }
            }
            .addOnFailureListener {
                flag = false
            }.await()
        Timber.d(today)
        Timber.d("$countPendingEvents")

        return if (flag) countPendingEvents else 0
    }
}