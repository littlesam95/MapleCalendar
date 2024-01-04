package com.bodan.maplecalendar.presentation.setting

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentPushNotificationBinding
import com.bodan.maplecalendar.presentation.BaseDialogFragment
import com.bodan.maplecalendar.presentation.MainViewModel
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmManagerRestarter
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmProvider
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("UnspecifiedRegisterReceiverFlag")
class PushNotificationFragment :
    BaseDialogFragment<FragmentPushNotificationBinding>(R.layout.fragment_push_notification) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var myAlarmManagerRestarter: MyAlarmManagerRestarter
    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            var flag = true
            it.entries.forEach { entry ->
                flag = entry.value
            }
            if (flag) {
                MyAlarmProvider.callAlarm()
                dismiss()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        myAlarmManagerRestarter = MyAlarmManagerRestarter()

        lifecycleScope.launch {
            viewModel.settingUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SettingUiEvent.AllowPushNotification) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        requestPermissions.launch(
                            arrayOf(
                                Manifest.permission.POST_NOTIFICATIONS,
                                Manifest.permission.SCHEDULE_EXACT_ALARM,
                                Manifest.permission.USE_FULL_SCREEN_INTENT,
                                Manifest.permission.RECEIVE_BOOT_COMPLETED
                            )
                        )
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        requestPermissions.launch(
                            arrayOf(
                                Manifest.permission.USE_FULL_SCREEN_INTENT,
                                Manifest.permission.RECEIVE_BOOT_COMPLETED
                            )
                        )
                    } else {
                        MyAlarmProvider.callAlarm()
                        dismiss()
                    }
                } else if (uiEvent == SettingUiEvent.CancelPushNotification) {
                    MyAlarmProvider.cancelAlarm()
                    dismiss()
                }
            }
        }
    }
}