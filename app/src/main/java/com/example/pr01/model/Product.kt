package com.example.pr01.model

data class Product(
    val id : Int? = null,
    val title : String,
    val price: Double,
    val category: String? = null,
    val stock: Int? = null
)
