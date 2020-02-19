package com.example.iotcoffeemaker.Main.eventdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.iotcoffeemaker.Main.main.EventsAdapter
import com.example.iotcoffeemaker.Main.models.Attraction
import com.example.iotcoffeemaker.Main.models.Event
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.event_item.view.*
import kotlinx.android.synthetic.main.line_item.view.*

class AttractionsAdapter(var items: List<Attraction>, val onClickListener: OnAttractionClickListener) : RecyclerView.Adapter<AttractionsAdapter.ViewHolder>() {

    interface OnAttractionClickListener {
        fun onClickAttraction(attraction: Attraction)
        fun onClickGetOnLineBtn(attraction: Attraction)
    }

    override fun getItemCount(): Int  = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.run {
            lineItemNameTv.text = items[position].name
            lineItemWaitTimer.text = context.getString(R.string.wait_time_min, items[position].line_time.toString())

            getInLineBtn.setBackgroundResource(if (items[position].is_waiting) R.drawable.bg_rounded_forest_green else R.drawable.bg_rounded_red)

            this.setOnClickListener {
                onClickListener.onClickAttraction(items[position])
            }
            getInLineBtn.setOnClickListener {
                onClickListener.onClickGetOnLineBtn(items[position])
            }
        }

    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.line_item, parent, false))
    }

}