package com.example.museum.Presenter

import android.util.Log
import com.example.museum.Domain.LoginUseCase
import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult
import com.example.museum.View.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginPresenter(
    private val loginUseCase: LoginUseCase,
    private val view: LoginView
) {
    fun onLoginButtonClicked(usernameOrEmail: String, password: String) {
        if (usernameOrEmail.isBlank() || password.isBlank()) {
            view.showError("Пожалуйста, заполните все поля.")
            return
        }

        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = loginUseCase.execute(LoginRequest(usernameOrEmail, password))
                view.hideLoading()

                when (result) {
                    is LoginResult.Success -> {
                        if (result.token.isNullOrEmpty()) {
                            Log.e("LoginPresenter", "Token is null or empty")
                            view.showError("Не удалось получить токен. Попробуйте снова.")
                        } else {
                            view.navigateToHomeScreen(result.token)
                        }
                    }
                    is LoginResult.Error -> {
                        Log.e("LoginPresenter", "Error occurred: ${result.message}")
                        view.showError(result.message)
                    }
                }
            } catch (e: Exception) {
                view.hideLoading()
                Log.e("LoginPresenter", "Exception occurred: ${e.message}", e)
                view.showError("Произошла ошибка. Проверьте подключение к интернету и попробуйте снова.")
            }
        }
    }
}
