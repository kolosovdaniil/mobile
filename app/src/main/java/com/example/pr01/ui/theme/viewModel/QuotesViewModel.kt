package com.example.pr01.ui.theme.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.TokenManager
import com.example.pr01.data.model.AuthRequest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {

    fun login(context: Context, authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val authorizedUser = RetrofitClient.authApi.login(authRequest)
                val token = authorizedUser.token
                Log.d("QuotesViewModel", "получен токен: $token")

                val tokenManager = TokenManager(context.applicationContext)
                tokenManager.saveToken(token)

                val savedToken = tokenManager.tokenFlow().first()
                Log.d("QuotesViewModel", "Token from DataStore: $savedToken")

                val quotes = RetrofitClient.quotesApi.getQuotes("Bearer $savedToken")
                Log.d("QuotesViewModel", "quotes = $quotes")

            } catch (ex: Exception) {
                Log.e("QuotesViewModel", ex.message.toString())
            }
        }
    }
}