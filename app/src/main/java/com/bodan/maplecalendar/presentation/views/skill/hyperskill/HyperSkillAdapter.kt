package com.bodan.maplecalendar.presentation.views.skill.hyperskill

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HyperSkillAdapter(fm: FragmentActivity, private val size: Int) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = size

    override fun createFragment(position: Int): Fragment {
        val itemId = getItemId(position)

        return HyperSkillInfoFragment.newInstance(itemId)
    }

    override fun getItemId(position: Int): Long = (position - START_POSITION).toLong()

    override fun containsItem(itemId: Long): Boolean = ((itemId >= START_POSITION) && (itemId < size))

    companion object {
        const val START_POSITION = 0
    }
}