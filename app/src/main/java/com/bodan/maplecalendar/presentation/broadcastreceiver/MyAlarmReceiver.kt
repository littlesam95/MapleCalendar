package com.bodan.maplecalendar.presentation.broadcastreceiver

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.data.EventListReader
import com.bodan.maplecalendar.presentation.SplashActivity
import com.google.android.material.internal.ManufacturerUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

@SuppressLint("ScheduleExactAlarm", "RestrictedApi")
class MyAlarmReceiver : BroadcastReceiver() {

    private val eventListReader = EventListReader()
    private lateinit var pendingIntent: PendingIntent
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationCompatBuilder: NotificationCompat.Builder

    override fun onReceive(context: Context, intent: Intent) {
        notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
        )

        notificationCompatBuilder = NotificationCompat.Builder(context, CHANNEL_ID)

        val alarmServiceIntent = Intent(context, SplashActivity::class.java)
        val fullscreenIntent = Intent(context, SplashActivity::class.java).apply {
            action = "fullscreen_activity"
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        CoroutineScope(Dispatchers.Main).launch {
            val countEndEvents = async(Dispatchers.Main) {
                eventListReader.getPendingEvents(
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            }.await()

            val fullscreenPendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                true -> {
                    PendingIntent.getActivity(
                        context,
                        REQUEST_CODE,
                        fullscreenIntent,
                        PendingIntent.FLAG_IMMUTABLE
                    )
                }

                false -> {
                    PendingIntent.getActivity(
                        context,
                        REQUEST_CODE,
                        alarmServiceIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                }
            }

            val eventNotification = notificationCompatBuilder
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(getIcon())
                .setColorized(true)
                .setAutoCancel(true)
                .setContentIntent(fullscreenPendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setLocalOnly(true).apply {
                    when (countEndEvents) {
                        0 -> {
                            setContentTitle(context.getString(R.string.message_alarm_no_event_end))
                            setContentText(context.getString(R.string.message_alarm_no_event_end_check))
                        }

                        else -> {
                            setContentTitle("${countEndEvents}${context.getString(R.string.message_alarm_event_end)}")
                            setContentText(context.getString(R.string.message_alarm_event_end_check))
                        }
                    }
                }
                .build()

            when (Build.VERSION.SDK_INT) {
                !in Build.VERSION_CODES.BASE until Build.VERSION_CODES.TIRAMISU -> {
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.POST_NOTIFICATIONS
                        )
                        == PackageManager.PERMISSION_GRANTED
                    ) {
                        notificationManager.notify(REQUEST_CODE, eventNotification)
                    }
                }

                else -> {
                    notificationManager.notify(REQUEST_CODE, eventNotification)
                }
            }

            val alarmManager =
                context.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager

            pendingIntent = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                true -> {
                    PendingIntent.getBroadcast(
                        context,
                        REQUEST_CODE,
                        intent,
                        PendingIntent.FLAG_IMMUTABLE
                    )
                }

                false -> {
                    PendingIntent.getBroadcast(
                        context,
                        REQUEST_CODE,
                        intent,
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
    }

    private fun getIcon(): Int {
        return if (ManufacturerUtils.isSamsungDevice()) {
            R.drawable.ic_bnv_main
        } else {
            R.drawable.ic_event_notification
        }
    }

    companion object {
        const val CHANNEL_ID = "channel"
        const val CHANNEL_NAME = "eventAlarmChannel"
        const val REQUEST_CODE = 1
    }
}