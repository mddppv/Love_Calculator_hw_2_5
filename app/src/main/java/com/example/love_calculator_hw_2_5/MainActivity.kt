package com.example.love_calculator_hw_2_5

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.love_calculator_hw_2_5.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCheck.setOnClickListener {
                getData()
            }
            btnHistory.setOnClickListener {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                tvResult.isGone = true
            }
        }
    }

    private fun ActivityMainBinding.getData() {
        viewModel.getLoveLiveData(etFirstName.text.toString(), etSecondName.text.toString())
            .observe(this@MainActivity) {
                App.appDatabase.getDao().insert(it)
                tvResult.text = it.toString()
                tvResult.isVisible = true
            }
    }
}