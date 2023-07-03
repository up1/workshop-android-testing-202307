package com.example.demowithtest.login

interface LoginPresenter {
    fun handleClick(viewId: Int)
    fun doLogin(email: String, password: String, emailValid: Boolean)
}