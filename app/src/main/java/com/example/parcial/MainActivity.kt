package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.totalId)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun onMatch(view: View) {
        val textId = findViewById<EditText>(R.id.editTextTextId)
        val textPass  = findViewById<EditText>(R.id.editTextTextPasswordId)
        val textTitle = findViewById<TextView>(R.id.TextViewTitle)
        if(textId.text.toString()=="admin@americancup.com" && textPass.text.toString() == "admin123"){
            Toast.makeText(this,  "Login sucessfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivityMenuParcial::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
        }
    }
}