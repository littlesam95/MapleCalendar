package com.bodan.maplecalendar.domain.usecase

import com.bodan.maplecalendar.domain.entity.CharacterSkill
import com.bodan.maplecalendar.domain.entity.Result
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import javax.inject.Inject

class GetCharacterSkillUseCase @Inject constructor(
    private val maplestoryRepository: MaplestoryRepository
) {

    suspend fun getCharacterSkill(
        ocid: String,
        date: String?,
        characterSkillGrade: String
    ): Result<CharacterSkill> {
        return maplestoryRepository.getCharacterSkill(ocid, date, characterSkillGrade)
    }
}