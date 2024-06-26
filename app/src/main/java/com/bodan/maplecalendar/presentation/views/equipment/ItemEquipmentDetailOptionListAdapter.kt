package com.bodan.maplecalendar.presentation.views.equipment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemEquipmentDetailOptionBinding

class ItemEquipmentDetailOptionListAdapter :
    ListAdapter<EquipmentDetailUiState, RecyclerView.ViewHolder>(equipmentDetailUiStateDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemEquipmentDetailOptionViewHolder(
            ItemEquipmentDetailOptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemEquipmentDetailOptionViewHolder).bind(currentList[position] as EquipmentDetailUiState.EquipmentDetailOption)
    }

    companion object {
        val equipmentDetailUiStateDiffUtil =
            object : DiffUtil.ItemCallback<EquipmentDetailUiState>() {
                override fun areItemsTheSame(
                    oldItem: EquipmentDetailUiState,
                    newItem: EquipmentDetailUiState
                ) =
                    (oldItem.id == newItem.id)

                override fun areContentsTheSame(
                    oldItem: EquipmentDetailUiState,
                    newItem: EquipmentDetailUiState
                ) =
                    (oldItem == newItem)
            }
    }

    class ItemEquipmentDetailOptionViewHolder(private val binding: ItemEquipmentDetailOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailOption: EquipmentDetailUiState.EquipmentDetailOption) {
            with(binding) {
                this.detailOption = detailOption
                clDetailOption.visibility = if (detailOption.isZero) View.GONE else View.VISIBLE
                tvOptionTypeDetailOption.visibility = if (detailOption.isZero) View.GONE else View.VISIBLE
                tvTotalOptionDetailOption.visibility = if (detailOption.isZero) View.GONE else View.VISIBLE
                tvLeftBracketDetailOption.visibility = if (detailOption.isForced) View.VISIBLE else View.GONE
                tvBaseOptionDetailOption.visibility = if (detailOption.isForced) View.VISIBLE else View.GONE
                tvAddOptionDetailOption.visibility = if (detailOption.addOption.isBlank()) View.GONE else View.VISIBLE
                tvEtcOptionDetailOption.visibility = if (detailOption.etcOption.isBlank()) View.GONE else View.VISIBLE
                tvStarforceOptionDetailOption.visibility = if (detailOption.starforceOption.isBlank()) View.GONE else View.VISIBLE
                tvRightBracketDetailOption.visibility = if (detailOption.isForced) View.VISIBLE else View.GONE
            }
        }
    }
}