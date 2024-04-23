package com.bodan.maplecalendar.presentation.lobby

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.joda.time.DateTime

class CustomCalendarAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private var startDay: Long = DateTime().withDayOfMonth(1).withTimeAtStartOfDay().millis

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun createFragment(position: Int): CustomCalendarFragment {
        val millis = getItemId(position)

        return CustomCalendarFragment.newInstance(millis)
    }

    override fun getItemId(position: Int): Long =
        DateTime(startDay).plusMonths(position - START_POSITION).millis

    override fun containsItem(itemId: Long): Boolean {
        val date = DateTime(itemId)

        return ((date.dayOfMonth == 1) && (date.millisOfDay == 0))
    }

    companion object {
        const val START_POSITION = Int.MAX_VALUE / 2
    }
}