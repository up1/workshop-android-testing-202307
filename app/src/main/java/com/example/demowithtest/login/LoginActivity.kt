package com.example.demowithtest.login

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.demowithtest.R
import com.example.demowithtest.databinding.ActivityLoginBinding
import com.example.demowithtest.login.service.LoginService
import com.example.demowithtest.model.User
import com.example.demowithtest.userdetail.UserDetailActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var loginPresenter: LoginPresenter
    private lateinit var loadingDialog: Dialog
    internal lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loginPresenter = LoginPresenterImpl(this, LoginService())

        binding.btnLogin.setOnClickListener { loginPresenter.handleClick(it.id) }
        binding.txtbtnForgotPassword.setOnClickListener { loginPresenter.handleClick(it.id) }
    }

    override fun navigateToBrowser() {
        val url = "http://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun setEmailEditTextError(errorMessage: String) {
        binding.edtEmail.error = errorMessage
        binding.edtEmail.requestFocus()
    }

    override fun setPasswordEditTextError(errorMessage: String) {
        binding.edtPassword.error = errorMessage
        binding.edtPassword.requestFocus()
    }

    override fun navigateToUserDetails(user: User) {
        val intent = Intent(this, UserDetailActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
        finish()
    }

    override fun showLoading() {
        loadingDialog = Dialog(this)
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.setCancelable(false)
        loadingDialog.setContentView(R.layout.dialog_loading)
        loadingDialog.show()
    }

    override fun dismissLoading() {
        loadingDialog.dismiss()
    }

    override fun showErrorDialog(errorMessage: String) {
        val alertDialog = AlertDialog.Builder(this@LoginActivity)
            .setTitle("Error")
            .setMessage(errorMessage)
            .setPositiveButton("Ok", null)
            .create()

        alertDialog.show()
    }

    override fun doLogin() {
        with(binding) {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val emailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()


            if (isNetworkAvailable()) {
                loginPresenter.doLogin(email, password, emailValid)
            } else {
                val alertDialog = AlertDialog.Builder(this@LoginActivity)
                    .setTitle("Error")
                    .setMessage("Please, enable internet connection")
                    .setPositiveButton("Ok", null)
                    .create()

                alertDialog.show()
            }
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    }
}