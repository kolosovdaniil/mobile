package com.example.pr01.data.model

data class Recipe(
    val id : Int,
    val name: String,
    val instructions: List<Instruction>,
    val tags: List<Tag>,
    val rating: Double
)
