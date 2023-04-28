package com.example.testovoe6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class RecordsActivity : AppCompatActivity() {

    private lateinit var imageViewFon2: ImageView

    private lateinit var edit_one: EditText
    private lateinit var edit_two: EditText
    private lateinit var edit_three: EditText
    private lateinit var edit_four: EditText
    private lateinit var edit_five: EditText
    private lateinit var edit_six: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        edit_one = findViewById(R.id.edit_one)
        edit_two = findViewById(R.id.edit_two)
        edit_three = findViewById(R.id.edit_three)
        edit_four = findViewById(R.id.edit_four)
        edit_five = findViewById(R.id.edit_five)
        edit_six = findViewById(R.id.edit_six)
        imageViewFon2 = findViewById(R.id.imageViewFon2)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val bench = sharedPreferences.getInt("bench", 0)
        val squats = sharedPreferences.getInt("squats", 0)
        val deadlifts = sharedPreferences.getInt("deadlifts", 0)
        val press = sharedPreferences.getInt("press", 0)
        val pull = sharedPreferences.getInt("pull", 0)
        val dips = sharedPreferences.getInt("dips", 0)

        edit_one.setText(bench.toString())
        edit_two.setText(squats.toString())
        edit_three.setText(deadlifts.toString())
        edit_four.setText(press.toString())
        edit_five.setText(pull.toString())
        edit_six.setText(dips.toString())

        Glide.with(this)
            .load("http://135.181.248.237/6/fon3.png")
            .into(imageViewFon2)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
        if (edit_one.text!=null){
            val bench = edit_one.text.toString().toInt()
            editor.putInt("bench",bench)
        }
        if (edit_two.text!=null){
            val squats = edit_two.text.toString().toInt()
            editor.putInt("squats",squats)
        }
        if (edit_three.text!=null){
            val deadlifts = edit_three.text.toString().toInt()
            editor.putInt("deadlifts",deadlifts)

        }
        if (edit_four.text!=null){
            val press = edit_four.text.toString().toInt()
            editor.putInt("press",press)

        }
        if (edit_five.text!=null){
            val pull = edit_five.text.toString().toInt()
            editor.putInt("pull",pull)
        }
        if (edit_six.text!=null){
            val dips = edit_six.text.toString().toInt()
            editor.putInt("dips",dips)
        }
        editor.apply()
        return super.onKeyDown(keyCode, event)
    }
}