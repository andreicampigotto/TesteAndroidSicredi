package com.example.testeandroidsicredi.service

import com.example.testeandroidsicredi.model.Event
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventAPI {
    @GET("/api/events/{id}")
    suspend fun getEventDetail(
        @Path(
            "id",
            encoded = true
        ) id: Int
    ): Response<Event>

    @GET("/api/events")
    suspend fun getEvents(): Response<List<Event>>

    @POST("/api/checkin")
    suspend fun setCheckIn(
        @Path("eventId") eventId: String,
        @Path("name") name: String,
        @Path("email") email: String,
    ): String
}