package com.example.museum.Domain

import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResult

interface UserRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResult
}
