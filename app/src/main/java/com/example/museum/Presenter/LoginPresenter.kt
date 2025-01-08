package com.example.museum.Presenter

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
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val result = loginUseCase.execute(LoginRequest(usernameOrEmail, password))
            view.hideLoading()
            when (result) {
                is LoginResult.Success -> view.navigateToHomeScreen(result.token)
                is LoginResult.Error -> view.showError(result.message)
            }
        }
    }
}
