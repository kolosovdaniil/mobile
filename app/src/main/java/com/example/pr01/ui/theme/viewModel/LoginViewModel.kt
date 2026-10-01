package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try{
            val user = RetrofitClient.authAPI.login(loginRequest)
                Log.d("LoginViewModel",  "Access token: ${user.accessToken}")
            }
            catch (ex: Exception){
                Log.e("LoginViewModel", ex.message.toString())
            }
        }
    }
}