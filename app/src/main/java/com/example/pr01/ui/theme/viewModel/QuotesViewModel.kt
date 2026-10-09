package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.AuthRequest
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {

    fun login(authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val authorizedUser = RetrofitClient.authApi.login(authRequest)
                Log.d("QuotesViewModel", "token = ${authorizedUser.token}")

                val quotes = RetrofitClient.quotesApi.getQuotes(
                    "Bearer ${authorizedUser.token}"
                )
                Log.d("QuotesViewModel", "quotes = $quotes")
            } catch (ex: Exception) {
                Log.e("QuotesViewModel", ex.message.toString())
            }
        }
    }
}