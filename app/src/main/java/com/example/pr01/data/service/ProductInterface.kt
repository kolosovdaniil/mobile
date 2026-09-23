package com.example.pr01.data

import com.example.pr01.model.Product
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductInterface {
    @POST("product")
    suspend fun addProduct(@Body product: Product): Product
}
