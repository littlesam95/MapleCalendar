package com.bodan.maplecalendar.app

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences {

    private val preferences: SharedPreferences =
        MainApplication.myContext().getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getSearchDate(key: String, defValue: String?): String? {
        return preferences.getString(key, defValue)
    }

    fun setSearchDate(key: String, defValue: String?) {
        preferences.edit().putString(key, defValue).apply()
    }

    fun getNickname(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setNickname(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }

    fun getOcid(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setOcid(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }

    fun getAlarm(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setAlarm(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }
}