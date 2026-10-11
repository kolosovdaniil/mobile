package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.data.model.AuthRequest
import com.example.pr01.ui.theme.viewModel.QuotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val quotesViewModel: QuotesViewModel = viewModel()
            val authRequest = AuthRequest(
                identity = "kolosovdaniil883@gmail.com",
                password = "kolosovdaniil"
            )
            quotesViewModel.login(
                context = applicationContext,
                authRequest = authRequest
            )
        }
    }
}