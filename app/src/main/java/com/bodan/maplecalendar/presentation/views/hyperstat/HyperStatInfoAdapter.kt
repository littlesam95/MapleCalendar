package com.bodan.maplecalendar.presentation.views.hyperstat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.databinding.ItemHyperStatPresetBinding
import com.bodan.maplecalendar.domain.entity.CharacterHyperStatInfo

class HyperStatInfoAdapter(private val hyperStats: List<CharacterHyperStatInfo>) :
    RecyclerView.Adapter<HyperStatInfoAdapter.HyperStatInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HyperStatInfoViewHolder =
        HyperStatInfoViewHolder(
            ItemHyperStatPresetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: HyperStatInfoViewHolder, position: Int) {
        holder.bind(hyperStats[position])
    }

    override fun getItemCount(): Int = hyperStats.size

    class HyperStatInfoViewHolder(private val binding: ItemHyperStatPresetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterHyperStatInfo) {
            binding.tvStatTypeItemHyperStatPreset.text = item.statType
            val hyperStatLevel =
                MainApplication.myContext().resources.getString(R.string.text_lv) + " " + item.statLevel.toString()
            binding.tvStatLevelItemHyperStatPreset.text = hyperStatLevel
        }
    }
}