package com.example.pr01.data.service

import com.example.pr01.data.model.Quotes
import retrofit2.http.GET
import retrofit2.http.Header

interface QuotesInterface {
    @GET("quotes/records")
    suspend fun getQuotes(@Header("Authorization") token: String): Quotes
}