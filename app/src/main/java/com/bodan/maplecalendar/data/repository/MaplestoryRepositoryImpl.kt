package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.mapper.CharacterAbilityMapper
import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.data.mapper.CharacterBasicMapper
import com.bodan.maplecalendar.data.mapper.CharacterDojangMapper
import com.bodan.maplecalendar.data.mapper.CharacterHyperStatMapper
import com.bodan.maplecalendar.data.mapper.CharacterItemEquipmentMapper
import com.bodan.maplecalendar.data.mapper.CharacterOcidMapper
import com.bodan.maplecalendar.data.mapper.CharacterPopularityMapper
import com.bodan.maplecalendar.data.mapper.CharacterSkillMapper
import com.bodan.maplecalendar.data.mapper.CharacterStatMapper
import com.bodan.maplecalendar.data.mapper.CharacterUnionMapper
import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.CharacterBasic
import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.domain.entity.CharacterOcid
import com.bodan.maplecalendar.domain.entity.CharacterSkill
import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.domain.entity.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MaplestoryRepositoryImpl @Inject constructor(
    private val maplestoryRemoteDataSource: MaplestoryRemoteDataSource
) : MaplestoryRepository {

    override suspend fun getCharacterOcid(characterName: String): Result<CharacterOcid> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterOcid(characterName)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterOcidMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterBasic(ocid: String, date: String?): Result<CharacterBasic> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterBasic(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterBasicMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterPower(ocid: String, date: String?): Result<List<FinalStat>> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterStat(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterStatMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterItemEquipment(ocid: String, date: String?): Result<CharacterItemEquipment> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterItemEquipment(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterItemEquipmentMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterUnion(ocid: String, date: String?): Result<CharacterUnion> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterUnion(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterUnionMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterPopularity(
        ocid: String,
        date: String?
    ): Result<CharacterPopularity> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterPopularity(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterPopularityMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterDojang(ocid: String, date: String?): Result<CharacterDojang> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterDojang(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterDojangMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterHyperStat(
        ocid: String,
        date: String?
    ): Result<CharacterHyperStat> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterHyperStat(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterHyperStatMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterAbility(
        ocid: String,
        date: String?
    ): Result<CharacterAbility> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterAbility(ocid, date)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterAbilityMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }

    override suspend fun getCharacterSkill(
        ocid: String,
        date: String?,
        characterSkillGrade: String
    ): Result<CharacterSkill> =
        try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                maplestoryRemoteDataSource.getCharacterSkill(ocid, date, characterSkillGrade)
            }

            val body = response.body()
            if (response.isSuccessful && (body != null)) {
                Result.success(CharacterSkillMapper(body))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (e: Exception) {
            Result.fail()
        }
}