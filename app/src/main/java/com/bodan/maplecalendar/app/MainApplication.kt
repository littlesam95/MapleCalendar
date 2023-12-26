package com.bodan.maplecalendar.app

import android.app.Application
import android.content.Context

class MainApplication : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        mySharedPreferences = MySharedPreferences()
        super.onCreate()
    }

    companion object {
        lateinit var mySharedPreferences: MySharedPreferences
        var instance: MainApplication? = null

        fun myContext(): Context {
            return instance!!.applicationContext
        }
    }
}