package com.example.testeandroidsicredi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val event: EventRepository
) : ViewModel() {

    private val _event = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> = _event

    fun getEventList() {
        viewModelScope.launch {
            val returnedPulls =
                event.getEvents()
            returnedPulls.let {
                _event.value = it
            }
        }
    }
}