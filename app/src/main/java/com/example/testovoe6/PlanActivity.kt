package com.example.testovoe6

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class PlanActivity : AppCompatActivity() {

    private lateinit var textViewDay: TextView
    private lateinit var plan: List<Plan>
    private lateinit var activity: Activity
    private lateinit var imageViewFon2: ImageView
    private lateinit var textViewRes: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlanAdapter

    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)

        recyclerView = findViewById(R.id.rv_table)
        textViewDay = findViewById(R.id.textViewDay)
        textViewRes = findViewById(R.id.textViewRes)
        textViewDay.text = dayOfWeek
        recyclerView.layoutManager = LinearLayoutManager(this)
        activity = this

        imageViewFon2 = findViewById(R.id.imageViewFon2)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val choose = sharedPreferences.getInt("choose", 0)

        when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> {
                when(choose){
                    1->url="http://135.181.248.237/6/mass_monday.json"
                    2->url="http://135.181.248.237/6/relief_monday.json"
                    3->url="http://135.181.248.237/6/mass_monday.json"
                    4->url="http://135.181.248.237/6/universal_monday.json"
                    else ->{
                        recyclerView.visibility = View.INVISIBLE
                        textViewRes.visibility = View.VISIBLE
                        textViewRes.text = "You have to choose a training program"
                    }
                }
            }
            Calendar.TUESDAY -> {
                when(choose){
                    1->url="http://135.181.248.237/6/mass_tuesday.json"
                    2->url="http://135.181.248.237/6/relief_tuesday.json"
                    3->url="http://135.181.248.237/6/mass_tuesday.json"
                    4->url="http://135.181.248.237/6/universal_tuesday.json"
                    else ->{
                        recyclerView.visibility = View.INVISIBLE
                        textViewRes.visibility = View.VISIBLE
                        textViewRes.text = "You have to choose a training program"
                    }
                }
            }
            Calendar.WEDNESDAY -> {
                when(choose){
                    1->url="http://135.181.248.237/6/mass_wednesday.json"
                    2->url="http://135.181.248.237/6/relief_wednesday.json"
                    3->url="http://135.181.248.237/6/mass_wednesday.json"
                    4->url="http://135.181.248.237/6/universal_wednesday.json"
                    else ->{
                        recyclerView.visibility = View.INVISIBLE
                        textViewRes.visibility = View.VISIBLE
                        textViewRes.text = "You have to choose a training program"
                    }
                }
            }
            Calendar.THURSDAY -> {
                when(choose){
                    1->url="http://135.181.248.237/6/mass_thursday.json"
                    2->url="http://135.181.248.237/6/relief_thursday.json"
                    3->url="http://135.181.248.237/6/mass_thursday.json"
                    4->url="http://135.181.248.237/6/universal_thursday.json"
                    else ->{
                        recyclerView.visibility = View.INVISIBLE
                        textViewRes.visibility = View.VISIBLE
                        textViewRes.text = "You have to choose a training program"
                    }
                }
            }
            Calendar.FRIDAY -> {
                when(choose){
                    1->url="http://135.181.248.237/6/mass_friday.json"
                    2->url="http://135.181.248.237/6/relief_friday.json"
                    3->url="http://135.181.248.237/6/mass_friday.json"
                    4->url="http://135.181.248.237/6/universal_friday.json"
                    else ->{
                        recyclerView.visibility = View.INVISIBLE
                        textViewRes.visibility = View.VISIBLE
                        textViewRes.text = "You have to choose a training program"
                    }
                }
            }
            Calendar.SATURDAY -> {
                recyclerView.visibility = View.INVISIBLE
                textViewRes.visibility = View.VISIBLE
                textViewRes.text = "Today is a day off!"
            }
            Calendar.SUNDAY -> {
                recyclerView.visibility = View.INVISIBLE
                textViewRes.visibility = View.VISIBLE
                textViewRes.text = "Today is a day off!"
            }
            else -> ""
        }

        Glide.with(this)
            .load("http://135.181.248.237/6/fon3.png")
            .into(imageViewFon2)

        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL(url).readText()
                val gson = Gson()
                plan = gson.fromJson(data, Array<Plan>::class.java).toList()

                activity.runOnUiThread {
                    adapter = PlanAdapter(plan)
                    recyclerView.adapter = adapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}