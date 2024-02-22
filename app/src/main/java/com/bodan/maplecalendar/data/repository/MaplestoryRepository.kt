package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.dto.CharacterBasicResponse
import com.bodan.maplecalendar.data.dto.CharacterDojangResponse
import com.bodan.maplecalendar.data.dto.CharacterItemEquipmentResponse
import com.bodan.maplecalendar.data.dto.CharacterOcidResponse
import com.bodan.maplecalendar.data.dto.CharacterPopularityResponse
import com.bodan.maplecalendar.data.dto.CharacterStatResponse
import com.bodan.maplecalendar.data.dto.CharacterUnionResponse

interface MaplestoryRepository {

    suspend fun getCharacterOcid(characterName: String): CharacterOcidResponse

    suspend fun getCharacterBasic(ocid: String, date: String): CharacterBasicResponse

    suspend fun getCharacterPower(ocid: String, date: String): CharacterStatResponse

    suspend fun getCharacterItemEquipment(ocid: String, date: String): CharacterItemEquipmentResponse

    suspend fun getCharacterUnion(ocid: String, date: String): CharacterUnionResponse

    suspend fun getCharacterPopularity(ocid: String, date: String): CharacterPopularityResponse

    suspend fun getCharacterDojang(ocid: String, date: String): CharacterDojangResponse
}