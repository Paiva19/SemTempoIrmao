package com.example.iotcoffeemaker.Main.eventdetail


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class EventDetailActivity : AppCompatActivity() {

}

 const val EXTRA_EVENT_ID = "EXTRA_EVENT_ID"
fun createEventDetailIntent(activity: AppCompatActivity, eventId: String): Intent {
    val intent = Intent(activity, EventDetailActivity::class.java)
    intent.putExtra(EXTRA_EVENT_ID, eventId)
    return intent
}