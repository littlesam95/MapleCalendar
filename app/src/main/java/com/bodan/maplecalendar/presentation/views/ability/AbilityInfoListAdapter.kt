package com.bodan.maplecalendar.presentation.views.ability

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.ItemAbilityPresetBinding
import com.bodan.maplecalendar.domain.entity.CharacterAbilityInfo

class AbilityInfoListAdapter(private val abilitys: List<CharacterAbilityInfo>) :
    RecyclerView.Adapter<AbilityInfoListAdapter.AbilityInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityInfoViewHolder =
        AbilityInfoViewHolder(
            ItemAbilityPresetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: AbilityInfoViewHolder, position: Int) {
        holder.bind(abilitys[position])
    }

    override fun getItemCount(): Int = abilitys.size

    class AbilityInfoViewHolder(private val binding: ItemAbilityPresetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterAbilityInfo) {
            with(binding) {
                tvAbilityItemAbilityPreset.text = item.abilityValue
                tvAbilityItemAbilityPreset.isSelected = true
                val backgroundResourceId: Int = when (item.abilityGrade) {
                    "레어" ->  R.drawable.shape_rare_background

                    "에픽" ->  R.drawable.shape_epic_background

                    "유니크" ->  R.drawable.shape_unique_background

                    else ->  R.drawable.shape_legendary_background
                }
                clItemAbilityPreset.setBackgroundResource(backgroundResourceId)
            }
        }
    }
}