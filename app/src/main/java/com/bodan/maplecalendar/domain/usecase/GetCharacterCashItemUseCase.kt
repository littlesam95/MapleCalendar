package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterCashItem
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterCashItemUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterCashItem(ocid: String, date: String?): Result<CharacterCashItem> {
        return maplestoryRepository.getCharacterCashItem(ocid, date)
    }
}