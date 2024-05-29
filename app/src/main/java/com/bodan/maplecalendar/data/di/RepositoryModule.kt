package com.bodan.maplecalendar.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.bodan.maplecalendar.data.repository.MaplestoryRemoteDataSource
import com.bodan.maplecalendar.data.repository.MaplestoryRepositoryImpl
import com.bodan.maplecalendar.data.repository.SettingsRepositoryImpl
import com.bodan.maplecalendar.domain.repository.MaplestoryRepository
import com.bodan.maplecalendar.domain.repository.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMaplestoryRepository(maplestoryRemoteDataSource: MaplestoryRemoteDataSource): MaplestoryRepository {
        return MaplestoryRepositoryImpl(maplestoryRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(dataStore: DataStore<Preferences>): SettingsRepository {
        return SettingsRepositoryImpl(dataStore)
    }
}