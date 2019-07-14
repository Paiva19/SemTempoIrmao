package com.example.iotcoffeemaker.Main

interface MainContract {
    interface MainActivity {
        fun showTextMessage(toastMsg: String)
        fun hideTextMessage()
    }
    interface MainPresenter {
        fun onMakeCoffeeClick()
        fun onCheckWaterLevelClick()
    }

}