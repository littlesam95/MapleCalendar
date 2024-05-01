package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.model.BasicEntity
import com.bodan.maplecalendar.data.model.DojangEntity
import com.bodan.maplecalendar.data.model.ItemEquipmentEntity
import com.bodan.maplecalendar.data.model.OcidEntity
import com.bodan.maplecalendar.data.model.PopularityEntity
import com.bodan.maplecalendar.data.model.StatEntity
import com.bodan.maplecalendar.data.model.UnionEntity
import retrofit2.Response

interface MaplestoryRemoteDataSource {

    suspend fun getCharacterOcid(characterName: String): Response<OcidEntity>

    suspend fun getCharacterBasic(ocid: String, date: String?): Response<BasicEntity>

    suspend fun getCharacterStat(ocid: String, date: String?): Response<StatEntity>

    suspend fun getCharacterItemEquipment(ocid: String, date: String?): Response<ItemEquipmentEntity>

    suspend fun getCharacterUnion(ocid: String, date: String?): Response<UnionEntity>

    suspend fun getCharacterPopularity(ocid: String, date: String?): Response<PopularityEntity>

    suspend fun getCharacterDojang(ocid: String, date: String?): Response<DojangEntity>
}