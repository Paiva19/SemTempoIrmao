package com.example.iotcoffeemaker.Main.retrofit

import com.example.iotcoffeemaker.Main.retrofit.service.CoffeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://modern-wasp-79.localtunnel.me/"//"http://10.144.217.208:8080/"

class RetrofitInitializer {

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//.baseUrl(Resources.getSystem().getString(R.string.api_base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun coffeeService(): CoffeeService {
        return retrofit.create(CoffeeService::class.java)
    }
}