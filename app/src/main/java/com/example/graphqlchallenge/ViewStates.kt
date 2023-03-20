package com.example.graphqlchallenge


// TODO: great ussage of viewstates.
sealed class ViewStates<T>(
    val value: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ViewStates<T>(data)
    class Error<T>(message: String?, data: T? = null) : ViewStates<T>(data, message)
    class Loading<T> : ViewStates<T>()
}

