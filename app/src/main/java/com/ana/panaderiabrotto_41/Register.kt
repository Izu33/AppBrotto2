package com.ana.panaderiabrotto_41

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import java.util.*
import java.util.regex.Pattern

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    //val firebase = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        /*Regreso*/

        val btnRegres = findViewById<ImageButton>(R.id.btnRegresa)
        btnRegres.setOnClickListener {
            val btnRegres = Intent(this, MainActivity::class.java)
            startActivity(btnRegres)
        }

        /*--------------------------------------------------------------------*/

        /*Editar la fecha de Nacimiento*/

        val editarFechaDeNacimiento = findViewById<EditText>(R.id.eFechaNacimiento)
        editarFechaDeNacimiento.setOnClickListener{
            mostrarCalendario()
        }

        /*---------------------------------------------------------------------*/

        /*Registrarse*/

        /*val btnPrincipal = findViewById<Button>(R.id.btnInicio)
        btnPrincipal.setOnClickListener {
            val btnPrincipal = Intent(this, Menu::class.java)
            startActivity(btnPrincipal)
        }*/

        val btnPrincipal = findViewById<Button>(R.id.btnRegistrarse2)
        btnPrincipal.setOnClickListener {
            registroUsuario()
        }

    }

    private fun registroUsuario(){

        val edNombre = findViewById<EditText>(R.id.eNombre).text.toString()
        val edFecha = findViewById<EditText>(R.id.eFechaNacimiento).text.toString()
        val edCorreo = findViewById<EditText>(R.id.eCorreoElectronico).text.toString()
        val edContrasena = findViewById<EditText>(R.id.eContrasena).text.toString()
        val edContrasena2 = findViewById<EditText>(R.id.eContrasena2).text.toString()

        if (edNombre.isNotEmpty() && edFecha.isNotEmpty() && edCorreo.isNotEmpty() &&
            edContrasena.isNotEmpty() && edContrasena2.isNotEmpty()) {

            if(validaciónContrasena(edContrasena,edContrasena2)){

                val firebase = FirebaseAuth.getInstance()

                firebase.createUserWithEmailAndPassword(
                        edCorreo,
                        edContrasena).addOnCompleteListener {

                        if (it.isSuccessful) {

                            if (validacionCorreo(edCorreo)){

                                val user = firebase.currentUser!!
                                user.sendEmailVerification().addOnCompleteListener {

                                    if (it.isSuccessful) {
                                        Toast.makeText(
                                            this,
                                            "Correo de verificación enviado",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        val btnPrincipal = Intent(this, Menu::class.java)
                                        startActivity(btnPrincipal)

                                    }else{
                                        Toast.makeText(
                                            this,
                                            "Error al enviar correo",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }

                            } else{
                                Toast.makeText(
                                    this,
                                    "Correo no valido",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                            Toast.makeText(
                                this,
                                "Cuenta creada",
                                Toast.LENGTH_LONG
                            ).show()

                        }else {
                            Toast.makeText(
                                this,
                                "Prueba",
                                Toast.LENGTH_LONG
                            )
                        }
                    }

            }else{
                Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_LONG).show()
            }
        }else{
            alerta()
        }
    }

   private fun validacionCorreo(correo: String): Boolean{
        val regex = "^[\\w\\.-]+@([\\w\\.-]+\\.[\\w]{2,})\$".toRegex()
        val matcher = regex.matches(correo)
        return matcher
    }

    /*fun verificarCorreoExistente(correo: String): Boolean {

        /*val firebase = FirebaseAuth.getInstance()

        firebase.fetchSignInMethodsForEmail(correo)
            .addOnCompleteListener {

                if (it.isSuccessful) {

                    Toast.makeText(
                        this,
                        "Correo electronico registrado",
                        Toast.LENGTH_LONG
                    )
                }
            }

        return true*/
    }*/

    private fun validaciónContrasena(contra: String, contra2: String):Boolean{
        return contra == contra2
        /*val edContrasena = findViewById<EditText>(R.id.eContrasena).text.toString()
        val edContrasena2 = findViewById<EditText>(R.id.eContrasena2).text.toString()

        if (edContrasena.equals(edContrasena2)){

        }
        else{
            Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_LONG).show()
        }*/
    }

    private fun mostrarCalendario() {
        val editarFechaDeNacimiento = findViewById<EditText>(R.id.eFechaNacimiento)
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val año = calendario.get(Calendar.YEAR)

        val fechaDialogo = DatePickerDialog(this,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                editarFechaDeNacimiento.setText("$dayOfMonth/${month + 1}/$year")
            }, año, mes, dia)
        fechaDialogo.show()
    }

    private fun alerta (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error en el Registro")
        builder.setMessage("Revisa que los datos requeridos esten completos correctamente")
        builder.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = builder.create()
        dialogo.show()
    }
}