package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.retrofit.RetrofitInitializer
import com.example.iotcoffeemaker.Main.retrofit.models.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {
    val mService = RetrofitInitializer().coffeeService()

    override fun onDestroy() {
       mView = null
    }

    override fun onClearMessageClick() {
        mView?.hideTextMessage()
    }

    override fun onMakeCoffeeClick() {
        mView?.setButtonsEnable(false)
        mService.coffee(mView?.getCoffeePotId() ?: 0).enqueue(object: Callback<ResponseModel?> {
            override fun onResponse(call: Call<ResponseModel?>?,
                                    response: Response<ResponseModel?>?) {
                mView?.setButtonsEnable(true)
                if(response?.code() == 200)
                    mView?.showTextMessage(response.body()?.msg ?: "Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<ResponseModel?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }


    override fun onChangeFilterClick() {
        mView?.setButtonsEnable(false)
        mService.changeFilter(mView?.getCoffeePotId() ?: 0).enqueue(object: Callback<ResponseModel?> {

            override fun onResponse(call: Call<ResponseModel?>?,
                                    response: Response<ResponseModel?>?) {

                mView?.setButtonsEnable(true)
                if(response?.code() == 200)
                    mView?.showTextMessage(response.body()?.msg ?: "Confirmado o filtro trocado! :)")
                else
                    mView?.showTextMessage("ERRO \n" + response?.message())
            }

            override fun onFailure(call: Call<ResponseModel?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }
    override fun onCheckWaterLevelClick() {
        mView?.setButtonsEnable(false)
        mService.waterLevel(mView?.getCoffeePotId() ?: 0).enqueue(object: Callback<ResponseModel?> {
            override fun onResponse(call: Call<ResponseModel?>?,
                                    response: Response<ResponseModel?>) {

                mView?.setButtonsEnable(true)
                if(response.code() == 200)
                    mView?.showTextMessage( response.body()?.msg ?: "Fazendo seu café, pois tudo nessa casa aqui sou eu NINGUÉM NUNCA FAZ NADA QUERO VER COMO VAI SER DEPOIS QUE EU MORRER")
                else
                    mView?.showTextMessage("ERRO \n" + response.code())
            }

            override fun onFailure(call: Call<ResponseModel?>?,
                                   t: Throwable?) {
                mView?.setButtonsEnable(true)
                mView?.showTextMessage( t?.message ?: "Erro desconhecido" )
            }
        })
    }
}