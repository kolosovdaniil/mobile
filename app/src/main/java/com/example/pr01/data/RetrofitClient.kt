package com.example.pr01.data

import com.example.pr01.data.service.AuthInterface
import com.example.pr01.data.service.RecipeInterface
import com.example.pr01.data.service.RetrofitInterface
import com.example.pr01.data.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))
    private val okHttpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .addInterceptor(loggingInterceptor)
        .build()
    private  val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val quoteAPI = retrofit.create(RetrofitInterface::class.java)
    val productAPI = retrofit.create(ProductInterface::class.java)

    val recipeAPI = retrofit.create(RecipeInterface::class.java)

    val userAPI = retrofit.create(UserInterface::class.java)

    val authAPI = retrofit.create(AuthInterface::class.java)
}