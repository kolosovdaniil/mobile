package com.example.pr01.data.service

import com.example.pr01.data.model.AuthRequest
import com.example.pr01.data.model.AuthResponse
import com.example.pr01.data.model.LoginRequest
import com.example.pr01.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthInterface {
    @POST("users/auth-with-password")
    suspend fun login(@Body authRequest: AuthRequest): AuthResponse
}