package com.bodan.maplecalendar.presentation.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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
        is SettingUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is SettingUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is SettingUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is SettingUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is SettingUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        is SettingUiEvent.ChangeCharacterName -> {
            findNavController().navigate(R.id.action_setting_to_change_character_name)
        }

        is SettingUiEvent.SetPushNotification -> {
            findNavController().navigate(R.id.action_setting_to_push_notification)
        }

        is SettingUiEvent.SetDarkMode -> {
            setDarkMode()
        }

        else -> {}
    }
}