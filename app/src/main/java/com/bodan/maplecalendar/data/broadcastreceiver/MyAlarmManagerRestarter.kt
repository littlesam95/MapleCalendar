package com.bodan.maplecalendar.data.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

class MyAlarmManagerRestarter : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            val alarmManagerRestarter = ComponentName(context, MyAlarmManagerRestarter::class.java)

            context.packageManager.setComponentEnabledSetting(
                alarmManagerRestarter,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )
        }
    }
}