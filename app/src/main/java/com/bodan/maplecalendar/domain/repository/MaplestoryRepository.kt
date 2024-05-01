package com.bodan.maplecalendar.domain.repository

import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.domain.entity.CharacterBasic
import com.bodan.maplecalendar.domain.entity.CharacterOcid
import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.presentation.utils.Result

interface MaplestoryRepository {

    suspend fun getCharacterOcid(characterName: String): Result<CharacterOcid>

    suspend fun getCharacterBasic(ocid: String, date: String?): Result<CharacterBasic>

    suspend fun getCharacterPower(ocid: String, date: String?): Result<List<FinalStat>>

    suspend fun getCharacterItemEquipment(ocid: String, date: String?): Result<CharacterItemEquipment>

    suspend fun getCharacterUnion(ocid: String, date: String?): Result<CharacterUnion>

    suspend fun getCharacterPopularity(ocid: String, date: String?): Result<CharacterPopularity>

    suspend fun getCharacterDojang(ocid: String, date: String?): Result<CharacterDojang>
}