package com.example.love_calculator_hw_2_5.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.love_calculator_hw_2_5.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao(): LoveDao

}