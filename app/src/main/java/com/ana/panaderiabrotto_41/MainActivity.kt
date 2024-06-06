package com.ana.panaderiabrotto_41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Inicio Sesion*/

        val btnInSesion = findViewById<Button>(R.id.btnInicioSesion)

        btnInSesion.setOnClickListener {
            val btnInSesion = Intent(this, LogIn::class.java)
            startActivity(btnInSesion)
        }

        /*Registro*/

        val btnRegis = findViewById<Button>(R.id.btnRegistro)

        btnRegis.setOnClickListener {
            val btnRegis = Intent(this,Register::class.java)
            startActivity(btnRegis)
        }

    }
}