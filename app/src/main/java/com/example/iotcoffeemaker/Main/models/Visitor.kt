package com.example.iotcoffeemaker.Main.models

import android.provider.CalendarContract

class Visitor (
    val  id: String,
    val used_discounts: List<Discount> = listOf<Discount>(),
    val visited_attractions: List<Attraction> = listOf<Attraction>(),
    val visited_events: List<Event> = listOf<Event>(),
    var current_event: Event,
    var current_line: Attraction
)