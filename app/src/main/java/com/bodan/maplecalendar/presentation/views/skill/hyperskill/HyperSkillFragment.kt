package com.bodan.maplecalendar.presentation.views.skill.hyperskill

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentHyperSkillBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.skill.SkillUiEvent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HyperSkillFragment :
    BaseDialogFragment<FragmentHyperSkillBinding>(R.layout.fragment_hyper_skill) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var hyperSkillAdapter: HyperSkillAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.skillUiEvent.collectLatest { uiEvent ->
                when (uiEvent) {
                    is SkillUiEvent.GetHyperSkillDetail -> {
                        findNavController().navigateSafely(R.id.action_hyper_skill_to_skill_detail)
                    }

                    is SkillUiEvent.CloseHyperSkill -> dismiss()

                    else -> {}
                }
            }
        }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            viewModel.characterHyperSkills.collectLatest { skills ->
                hyperSkillAdapter = HyperSkillAdapter(requireActivity(), skills.size)
                with(binding.vpHyperSkill) {
                    adapter = hyperSkillAdapter
                    setCurrentItem(HyperSkillAdapter.START_POSITION, true)
                }
                initTabLayout()
            }
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tlHyperSkill, binding.vpHyperSkill) { tab, position ->
            tab.text = when (viewModel.characterHyperSkills.value[position].characterSkillGrade) {
                "hyperpassive" -> resources.getString(R.string.text_title_hyper_skill_passive)

                "hyperactive" -> resources.getString(R.string.text_title_hyper_skill_active)

                else -> ""
            }
        }.attach()
    }
}