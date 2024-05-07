package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.domain.entity.Result
import javax.inject.Inject

class GetCharacterPopularityUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterPopularity(ocid: String, date: String?): Result<CharacterPopularity> =
        maplestoryRepository.getCharacterPopularity(ocid, date)
}