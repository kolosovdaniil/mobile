package com.example.pr01.data.service

import com.example.pr01.data.model.User
import retrofit2.http.DELETE
import retrofit2.http.Path

interface UserInterface {
    @DELETE("users/{id}")
    suspend fun deleteUserById(@Path("id") userId: Int): User
}