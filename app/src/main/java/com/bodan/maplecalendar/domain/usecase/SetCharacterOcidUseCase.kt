package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetCharacterOcidUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend fun setCharacterOcid(characterOcid: String) {
        settingsRepository.setCharacterOcid(characterOcid)
    }

    fun getCharacterOcid(): Flow<String> {
        return settingsRepository.getCharacterOcid()
    }
}