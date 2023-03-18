package com.example.graphqlchallenge

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import com.example.graphqlchallenge.adapter.PeopleListAdapter
import com.example.graphqlchallenge.adapter.PeopleViewModel
import com.example.graphqlchallenge.adapter.ViewHolderList
import com.example.graphqlchallenge.databinding.ActivityMainBinding
import com.example.graphqlchallenge.databinding.ItemCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


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

        peopleListAdapter.setOnItemClickListener(object : PeopleListAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity,"You Clicked this",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                startActivity(intent)
                  //  intent.putExtra("name", )
            }

        })
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