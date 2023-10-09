package com.example.spanishflashcardsandroid

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class ViewModel() {



    // set up mutable state labels
    private val _streak = MutableStateFlow("")

    val streak = _streak.asStateFlow()
    private val _typeFront = MutableStateFlow("")
    val typeFront = _typeFront.asStateFlow()
    private val _wordFront = MutableStateFlow("")
    val wordFront = _wordFront.asStateFlow()
    private val _sentenceFront = MutableStateFlow("")
    val sentenceFront = _sentenceFront.asStateFlow()

    private val _typeBack = MutableStateFlow("")
    val typeBack = _typeBack.asStateFlow()
    private val _wordBack = MutableStateFlow("")
    val wordBack = _wordBack.asStateFlow()
    private val _sentenceBack = MutableStateFlow("")
    val sentenceBack = _sentenceBack.asStateFlow()





    // standard model vars
    private var streakInt: Int = 0
    private var _translationWordsList = mutableListOf<TranslatableWord>()

    // public interface
    public fun init(context: Context, translationWordsFileName: String) {

        resetStreak()
        val jsonReader = JsonReader()
        _translationWordsList = jsonReader.getListOfTranslatableWords(context, translationWordsFileName)

        _typeFront.value = "Frase"
        _typeBack.value = "Phrase"
        _wordFront.value = "no (lo) sé"
        _wordBack.value = "i don’t know"
        _sentenceFront.value = "No sé cuántos tiburones hay en el océano"
        _sentenceBack.value = "I don't know how many sharks are in the ocean"


    }
    public fun incrementStreak() {
        streakInt++
        updateStreakLabel()
    }
    public fun resetStreak() {
        streakInt = 0
        updateStreakLabel()
    }
    public fun nextCard() {
        _typeFront.value = "2Frase"
        _typeBack.value = "2Phrase"
        _wordFront.value = "2no (lo) sé"
        _wordBack.value = "2i don’t know"
        _sentenceFront.value = "2No sé cuántos tiburones hay en el océano"
        _sentenceBack.value = "2I don't know how many sharks are in the ocean"
    }



    // private methods
    private fun updateStreakLabel() {
        _streak.value = streakInt.toString()
    }


}