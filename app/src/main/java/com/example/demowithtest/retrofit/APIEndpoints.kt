package com.example.demowithtest.retrofit

import com.example.demowithtest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIEndpoints {

    @GET("/users")
    fun getUser(@Query("email") email: String, @Query("password") password: String): Call<List<User>>

}