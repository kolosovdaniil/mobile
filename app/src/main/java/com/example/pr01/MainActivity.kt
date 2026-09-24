package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.model.Product
import com.example.pr01.ui.theme.PR01Theme
import com.example.pr01.ui.theme.viewModel.ProductViewModel
import com.example.pr01.ui.theme.viewModel.RetrofitViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//           val retrofitViewModel: RetrofitViewModel = viewModel()
//           retrofitViewModel.fetchQuotas()
            val ProductViewModel: ProductViewModel = viewModel()
            val product = Product(
                title = "Офисное кресло Comfort-Т",
                price = 14200.0,
                stock = 3
            )
            ProductViewModel.CreateProduct(product)
        }
    }
}