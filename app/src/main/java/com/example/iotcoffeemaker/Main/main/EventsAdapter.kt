package com.example.iotcoffeemaker.Main.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iotcoffeemaker.Main.models.Event
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.event_item.view.*

class EventsAdapter(private val items: Array<Event>, val onClickListener: OnEventClickListener) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    public interface OnEventClickListener {
        fun onClickEvent(event: Event)
    }

    override fun getItemCount(): Int  = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.run {
            this.eventItemNameTv.text = items[position].name
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false))
    }

}