package com.example.kotlinsampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val id:Int = 10
    var inputValue:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button);
        val editText = findViewById<EditText>(R.id.editText);
        val textView4 = findViewById<TextView>(R.id.textView4);
        val textView5 = findViewById<TextView>(R.id.textView5);

        button.setOnClickListener(){
             inputValue = editText.text.toString()
            if (inputValue.trim()==""){
                Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            }else{
                textView4.setText(inputValue).toString()
                intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("id_value", id)
                intent.putExtra("language_value", inputValue)
                startActivity(intent)
            }
        }
        textView5.setOnClickListener(){
            if (textView4.text.toString().trim()==""){
                Toast.makeText(this,"clicked on reset textView,\n output textView already reset",Toast.LENGTH_LONG).show()
            }else{
                textView4.setText("").toString()
            }
        }
        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed before making any change over EditText",Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed while making any change over EditText",Toast.LENGTH_SHORT).show()
            }
            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed after change made over EditText",Toast.LENGTH_SHORT).show()
            }
        })
    }
}