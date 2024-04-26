package com.bodan.maplecalendar.presentation.views.lobby

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.presentation.utils.DateFormatConverter
import kotlin.math.abs

class CustomCalendarAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private val dateFormatConverter = DateFormatConverter()

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun createFragment(position: Int): CustomCalendarFragment {
        val itemId = getItemId(position)

        return CustomCalendarFragment.newInstance(itemId)
    }

    override fun getItemId(position: Int): Long {
        val searchDate =
            MainApplication.mySharedPreferences.getSearchDate("searchDate", null) ?: return 0
        var currentYear = searchDate.substring(0, 4).toInt()
        var currentMonth = searchDate.substring(5, 7).toInt()

        val move = position - START_POSITION
        val bias = if (move < 0) -1 else 1

        val moveYear = abs(move) / 12 * bias
        val moveMonth = abs(move) % 12 * bias

        currentYear += moveYear
        when {
            (currentMonth + moveMonth) < 1 -> {
                currentMonth = 12 + (currentMonth + moveMonth)
                currentYear--
            }

            (currentMonth + moveMonth) > 12 -> {
                currentMonth = (currentMonth + moveMonth) - 12
                currentYear++
            }

            else -> {
                currentMonth = (currentMonth + moveMonth)
            }
        }

        return (currentYear * 100 + currentMonth).toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        val nowMonth =
            ((dateFormatConverter.todayYear() * 100) + dateFormatConverter.todayMonth() + 1).toLong()

        return ((itemId > 202311L) && (itemId < nowMonth))
    }

    companion object {
        const val START_POSITION = Int.MAX_VALUE / 2
    }
}