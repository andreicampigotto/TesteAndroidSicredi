package com.example.testeandroidsicredi.repository

import com.example.testeandroidsicredi.service.EventAPI
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val service: EventAPI
) {
}