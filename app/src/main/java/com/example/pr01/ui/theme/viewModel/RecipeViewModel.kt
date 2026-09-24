package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.Product
import com.example.pr01.data.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun updateRecipe (recipe: Recipe){
        viewModelScope.launch {
            try {
                if (recipe.id != null) {
                    RetrofitClient.recipeAPI.updateRecipe(
                        recipeId = recipe.id,
                        recipe
                    )
                }
            } catch (e: Exception){
                Log.e("RecipeViewModel", e.message.toString())
            }
        }
    }
}