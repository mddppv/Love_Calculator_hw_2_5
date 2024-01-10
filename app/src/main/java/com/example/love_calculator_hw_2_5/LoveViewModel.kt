package com.example.love_calculator_hw_2_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.love_calculator_hw_2_5.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLoveLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }

}