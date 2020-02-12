package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.models.Event
import com.example.iotcoffeemaker.Main.retrofit.RetrofitInitializer
import java.util.*


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {

    val mService = RetrofitInitializer().coffeeService()

    override fun getEvents() {
        val testEvents = arrayOf(Event(id = "louvre_museum_id", name = "Louvre Museum", place = "", time = Date(), ticket_price = 13.4f))

        mView?.setList(testEvents)
    }

    override fun onSelectEvent(event: Event) {
        mView?.openEventDetailActivity(event)
    }

    override fun onDestroy() {
       mView = null
    }

}