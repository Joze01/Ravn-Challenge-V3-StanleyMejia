package com.example.graphqlchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graphqlchallenge.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name
        binding.birthYear
        binding.eyecolor
        binding.generalInf
        binding.hairColor
        binding.skinColor
        binding.textView2
        binding.textView3
        binding.textView4
        binding.textView5
    }

}