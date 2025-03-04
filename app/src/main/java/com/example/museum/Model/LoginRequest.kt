package com.example.museum.Model

data class LoginRequest(
    val email: String,
    val password: String
)


sealed class LoginResult {
    data class Success(val token: String) : LoginResult()
    data class Error(val message: String) : LoginResult()
}