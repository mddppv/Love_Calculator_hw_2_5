package com.example.love_calculator_hw_2_5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.love_calculator_hw_2_5.model.LoveApi
import com.example.love_calculator_hw_2_5.model.LoveModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {

        val mutableLiveData = MutableLiveData<LoveModel>()

        api.getLovePercentage(firstName, secondName)
            .enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let { loveModel ->
                            mutableLiveData.postValue(loveModel)
                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }
            })
        return mutableLiveData
    }
}