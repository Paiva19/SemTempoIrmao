package com.example.iotcoffeemaker.Main.retrofit.service

import com.example.iotcoffeemaker.Main.retrofit.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoffeeService {
    @GET("coffee")
    fun coffee(@Query("coffeeMaker_ID") coffeeMaker_ID: Int): Call<ResponseModel>

    @GET("waterLevel")
    fun waterLevel(@Query("coffeeMaker_ID") coffeeMaker_ID: Int): Call<ResponseModel>


    @GET("filter")
    fun changeFilter(@Query("coffeeMaker_ID") coffeeMaker_ID: Int): Call<ResponseModel>
}