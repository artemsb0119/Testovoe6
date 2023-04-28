package com.example.testovoe6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

class TrainActivity : AppCompatActivity() {

    private lateinit var buttonWeight: AppCompatButton
    private lateinit var buttonRelief: AppCompatButton
    private lateinit var buttonPower: AppCompatButton
    private lateinit var buttonUniversal: AppCompatButton
    private lateinit var buttonChoose: AppCompatButton
    private lateinit var imageViewFon2: ImageView

    private var choose = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)

        buttonWeight = findViewById(R.id.buttonWeight)
        buttonRelief = findViewById(R.id.buttonRelief)
        buttonPower = findViewById(R.id.buttonPower)
        buttonUniversal = findViewById(R.id.buttonUniversal)
        buttonChoose = findViewById(R.id.buttonChoose)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        buttonWeight.setBackgroundColor(ContextCompat.getColor(this, R.color.light_pink))

        Glide.with(this)
            .load("http://135.181.248.237/6/fon3.png")
            .into(imageViewFon2)

        buttonWeight.setOnClickListener {
            buttonWeight.setBackgroundColor(ContextCompat.getColor(this, R.color.light_pink))
            buttonRelief.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonPower.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonUniversal.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            choose = 1
        }
        buttonRelief.setOnClickListener {
            buttonWeight.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonRelief.setBackgroundColor(ContextCompat.getColor(this, R.color.light_pink))
            buttonPower.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonUniversal.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            choose = 2
        }
        buttonPower.setOnClickListener {
            buttonWeight.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonRelief.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonPower.setBackgroundColor(ContextCompat.getColor(this, R.color.light_pink))
            buttonUniversal.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            choose = 3
        }
        buttonUniversal.setOnClickListener {
            buttonWeight.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonRelief.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonPower.setBackgroundColor(ContextCompat.getColor(this, R.color.main))
            buttonUniversal.setBackgroundColor(ContextCompat.getColor(this, R.color.light_pink))
            choose = 4
        }

        buttonChoose.setOnClickListener {
            val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            editor.putInt("choose", choose)
            editor.apply()
            val intent = Intent(this, PlanActivity::class.java)
            startActivity(intent)
        }
    }
}