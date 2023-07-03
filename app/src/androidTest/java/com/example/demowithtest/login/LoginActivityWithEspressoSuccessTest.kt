package com.example.demowithtest.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.demowithtest.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
public class LoginActivityEspressoSuccessTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun shouldShowUserDetailsWhenLoginCompletesSuccessfully() {
//        onView(withId(R.id.edtEmail)).perform(typeText("Sincere@april.biz"))
//        onView(withId(R.id.edtPassword)).perform(typeText("CorrectPassword123456"))
//        onView(withId(R.id.edtPassword)).perform(ViewActions.closeSoftKeyboard())
//        onView(withId(R.id.btnLogin)).perform(click())
//
//        onView(withId(R.id.txtWelcomeMsg)).check(matches(withText("Hello \nLeanne Graham")))
    }

}