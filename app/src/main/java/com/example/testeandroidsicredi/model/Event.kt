package com.example.testeandroidsicredi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Event(
    @SerializedName("date")
    val date: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("id")
    val id: String,
) : Serializable {
    fun formattedDate(): String {
        val dateFormatted = SimpleDateFormat("dd/MM/yyyy")
        return dateFormatted.format(date).capitalize()
    }
}

