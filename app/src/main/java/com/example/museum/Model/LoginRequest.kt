package com.example.museum.Model

data class LoginRequest(val usernameOrEmail: String, val password: String)

sealed class LoginResult {
    object Success : LoginResult()
    data class Error(val message: String) : LoginResult()
}
