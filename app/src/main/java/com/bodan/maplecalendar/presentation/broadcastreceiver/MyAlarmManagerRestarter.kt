package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

class MyAlarmManagerRestarter : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            MyAlarmProvider.callAlarm()
        }
    }
}