package com.bodan.maplecalendar.data.network

import com.bodan.maplecalendar.data.dto.CharacterBasic
import com.bodan.maplecalendar.data.dto.CharacterOcid
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

    /*
    @GET("v1/character/stat")
    suspend fun fetchCharacterStat(
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Response<CharacterStat>
    */
}