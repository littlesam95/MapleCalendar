package com.bodan.maplecalendar.data.di

import com.bodan.maplecalendar.data.api.MaplestoryApi
import com.bodan.maplecalendar.data.repository.MaplestoryRemoteDataSource
import com.bodan.maplecalendar.data.repository.MaplestoryRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideMaplestoryRemoteDataSource(maplestoryApi: MaplestoryApi): MaplestoryRemoteDataSource {
        return MaplestoryRemoteDataSourceImpl(maplestoryApi)
    }
}