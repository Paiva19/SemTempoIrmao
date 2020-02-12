package com.example.iotcoffeemaker.Main.models

import java.util.*

class Event(
    val id: String,
    val name: String,
    val place: String,
    val time: Date,
    val ticket_price: Float,
    val attractions: List<Attraction> = listOf()
)