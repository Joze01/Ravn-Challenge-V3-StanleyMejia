package com.example.graphqlchallenge.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.graphqlchallenge.PeopleListQuery
import com.example.graphqlchallenge.api.StarWarsApi
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val peoplesApi: StarWarsApi
):PeopleRepository {


    override suspend fun getPeople(): Response<PeopleListQuery.Data> {
        return peoplesApi.getApolloClient().query(PeopleListQuery()).await()
    }

}