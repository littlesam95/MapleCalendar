package com.bodan.maplecalendar.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bodan.maplecalendar.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    override suspend fun setDarkMode() {
        dataStore.edit { preferences ->
            preferences[DARK_MODE] = when (preferences[DARK_MODE]) {
                true -> false

                false -> true

                else -> false
            }
        }
    }

    override fun getDarkMode(): Flow<Boolean> {
        return dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            preferences[DARK_MODE] ?: false
        }
    }

    override suspend fun setCharacterName(characterName: String) {
        dataStore.edit { preferences ->
            preferences[CHARACTER_NAME] = characterName
        }
    }

    override fun getCharacterName(): Flow<String> {
        return dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            preferences[CHARACTER_NAME] ?: "한달해"
        }
    }

    override suspend fun setCharacterOcid(characterOcid: String) {
        dataStore.edit { preferences ->
            preferences[CHARACTER_OCID] = characterOcid
        }
    }

    override fun getCharacterOcid(): Flow<String> {
        return dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            preferences[CHARACTER_OCID] ?: ""
        }
    }

    override suspend fun setSearchDate(searchDate: String?) {
        dataStore.edit { preferences ->
            preferences[SEARCH_DATE] = searchDate ?: ""
        }
    }

    override fun getSearchDate(): Flow<String?> {
        return dataStore.data.catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            if (preferences[SEARCH_DATE] == "") {
                null
            } else {
                preferences[SEARCH_DATE]
            }
        }
    }

    companion object {
        private val DARK_MODE = booleanPreferencesKey("dark_mode")
        private val CHARACTER_NAME = stringPreferencesKey("character_name")
        private val CHARACTER_OCID = stringPreferencesKey("character_ocid")
        private val SEARCH_DATE = stringPreferencesKey("search_date")
    }
}