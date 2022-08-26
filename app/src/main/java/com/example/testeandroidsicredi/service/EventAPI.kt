package com.example.testeandroidsicredi.service

import com.example.testeandroidsicredi.model.Event
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EventAPI {
    @GET("/api/events/{id}")
    suspend fun getEventDetail(
        @Path("id") id: String
    ): Response<List<Event>>

    @GET("/api/events")
    suspend fun getEvents(): Response<List<Event>>
}