package com.example.pr01.data.service

import com.example.pr01.data.model.ResQuote
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("quotes")
    suspend fun getQuotes(): ResQuote
}