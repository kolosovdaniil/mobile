package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.data.model.Instruction
import com.example.pr01.data.model.Product
import com.example.pr01.data.model.Recipe
import com.example.pr01.data.model.Tag
import com.example.pr01.ui.theme.viewModel.ProductViewModel
import com.example.pr01.ui.theme.viewModel.RecipeViewModel
import com.example.pr01.ui.theme.viewModel.RetrofitViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//           val retrofitViewModel: RetrofitViewModel = viewModel()
//           retrofitViewModel.fetchQuotas()


//            val productViewModel: ProductViewModel = viewModel()
//            val product = Product(
//                title = "Офисное кресло Comfort-Т",
//                price = 14200.0,
//                stock = 3,
//                category = "Мебель"
//            )
//            productViewModel.createProduct(product)

            val recipeViewModel: RecipeViewModel = viewModel()


            val recipe = Recipe(
                id=61,
                name = "Традиционная паэлья с морепродуктами",
                instructions = listOf(
                    Instruction("")
                ),
                tags = listOf(
                    Tag("Обед"),
                    Tag("Ужин"),
                    Tag("Морепродукты"),
                    Tag("ИспанскаяКухня"),
                    Tag("ПраздничноеБлюдо")
                ),
                rating = 4.9
            )
        }
    }
}