package com.example.demowithtest.utility

import android.content.Context
import android.content.res.AssetManager
import androidx.test.platform.app.InstrumentationRegistry
import java.util.Scanner


object ReadDummyServerResponse {

    fun readJsonFile(fileName: String): String {
        val context: Context = InstrumentationRegistry.getInstrumentation().getContext();
        val assetManager: AssetManager = context.getAssets()
        val jsonFixtureFile = assetManager.open("files/$fileName")
        val s = Scanner(jsonFixtureFile).useDelimiter("\\A")
        return if (s.hasNext()) s.next() else ""
    }
}