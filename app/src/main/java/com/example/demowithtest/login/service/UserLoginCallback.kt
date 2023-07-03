package com.example.demowithtest.login.service

import com.example.demowithtest.login.LoginView
import com.example.demowithtest.model.User
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class UserLoginCallback(private val loginView: LoginView) : Callback<List<User>> {

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        loginView.dismissLoading()
        response.body()?.let {
            if (it.isNotEmpty()) {
                loginView.navigateToUserDetails(it[0])
            } else {
                loginView.showErrorDialog("User not found for this credentials")
            }
        }
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        t.printStackTrace()
        loginView.dismissLoading()
        loginView.showErrorDialog("Error occurred in Login")
    }
}