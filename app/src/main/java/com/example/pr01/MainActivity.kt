package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pr01.data.TokenManager
import com.example.pr01.data.model.AuthRequest
import com.example.pr01.ui.theme.viewModel.LoginViewModel
import com.example.pr01.ui.theme.viewModel.QuotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tokenManager = TokenManager(applicationContext)
            val quotesViewModel: QuotesViewModel by viewModels {
                viewModelFactory {
                    initializer {
                        QuotesViewModel(tokenManager)
                    }
                }
            }

            val loginViewModel: LoginViewModel by viewModels {
                viewModelFactory {
                    initializer {
                        LoginViewModel(tokenManager, quotesViewModel)
                    }
                }
            }

            val loginUser = AuthRequest(
                identity = "kolosovdaniil883@gmail.com",
                password = "kolosovdaniil"
            )
            loginViewModel.login(loginUser)
        }
    }
}