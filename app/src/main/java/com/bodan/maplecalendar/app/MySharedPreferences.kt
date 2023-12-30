package com.bodan.maplecalendar.app

import android.content.Context
import android.content.SharedPreferences
import com.bodan.maplecalendar.R

class MySharedPreferences {

    private val preferences: SharedPreferences =
        MainApplication.myContext().getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    init {
        if (getThemeMode("theme", "") == "") {
            setThemeMode("theme", MainApplication.myContext().getString(R.string.text_light_mode))
        }
    }

    fun getNickname(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setNickname(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }

    fun getThemeMode(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setThemeMode(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }
}