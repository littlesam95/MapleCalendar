package com.bodan.maplecalendar.presentation.views.hyperstat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemHyperStatPresetBinding

class HyperStatInfoListAdapter(private val hyperStats: List<HyperStatUiState>) :
    RecyclerView.Adapter<HyperStatInfoListAdapter.HyperStatInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HyperStatInfoViewHolder =
        HyperStatInfoViewHolder(
            ItemHyperStatPresetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: HyperStatInfoViewHolder, position: Int) {
        holder.bind(hyperStats[position] as HyperStatUiState.HyperStatInfo)
    }

    override fun getItemCount(): Int = hyperStats.size

    class HyperStatInfoViewHolder(private val binding: ItemHyperStatPresetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HyperStatUiState.HyperStatInfo) {
            binding.tvStatTypeItemHyperStatPreset.text = item.statType
            binding.tvStatLevelItemHyperStatPreset.text = item.statLevel
        }
    }
}