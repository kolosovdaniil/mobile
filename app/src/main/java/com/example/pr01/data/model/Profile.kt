package com.example.pr01.data.model

data class Profile(
    val id: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String,
    val created: String,
    val updated: String
)
