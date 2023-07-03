package com.example.demowithtest.userdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demowithtest.databinding.ActivityUserDetailBinding
import com.example.demowithtest.model.User

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val user = intent.extras!!.get("user") as User
        binding.txtWelcomeMsg.text = "Hello \n" + user.name
    }
}