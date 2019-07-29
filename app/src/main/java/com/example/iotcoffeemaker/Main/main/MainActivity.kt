package com.example.iotcoffeemaker.Main.main

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainActivity {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCoffeeBtn.setOnClickListener { presenter.onMakeCoffeeClick() }

        checkWaterBtn.setOnClickListener { presenter.onCheckWaterLevelClick() }

        mainIconIv.setOnClickListener { presenter.onLogoClick()}

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTextMessage(toastMsg: String) {
        buttonClickInformationTv.visibility = TextView.VISIBLE
        buttonClickInformationTv.text = toastMsg
        Toast.makeText(applicationContext, toastMsg, Toast.LENGTH_LONG ).show()
    }
    override fun hideTextMessage() {
        buttonClickInformationTv.visibility = TextView.GONE
        buttonClickInformationTv.text = ""
    }

    override fun setButtonsEnable(enable: Boolean) {
        checkWaterBtn.isEnabled = enable
        makeCoffeeBtn.isEnabled = enable
        mainIconIv.isEnabled = enable
    }


}