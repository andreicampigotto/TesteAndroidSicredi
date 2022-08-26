package com.example.testeandroidsicredi.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.databinding.FragmentEventDetailBinding
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.viewModel.EventViewModel
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailFragment() : Fragment(R.layout.fragment_event_detail) {

    private lateinit var binding: FragmentEventDetailBinding
    private val args by navArgs<EventDetailFragmentArgs>()
    private lateinit var viewModel: EventViewModel
    lateinit var mapa: GoogleMap

    private val observerEvent = Observer<Event> {
        binding.progressBar.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventDetailBinding.bind(view)

        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        viewModel.event.observe(viewLifecycleOwner, observerEvent)

        viewModel.getEventDetail(args.event.id.toInt())

        load(args.event!!)

        checkIn()
    }

    private fun load(event: Event) {
        binding.tvTitle.text = event.title
        binding.tvDescription.text = event.description
        binding.tvDate.text = event.formattedDate()

        event.image.let {
            Glide.with(this).load(it)
                .into(binding.incImage.ivImage)
        }
    }

    private fun checkIn() {
        binding.mbCheckIn.setOnClickListener {
            it.findNavController().navigate(
                EventDetailFragmentDirections.actionEventDetailFragmentToCheckInFragment(args.event.id)
            )
        }
    }

}
