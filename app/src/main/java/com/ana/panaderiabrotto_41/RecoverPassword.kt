package com.ana.panaderiabrotto_41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RecoverPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        val firebase = FirebaseAuth.getInstance()
        val correoRecuperacion = findViewById<EditText>(R.id.Correo).text.toString()
        val botonRecuperarContraseña = findViewById<Button>(R.id.btnRecuperar)

        botonRecuperarContraseña.setOnClickListener{
            firebase.sendPasswordResetEmail(correoRecuperacion).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(
                        this,
                        "Correo enviado para recuperación de contraseña",
                        Toast.LENGTH_LONG
                    ).show()

                }else{
                    Toast.makeText(
                        this,
                        "Error al enviar correo de recuperación",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        }

        //Regreso Inicio
        val btnRegres = findViewById<ImageButton>(R.id.btnRegresInicio)
        btnRegres.setOnClickListener {
            val btnRegres = Intent(this, LogIn::class.java)
            startActivity(btnRegres)
        }

    }
}
