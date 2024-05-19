package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityMenuParcial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu_parcial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.totalId)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        setContentView(R.layout.activity_main_menu_parcial)

    }

    fun onMatchPrizes(view: View) {
        val intent = Intent(this, Prizes::class.java)
        startActivity(intent)
    }
    fun onMatchTeams(view: View) {
        val intent = Intent(this, Teams::class.java)
        startActivity(intent)
    }
    fun onMatchStadiums(view: View) {
        val intent = Intent(this, Stadiums::class.java)
        startActivity(intent)
    }
}