package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.retrofit.RetrofitInitializer
import com.example.iotcoffeemaker.Main.retrofit.models.CoffeeModel
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {
    var coffeePotId = 12
    val mService = RetrofitInitializer().coffeeService()

    override fun onDestroy() {
       mView = null
    }

    override fun onClearMessageClick() {
        mView?.hideTextMessage()
    }

    override fun onMakeCoffeeClick() {
        mView?.setButtonsEnable(false)
        mService.coffee(coffeePotId).enqueue(object: Callback<CoffeeModel?> {
            override fun onResponse(call: Call<CoffeeModel?>?,
                                    response: Response<CoffeeModel?>?) {
                mView?.setButtonsEnable(true)
                val jsonBody = Gson().toJson(response?.body())
                if(response?.code() == 200)
                    mView?.showTextMessage(jsonBody ?: "Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<CoffeeModel?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }


    override fun onChangeFilterClick() {
        mView?.setButtonsEnable(false)
        mService.changeFilter(coffeePotId).enqueue(object: Callback<String?> {
            override fun onResponse(call: Call<String?>?,
                                    response: Response<String?>?) {

                mView?.setButtonsEnable(true)
                val jsonBody = Gson().toJson(response?.body())
                if(response?.code() == 200)
                    mView?.showTextMessage(jsonBody ?: "Confirmado o filtro trocado! :)")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<String?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }
    override fun onCheckWaterLevelClick() {
        mView?.setButtonsEnable(false)
        mService.waterLevel(coffeePotId).enqueue(object: Callback<String?> {
            override fun onResponse(call: Call<String?>?,
                                    response: Response<String?>?) {

                mView?.setButtonsEnable(true)
                val jsonBody = Gson().toJson(response?.body())
                if(response?.code() == 200)
                    mView?.showTextMessage(jsonBody ?: "Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<String?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }
}