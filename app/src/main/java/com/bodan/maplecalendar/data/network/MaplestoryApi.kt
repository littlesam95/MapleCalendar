package com.bodan.maplecalendar.data.network

import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.dto.CharacterDojang
import com.bodan.maplecalendar.data.dto.CharacterItemEquipment
import com.bodan.maplecalendar.data.dto.CharacterOcid
import com.bodan.maplecalendar.data.dto.CharacterPopularity
import com.bodan.maplecalendar.data.dto.CharacterStat
import com.bodan.maplecalendar.data.dto.CharacterUnion
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MaplestoryApi {

    @GET("v1/id")
    suspend fun fetchCharacterOcid(
        @Query("character_name") characterName: String
    ): Response<CharacterOcid>

    @GET("v1/character/basic")
    suspend fun fetchCharacterBasic(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterBasic>

    @GET("v1/character/stat")
    suspend fun fetchCharacterStat(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterStat>

    @GET("v1/character/item-equipment")
    suspend fun fetchCharacterItemEquipment(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterItemEquipment>

    @GET("v1/user/union")
    suspend fun fetchCharacterUnion(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterUnion>

    @GET("v1/character/popularity")
    suspend fun fetchCharacterPopularity(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterPopularity>

    @GET("v1/character/dojang")
    suspend fun fetchCharacterDojang(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterDojang>
}