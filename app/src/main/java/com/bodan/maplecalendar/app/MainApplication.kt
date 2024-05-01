package com.bodan.maplecalendar.app

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.bodan.maplecalendar.R
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        mySharedPreferences = MySharedPreferences()
        super.onCreate()

        when (mySharedPreferences.getThemeMode("theme", "")) {
            myContext().getString(R.string.text_light_mode) -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            myContext().getString(R.string.text_dark_mode) -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            else -> {}
        }

        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var mySharedPreferences: MySharedPreferences
        var instance: MainApplication? = null

        fun myContext(): Context {
            return instance!!.applicationContext
        }
    }
}