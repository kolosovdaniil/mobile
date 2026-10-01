package com.example.pr01.data.service

import com.example.pr01.data.model.LoginRequest
import com.example.pr01.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthInterface {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): User
}