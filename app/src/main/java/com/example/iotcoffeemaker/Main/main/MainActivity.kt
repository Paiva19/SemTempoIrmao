package com.example.iotcoffeemaker.Main.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iotcoffeemaker.Main.models.Event
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), MainContract.MainActivity {

    private val presenter = MainPresenter(this)
    private lateinit var recyclerView: RecyclerView

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
        val eventsAdapter = EventsAdapter(list, object: EventsAdapter.OnEventClickListener {
            override fun onClickEvent(event: Event) {
                presenter.onSelectEvent(event)
            }
        } )
        val lManager = LinearLayoutManager(this)
        recyclerView = eventListRv.apply{
            layoutManager = lManager
            adapter = eventsAdapter
        }
    }

   override fun openEventDetailActivity(event: Event) {
//       startActivity()
   }

    override fun setUserName(name: String?){

    }
}