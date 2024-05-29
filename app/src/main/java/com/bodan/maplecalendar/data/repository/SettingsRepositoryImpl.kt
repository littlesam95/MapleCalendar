package com.bodan.maplecalendar.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
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

    companion object {
        private val DARK_MODE = booleanPreferencesKey("dark_mode")
    }
}