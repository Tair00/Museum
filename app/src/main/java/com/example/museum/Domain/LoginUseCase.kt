package com.example.museum.Domain

import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult

class LoginUseCase(private val repository: UserRepository) {
    suspend fun execute(loginRequest: LoginRequest): LoginResult {
        return if (loginRequest.email.isNotEmpty() && loginRequest.password.isNotEmpty()) {
            repository.login(loginRequest)
        } else {
            LoginResult.Error("Заполните все поля")
        }
    }
}


