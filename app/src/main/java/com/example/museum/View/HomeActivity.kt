package com.example.museum.View

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.museum.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val accessToken = intent.getStringExtra("access_token")
        val refreshToken = intent.getStringExtra("REFRESH_TOKEN")
        val userEmail = intent.getStringExtra("USER_EMAIL")

        if (accessToken.isNullOrEmpty()) {
            Toast.makeText(this, "Токен не найден, повторите вход.", Toast.LENGTH_LONG).show()
            finish()
        } else {

            val tvToken = findViewById<TextView>(R.id.tvToken)
            tvToken.text = "Токен пользователя $userEmail: $accessToken"
        }


    }
}
