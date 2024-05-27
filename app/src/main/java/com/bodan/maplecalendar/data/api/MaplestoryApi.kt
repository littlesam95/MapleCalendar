package com.bodan.maplecalendar.data.api

import com.bodan.maplecalendar.data.model.AbilityEntity
import com.bodan.maplecalendar.data.model.BasicEntity
import com.bodan.maplecalendar.data.model.DojangEntity
import com.bodan.maplecalendar.data.model.HyperStatEntity
import com.bodan.maplecalendar.data.model.ItemEquipmentEntity
import com.bodan.maplecalendar.data.model.LinkSkillEntity
import com.bodan.maplecalendar.data.model.OcidEntity
import com.bodan.maplecalendar.data.model.PopularityEntity
import com.bodan.maplecalendar.data.model.SkillEntity
import com.bodan.maplecalendar.data.model.StatEntity
import com.bodan.maplecalendar.data.model.UnionEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MaplestoryApi {

    @GET("v1/id")
    suspend fun fetchCharacterOcid(
        @Query("character_name") characterName: String
    ): Response<OcidEntity>

    @GET("v1/character/basic")
    suspend fun fetchCharacterBasic(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<BasicEntity>

    @GET("v1/character/stat")
    suspend fun fetchCharacterStat(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<StatEntity>

    @GET("v1/character/item-equipment")
    suspend fun fetchCharacterItemEquipment(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<ItemEquipmentEntity>

    @GET("v1/user/union")
    suspend fun fetchCharacterUnion(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<UnionEntity>

    @GET("v1/character/popularity")
    suspend fun fetchCharacterPopularity(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<PopularityEntity>

    @GET("v1/character/dojang")
    suspend fun fetchCharacterDojang(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<DojangEntity>

    @GET("v1/character/hyper-stat")
    suspend fun fetchCharacterHyperStat(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<HyperStatEntity>

    @GET("v1/character/ability")
    suspend fun fetchCharacterAbility(
        @Query("ocid") ocid: String,
        @Query("date") date: String?
    ): Response<AbilityEntity>

    @GET("v1/character/skill")
    suspend fun fetchCharacterSkill(
        @Query("ocid") ocid: String,
        @Query("date") date: String?,
        @Query("character_skill_grade") characterSkillGrade: String
    ): Response<SkillEntity>

    @GET("v1/character/link-skill")
    suspend fun fetchCharacterLinkSkill(
        @Query("ocid") ocid: String,
        @Query("date") date: String?,
    ): Response<LinkSkillEntity>
}