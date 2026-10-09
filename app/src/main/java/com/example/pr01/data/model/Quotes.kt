package com.example.pr01.data.model

data class Quotes(
    val items: List<Items>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)
