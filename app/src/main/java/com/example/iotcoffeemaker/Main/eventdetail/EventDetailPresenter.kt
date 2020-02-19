package com.example.iotcoffeemaker.Main.eventdetail

import com.example.iotcoffeemaker.Main.models.Attraction

class EventDetailPresenter(var mvpView: EventDetailActivity?): EventDetailContract.EventDetailPresenter {
    private var attractions = listOf<Attraction>()
    override fun onActivityCreated(eventId: String) {
        //TODO GET filas(eventId)
        attractions = listOf(Attraction(attraction_id = "1", name  = "Mona Lisa", eventId = eventId, capacity = 260, line_time = 260, is_waiting = false), Attraction(attraction_id = "2", name  = "NOT Mona Lisa", eventId = eventId, capacity = 15, line_time = 500, is_waiting = false), Attraction(attraction_id = "3", name  = "East Wing", eventId = eventId, capacity = 1800, line_time = 45, is_waiting = false))

        mvpView?.displayAttractions(attractions)
    }

    //TODO Do this on back-end
    override fun mockGetInLine(attraction: Attraction) {
        attractions.forEach {
            it.is_waiting = it.attraction_id == attraction.attraction_id
        }
        mvpView?.displayAttractions(attractions)
    }

    override fun onDestroy() {
        mvpView = null
    }
}