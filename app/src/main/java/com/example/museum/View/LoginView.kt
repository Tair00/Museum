package com.example.museum.View

interface LoginView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun navigateToHomeScreen(token: String)
}
