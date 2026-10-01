package com.example.pr01.data.model

interface Profile {
    val id : Int?
    val firstName: String
    val lastName: String
    val maidenName: String
    val isDeleted: Boolean
}