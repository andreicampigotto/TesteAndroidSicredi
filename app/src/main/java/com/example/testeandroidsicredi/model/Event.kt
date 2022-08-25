package com.example.testeandroidsicredi.model

import com.google.gson.annotations.SerializedName

data class Event (
    @SerializedName("people")
    val people :  List<People>,
    @SerializedName("date")
    val date: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("longitude")
    val longitude: Long,
    @SerializedName("latitude")
    val latitude: Long,
    @SerializedName("price")
    val price : Float,
    @SerializedName("title")
    val title: String,
    @SerializedName("id")
    val id: String,
)

data class EventResponse(
    val results: List<Event>
)

data class People(
    val id: Long,
    val name: String,
    val email: String
)
