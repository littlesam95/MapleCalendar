package com.bodan.maplecalendar.presentation.views.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentChangeCharacterNameBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChangeCharacterNameFragment :
    BaseDialogFragment<FragmentChangeCharacterNameBinding>(R.layout.fragment_change_character_name) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()

        requireContext().dialogFragmentResize(this, 0.8F, 0.9F)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
        isCancelable = false

        lifecycleScope.launch {
            viewModel.settingUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SettingUiEvent.CloseChangeCharacterName) dismiss()
            }
        }
    }
}