package com.example.love_calculator_hw_2_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.love_calculator_hw_2_5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = App.appDatabase.getDao().getAll()

        list.forEach {
            with(binding) {
                tvResultHistory.append("$it")
                tvResultHistory.text = list.joinToString(separator = "\n\n\n")
            }
        }
    }
}