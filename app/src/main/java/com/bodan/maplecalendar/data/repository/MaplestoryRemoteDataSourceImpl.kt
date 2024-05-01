package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.api.MaplestoryApi
import com.bodan.maplecalendar.data.model.BasicEntity
import com.bodan.maplecalendar.data.model.DojangEntity
import com.bodan.maplecalendar.data.model.ItemEquipmentEntity
import com.bodan.maplecalendar.data.model.OcidEntity
import com.bodan.maplecalendar.data.model.PopularityEntity
import com.bodan.maplecalendar.data.model.StatEntity
import com.bodan.maplecalendar.data.model.UnionEntity
import retrofit2.Response
import javax.inject.Inject

class MaplestoryRemoteDataSourceImpl @Inject constructor(
    private val maplestoryApi: MaplestoryApi
) : MaplestoryRemoteDataSource {

    override suspend fun getCharacterOcid(characterName: String): Response<OcidEntity> =
        maplestoryApi.fetchCharacterOcid(characterName)

    override suspend fun getCharacterBasic(ocid: String, date: String?): Response<BasicEntity> =
        maplestoryApi.fetchCharacterBasic(ocid, date)

    override suspend fun getCharacterStat(ocid: String, date: String?): Response<StatEntity> =
        maplestoryApi.fetchCharacterStat(ocid, date)

    override suspend fun getCharacterItemEquipment(
        ocid: String,
        date: String?
    ): Response<ItemEquipmentEntity> =
        maplestoryApi.fetchCharacterItemEquipment(ocid, date)

    override suspend fun getCharacterUnion(ocid: String, date: String?): Response<UnionEntity> =
        maplestoryApi.fetchCharacterUnion(ocid, date)

    override suspend fun getCharacterPopularity(
        ocid: String,
        date: String?
    ): Response<PopularityEntity> =
        maplestoryApi.fetchCharacterPopularity(ocid, date)

    override suspend fun getCharacterDojang(ocid: String, date: String?): Response<DojangEntity> =
        maplestoryApi.fetchCharacterDojang(ocid, date)
}