package com.ana.panaderiabrotto_41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*Regreso*/

        val btnAtras = findViewById<ImageButton>(R.id.btnRegres)
        btnAtras.setOnClickListener {
            val btnAtras = Intent(this, MainActivity::class.java)
            startActivity(btnAtras)
        }

        /*Registro*/

        val btnCrearCuenta = findViewById<Button>(R.id.btnCCuenta)
        btnCrearCuenta.setOnClickListener {
            val btnCrearCuenta= Intent(this, Register::class.java)
            startActivity(btnCrearCuenta)
        }

        /*Menu Principal*/

        val btnPrincipal = findViewById<Button>(R.id.btnSesion)
        btnPrincipal.setOnClickListener {

            val edCorreo = findViewById<EditText>(R.id.editCorreo)
            val edContraseña = findViewById<EditText>(R.id.editContraseña)

            if (edCorreo.text.isNotEmpty() && edContraseña.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        edCorreo.text.toString(),
                        edContraseña.text.toString()).addOnCompleteListener {

                            if(it.isSuccessful){
                                val btnPrincipal = Intent(this, Menu::class.java)
                                startActivity(btnPrincipal)
                            }else{
                                alerta()
                            }
                    }
            }

            /*val btnPrincipal = Intent(this, Menu::class.java)
            startActivity(btnPrincipal)*/
        }

        /*Recuperar Contraseña*/
        val btnRecuperar = findViewById<Button>(R.id.btnRecuperarContraseña)
        btnRecuperar.setOnClickListener {
            val btnRecuperar = Intent(this, RecoverPassword::class.java)
            startActivity(btnRecuperar)
        }

    }

    private fun alerta (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Correo y/o contraseña invalido")
        builder.setMessage("Revisa que tu correo y/o contraseña sea el correcto")
        builder.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = builder.create()
        dialogo.show()
    }

    /*private fun infoPerfil (email: String, nombre: String){
        val perfilIntent = Intent(this, NotificationsFragment::class.java).apply {
            putExtra("email", email)
            putExtra("nombre",nombre )
        }

        startActivity(perfilIntent)
    }*/
}