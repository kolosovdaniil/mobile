package com.example.pr01.data.model

data class Recipe(
    val id : Int? = null,
    val name: String,
    val instructions: List<String>?,
    val tags: List<String>?,
    val rating: Double
)
