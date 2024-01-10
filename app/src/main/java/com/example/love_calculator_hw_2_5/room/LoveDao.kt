package com.example.love_calculator_hw_2_5.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.love_calculator_hw_2_5.model.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM `love-table` ORDER BY firstName, secondName ASC")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(users: LoveModel)

}