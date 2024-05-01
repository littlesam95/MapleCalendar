package com.bodan.maplecalendar.data.util

import android.annotation.SuppressLint
import com.bodan.maplecalendar.domain.entity.EventItem
import com.bodan.maplecalendar.domain.entity.EventType
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
class EventListReader {

    private val db: FirebaseFirestore = Firebase.firestore
    private val formatter: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")

    suspend fun getEventList(specificDay: String): List<EventItem>? {
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
                        if ((compareToIat <= 0) && (compareToExp >= 0)) {
                            val newEvent = EventItem(
                                eventName = element.data["eventName"].toString(),
                                eventIat = element.data["eventIat"].toString(),
                                eventExp = element.data["eventExp"].toString(),
                                eventType = getEventTypes(element.data["eventType"].toString()),
                                eventUrl = element.data["eventUrl"].toString(),
                                eventImage = element.data["eventImage"].toString()
                            )
                            newEvents.add(newEvent)
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
                    if (today == element.data["eventExp"].toString()) {
                        countPendingEvents++
                    }
                }
            }
            .addOnFailureListener {
                flag = false
            }.await()

        return if (flag) countPendingEvents else 0
    }

    private fun getEventTypes(eventType: String): List<EventType> {
        val result = mutableListOf<EventType>()
        val eventTypes = eventType.split(',')
        for (element in eventTypes) {
            when (element) {
                "DAYCHECK" -> {
                    result.add(EventType.DAYCHECK)
                }

                "MINIGAME" -> {
                    result.add(EventType.MINIGAME)
                }

                "BURNING" -> {
                    result.add(EventType.BURNING)
                }

                "BOSS" -> {
                    result.add(EventType.BOSS)
                }

                "PUNCHKING" -> {
                    result.add(EventType.PUNCHKING)
                }

                "SPECIALSTAT" -> {
                    result.add(EventType.SPECIALSTAT)
                }

                "COORDINATE" -> {
                    result.add(EventType.COORDINATE)
                }

                "PCROOM" -> {
                    result.add(EventType.PCROOM)
                }

                "COINSHOP" -> {
                    result.add(EventType.COINSHOP)
                }

                "CASH" -> {
                    result.add(EventType.CASH)
                }

                "WORLDLEAP" -> {
                    result.add(EventType.WORLDLEAP)
                }

                "EVENTWORLD" -> {
                    result.add(EventType.EVENTWORLD)
                }

                "HUNTING" -> {
                    result.add(EventType.HUNTING)
                }

                "SPECIALSUNDAY" -> {
                    result.add(EventType.SPECIALSUNDAY)
                }

                else -> {
                    result.add(EventType.DEFAULT)
                }
            }
        }

        return result.toList()
    }
}