package com.example.museum.View

import com.example.museum.Domain.UserRepository
import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult
import com.example.museum.Network.RetrofitClient

class UserRepositoryImpl : UserRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResult {
        return try {
            val response = RetrofitClient.apiService.login(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()
                // Проверяем, что тело ответа не null и содержит `access_token`
                if (body != null && body.accessToken != null) {
                    LoginResult.Success(body.accessToken)
                } else {
                    LoginResult.Error("Отсутствует access_token в ответе сервера")
                }
            } else {
                LoginResult.Error("Ошибка сервера: ${response.message()}")
            }
        } catch (e: Exception) {
            LoginResult.Error("Ошибка подключения: ${e.message}")
        }
    }
}
