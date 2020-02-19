package com.example.iotcoffeemaker.Main.eventdetail


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iotcoffeemaker.Main.main.MainPresenter
import com.example.iotcoffeemaker.Main.models.Attraction
import com.example.iotcoffeemaker.R
import kotlinx.android.synthetic.main.activity_event_detail.*


class EventDetailActivity : AppCompatActivity(), EventDetailContract.EventDetailActivity {

    private val presenter = EventDetailPresenter(this)
    private lateinit var recyclerView: RecyclerView
    private val attractionsAdapter =  AttractionsAdapter(listOf(), object: AttractionsAdapter.OnAttractionClickListener {
        override fun onClickAttraction(attraction: Attraction) {
            //TODO get Attraction info?
        }

        override fun onClickGetOnLineBtn(attraction: Attraction) {
            //TODO Request to get in Attraction line
            presenter.mockGetInLine(attraction)

        }
    } )

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_event_detail)
        setView()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun setView() {
        presenter.onActivityCreated(intent.getStringExtra(EXTRA_EVENT_ID) ?: "")

    }

    override fun displayAttractions(attractions: List<Attraction>) {
        attractionsAdapter.items = attractions
        val lManager = LinearLayoutManager(this)
        recyclerView = attractionListRv.apply{
            layoutManager = lManager
            adapter = attractionsAdapter
        }
    }


}


const val EXTRA_EVENT_ID = "EXTRA_EVENT_ID"
fun createEventDetailIntent(activity: AppCompatActivity, eventId: String): Intent {
    val intent = Intent(activity, EventDetailActivity::class.java)
    intent.putExtra(EXTRA_EVENT_ID, eventId)
    return intent
}