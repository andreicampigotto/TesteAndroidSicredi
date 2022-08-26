package com.example.testeandroidsicredi.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Event (
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
    val price : Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("id")
    val id: String,
): Serializable {
    @RequiresApi(Build.VERSION_CODES.O)
    fun formattedDate(): String {
        return java.time.format.DateTimeFormatter.ISO_INSTANT
            .format(java.time.Instant.ofEpochSecond(date))
    }
}

