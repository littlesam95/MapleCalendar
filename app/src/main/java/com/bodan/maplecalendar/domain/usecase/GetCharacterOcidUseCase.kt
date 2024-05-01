package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterOcid
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.presentation.utils.Result
import javax.inject.Inject

class GetCharacterOcidUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterOcid(characterName: String): Result<CharacterOcid> =
        maplestoryRepository.getCharacterOcid(characterName)
}