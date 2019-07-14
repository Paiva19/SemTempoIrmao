package com.example.iotcoffeemaker.Main.retrofit.service

import retrofit2.Call
import retrofit2.http.GET

interface CoffeeService {
    @GET("coffee")
    fun coffee(coffeeMaker_ID: Int): Call<Int>

    @GET("waterLevel")
    fun waterLevel(coffeeMaker_ID: Int): Call<Int>
}