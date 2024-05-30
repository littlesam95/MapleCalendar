package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetSearchDateUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend fun setSearchDate(searchDate: String?) {
        settingsRepository.setSearchDate(searchDate)
    }

    fun getSearchDate(): Flow<String?> {
        return settingsRepository.getSearchDate()
    }
}