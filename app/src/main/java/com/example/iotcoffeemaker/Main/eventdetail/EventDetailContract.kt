package com.example.iotcoffeemaker.Main.eventdetail

import com.example.iotcoffeemaker.Main.models.Attraction


interface EventDetailContract {

    interface EventDetailActivity {
       fun displayAttractions(attractions: List<Attraction>)
    }

    interface EventDetailPresenter {
        fun mockGetInLine(attraction: Attraction)
        fun onActivityCreated(eventId: String)
        fun onDestroy()



    }

}