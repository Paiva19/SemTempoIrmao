package com.example.iotcoffeemaker.Main.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.MainActivity {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCoffeeBtn.setOnClickListener { presenter.onMakeCoffeeClick() }

        checkWaterBtn.setOnClickListener { presenter.onCheckWaterLevelClick() }

        ChangeFilterBtn.setOnClickListener { presenter.onChangeFilterClick() }

        clearMsgBtn.setOnClickListener { presenter.onClearMessageClick()}

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTextMessage(toastMsg: String) {
        clearMsgBtn.visibility = Button.VISIBLE
        buttonClickInformationTv.visibility = TextView.VISIBLE
        buttonClickInformationTv.text = toastMsg
        Toast.makeText(applicationContext, toastMsg, Toast.LENGTH_LONG ).show()
    }
    override fun hideTextMessage() {
        clearMsgBtn.visibility = Button.GONE
        buttonClickInformationTv.visibility = TextView.GONE
        buttonClickInformationTv.text = ""
    }

    override fun setButtonsEnable(enable: Boolean) {
        checkWaterBtn.isEnabled = enable
        makeCoffeeBtn.isEnabled = enable
        ChangeFilterBtn.isEnabled = enable
    }


    override fun getCoffeePotId(): Int {
        coffeeIdEt.clearFocus()
        return try {
            coffeeIdEt.text.toString().toInt()
        } catch (e: Exception){
            0
        }
    }
}