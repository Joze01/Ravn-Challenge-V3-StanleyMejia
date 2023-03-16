package com.example.graphqlchallenge.repository

import com.example.graphqlchallenge.api.StarWarsApi
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
    fun providesStarWarsApi() = StarWarsApi()
}