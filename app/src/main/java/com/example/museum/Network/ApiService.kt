package com.example.museum.Network

import com.example.museum.Model.LoginRequest
import com.example.museum.Model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
