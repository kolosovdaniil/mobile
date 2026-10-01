package com.example.pr01.data.model

data class User(
    val id : Int? = null,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val isDeleted: Boolean = false,
    val accessToken: String? = null
)
