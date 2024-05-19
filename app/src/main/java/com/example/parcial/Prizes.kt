package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Prizes : AppCompatActivity() {
    lateinit var edtNumero1 : EditText
    lateinit var btnCalcular : Button
    lateinit var txtResultado1 : TextView
    lateinit var txtResultado2 : TextView
    lateinit var txtResultado3 : TextView
    lateinit var txtResultado4 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prizes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.totalId)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //setContentView(R.layout.activity_prizes)
        edtNumero1 = findViewById(R.id.editTextText)
        btnCalcular = findViewById(R.id.caldularId)
        txtResultado1 = findViewById(R.id.resultado1Id)
        txtResultado2 = findViewById(R.id.resultado2Id)
        txtResultado3 = findViewById(R.id.resultado3Id)
        txtResultado4 = findViewById(R.id.resultado4Id)

        btnCalcular.setOnClickListener(View.OnClickListener {
            val num1 = Integer.parseInt(edtNumero1.text.toString())
            txtResultado1.setText("1 place:  " + calcular(num1))
            txtResultado2.setText("2 place :  " + calcular2(num1))
            txtResultado3.setText("3 place :  " + calcular3(num1))
            txtResultado4.setText("4-16 place:  " + calcular4(num1))
        })


    }
    fun calcular(numero1: Int): Double {
        val result1 = numero1 * 0.25
        return result1
    }
    fun calcular2(numero2: Int): Double{
        val result2 = numero2 * 0.15
        return result2
    }
    fun calcular3(numero3: Int): Double{
        val result3 = numero3 * 0.10
        return result3
    }
    fun calcular4(numero4: Int): Double{
        val resultSuma= calcular(numero4) + calcular2(numero4) + calcular3(numero4)
        val div= resultSuma / 13
        val resultFinal = numero4 - div
        return resultFinal
    }

    fun onMatchMenuPrincipal(view: View) {
        val intent = Intent(this, MainActivityMenuParcial::class.java)
        startActivity(intent)
    }

}