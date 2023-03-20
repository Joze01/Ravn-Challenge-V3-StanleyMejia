package com.example.graphqlchallenge.api

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class StarWarsApi {
    fun getApolloClient(): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()){

        }

        val okHttpClient = OkHttpClient.Builder().build()
        // TODO: hard code strings should be in constants
        return ApolloClient.builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .okHttpClient(okHttpClient)
            .build()
    }
}