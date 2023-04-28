package com.example.testovoe6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class MenuActivity : AppCompatActivity() {

    private lateinit var buttonTrain: AppCompatButton
    private lateinit var buttonPlan: AppCompatButton
    private lateinit var buttonRecord: AppCompatButton
    private lateinit var buttonSettings: AppCompatButton
    private lateinit var imageViewFon2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonTrain = findViewById(R.id.buttonTrain)
        buttonPlan = findViewById(R.id.buttonPlan)
        buttonRecord = findViewById(R.id.buttonRecord)
        buttonSettings = findViewById(R.id.buttonSettings)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        Glide.with(this)
            .load("http://135.181.248.237/6/fon3.png")
            .into(imageViewFon2)

        buttonTrain.setOnClickListener {
            val intent = Intent(this, TrainActivity::class.java)
            startActivity(intent)
        }
        buttonPlan.setOnClickListener {
            val intent = Intent(this, PlanActivity::class.java)
            startActivity(intent)
        }
        buttonRecord.setOnClickListener {
            val intent = Intent(this, RecordsActivity::class.java)
            startActivity(intent)
        }
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

}