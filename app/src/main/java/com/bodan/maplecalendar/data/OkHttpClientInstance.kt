package com.bodan.maplecalendar.data

import okhttp3.OkHttpClient

object OkHttpClientInstance {

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().run {
            this.addInterceptor(NexonApiKeyInterceptor)
            this.build()
        }
    }
}