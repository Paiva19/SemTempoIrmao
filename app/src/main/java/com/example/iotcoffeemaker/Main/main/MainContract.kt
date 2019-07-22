package com.example.iotcoffeemaker.Main.main

interface MainContract {
    interface MainActivity {
        fun showTextMessage(toastMsg: String)
        fun hideTextMessage()
    }
    interface MainPresenter {
        fun onMakeCoffeeClick()
        fun onCheckWaterLevelClick()
        fun onLogoClick()
        fun onDestroy()
    }

}