package com.example.iotcoffeemaker.Main.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iotcoffeemaker.Main.eventdetail.EventDetailActivity
import com.example.iotcoffeemaker.Main.eventdetail.createEventDetailIntent
import com.example.iotcoffeemaker.Main.models.Event
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), MainContract.MainActivity {

    private val presenter = MainPresenter(this)
    private lateinit var recyclerView: RecyclerView
    private val eventsAdapter = EventsAdapter(arrayOf(), object: EventsAdapter.OnEventClickListener {
        override fun onClickEvent(event: Event) {
            presenter.onSelectEvent(event)
        }
    } )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        setListeners()
        presenter.getEvents()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun setView() {
        presenter.getEvents()
    }

    private fun setListeners() {

    }

    override fun setList(list: Array<Event>) {
        eventsAdapter.items = list
        val lManager = LinearLayoutManager(this)
        recyclerView = eventListRv.apply{
            layoutManager = lManager
            adapter = eventsAdapter
        }
    }

   override fun openEventDetailActivity(event: Event) {
        startActivity(createEventDetailIntent(this, event.id))
   }

    override fun setUserName(name: String?){

    }
}