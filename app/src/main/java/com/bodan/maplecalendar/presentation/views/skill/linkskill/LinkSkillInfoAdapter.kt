package com.bodan.maplecalendar.presentation.views.skill.linkskill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemLinkSkillInfoBinding
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo
import com.bodan.maplecalendar.presentation.views.skill.OnSkillClickListener

class LinkSkillInfoAdapter(
    private val linkSkills: List<CharacterSkillInfo>,
    private val onSkillClickListener: OnSkillClickListener
) :
    RecyclerView.Adapter<LinkSkillInfoAdapter.LinkSkillInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkSkillInfoViewHolder =
        LinkSkillInfoViewHolder(
            ItemLinkSkillInfoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: LinkSkillInfoViewHolder, position: Int) {
        holder.bind(linkSkills[position], onSkillClickListener)
    }

    override fun getItemCount(): Int = linkSkills.size

    class LinkSkillInfoViewHolder(private val binding: ItemLinkSkillInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterSkillInfo, clickListener: OnSkillClickListener) {
            binding.skillInfo = item
            binding.clickListener = clickListener
            binding.tvSkillNameSkillInfo.isSelected = true
        }
    }
}