package com.example.graphqlchallenge.adapter


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.graphqlchallenge.PeopleListQuery
import com.example.graphqlchallenge.ViewStates
import com.example.graphqlchallenge.repository.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: PeopleRepository
):ViewModel(){

    private val _peopleList by lazy { MutableLiveData<ViewStates<Response<PeopleListQuery.Data>>>()}
        val peoplesList: LiveData<ViewStates<Response<PeopleListQuery.Data>>>
        get()=_peopleList

    fun queryPeopleList() = viewModelScope.launch {
        _peopleList.postValue(ViewStates.Loading())
        try {
            val response = repository.getPeople()
            _peopleList.postValue(ViewStates.Success(response))
        }
        catch (e:ApolloException){
            Log.d("ApolloException", "Failure", e)
            _peopleList.postValue(ViewStates.Error("Error Fetching Characters"))
        }
    }
}