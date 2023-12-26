package com.bodan.maplecalendar.app

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences {

    private val preferences: SharedPreferences =
        MainApplication.myContext().getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getNickname(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setNickname(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }
}