package com.bodan.maplecalendar.presentation.views.ability

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentAbilityBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.character.CharacterUiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AbilityFragment : BaseDialogFragment<FragmentAbilityBinding>(R.layout.fragment_ability) {

    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.characterUiEvent.collectLatest { uiEvent ->
                if (uiEvent == CharacterUiEvent.CloseAbility) dismiss()
            }
        }
    }
}