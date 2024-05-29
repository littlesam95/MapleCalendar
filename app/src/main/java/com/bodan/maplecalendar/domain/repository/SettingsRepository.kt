package com.bodan.maplecalendar.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun setDarkMode()

    fun getDarkMode(): Flow<Boolean>
}