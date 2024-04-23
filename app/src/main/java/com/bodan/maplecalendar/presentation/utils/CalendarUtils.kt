package com.bodan.maplecalendar.presentation.utils

import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.bodan.maplecalendar.R
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants

object CalendarUtils {

    const val WEEKS_PER_MONTH = 6

    private fun getPrevMonth(dateTime: DateTime): Int {
        var prevMonthTailOffset = dateTime.dayOfWeek
        if (prevMonthTailOffset >= 7) prevMonthTailOffset %= 7
        return prevMonthTailOffset
    }

    fun getMonthList(dateTime: DateTime): List<DateTime> {
        val result = mutableListOf<DateTime>()

        val date = dateTime.withDayOfMonth(1)
        val prev = getPrevMonth(date)
        val startValue = date.minusDays(prev)
        val totalDay = DateTimeConstants.DAYS_PER_WEEK * WEEKS_PER_MONTH

        for (index in 0 until totalDay) {
            result.add(DateTime(startValue.plusDays(index)))
        }

        return result
    }

    fun isSameMonth(firstDateTime: DateTime, secondDateTime: DateTime): Boolean =
        ((firstDateTime.year == secondDateTime.year) && (firstDateTime.monthOfYear == secondDateTime.monthOfYear))


    @ColorInt
    fun getDateColor(@IntRange(from = 1, to = 7) dayOfWeek: Int): Int {
        return when (dayOfWeek) {
            DateTimeConstants.SATURDAY -> {
                R.color.submit
            }

            DateTimeConstants.SUNDAY -> {
                R.color.alert
            }

            else -> {
                R.color.black
            }
        }
    }
}