package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterLinkSkill
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterLinkSkillUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterLinkSkill(ocid: String, date: String?): Result<CharacterLinkSkill> {
        return maplestoryRepository.getCharacterLinkSkill(ocid, date)
    }
}