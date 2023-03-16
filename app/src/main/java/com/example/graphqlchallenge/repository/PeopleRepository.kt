package com.example.graphqlchallenge.repository

import com.apollographql.apollo.api.Response
import com.example.graphqlchallenge.PeopleListQuery

interface PeopleRepository {
    suspend fun getPeople(): Response<PeopleListQuery.Data>
}