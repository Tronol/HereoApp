package com.example.heroappex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.heroappex.activities.PublisherActivity
import com.example.heroappex.models.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var  passwordEditText: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
        Log.i("IS_LOGGED", isLogged.toString())

        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById((R.id.passwordET))
        loginBtn = findViewById(R.id.btnLogin)
        loginBtn.setOnClickListener{ v->
            Log.i("AndroidLogGato","Iniciando Sesion")
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Log.i("LOGIN_ERROR", "Email o password vacios")
                //Creando un Snackbar, basicamente un modal que aparece con un mensaje
                Snackbar.make(v,"El correo elctronico o la contraseña estan vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Log.i("LOGIN_SUCCESS", "Inicio correcto")

            // Validando que el email y la contraseña ingresada se encuentren en nuesta
            // lista del Data Class User
            val isValidUser = User.users.any{
                    user-> user.email == email && user.password == password
            }
            if(!isValidUser){
                Log.i("LOGIN_ERROR", "Email o password incorrectos")
                Snackbar.make(v,"El correo elctronico o la contraseña son incorrectos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Intents. Objetos que permiten la navegacion entre actividades
            //Intent explicitos
            // Intent implicitos
            Log.i("SUCCESS", "Usuario Correcto")
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity,PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}