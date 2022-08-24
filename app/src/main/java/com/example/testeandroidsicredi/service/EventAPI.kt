package com.example.testeandroidsicredi.service

import com.example.testeandroidsicredi.model.EventResponse
import retrofit2.Response
import retrofit2.http.GET

interface EventAPI {
    @GET("/api/events")
    suspend fun getEvents(): Response<EventResponse>

}