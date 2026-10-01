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
            val  authorizedUser = RetrofitClient.authAPI.login(loginRequest)
                Log.d("LoginViewModel", authorizedUser.accessToken.toString())

                val user =  RetrofitClient.userAPI.getCurrentUser("Bearer ${authorizedUser.accessToken}")
                Log.d("LoginViewModel", "${user.lastName} ${user.firstName}")
            }
            catch (ex: Exception){
                Log.e("LoginViewModel", ex.message.toString())
            }
        }
    }
}