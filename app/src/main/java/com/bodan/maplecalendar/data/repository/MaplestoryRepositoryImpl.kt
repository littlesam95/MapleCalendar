package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.NetworkModule
import com.bodan.maplecalendar.data.dto.CharacterBasicResponse
import com.bodan.maplecalendar.data.dto.CharacterDojangResponse
import com.bodan.maplecalendar.data.dto.CharacterItemEquipmentResponse
import com.bodan.maplecalendar.data.dto.CharacterOcidResponse
import com.bodan.maplecalendar.data.dto.CharacterPopularityResponse
import com.bodan.maplecalendar.data.dto.CharacterStatResponse
import com.bodan.maplecalendar.data.dto.CharacterUnionResponse
import com.bodan.maplecalendar.data.network.MaplestoryApi
import timber.log.Timber

class MaplestoryRepositoryImpl : MaplestoryRepository {

    private val maplestoryApi: MaplestoryApi by lazy {
        NetworkModule.retrofit.create(MaplestoryApi::class.java)
    }

    override suspend fun getCharacterOcid(characterName: String): CharacterOcidResponse {
        val response = maplestoryApi.fetchCharacterOcid(characterName = characterName)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterOcid ->
                    Timber.d("Ocid Success")
                    return CharacterOcidResponse(
                        status = ResponseStatus.SUCCESS,
                        characterOcid = characterOcid
                    )
                }
            }

            BAD_REQUEST -> {
                Timber.d("Ocid 400")
                return CharacterOcidResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterOcid = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                Timber.d("Ocid 401")
                return CharacterOcidResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterOcid = null
                )
            }

            FORBIDDEN -> {
                Timber.d("Ocid 403")
                return CharacterOcidResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterOcid = null
                )
            }

            TOO_MANY_REQUESTS -> {
                Timber.d("Ocid 429")
                return CharacterOcidResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterOcid = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                Timber.d("Ocid 500")
                return CharacterOcidResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterOcid = null
                )
            }
        }

        Timber.d("Ocid 500")
        return CharacterOcidResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterOcid = null
        )
    }

    override suspend fun getCharacterBasic(ocid: String, date: String): CharacterBasicResponse {
        val response = maplestoryApi.fetchCharacterBasic(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterBasic ->
                    return CharacterBasicResponse(
                        status = ResponseStatus.SUCCESS,
                        characterBasic = characterBasic
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterBasicResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterBasic = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterBasicResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterBasic = null
                )
            }

            FORBIDDEN -> {
                return CharacterBasicResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterBasic = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterBasicResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterBasic = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterBasicResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterBasic = null
                )
            }
        }

        return CharacterBasicResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterBasic = null
        )
    }

    override suspend fun getCharacterPower(ocid: String, date: String): CharacterStatResponse {
        val response = maplestoryApi.fetchCharacterStat(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterStat ->
                    return CharacterStatResponse(
                        status = ResponseStatus.SUCCESS,
                        characterStat = characterStat
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterStatResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterStat = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterStatResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterStat = null
                )
            }

            FORBIDDEN -> {
                return CharacterStatResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterStat = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterStatResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterStat = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterStatResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterStat = null
                )
            }
        }

        return CharacterStatResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterStat = null
        )
    }

    override suspend fun getCharacterItemEquipment(ocid: String, date: String): CharacterItemEquipmentResponse {
        val response = maplestoryApi.fetchCharacterItemEquipment(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterItemEquipment ->
                    return CharacterItemEquipmentResponse(
                        status = ResponseStatus.SUCCESS,
                        characterItemEquipment = characterItemEquipment
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterItemEquipmentResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterItemEquipment = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterItemEquipmentResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterItemEquipment = null
                )
            }

            FORBIDDEN -> {
                return CharacterItemEquipmentResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterItemEquipment = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterItemEquipmentResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterItemEquipment = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterItemEquipmentResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterItemEquipment = null
                )
            }
        }

        return CharacterItemEquipmentResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterItemEquipment = null
        )
    }

    override suspend fun getCharacterUnion(ocid: String, date: String): CharacterUnionResponse {
        val response = maplestoryApi.fetchCharacterUnion(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterUnion ->
                    return CharacterUnionResponse(
                        status = ResponseStatus.SUCCESS,
                        characterUnion = characterUnion
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterUnionResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterUnion = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterUnionResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterUnion = null
                )
            }

            FORBIDDEN -> {
                return CharacterUnionResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterUnion = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterUnionResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterUnion = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterUnionResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterUnion = null
                )
            }
        }

        return CharacterUnionResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterUnion = null
        )
    }

    override suspend fun getCharacterPopularity(ocid: String, date: String): CharacterPopularityResponse {
        val response = maplestoryApi.fetchCharacterPopularity(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterPopularity ->
                    return CharacterPopularityResponse(
                        status = ResponseStatus.SUCCESS,
                        characterPopularity = characterPopularity
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterPopularityResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterPopularity = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterPopularityResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterPopularity = null
                )
            }

            FORBIDDEN -> {
                return CharacterPopularityResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterPopularity = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterPopularityResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterPopularity = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterPopularityResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterPopularity = null
                )
            }
        }

        return CharacterPopularityResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterPopularity = null
        )
    }

    override suspend fun getCharacterDojang(ocid: String, date: String): CharacterDojangResponse {
        val response = maplestoryApi.fetchCharacterDojang(ocid = ocid, date = date)

        when (response.code()) {
            in successStatusCodeRange -> {
                response.body()?.let { characterDojang ->
                    return CharacterDojangResponse(
                        status = ResponseStatus.SUCCESS,
                        characterDojang = characterDojang
                    )
                }
            }

            BAD_REQUEST -> {
                return CharacterDojangResponse(
                    status = ResponseStatus.BAD_REQUEST,
                    characterDojang = null
                )
            }

            UNAUTHORIZED_STATUS -> {
                return CharacterDojangResponse(
                    status = ResponseStatus.UNAUTHORIZED_STATUS,
                    characterDojang = null
                )
            }

            FORBIDDEN -> {
                return CharacterDojangResponse(
                    status = ResponseStatus.FORBIDDEN,
                    characterDojang = null
                )
            }

            TOO_MANY_REQUESTS -> {
                return CharacterDojangResponse(
                    status = ResponseStatus.TOO_MANY_REQUESTS,
                    characterDojang = null
                )
            }

            in internalServerErrorStatusCodeRange -> {
                return CharacterDojangResponse(
                    status = ResponseStatus.INTERNAL_SERVER_ERROR,
                    characterDojang = null
                )
            }
        }

        return CharacterDojangResponse(
            status = ResponseStatus.INTERNAL_SERVER_ERROR,
            characterDojang = null
        )
    }

    companion object {
        private const val BAD_REQUEST: Int = 400
        private const val UNAUTHORIZED_STATUS: Int = 401
        private const val FORBIDDEN: Int = 403
        private const val TOO_MANY_REQUESTS: Int = 429

        private val successStatusCodeRange: IntRange = 200..299
        private val internalServerErrorStatusCodeRange: IntRange = 500..599
    }
}