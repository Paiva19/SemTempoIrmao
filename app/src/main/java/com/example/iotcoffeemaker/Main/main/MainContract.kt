package com.example.iotcoffeemaker.Main.main

interface MainContract {
    interface MainActivity {
        fun showTextMessage(toastMsg: String)
        fun hideTextMessage()
        fun setButtonsEnable(enable: Boolean)
    }
    interface MainPresenter {
        fun onMakeCoffeeClick()
        fun onCheckWaterLevelClick()
        fun onClearMessageClick()
        fun onChangeFilterClick()
        fun onDestroy()
    }

}