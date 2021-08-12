package com.example.kotlinsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class CustomToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        val button = findViewById<Button>(R.id.button)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        val layout = layoutInflater.inflate(R.layout.custom_toast,linearLayout)
        button.setOnClickListener(){
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_LONG
            myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            myToast.view = layout//setting the view of custom toast layout
            myToast.show()
        }

    }
}