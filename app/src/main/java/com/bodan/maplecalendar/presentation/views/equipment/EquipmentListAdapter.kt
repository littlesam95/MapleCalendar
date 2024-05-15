package com.bodan.maplecalendar.presentation.views.equipment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemEquipmentOptionBinding

class EquipmentListAdapter(private val onItemEquipmentClickListener: OnItemEquipmentClickListener) :
    ListAdapter<EquipmentUiState, RecyclerView.ViewHolder>(equipmentUiStateDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemEquipmentOptionViewHolder(
            ItemEquipmentOptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemEquipmentOptionViewHolder).bind(
            currentList[position] as EquipmentUiState.EquipmentOption,
            onItemEquipmentClickListener
        )
    }

    companion object {

        val equipmentUiStateDiffUtil = object : DiffUtil.ItemCallback<EquipmentUiState>() {
            override fun areItemsTheSame(oldItem: EquipmentUiState, newItem: EquipmentUiState) =
                (oldItem.id == newItem.id)

            override fun areContentsTheSame(oldItem: EquipmentUiState, newItem: EquipmentUiState) =
                (oldItem == newItem)
        }
    }

    class ItemEquipmentOptionViewHolder(private val binding: ItemEquipmentOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: EquipmentUiState.EquipmentOption,
            onClickListener: OnItemEquipmentClickListener
        ) {
            binding.item = item
            binding.onItemEquipmentClickListener = onClickListener
        }
    }
}