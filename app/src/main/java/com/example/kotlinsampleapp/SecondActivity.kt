package com.example.kotlinsampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button2 = findViewById<Button>(R.id.button2)
        val buttonNext = findViewById<Button>(R.id.next)
        val txtId = findViewById<TextView>(R.id.id)
        val txtValue = findViewById<TextView>(R.id.value)

        val bundle:Bundle = intent.extras!!
        val id = bundle.get("id_value")
        val language = bundle.get("language_value")
        txtId.setText(id.toString()).toString()
        txtValue.setText(language.toString()).toString()
        Toast.makeText(applicationContext,id.toString()+" "+language, Toast.LENGTH_LONG).show()
        button2.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        buttonNext.setOnClickListener(){
            intent = Intent(this,CustomToastActivity::class.java)
            startActivity(intent)
        }
    }
}