package com.example.museum.Presenter

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.museum.Domain.LoginUseCase
import com.example.museum.R
import com.example.museum.View.HomeActivity
import com.example.museum.View.LoginView
import com.example.museum.View.UserRepositoryImpl
import kotlin.math.log

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var presenter: LoginPresenter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val repository = UserRepositoryImpl()
        val loginUseCase = LoginUseCase(repository)
        presenter = LoginPresenter(loginUseCase, this)

        progressDialog = ProgressDialog(this).apply {
            setMessage("Пожалуйста, подождите...")
            setCancelable(false)
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val usernameOrEmail = findViewById<EditText>(R.id.etEmailOrUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            presenter.onLoginButtonClicked(usernameOrEmail, password)
        }
    }

    override fun showLoading() {
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Log.e("LoginActivity", "Error occurred: $message")
    }

    override fun navigateToHomeScreen(token: String) {
        // Переход в следующую активити с передачей токена
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("access_token", token)
        }
        startActivity(intent)
        finish()
    }
}
