package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetCharacterNameUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend fun setCharacterName(characterName: String) {
        settingsRepository.setCharacterName(characterName)
    }

    fun getCharacterName(): Flow<String> {
        return settingsRepository.getCharacterName()
    }
}