package com.bodan.maplecalendar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bodan.maplecalendar.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}