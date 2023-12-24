package com.example.love_calculator_hw_2_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.love_calculator_hw_2_5.databinding.ActivityMainBinding
import com.example.love_calculator_hw_2_5.model.LoveModel

class MainActivity : AppCompatActivity(), LoveView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()
    private var firstName = String()
    private var secondName = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCheck.setOnClickListener {
                firstName = etFirstName.text.toString()
                secondName = etSecondName.text.toString()
                presenter.getData(firstName, secondName)
            }
        }
    }

    override fun showResult(model: LoveModel) {
        if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
            val resultText = "Percentage: " + model.percentage + "\nResult: " + model.result
            val secondActivity = Intent(this, SecondActivity::class.java)
            secondActivity.putExtra("resultText", resultText)
            startActivity(secondActivity)
        } else {
            if (firstName.isEmpty()) {
                binding.etFirstName.error = "Enter the first name"
            }
            if (secondName.isEmpty()) {
                binding.etSecondName.error = "Enter the second name"
            }
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }


}