package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.bodan.maplecalendar.app.MainApplication
import com.bodan.maplecalendar.presentation.MainViewModel
import kotlinx.coroutines.runBlocking
import java.util.Calendar

object MyAlarmProvider {

    private lateinit var pendingIntent: PendingIntent

    @SuppressLint("SimpleDateFormat", "ScheduleExactAlarm")
    fun callAlarm(alarmCode: Int, viewModel: MainViewModel) {
        runBlocking {
            viewModel.setToday().await()
        }
        val alarmManager =
            MainApplication.myContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiverIntent =
            Intent(MainApplication.myContext(), MyAlarmReceiver::class.java).apply {
                putExtra("alarm_code", alarmCode)
                putExtra("today", viewModel.todayFormatted.value)
            }

        pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            true -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    alarmCode,
                    receiverIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            }

            false -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    alarmCode,
                    receiverIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            }
        }

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 10)
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    }

    fun cancelAlarm(alarmCode: Int) {
        val alarmManager =
            MainApplication.myContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val receiverIntent =
            Intent(MainApplication.myContext(), MyAlarmReceiver::class.java)

        pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            true -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    alarmCode,
                    receiverIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            }

            false -> {
                PendingIntent.getBroadcast(
                    MainApplication.myContext(),
                    alarmCode,
                    receiverIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            }
        }

        alarmManager.cancel(pendingIntent)
    }
}