package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun createProduct(product: Product){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.productAPI.addProduct(product)
                Log.d("RetrofitViewModel","id: ${response.id}, title: ${response.title}, price: ${response.price}, category: ${response.category}, stock: ${response.stock}")
            } catch (e: Exception){
                Log.e("ProductViewModel", e.message.toString())
            }
        }
    }
}