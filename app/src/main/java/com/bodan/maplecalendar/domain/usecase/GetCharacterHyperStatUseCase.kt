package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterHyperStatUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterHyperStat(ocid: String, date: String?): Result<CharacterHyperStat> {
        return maplestoryRepository.getCharacterHyperStat(ocid, date)
    }
}