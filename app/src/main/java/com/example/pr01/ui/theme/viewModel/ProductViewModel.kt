package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.model.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun CreateProduct(product: Product){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.productAPI.addProduct(product)
                Log.d("RetrofitViewModel","id: ${product.id}, title: ${product.title}, price: ${product.price}, category: ${product.category}, stock: ${product.stock}")
            } catch (e: Exception){
                Log.e("ProductViewModel", e.message.toString())
            }
        }
    }
}