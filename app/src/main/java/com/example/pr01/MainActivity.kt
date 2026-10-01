package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.data.model.LoginRequest
import com.example.pr01.ui.theme.viewModel.LoginViewModel
import com.example.pr01.ui.theme.viewModel.RecipeViewModel
import com.example.pr01.ui.theme.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val loginViewModel: LoginViewModel = viewModel()
            val loginRequest = LoginRequest(
                username = "emilys",
                password = "emilyspass"
            )
            loginViewModel.login(loginRequest)
        }
    }
}