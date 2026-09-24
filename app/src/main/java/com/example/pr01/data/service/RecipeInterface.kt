package com.example.pr01.data.service

import com.example.pr01.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface RecipeInterface {
    @PUT("recipe/{id}")
    suspend fun updateRecipe(@Path("id") recipeId: Int,@Body recipe: Recipe)
}