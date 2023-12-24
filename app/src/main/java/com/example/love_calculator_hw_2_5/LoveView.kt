package com.example.love_calculator_hw_2_5

import com.example.love_calculator_hw_2_5.model.LoveModel

interface LoveView {

    fun showResult(model: LoveModel)
    fun showError(error: String)


}