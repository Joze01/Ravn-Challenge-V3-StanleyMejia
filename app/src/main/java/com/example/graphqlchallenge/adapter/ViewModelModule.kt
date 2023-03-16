package com.example.graphqlchallenge.adapter

import com.example.graphqlchallenge.repository.PeopleRepository
import com.example.graphqlchallenge.repository.PeopleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)

abstract class ViewModelModule {
    @Binds
    @ViewModelScoped

    abstract fun bindRepository(repo: PeopleRepositoryImpl): PeopleRepository
}