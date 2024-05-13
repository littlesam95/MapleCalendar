package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterAbilityUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterAbility(ocid: String, date: String?): Result<CharacterAbility> {
        return maplestoryRepository.getCharacterAbility(ocid, date)
    }
}