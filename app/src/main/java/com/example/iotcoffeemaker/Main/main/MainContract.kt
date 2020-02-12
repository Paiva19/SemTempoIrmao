package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.models.Event

interface MainContract {
    interface MainActivity {
        fun setUserName(name: String?)
        fun setList(list: Array<Event>)
        fun openEventDetailActivity(event: Event)
    }
    interface MainPresenter {
        fun onDestroy()
        fun getEvents()
        fun onSelectEvent(event: Event)
    }

}