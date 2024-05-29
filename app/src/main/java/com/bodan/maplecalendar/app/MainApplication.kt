package com.bodan.maplecalendar.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        mySharedPreferences = MySharedPreferences()

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