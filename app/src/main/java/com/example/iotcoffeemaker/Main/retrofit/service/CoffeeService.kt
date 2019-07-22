package com.example.iotcoffeemaker.Main.retrofit.service

import com.example.iotcoffeemaker.Main.retrofit.models.CoffeeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoffeeService {
    @GET("coffee")
    fun coffee(@Query("coffeeMaker_ID") coffeeMaker_ID: Int): Call<CoffeeModel>

    @GET("waterLevel")
    fun waterLevel(@Query("coffeeMaker_ID") coffeeMaker_ID: Int): Call<String>
}