package com.example.love_calculator_hw_2_5

import com.example.love_calculator_hw_2_5.model.LoveModel
import com.example.love_calculator_hw_2_5.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter {

    private val api = RetrofitService().api
    lateinit var view: LoveView

    fun getData(firstName: String, secondName: String) {
        api?.getLovePercentage(firstName, secondName)?.enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.showResult(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError(t.message.toString())
            }
        })
    }

    fun attachView(view: LoveView){
        this.view = view
    }


}