package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.bodan.maplecalendar.app.MainApplication
import timber.log.Timber

class MyAlarmManagerRestarter : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if ((intent.action == "android.intent.action.BOOT_COMPLETED") &&
            (MainApplication.mySharedPreferences.getAlarm("eventAlarm", "") == "alarm")) {
            MyAlarmProvider.callAlarm()
            Timber.d("Alarm")
        }
    }
}