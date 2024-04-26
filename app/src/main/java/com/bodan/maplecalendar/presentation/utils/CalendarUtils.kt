package com.bodan.maplecalendar.presentation.utils

import androidx.annotation.ColorInt
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import java.util.Calendar

object CalendarUtils {

    const val DAYS_PER_WEEK = 7
    const val WEEKS_PER_MONTH = 6 + 1

    private val dateFormatConverter = DateFormatConverter()

    fun getDaysOfMonth(year: Int, month: Int): List<Int> {
        val result = MutableList(42) { -1 }
        val newCalendar = Calendar.getInstance()

        var nowDate = 1
        newCalendar.set(year, month - 1, nowDate)
        while (true) {
            val nowWeek = newCalendar.get(Calendar.WEEK_OF_MONTH)
            val nowDay = newCalendar.get(Calendar.DAY_OF_WEEK)
            result[((nowWeek - 1) * 7) + nowDay - 1] = newCalendar.get(Calendar.DATE)

            nowDate++
            if (nowDate > newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) break

            newCalendar.set(year, month - 1, nowDate)
        }

        return result
    }

    fun isSearchDateRange(year: Int, month: Int, day: Int): Boolean {
        if (day == -1) return false

        val firstDate =
            dateFormatConverter.selectedSearchDateFormatted(year = 2023, month = 12, day = 21)
        val searchDate = dateFormatConverter.selectedSearchDateFormatted(year, month, day)
        val yesterdayFormatted = dateFormatConverter.yesterdayFormatted()

        return ((firstDate <= searchDate) && (searchDate <= yesterdayFormatted))
    }

    @ColorInt
    fun getDateColor(year: Int, month: Int, day: Int): Int {
        val newCalendar = Calendar.getInstance()
        newCalendar.set(year, month - 1, day)
        return when (newCalendar.get(Calendar.DAY_OF_WEEK)) {
            1 -> {
                MainApplication.myContext().resources.getColor(
                    R.color.alert,
                    MainApplication.myContext().theme
                )
            }

            7 -> {
                MainApplication.myContext().resources.getColor(
                    R.color.submit,
                    MainApplication.myContext().theme
                )
            }

            else -> {
                MainApplication.myContext().resources.getColor(
                    R.color.black,
                    MainApplication.myContext().theme
                )
            }
        }
    }

    @ColorInt
    fun getDayOfWeekColor(dayOfWeek: String): Int {
        return when (dayOfWeek) {
            MainApplication.myContext().getString(R.string.text_sunday) -> {
                MainApplication.myContext().resources.getColor(
                    R.color.alert,
                    MainApplication.myContext().theme
                )
            }

            MainApplication.myContext().getString(R.string.text_saturday) -> {
                MainApplication.myContext().resources.getColor(
                    R.color.submit,
                    MainApplication.myContext().theme
                )
            }

            else -> {
                MainApplication.myContext().resources.getColor(
                    R.color.black,
                    MainApplication.myContext().theme
                )
            }
        }
    }
}