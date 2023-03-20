package com.example.graphqlchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graphqlchallenge.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        // TODO: all the keys should in  companion object constants
        val name = intent.getStringExtra("name")
        val birthYear = intent.getStringExtra("birthday")
        val eyeColor = intent.getStringExtra("eyecolor")
        val hairColor = intent.getStringExtra("haircolor")
        val skinColor = intent.getStringExtra("skincolor")


        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.text = name
        binding.birthYear.text = birthYear
        binding.eyecolor.text = eyeColor
        binding.hairColor.text = hairColor
        binding.skinColor.text = skinColor
    }

}