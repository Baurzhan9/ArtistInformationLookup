package com.example.pixabayapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.Button
import android.widget.TextView
import com.example.pixabayapp.R
import com.example.pixabayapp.activity.ArtistActivity
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    private val auth by lazy  { FirebaseAuth.getInstance() }
    private val database by lazy { FirebaseFirestore.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        email =  findViewById(R.id.email)
        password =  findViewById(R.id.password)
        val btn = findViewById<Button>(R.id.signIn)
        val reg = findViewById<Button>(R.id.signUp)
        reg.setOnClickListener {
            val intent = Intent(this, Registration::class.java);
            startActivity(intent)
        }

        btn.setOnClickListener {
            signIn(email.getText().toString(), password.getText().toString())
//            signIn("asd@gmail.com","123456")
             }
    }

    private fun signIn(
        email: String,
        password: String
    ){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    val intent = Intent(this, ArtistActivity::class.java);
                    startActivity(intent)
                    return@addOnCompleteListener
                }else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { Toast.makeText(this, "Null Email or password", Toast.LENGTH_SHORT).show() }
    }


}




