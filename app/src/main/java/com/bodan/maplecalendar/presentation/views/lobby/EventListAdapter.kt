package com.bodan.maplecalendar.presentation.views.lobby

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemRecyclerViewLobbyBinding
import com.bodan.maplecalendar.domain.entity.EventItem

class EventListAdapter(private val onEventClickListener: OnEventClickListener) :
    ListAdapter<EventItem, RecyclerView.ViewHolder>(eventItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DefaultViewHolder(
            ItemRecyclerViewLobbyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DefaultViewHolder).bind(currentList[position], onEventClickListener)
    }

    companion object {
        val eventItemDiffUtil = object : DiffUtil.ItemCallback<EventItem>() {
            override fun areItemsTheSame(oldItem: EventItem, newItem: EventItem): Boolean =
                (oldItem.eventId == newItem.eventId)

            override fun areContentsTheSame(oldItem: EventItem, newItem: EventItem): Boolean =
                (oldItem == newItem)

        }
    }

    class DefaultViewHolder(private val binding: ItemRecyclerViewLobbyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EventItem, clickListener: OnEventClickListener) {
            binding.eventItem = item
            binding.clickListener = clickListener
        }
    }
}