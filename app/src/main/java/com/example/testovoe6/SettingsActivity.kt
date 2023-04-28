package com.example.testovoe6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class SettingsActivity : AppCompatActivity() {

    private lateinit var imageViewFon2: ImageView
    private lateinit var buttonClear: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        buttonClear = findViewById(R.id.buttonClear)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        Glide.with(this)
            .load("http://135.181.248.237/6/fon3.png")
            .into(imageViewFon2)

        buttonClear.setOnClickListener {
            val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            editor.putBoolean("is_first_start", true)
            editor.putString("hello", "HAVE A NICE DAY!")
            editor.putInt("choose", 0)
            editor.putInt("bench", 0)
            editor.putInt("squats", 0)
            editor.putInt("deadlifts", 0)
            editor.putInt("press", 0)
            editor.putInt("pull", 0)
            editor.putInt("dips", 0)
            editor.apply()
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}