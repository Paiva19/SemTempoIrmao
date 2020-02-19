package com.example.iotcoffeemaker.Main.models

class Attraction(
    val attraction_id: String,
    val name: String,
    val eventId: String,
    val capacity: Int,
    val line_time: Int,
    var is_waiting: Boolean = false
)

