package com.example.pr01.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun deleteUser(id: Int){
        viewModelScope.launch {
            try {
                val deletedUser = RetrofitClient.userAPI.deleteUserById(id)
                Log.d("UserViewModel", "${deletedUser.id}: ${deletedUser.isDeleted}")
            } catch (e: Exception){
                Log.e("UserViewModel", e.message.toString())
            }
        }
    }
}