package com.example.testeandroidsicredi.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testeandroidsicredi.model.Event

class EventsDiffCallBack : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }
}