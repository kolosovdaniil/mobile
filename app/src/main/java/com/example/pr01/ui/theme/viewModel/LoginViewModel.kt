package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.TokenManager
import com.example.pr01.data.model.AuthRequest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val tokenManager: TokenManager,
    private val quotesViewModel: QuotesViewModel
) : ViewModel() {

    fun login(authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authApi.login(authRequest)
                Log.d("LoginViewModel", "User: ${authUser.token} ${authUser.record}")
                authUser.token?.let {
                    writeToken(it)
                    quotesViewModel.quotesFetch()
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }

    fun writeToken(token: String) {
        viewModelScope.launch {
            tokenManager.saveToken(token)
        }
    }
}