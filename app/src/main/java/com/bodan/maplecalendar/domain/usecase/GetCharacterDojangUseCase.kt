package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.domain.entity.Result
import javax.inject.Inject

class GetCharacterDojangUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterDojang(ocid: String, date: String?): Result<CharacterDojang> =
        maplestoryRepository.getCharacterDojang(ocid, date)
}