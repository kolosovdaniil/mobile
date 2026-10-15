package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class QuotesViewModel(private val tokenManager: TokenManager) : ViewModel() {

    fun quotesFetch() {
        viewModelScope.launch {
            val token = tokenManager.tokenFlow().first()
            try {
                val records = RetrofitClient.quotesApi.getQuotes("Bearer $token")
                val items = records.items

                for (item in items) {
                    Log.d("QuotesViewModel", "id: ${item.id}, quote: ${item.quote}, author: ${item.author}, created: ${item.created}, updated: ${item.updated}")
                }
                Log.d("QuotesViewModel", "page: ${records.page}, perPage: ${records.perPage}, totalItems: ${records.totalItems}, totalPages: ${records.totalPages}")
            } catch (ex: Exception) {
                Log.e("QuotesViewModel", "${ex.message}")
            }
        }
    }
}