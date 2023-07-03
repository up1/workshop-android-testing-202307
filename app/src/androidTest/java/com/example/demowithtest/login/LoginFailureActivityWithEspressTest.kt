package com.example.demowithtest.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.demowithtest.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
public class LoginFailureActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun shouldShowEmptyMessageErrorWhenFieldsAreEmpty() {
        onView(withId(R.id.btnLogin)).perform(click())

        onView(allOf(withId(R.id.edtPassword), isDisplayed())).check(matches(hasErrorText("This field is empty")))
        onView(withId(R.id.edtEmail)).check(matches(hasErrorText("This field is empty")))
    }

    @Test
    fun shouldShowValidationMessageErrorWhenEmailFieldIsInvalid() {
        onView(withId(R.id.edtEmail)).perform(typeText("tw@"))
        onView(withId(R.id.edtPassword)).perform(typeText("CorrectPassword123456"))
        onView(withId(R.id.edtPassword)).perform(closeSoftKeyboard())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.edtEmail)).check(matches(hasErrorText("Please fill your email correctly")))
    }

    @Test
    fun shouldShowValidationMessageErrorWhenPasswordFieldIsInvalid() {
        onView(withId(R.id.edtEmail)).perform(typeText("tw@tw.com"))
        onView(withId(R.id.edtPassword)).perform(typeText("wrongPass"))
        onView(withId(R.id.edtPassword)).perform(closeSoftKeyboard())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.edtPassword)).check(matches(hasErrorText("Your password must have at least 8 characters with letters and numbers")))
    }

}