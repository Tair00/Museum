package com.example.museum.View

import com.example.museum.Domain.UserRepository
import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult
import com.example.museum.Network.RetrofitClient

class UserRepositoryImpl : UserRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResult {
        return try {
            // Обращение к серверу через Retrofit
            val response = RetrofitClient.apiService.login(loginRequest)
            LoginResult.Success(response.accessToken)
        } catch (e: Exception) {
            // Обработка ошибок
            LoginResult.Error("Ошибка подключения: ${e.message}")
        }
    }
}

