package com.bodan.maplecalendar.presentation.views.skill

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentSkillBinding
import com.bodan.maplecalendar.presentation.config.BaseFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SkillFragment : BaseFragment<FragmentSkillBinding>(R.layout.fragment_skill) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var skillAdapter: SkillAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        binding.vm = viewModel

        collectLatestFlow(viewModel.skillUiEvent) { handleUiEvent(it) }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            viewModel.characterSkills.collectLatest { skills ->
                skillAdapter = SkillAdapter(requireActivity(), skills.size)
                with(binding.vpSkill) {
                    adapter = skillAdapter
                    setCurrentItem(SkillAdapter.START_POSITION, true)
                }
                initTabLayout()
            }
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tlSkill, binding.vpSkill) { tab, position ->
            tab.text = when (viewModel.characterSkills.value[position].characterSkillGrade) {
                "1" -> resources.getString(R.string.text_skill_grade_one)

                "1.5" -> resources.getString(R.string.text_skill_grade_one_plus)

                "2" -> resources.getString(R.string.text_skill_grade_two)

                "2.5" -> resources.getString(R.string.text_skill_grade_two_plus)

                "3" -> resources.getString(R.string.text_skill_grade_three)

                "4" -> resources.getString(R.string.text_skill_grade_four)

                "5" -> resources.getString(R.string.text_skill_grade_five)

                "6" -> resources.getString(R.string.text_skill_grade_six)

                else -> resources.getString(R.string.text_skill_grade_zero)
            }
        }.attach()
    }

    private fun handleUiEvent(event: SkillUiEvent) = when (event) {
        is SkillUiEvent.GetSkillDetail -> {
            findNavController().navigate(R.id.action_skill_to_skill_detail)
        }

        is SkillUiEvent.GetHyperSkill -> {
            findNavController().navigate(R.id.action_skill_to_hyper_skill)
        }

        is SkillUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is SkillUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is SkillUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is SkillUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is SkillUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        else -> {}
    }
}