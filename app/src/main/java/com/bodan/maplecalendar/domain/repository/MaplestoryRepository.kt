package com.bodan.maplecalendar.domain.repository

import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.CharacterAndroid
import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.domain.entity.CharacterBasic
import com.bodan.maplecalendar.domain.entity.CharacterCashItem
import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.CharacterLinkSkill
import com.bodan.maplecalendar.domain.entity.CharacterOcid
import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.domain.entity.CharacterSkill
import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.domain.entity.Result

interface MaplestoryRepository {

    suspend fun getCharacterOcid(characterName: String): Result<CharacterOcid>

    suspend fun getCharacterBasic(ocid: String, date: String?): Result<CharacterBasic>

    suspend fun getCharacterPower(ocid: String, date: String?): Result<List<FinalStat>>

    suspend fun getCharacterItemEquipment(
        ocid: String,
        date: String?
    ): Result<CharacterItemEquipment>

    suspend fun getCharacterUnion(ocid: String, date: String?): Result<CharacterUnion>

    suspend fun getCharacterPopularity(ocid: String, date: String?): Result<CharacterPopularity>

    suspend fun getCharacterDojang(ocid: String, date: String?): Result<CharacterDojang>

    suspend fun getCharacterHyperStat(ocid: String, date: String?): Result<CharacterHyperStat>

    suspend fun getCharacterAbility(ocid: String, date: String?): Result<CharacterAbility>

    suspend fun getCharacterSkill(
        ocid: String,
        date: String?,
        characterSkillGrade: String
    ): Result<CharacterSkill>

    suspend fun getCharacterLinkSkill(
        ocid: String,
        date: String?
    ): Result<CharacterLinkSkill>

    suspend fun getCharacterAndroid(ocid: String, date: String?): Result<CharacterAndroid>

    suspend fun getCharacterCashItem(ocid: String, date: String?): Result<CharacterCashItem>
}