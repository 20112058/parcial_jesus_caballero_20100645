package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Teams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_teams)

        val teams = listOf(
            "Argentina", "Bolivia", "Brasil", "Chile", "Colombia",
            "Ecuador", "Paraguay", "Perú", "Uruguay", "Venezuela"
        )
        val listViewTeams = findViewById<ListView>(R.id.listViewTeams)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, teams)
        listViewTeams.adapter = adapter
    }

    fun RegresarMenu(view: View) {

        val intent = Intent(this, MainActivityMenuParcial::class.java)
        startActivity(intent)
    }

}