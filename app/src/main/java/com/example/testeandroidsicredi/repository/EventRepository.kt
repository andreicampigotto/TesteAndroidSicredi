package com.example.testeandroidsicredi.repository

import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.service.EventAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val service: EventAPI
) {
    suspend fun getEvents(): List<Event>? {
        return withContext(Dispatchers.Default) {
            val response = service.getEvents()
            val processResponse = processData(response)
            processResponse
        }
    }

    suspend fun getEventDetail(id: Int): Event? {
        return withContext(Dispatchers.Default) {
            val response = service.getEventDetail(id)
            response.body()
        }
    }

    suspend fun setCheckIn(id: String, name: String, email: String): String {
        return withContext(Dispatchers.Default) {
            service.setCheckIn(eventId = id, name = name, email = email)
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}