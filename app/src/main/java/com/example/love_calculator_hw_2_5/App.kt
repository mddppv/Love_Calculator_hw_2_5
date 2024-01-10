package com.example.love_calculator_hw_2_5

import android.app.Application
import androidx.room.Room
import com.example.love_calculator_hw_2_5.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }
}