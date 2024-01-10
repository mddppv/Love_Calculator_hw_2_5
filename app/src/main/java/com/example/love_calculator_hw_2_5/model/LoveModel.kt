package com.example.love_calculator_hw_2_5.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love-table")
data class LoveModel(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @SerializedName("fname")
    val firstName: String,

    @SerializedName("sname")
    val secondName: String,

    val percentage: String,
    val result: String

) {
    override fun toString(): String {
        return "Search $id\n First name: $firstName\n Second name: $secondName\n Love percentage: $percentage\n Your result: $result"
    }
}