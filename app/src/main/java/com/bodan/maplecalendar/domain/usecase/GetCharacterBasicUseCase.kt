package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterBasic
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.presentation.utils.Result
import javax.inject.Inject

class GetCharacterBasicUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterBasic(ocid: String, date: String?): Result<CharacterBasic> =
        maplestoryRepository.getCharacterBasic(ocid, date)
}