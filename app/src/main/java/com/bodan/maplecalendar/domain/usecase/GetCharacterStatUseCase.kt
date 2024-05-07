package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.domain.entity.Result
import javax.inject.Inject

class GetCharacterStatUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterStat(ocid: String, date: String?): Result<List<FinalStat>> =
        maplestoryRepository.getCharacterPower(ocid, date)
}