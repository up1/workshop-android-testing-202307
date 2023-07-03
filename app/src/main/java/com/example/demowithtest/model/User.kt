package com.example.demowithtest.model

import java.io.Serializable

data class User(
    val address: Address?,
    val company: Company?,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
) : Serializable