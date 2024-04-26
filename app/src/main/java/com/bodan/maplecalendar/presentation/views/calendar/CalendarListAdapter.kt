package com.bodan.maplecalendar.presentation.views.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemCalendarDateBinding
import com.bodan.maplecalendar.databinding.ItemCalendarHeaderBinding
import com.bodan.maplecalendar.presentation.views.calendar.CalendarUiState.Companion.DATE_VIEW_TYPE
import com.bodan.maplecalendar.presentation.views.calendar.CalendarUiState.Companion.HEADER_VIEW_TYPE

class CalendarListAdapter(private val onDateClickListener: OnDateClickListener) :
    ListAdapter<CalendarUiState, RecyclerView.ViewHolder>(calendarUiStateDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_VIEW_TYPE -> CalendarHeaderViewHolder(
                ItemCalendarHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> CalendarDateViewHolder(
                ItemCalendarDateBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            HEADER_VIEW_TYPE -> (holder as CalendarHeaderViewHolder).bind(currentList[position] as CalendarUiState.CalendarHeader)

            DATE_VIEW_TYPE -> (holder as CalendarDateViewHolder).bind(
                currentList[position] as CalendarUiState.CalendarDate,
                onDateClickListener
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            currentList[position] is CalendarUiState.CalendarHeader -> HEADER_VIEW_TYPE
            else -> DATE_VIEW_TYPE
        }
    }

    companion object {
        val calendarUiStateDiffUtil = object : DiffUtil.ItemCallback<CalendarUiState>() {
            override fun areItemsTheSame(oldItem: CalendarUiState, newItem: CalendarUiState) =
                (oldItem.id == newItem.id)

            override fun areContentsTheSame(oldItem: CalendarUiState, newItem: CalendarUiState) =
                (oldItem == newItem)
        }
    }

    class CalendarHeaderViewHolder(private val binding: ItemCalendarHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: CalendarUiState.CalendarHeader) {
            binding.header = header
        }
    }

    class CalendarDateViewHolder(private val binding: ItemCalendarDateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(date: CalendarUiState.CalendarDate, clickListener: OnDateClickListener) {
            binding.date = date
            binding.clickListener = clickListener
        }
    }
}