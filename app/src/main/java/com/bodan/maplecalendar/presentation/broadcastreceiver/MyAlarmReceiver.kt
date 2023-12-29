package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.data.EventListReader
import com.bodan.maplecalendar.data.service.MyAlarmService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyAlarmReceiver : BroadcastReceiver() {

    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationCompatBuilder: NotificationCompat.Builder
    private val eventListReader = EventListReader()

    override fun onReceive(context: Context?, intent: Intent?) {
        notificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
        )

        notificationCompatBuilder = NotificationCompat.Builder(context, CHANNEL_ID)

        val alarmServiceIntent = Intent(context, MyAlarmService::class.java)
        val requestCode = intent?.extras?.getInt("alarm_code") ?: 1

        CoroutineScope(Dispatchers.Main).launch {
            val countEndEvents = async(Dispatchers.Main) {
                eventListReader.getPendingEvents(
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            }.await()

            Timber.d("이벤트: $countEndEvents")

            val pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                true -> {
                    PendingIntent.getActivity(
                        context,
                        requestCode,
                        alarmServiceIntent,
                        PendingIntent.FLAG_IMMUTABLE
                    )
                }

                false -> {
                    PendingIntent.getActivity(
                        context,
                        requestCode,
                        alarmServiceIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                }
            }

            val eventNotification = notificationCompatBuilder
                .setContentTitle("${countEndEvents}${context.getString(R.string.message_alarm_event_end)}")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_bnv_main)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if ((ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED) && (countEndEvents > 0)
                ) {
                    notificationManager.notify(1, eventNotification)
                }
            } else {
                if (countEndEvents > 0) {
                    notificationManager.notify(1, eventNotification)
                }
            }
        }
    }

    companion object {
        const val CHANNEL_ID = "channel"
        const val CHANNEL_NAME = "eventAlarmChannel"
    }
}