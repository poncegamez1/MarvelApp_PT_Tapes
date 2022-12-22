package com.poncegamez.marvelapp_pt_tapes.di

import com.poncegamez.marvelapp_pt_tapes.api.ComicsApi
import com.poncegamez.marvelapp_pt_tapes.repository.ComicsRepository
import com.poncegamez.marvelapp_pt_tapes.repository.impl.ComicsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesComicsRepository(comicsApi: ComicsApi): ComicsRepository {
        return ComicsRepositoryImpl(comicsApi)
    }
}