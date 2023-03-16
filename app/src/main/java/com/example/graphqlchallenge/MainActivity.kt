package com.example.graphqlchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.graphqlchallenge.adapter.PeopleListAdapter
import com.example.graphqlchallenge.adapter.PeopleViewModel
import com.example.graphqlchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PeopleViewModel by viewModels()
    private val peopleListAdapter = PeopleListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.characterList.apply { adapter = peopleListAdapter}
        observeLiveData()
        viewModel.queryPeopleList()

    }

    private fun observeLiveData() {
        viewModel.peoplesList.observe(this) { response ->
            when (response) {
                is ViewStates.Success -> {
                    if (response.value?.data?.allPeople?.people?.size == 0) {
                        peopleListAdapter.submitList(emptyList())
                        return@observe
                    }
                    val results = response.value?.data?.allPeople?.people
                    peopleListAdapter.submitList(results)
                }
                else -> Unit
            }
        }
    }

    }