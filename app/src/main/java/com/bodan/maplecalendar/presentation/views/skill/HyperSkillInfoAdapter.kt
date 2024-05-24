package com.bodan.maplecalendar.presentation.views.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemHyperSkillInfoBinding
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo

class HyperSkillInfoAdapter(
    private val hyperSkillInfos: List<CharacterSkillInfo>,
    private val onSkillClickListener: OnSkillClickListener
) : RecyclerView.Adapter<HyperSkillInfoAdapter.HyperSkillInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HyperSkillInfoViewHolder =
        HyperSkillInfoViewHolder(
            ItemHyperSkillInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: HyperSkillInfoViewHolder, position: Int) {
        holder.bind(hyperSkillInfos[position], onSkillClickListener)
    }

    override fun getItemCount(): Int = hyperSkillInfos.size

    class HyperSkillInfoViewHolder(private val binding: ItemHyperSkillInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterSkillInfo, clickListener: OnSkillClickListener) {
            binding.skillInfo = item
            binding.clickListener = clickListener
            binding.tvSkillNameHyperSkillInfo.isSelected = true
        }
    }
}