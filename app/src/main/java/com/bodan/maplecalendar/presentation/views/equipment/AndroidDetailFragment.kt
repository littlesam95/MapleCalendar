package com.bodan.maplecalendar.presentation.views.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentAndroidDetailBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AndroidDetailFragment :
    BaseDialogFragment<FragmentAndroidDetailBinding>(R.layout.fragment_android_detail) {

    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.equipmentUiEvent.collectLatest { uiEvent ->
                if (uiEvent == EquipmentUiEvent.CloseItemEquipmentDetail) dismiss()
            }
        }
    }
}