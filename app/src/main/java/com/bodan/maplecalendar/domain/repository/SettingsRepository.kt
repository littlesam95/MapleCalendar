package com.bodan.maplecalendar.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun setDarkMode()

    fun getDarkMode(): Flow<Boolean>

    suspend fun setCharacterName(characterName: String)

    fun getCharacterName(): Flow<String>

    suspend fun setCharacterOcid(characterOcid: String)

    fun getCharacterOcid(): Flow<String>

    suspend fun setSearchDate(searchDate: String?)

    fun getSearchDate(): Flow<String?>
}