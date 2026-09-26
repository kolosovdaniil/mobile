package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun updateRecipe (){
        viewModelScope.launch {
            try{
                val recipe = RetrofitClient.recipeAPI.getRecipeById(49)
                Log.d("RecipeViewModel", "$recipe")

                val newRecipe = recipe.copy(
                    name = "Традиционная паэлья с морепродуктами",
                    instructions = listOf(
                        "Инструкция по приготовлению – Очистите креветки и кальмары.",
                        "Мелко нарежьте лук, чеснок и болгарский перец.",
                        "Томаты натрите на терке, удалив кожуру.",
                        "Разогрейте оливковое масло на большой сковороде",
                        "Обжарьте морепродукты по 1–2 минуты с каждой стороны, затем переложите их на тарелку.",
                        "В той же сковороде обжарьте лук и чеснок до мягкости.",
                        "Добавьте перец, а через 3 минуты — натертые томаты и паприку.",
                        "Тушите 5 минут.",
                        "Всыпьте рис круглозерный (лучше сорта Бомба) и обжаривайте 2 минуты, чтобы он впитал ароматы.",
                        "Залейте горячим бульконом со щепоткой шафрана.",
                        "Варите на среднем огне 15 минут, не перемешивая, чтобы на дне образовалась аппетитная корочка."
                    ),
                    tags = listOf(
                        "Обед",
                        "Ужин",
                        "Морепродукты",
                        "ИспанскаяКухня",
                        "ПраздничноеБлюдо"
                    ),
                    rating =4.9
                )
                if(newRecipe.id != null){
                    val updatedRecipe = RetrofitClient.recipeAPI.updateRecipe(
                        recipeId = newRecipe.id,
                        newRecipe
                    )
                    Log.d("RecipeViewModel", "$updatedRecipe")
                }
            }catch (ex: Exception){
                Log.e("RecipeViewModel", ex.message.toString())
            }
        }
    }
}