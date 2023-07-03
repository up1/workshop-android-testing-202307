package com.example.demowithtest.login

import android.content.Intent
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.buildActivity
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf


@RunWith(RobolectricTestRunner::class)
class LoginActivityWithRobolectricTest {

    private lateinit var loginActivity: LoginActivity

    @Before
    fun setUp() {
        loginActivity = buildActivity(LoginActivity::class.java).setup().get()
    }

    @Test
    fun shouldShowEmptyMessageErrorWhenEmailFieldIsEmpty() {
        loginActivity.binding.btnLogin.performClick()

        assertEquals("This field is empty", loginActivity.binding.edtEmail.error)
    }

    @Test
    fun shouldShowEmptyMessageErrorWhenPasswordFieldIsEmpty() {
        loginActivity.binding.btnLogin.performClick()

        assertEquals("This field is empty", loginActivity.binding.edtPassword.error)
    }

    @Test
    fun shouldShowValidationMessageErrorWhenEmailFieldIsInvalid() {
        loginActivity.binding.edtEmail.setText("tw@")

        loginActivity.binding.btnLogin.performClick()

        assertEquals("Please fill your email correctly", loginActivity.binding.edtEmail.error)
    }

    @Test
    fun shouldShowValidationMessageErrorWhenPasswordFieldIsInvalid() {
        loginActivity.binding.edtPassword.setText("passwordWithoutNumbers")

        loginActivity.binding.btnLogin.performClick()

        assertEquals(
            "Your password must have at least 8 characters with letters and numbers",
            loginActivity.binding.edtPassword.error
        )
    }

    @Test
    fun shouldCallBrowserWhenForgotPasswordButtonIsClicked() {
        loginActivity.binding.txtbtnForgotPassword.performClick()

        val shadowActivity = shadowOf(loginActivity)
        val intent = shadowActivity.nextStartedActivity

        assertEquals("http://www.google.com", intent.dataString)
        assertEquals(Intent.ACTION_VIEW, intent.action)
    }

}