package com.example.spanishflashcardsandroid

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class JsonReader {
    fun getJsonDataFromAsset(
        context: Context,
        fileName: String
    ): String? {
        val jsonString: String
        try {
            val openFile = context.assets.open(fileName)
            jsonString = openFile.bufferedReader().use {
                it.readText()
            }
        } catch (exp: IOException) {
            exp.printStackTrace()
            return exp.message
        }

        return jsonString
    }
    fun getListOfTranslatableWords (context: Context, translationWordsFileName: String): MutableList<TranslatableWord> {
        val jsonFileString = getJsonDataFromAsset(context = context, fileName = translationWordsFileName)
        val type = object : TypeToken<List<TranslatableWord>>() {}.type
        return Gson().fromJson(jsonFileString, type)

    }
}