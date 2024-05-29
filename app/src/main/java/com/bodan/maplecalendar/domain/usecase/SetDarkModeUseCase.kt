package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetDarkModeUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend fun setDarkMode() {
        settingsRepository.setDarkMode()
    }

    fun getDarkMode(): Flow<Boolean> {
        return settingsRepository.getDarkMode()
    }
}