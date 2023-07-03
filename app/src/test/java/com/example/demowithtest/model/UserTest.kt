package com.example.demowithtest.model

import junit.framework.TestCase.assertEquals
import org.junit.Test



class UserTest {

    @Test
    fun shouldTest() {
        val u = User(null, null,"", 0, "", "", "", "")
        u.name
        assertEquals("", u.name)
    }
}