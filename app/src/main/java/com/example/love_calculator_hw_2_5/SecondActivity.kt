package com.example.love_calculator_hw_2_5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.love_calculator_hw_2_5.databinding.ActivitySecondBinding
import com.example.love_calculator_hw_2_5.model.LoveModel

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultText = intent.getStringExtra("resultText")
        binding.tvLoveResult.text = resultText
    }


}