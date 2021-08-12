package com.example.kotlinsampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listView = findViewById<ListView>(R.id.listView)
        val btnNext = findViewById<Button>(R.id.gotonext)

        btnNext.setOnClickListener(){

            intent = Intent(this,AlertDialogScreen::class.java)
            startActivity(intent)
        }

        val language:Array<String> = resources.getStringArray(R.array.technology_list)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,language)

        listView.adapter = arrayAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            Toast.makeText(applicationContext,"click item $selectedItem its position $itemIdAtPos",Toast.LENGTH_SHORT).show()
        }









    }
}