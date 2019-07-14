package com.example.iotcoffeemaker.Main.main

import com.example.iotcoffeemaker.Main.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {

    val mService = RetrofitInitializer().coffeeService()

    override fun onDestroy() {
       mView = null
    }


    override fun onMakeCoffeeClick() {
        mService.coffee(56246).enqueue(object: Callback<Int?> {
            override fun onResponse(call: Call<Int?>?,
                                    response: Response<Int?>?) {
                mView?.showTextMessage("FAZENDO SEU CAFE, PREGUICOSO INUTIL")
            }

            override fun onFailure(call: Call<Int?>?,
                                   t: Throwable?) {
                mView?.showTextMessage( t?.message ?: "Nao ha mensagem" )
            }
        })
    }

    override fun onCheckWaterLevelClick() {
        mService.waterLevel(56246).enqueue(object: Callback<Int?> {
            override fun onResponse(call: Call<Int?>?,
                                    response: Response<Int?>?) {
                mView?.showTextMessage("MEDINDO AGUA, PREGUICOSO INUTIL")
            }

            override fun onFailure(call: Call<Int?>?,
                                   t: Throwable?) {
                mView?.showTextMessage( t.toString() )
            }
        })
    }
}