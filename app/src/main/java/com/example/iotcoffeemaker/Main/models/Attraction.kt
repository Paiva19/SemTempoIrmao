package com.example.iotcoffeemaker.Main.models

class Attraction(
    val name: String,
    val event: Event,
    val capacity: Int,
    val line_time: Int,
    val is_waiting: Boolean = false
)

