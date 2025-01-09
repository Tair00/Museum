package com.example.museum.Model

data class LoginResponse(
    val accessToken: String?, // Поле accessToken, возвращаемое сервером
    val refreshToken: String?,
    val user: User
)

data class User(
    val id: Int,
    val email: String,
    val role: String
)
