package com.bodan.maplecalendar.presentation.views.ability

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentAbilityPresetBinding
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AbilityPresetFragment : Fragment() {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var binding: FragmentAbilityPresetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAbilityPresetBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel

            arguments?.let { argument ->
                val pos = argument.getInt("preset")
                with(rvAbilityPreset) {
                    layoutManager = LinearLayoutManager(requireActivity())
                    viewModel.characterAbility.value?.let { ability ->
                        adapter = AbilityInfoListAdapter(ability.abilitys[pos].abilityInfo)
                    }
                    setHasFixedSize(false)
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { argument ->
            val pos = argument.getInt("preset")
            initAbilityText(pos)
        }
    }

    private fun initAbilityText(position: Int) {
        viewModel.characterAbility.value?.let { ability ->
            val abilityText =
                ability.abilitys[position].abilityPresetGrade + " " + resources.getString(R.string.text_ability)
            val backgroundDrawableId: Int = when (ability.abilitys[position].abilityPresetGrade) {
                "레어" ->  R.drawable.shape_rare_background

                "에픽" ->  R.drawable.shape_epic_background

                "유니크" ->  R.drawable.shape_unique_background

                else ->  R.drawable.shape_legendary_background
            }

            with(binding) {
                tvAbilityGradeAbilityPreset.text = abilityText
                mcvAbilityPreset.setBackgroundResource(backgroundDrawableId)
            }
        }
    }

    companion object {

        fun newInstance(itemId: Long) = AbilityPresetFragment().apply {
            arguments = Bundle().apply {
                putInt("preset", itemId.toInt())
            }
        }
    }
}