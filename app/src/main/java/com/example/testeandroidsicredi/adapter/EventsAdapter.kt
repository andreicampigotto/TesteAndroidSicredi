package com.example.testeandroidsicredi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.databinding.ItemEventBinding
import com.example.testeandroidsicredi.model.Event

class EventsAdapter(val onTap: (Event) -> Unit) :
    ListAdapter<Event, EventViewHolder>(EventsDiffCallBack()) {

    private val events = mutableListOf<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false).apply {
            return EventViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
            holder.itemView.setOnClickListener {

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
        binding.tvTitle.text = event.title
        binding.tvDescription.text = event.description
        binding.incImage.tvPrice.text = event.price.toString()

        event.image.let {
            Glide.with(itemView.context).load(it)
                .into(binding.incImage.ivImage)
        }
    }
}