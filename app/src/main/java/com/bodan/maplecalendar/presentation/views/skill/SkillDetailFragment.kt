package com.bodan.maplecalendar.presentation.views.skill

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentSkillDetailBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SkillDetailFragment : BaseDialogFragment<FragmentSkillDetailBinding>(R.layout.fragment_skill_detail) {

    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()

        requireContext().dialogFragmentResize(this, 0.9F, 1F)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
        isCancelable = false

        lifecycleScope.launch {
            viewModel.skillUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SkillUiEvent.CloseSkillDetail) dismiss()
            }
        }
    }
}