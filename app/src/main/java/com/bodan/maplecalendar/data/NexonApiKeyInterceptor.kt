package com.bodan.maplecalendar.data

import com.bodan.maplecalendar.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

object NexonApiKeyInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val nexonApiKey = BuildConfig.NEXON_API_KEY
        val newRequest = request().newBuilder()
            .addHeader("x-nxopen-api-key", nexonApiKey)
            .build()
        proceed(newRequest)
    }
}