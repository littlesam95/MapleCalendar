package com.bodan.maplecalendar.data.di

import com.bodan.maplecalendar.data.api.MaplestoryApi
import com.bodan.maplecalendar.data.util.NexonApiKeyInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    private const val BASE_URL = "https://open.api.nexon.com/maplestory/"

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            this.addInterceptor(NexonApiKeyInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    @Named("Maplestory")
    fun provideMaplestoryRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(provideMoshiConverterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideMaplestoryApiService(@Named("Maplestory") retrofit: Retrofit): MaplestoryApi {
        return retrofit.create(MaplestoryApi::class.java)
    }
}