package com.bodan.maplecalendar.presentation.utils

import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class DateFormatConverter {

    private val yesterdayTime = LocalDateTime.now().plusDays(-1)
    private val todayTime = LocalDateTime.now()
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    private fun getDayOfWeek(): String {
        when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            1 -> return MainApplication.myContext().getString(R.string.text_sunday)

            2 -> return MainApplication.myContext().getString(R.string.text_monday)

            3 -> return MainApplication.myContext().getString(R.string.text_tuesday)

            4 -> return MainApplication.myContext().getString(R.string.text_wednesday)

            5 -> return MainApplication.myContext().getString(R.string.text_thursday)

            6 -> return MainApplication.myContext().getString(R.string.text_friday)
        }

        return MainApplication.myContext().getString(R.string.text_saturday)
    }

    private fun todayDay(): Int {
        return todayTime.dayOfMonth
    }

    fun selectedSearchDateFormatted(year: Int, month: Int, day: Int): String {
        val selectedSearchDate = LocalDate.of(year, month, day)
        return formatter.format(selectedSearchDate)
    }

    fun yesterdayFormatted(): String {
        return yesterdayTime.format(formatter)
    }

    fun todayFormatted(): String {
        return todayTime.format(formatter)
    }

    fun todayYear(): Int {
        return todayTime.year
    }

    fun todayMonth(): Int {
        return todayTime.monthValue
    }

    fun todayHour(): Int {
        return todayTime.hour
    }

    fun todayMinute(): Int {
        return todayTime.minute
    }

    fun todayOtherFormatted(): String {
        return "${todayYear()}년 ${todayMonth()}월 ${todayDay()}일 ${getDayOfWeek()}요일"
    }
}