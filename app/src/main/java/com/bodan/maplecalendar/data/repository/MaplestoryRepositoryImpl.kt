package com.bodan.maplecalendar.data.repository

import com.bodan.maplecalendar.data.ResponseStatus
import com.bodan.maplecalendar.data.NetworkModule
import com.bodan.maplecalendar.data.dto.CharacterBasicResponse
import com.bodan.maplecalendar.data.dto.CharacterOcidResponse
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

    /*
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
    */

    companion object {
        private const val BAD_REQUEST: Int = 400
        private const val UNAUTHORIZED_STATUS: Int = 401
        private const val FORBIDDEN: Int = 403
        private const val TOO_MANY_REQUESTS: Int = 429

        private val successStatusCodeRange: IntRange = 200..299
        private val internalServerErrorStatusCodeRange: IntRange = 500..599
    }
}