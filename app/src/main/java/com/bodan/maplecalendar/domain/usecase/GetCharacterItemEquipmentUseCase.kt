package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.presentation.utils.Result
import javax.inject.Inject

class GetCharacterItemEquipmentUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterItemEquipment(ocid: String, date: String?): Result<CharacterItemEquipment> =
        maplestoryRepository.getCharacterItemEquipment(ocid, date)
}