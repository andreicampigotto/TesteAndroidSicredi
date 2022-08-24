package com.example.testeandroidsicredi.service

import com.example.testeandroidsicredi.model.EventResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EventAPI {
    @GET("/api/events")
    suspend fun fetchEvents(
        @Query("id") id: Long,
    ): Response<EventResponse>

}