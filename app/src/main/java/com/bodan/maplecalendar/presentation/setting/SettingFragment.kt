package com.bodan.maplecalendar.presentation.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentSettingBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.MainViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        collectLatestFlow(viewModel.settingUiEvent) { handleUiEvent(it) }
    }

    private fun handleUiEvent(event: SettingUiEvent) = when (event) {
        is SettingUiEvent.NetworkErrorEvent -> {
            showSnackBar(R.string.message_network_error)
        }
    }
}