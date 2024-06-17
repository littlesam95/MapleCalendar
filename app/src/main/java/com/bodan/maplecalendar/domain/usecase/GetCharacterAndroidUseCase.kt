package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterAndroid
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterAndroidUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterAndroid(ocid: String, date: String?): Result<CharacterAndroid> {
        return maplestoryRepository.getCharacterAndroid(ocid, date)
    }
}