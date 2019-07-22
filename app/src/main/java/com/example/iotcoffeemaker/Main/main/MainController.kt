package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.retrofit.RetrofitInitializer
import com.example.iotcoffeemaker.Main.retrofit.models.CoffeeModel
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {

    val mService = RetrofitInitializer().coffeeService()

    override fun onDestroy() {
       mView = null
    }

    override fun onLogoClick() {
        mView?.hideTextMessage()
    }

    override fun onMakeCoffeeClick() {
        mService.coffee(56246).enqueue(object: Callback<CoffeeModel?> {
            override fun onResponse(call: Call<CoffeeModel?>?,
                                    response: Response<CoffeeModel?>?) {
                if(response?.code() == 200)
                    mView?.showTextMessage("Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<CoffeeModel?>?,
                                   t: Throwable?) {
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }

    override fun onCheckWaterLevelClick() {
        mService.waterLevel(56246).enqueue(object: Callback<String?> {
            override fun onResponse(call: Call<String?>?,
                                    response: Response<String?>?) {

                var jsonBody = Gson().toJson(response?.body())
                if(response?.code() == 200)
                    mView?.showTextMessage("Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<String?>?,
                                   t: Throwable?) {
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }
}