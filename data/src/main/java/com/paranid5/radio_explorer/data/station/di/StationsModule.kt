package com.paranid5.radio_explorer.data.station.di

import com.paranid5.radio_explorer.data.station.StationsApi
import com.paranid5.radio_explorer.data.station.StationsRepositoryImpl
import com.paranid5.radio_explorer.domain.station.StationsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class StationsModule {

    @Binds
    internal abstract fun bindStationsRepository(
        repositoryImpl: StationsRepositoryImpl,
    ): StationsRepository

    companion object {
        @Provides
        internal fun provideStationsApi(retrofit: Retrofit): StationsApi =
            retrofit.create(StationsApi::class.java)
    }
}