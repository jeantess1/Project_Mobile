package com.example.mini_projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.mini_projet.DisneyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val facebookImageView = findViewById<ImageView>(R.id.facebookImageView)
        val googleImageView = findViewById<ImageView>(R.id.googleImageView)
        val appleImageView = findViewById<ImageView>(R.id.appleImageView)

        loginButton.setOnClickListener {

            Toast.makeText(this, "Login Clicked", Toast.LENGTH_SHORT).show()
        }

        facebookImageView.setOnClickListener {
            showToast("Facebook")
        }

        googleImageView.setOnClickListener {
            showToast("Google")
            val intent = Intent(this, DisneyCharacterActivity::class.java)
            startActivity(intent)
        }

        appleImageView.setOnClickListener {
            showToast("Apple ID")
        }
    }

    private fun showToast(platform: String) {
        Toast.makeText(this, "Connected with $platform", Toast.LENGTH_SHORT).show()
    }
}
