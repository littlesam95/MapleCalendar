package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.dto.CharacterBasicResponse
import com.bodan.maplecalendar.data.dto.CharacterOcidResponse

interface MaplestoryRepository {

    suspend fun getCharacterOcid(characterName: String): CharacterOcidResponse

    suspend fun getCharacterBasic(ocid: String, date: String): CharacterBasicResponse

    // suspend fun getCharacterPower(ocid: String, date: String): CharacterStatResponse
}