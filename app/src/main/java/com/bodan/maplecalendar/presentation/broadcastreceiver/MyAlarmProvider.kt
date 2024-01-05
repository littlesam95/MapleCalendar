package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.bodan.maplecalendar.app.MainApplication
import java.util.Calendar

@SuppressLint("SimpleDateFormat", "ScheduleExactAlarm")
object MyAlarmProvider {

    private lateinit var pendingIntent: PendingIntent

    fun callAlarm() {
        MainApplication.mySharedPreferences.setAlarm("eventAlarm", "alarm")

        val alarmManager =
            MainApplication.myContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiverIntent =
            Intent(MainApplication.myContext(), MyAlarmReceiver::class.java)

        pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            true -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    1,
                    receiverIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            }

            false -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    1,
                    receiverIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            }
        }

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.DAY_OF_MONTH, 1)
        }

        val alarmClock = AlarmManager.AlarmClockInfo(calendar.timeInMillis, pendingIntent)
        alarmManager.setAlarmClock(alarmClock, pendingIntent)
    }

    fun cancelAlarm() {
        MainApplication.mySharedPreferences.setAlarm("eventAlarm", "")

        val alarmManager =
            MainApplication.myContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiverIntent =
            Intent(MainApplication.myContext(), MyAlarmReceiver::class.java)

        pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            true -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    1,
                    receiverIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            }

            false -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    1,
                    receiverIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            }
        }

        alarmManager.cancel(pendingIntent)
    }
}