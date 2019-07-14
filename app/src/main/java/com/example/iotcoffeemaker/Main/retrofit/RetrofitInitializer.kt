package com.example.iotcoffeemaker.Main.retrofit

import android.content.Context
import android.content.res.Resources
import com.example.iotcoffeemaker.Main.retrofit.service.CoffeeService
import com.example.iotcoffeemaker.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

        private val retrofit = Retrofit.Builder()
            .baseUrl(Resources.getSystem().getString(R.string.api_base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun coffeeService(): CoffeeService {
        return retrofit.create(CoffeeService::class.java)
    }
}