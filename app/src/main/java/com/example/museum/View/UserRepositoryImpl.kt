package com.example.museum.View

import com.example.museum.Domain.UserRepository
import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult

class UserRepositoryImpl : UserRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResult {
        // Здесь можно добавить реальный запрос API
        return if (loginRequest.usernameOrEmail == "user" && loginRequest.password == "password") {
            LoginResult.Success
        } else {
            LoginResult.Error("Неверный логин или пароль")
        }
    }
}
