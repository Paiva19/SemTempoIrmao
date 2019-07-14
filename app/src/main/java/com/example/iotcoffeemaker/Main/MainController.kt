package com.example.iotcoffeemaker.Main


class MainPresenter(var mView: MainActivity?) : MainContract.MainPresenter {


    override fun onMakeCoffeeClick() {
        mView?.showTextMessage("Click em fazer cafe!")
    }

    override fun onCheckWaterLevelClick() {
        mView?.showTextMessage("Click em checar nivel de agua!")
    }
}