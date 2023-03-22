package com.oguzdogdu.rickandmortycompose.data.remote.di

import com.oguzdogdu.rickandmortycompose.data.remote.service.RickAndMortyService
import com.oguzdogdu.rickandmortycompose.data.repository.RickMortyRepositoryImpl
import com.oguzdogdu.rickandmortycompose.domain.repository.RickMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRickMortRepository(service: RickAndMortyService): RickMortyRepository {
        return RickMortyRepositoryImpl(service)
    }
}