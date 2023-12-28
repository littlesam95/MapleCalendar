package com.bodan.maplecalendar.presentation.setting

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmProvider.callAlarm
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmProvider.cancelAlarm
import com.bodan.maplecalendar.databinding.FragmentPushNotificationBinding
import com.bodan.maplecalendar.presentation.BaseDialogFragment
import com.bodan.maplecalendar.presentation.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PushNotificationFragment :
    BaseDialogFragment<FragmentPushNotificationBinding>(R.layout.fragment_push_notification) {

    private val viewModel: MainViewModel by activityViewModels()
    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            var flag = true
            it.entries.forEach { entry ->
                flag = entry.value
            }
            if (flag) {
                callAlarm(alarmCode = 1, viewModel = viewModel)
                dismiss()
            }
        }
    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                callAlarm(alarmCode = 1, viewModel = viewModel)
                dismiss()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        isCancelable = false

        lifecycleScope.launch {
            viewModel.settingUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SettingUiEvent.AllowPushNotification) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        requestPermissions.launch(
                            arrayOf(
                                Manifest.permission.POST_NOTIFICATIONS,
                                Manifest.permission.USE_FULL_SCREEN_INTENT
                            )
                        )
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        requestPermission.launch(Manifest.permission.USE_FULL_SCREEN_INTENT)
                    } else {
                        callAlarm(alarmCode = 1, viewModel = viewModel)
                        dismiss()
                    }
                } else if (uiEvent == SettingUiEvent.CancelPushNotification) {
                    cancelAlarm(alarmCode = 1)
                    dismiss()
                }
            }
        }
    }
}