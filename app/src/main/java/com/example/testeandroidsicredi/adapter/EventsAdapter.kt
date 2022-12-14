package com.example.testeandroidsicredi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.databinding.ItemEventBinding
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.view.EventsFragmentDirections

class EventsAdapter() :
    ListAdapter<Event, EventViewHolder>(EventsDiffCallBack()) {

    private val events = mutableListOf<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false).apply {
            return EventViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        getItem(position).let { event ->
            holder.bind(event)
            holder.itemView.setOnClickListener {
                it.findNavController().navigate(
                    EventsFragmentDirections.actionEventsFragmentToEventDetailFragment(event)
                )
            }
        }
    }

    fun update(newList: MutableList<Event>) {
        events.addAll(newList)
        submitList(newList)
        notifyDataSetChanged()
    }
}

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemEventBinding = ItemEventBinding.bind(itemView)

    fun bind(event: Event) {
        binding.eventItemDate.text = event.formattedDate()
        binding.eventItemPrice.text = event.price.toString()
        event.image.let {
            Glide.with(itemView.context).load(it)
                .placeholder(R.drawable.logo)
                .into(binding.ivImage)
        }
    }
}