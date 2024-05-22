package com.bodan.maplecalendar.presentation.views.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemSkillInfoBinding
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo

class SkillInfoAdapter(
    private val skillInfos: List<CharacterSkillInfo>,
    private val onSkillClickListener: OnSkillClickListener
) : RecyclerView.Adapter<SkillInfoAdapter.SkillInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillInfoViewHolder =
        SkillInfoViewHolder(
            ItemSkillInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: SkillInfoViewHolder, position: Int) {
        holder.bind(skillInfos[position], onSkillClickListener)
    }

    override fun getItemCount(): Int = skillInfos.size

    class SkillInfoViewHolder(private val binding: ItemSkillInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterSkillInfo, clickListener: OnSkillClickListener) {
            binding.skillInfo = item
            binding.clickListener = clickListener
            binding.tvSkillNameSkillInfo.isSelected = true
        }
    }
}