package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.presentation.utils.Result
import javax.inject.Inject

class GetCharacterUnionUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterUnion(ocid: String, date: String?): Result<CharacterUnion> =
        maplestoryRepository.getCharacterUnion(ocid, date)
}