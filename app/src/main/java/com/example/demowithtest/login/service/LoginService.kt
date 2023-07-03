package com.example.demowithtest.login.service

import com.example.demowithtest.BuildConfig
import com.example.demowithtest.model.User
import com.example.demowithtest.retrofit.APIEndpoints
import retrofit2.Callback
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class LoginService {

    private val retrofit: Retrofit

    init {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.login_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun callAuthenticationService(callback: Callback<List<User>>, email: String, password: String) {
        val apiEndpoints = retrofit.create(APIEndpoints::class.java)
        val userCall = apiEndpoints.getUser(email, password)
        userCall.enqueue(callback)
    }
}