package com.example.testeandroidsicredi.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.adapter.EventsAdapter
import com.example.testeandroidsicredi.databinding.FragmentEventsBinding
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.viewModel.EventViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment(R.layout.fragment_events) {

    private lateinit var viewModel: EventViewModel
    private lateinit var binding: FragmentEventsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEventsBinding.bind(view)

        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        viewModel.events.observe(viewLifecycleOwner, observerEvent)

        viewModel.getEventList()
        setupRecyclerView()


    }

    private val eventAdapter = EventsAdapter()

    private val observerEvent =
        Observer<List<Event>> {
            eventAdapter.update(it.toMutableList())
            binding.progressBar.visibility = View.GONE
            binding.eventsRecyclerView.visibility = View.VISIBLE
        }

    private fun setupRecyclerView() = with(binding.eventsRecyclerView) {
        adapter = eventAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE)
            }
        })
    }
}