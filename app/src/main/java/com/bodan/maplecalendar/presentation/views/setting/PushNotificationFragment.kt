package com.bodan.maplecalendar.presentation.views.setting

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentPushNotificationBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.MainViewModel
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmManagerRestarter
import com.bodan.maplecalendar.presentation.broadcastreceiver.MyAlarmProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class PushNotificationFragment :
    BaseDialogFragment<FragmentPushNotificationBinding>(R.layout.fragment_push_notification) {

    private val viewModel: MainViewModel by activityViewModels()
    private val settingActionRequestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                setEventAlarm()
            }
        }
    private lateinit var myAlarmManagerRestarter: MyAlarmManagerRestarter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        myAlarmManagerRestarter = MyAlarmManagerRestarter()

        lifecycleScope.launch {
            viewModel.settingUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SettingUiEvent.AllowPushNotification) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        TedPermission.create()
                            .setPermissionListener(object : PermissionListener {
                                override fun onPermissionGranted() {
                                    setEventAlarm()
                                }

                                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                                    Timber.d("$deniedPermissions 거절함")
                                    goSettingActivityAlertDialog()
                                }
                            })
                            .setPermissions(Manifest.permission.POST_NOTIFICATIONS)
                            .check()
                    } else {
                        setEventAlarm()
                    }
                } else if (uiEvent == SettingUiEvent.CancelPushNotification) {
                    cancelEventAlarm()
                }
            }
        }
    }

    private fun goSettingActivityAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.message_alarm_need_to_allow_permission_title))
            .setMessage(getString(R.string.message_alarm_need_to_allow_permission))
            .setPositiveButton(getString(R.string.text_allow)) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                requireActivity().packageName.also { name ->
                    intent.data = Uri.fromParts("package", name, null)
                }
                settingActionRequestLauncher.launch(intent)
            }
            .setNegativeButton(getString(R.string.text_not_allow)) { _, _ -> }
            .create()
            .show()
    }

    private fun setEventAlarm() {
        MyAlarmProvider.callAlarm()
        showToastMessage(getString(R.string.message_alarm_call))
        dismiss()
    }

    private fun cancelEventAlarm() {
        MyAlarmProvider.cancelAlarm()
        showToastMessage(getString(R.string.message_alarm_cancel))
        dismiss()
    }
}