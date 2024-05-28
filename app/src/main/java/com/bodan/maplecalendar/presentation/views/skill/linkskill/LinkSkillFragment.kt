package com.bodan.maplecalendar.presentation.views.skill.linkskill

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentLinkSkillBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.skill.SkillUiEvent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LinkSkillFragment :
    BaseDialogFragment<FragmentLinkSkillBinding>(R.layout.fragment_link_skill) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var linkSkillAdapter: LinkSkillAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.skillUiEvent.collectLatest { uiEvent ->
                when (uiEvent) {
                    is SkillUiEvent.GetLinkSkillDetail -> {
                        findNavController().navigateSafely(R.id.action_link_skill_to_skill_detail)
                    }

                    is SkillUiEvent.CloseLinkSkill -> dismiss()

                    else -> {}
                }
            }
        }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            viewModel.characterLinkSkills.collectLatest { linkSkills ->
                linkSkillAdapter = LinkSkillAdapter(requireActivity(), linkSkills.size)
                with(binding.vpLinkSkill) {
                    adapter = linkSkillAdapter
                    setCurrentItem(LinkSkillAdapter.START_POSITION, true)
                }
                initTabLayout()
            }
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tlLinkSkill, binding.vpLinkSkill) { tab, position ->
            tab.text = "Preset ${position + 1}"
        }.attach()
    }
}