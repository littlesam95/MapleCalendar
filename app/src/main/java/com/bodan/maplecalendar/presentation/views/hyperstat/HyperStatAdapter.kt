package com.bodan.maplecalendar.presentation.views.hyperstat

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HyperStatAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = TOTAL_PRESET_COUNT

    override fun createFragment(position: Int): HyperStatPresetFragment {
        val itemId = getItemId(position)

        return HyperStatPresetFragment.newInstance(itemId)
    }

    override fun getItemId(position: Int): Long = (position - START_POSITION).toLong()

    override fun containsItem(itemId: Long): Boolean =
        ((itemId >= START_POSITION) && (itemId < TOTAL_PRESET_COUNT))

    companion object {
        private const val TOTAL_PRESET_COUNT = 3
        const val START_POSITION = 0
    }
}