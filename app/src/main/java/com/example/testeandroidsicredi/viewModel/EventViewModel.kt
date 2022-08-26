package com.example.testeandroidsicredi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.repository.EventRepository
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository
) : ViewModel() {

    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> = _events

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> = _event

    private val _checkIn = MutableLiveData<String>()
    val checkIn: LiveData<String> = _checkIn

    fun getEventDetail(id: Int) {
        viewModelScope.launch {
            val returnedPulls =
                eventRepository.getEventDetail(
                    id = id
                )
            returnedPulls.let {
                _event.value = it
            }
        }
    }

    fun getEventList() {
        viewModelScope.launch {
            val returnedEvents =
                eventRepository.getEvents()
            returnedEvents.let {
                _events.value = it
            }
        }
    }

    fun setCheckIn(id: String, name: String, email: String) {
        val message = "Max number of elements reached for this resource!"
        viewModelScope.launch {
            val setChekIn =
                eventRepository.setCheckIn(id = id, name = name, email = email)
            setChekIn.let {}
            if (setChekIn == message) {
                _checkIn
            }
        }
    }
}