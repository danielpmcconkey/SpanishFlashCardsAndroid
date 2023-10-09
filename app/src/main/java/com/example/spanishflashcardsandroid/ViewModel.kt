package com.example.spanishflashcardsandroid

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class ViewModel() {



    // set up mutable state vals
    private val _streak = MutableStateFlow("")
    val streak = _streak.asStateFlow()
    private val _answerView = MutableStateFlow("")
    val answerView = _answerView.asStateFlow()


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
    private var _currentCard: Int = 0
    private var _translationWordsList = mutableListOf<TranslatableWord>()
    private var _translationWordsDeck = mutableListOf<TranslationCard>()

    // public interface
    public fun init(context: Context, translationWordsFileName: String) {

        resetStreak()
        hideAnswer()
        val jsonReader = JsonReader()
        _translationWordsList = jsonReader.getListOfTranslatableWords(context, translationWordsFileName)

        shuffleWordsDeck()
        displayCardAtIndex(_currentCard)
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
        if(_currentCard >= _translationWordsDeck.size - 1) _currentCard = 0
        else _currentCard++
        displayCardAtIndex(_currentCard)
    }
    public fun previousCard() {
        if(_currentCard <= 0) _currentCard = _translationWordsDeck.size - 1
        else _currentCard--
        displayCardAtIndex(_currentCard)
    }
    public fun shuffleWordsDeck() {

        val nums_list = (0 until _translationWordsList.size).toList()
        val shuffled_nums = nums_list.shuffled()
        for (i in shuffled_nums) {
            val word = _translationWordsList[i]
            if (spanishOrEnglish() == "spanish") {
                _translationWordsDeck.add(
                    TranslationCard(
                        typeFront = word.spanishType,
                        wordFront = word.spanishWord,
                        sentenceFront = word.spanishSentence,
                        typeBack = word.englishType,
                        wordBack = word.englishWord,
                        sentenceBack = word.englishSentence
                    )  
                )
            }
            else {
                _translationWordsDeck.add(
                    TranslationCard(
                        typeFront = word.englishType,
                        wordFront = word.englishWord,
                        sentenceFront = word.englishSentence,
                        typeBack = word.spanishType,
                        wordBack = word.spanishWord,
                        sentenceBack = word.spanishSentence
                    )
                )
            }
        }
    }
    public fun showAnswer() {
        _answerView.value = "shown"
    }
    public fun hideAnswer() {
        _answerView.value = "hidden"
    }

    // private methods
    private fun updateStreakLabel() {
        _streak.value = streakInt.toString()
    }
    private fun spanishOrEnglish():String {
        return listOf("spanish", "english").random()
    }
    private fun displayCardAtIndex(i: Int) {
        val card = _translationWordsDeck[i]
        _typeFront.value = card.typeFront
        _typeBack.value = card.typeBack
        _wordFront.value = card.wordFront
        _wordBack.value = card.wordBack
        _sentenceFront.value = card.sentenceFront
        _sentenceBack.value = card.sentenceBack
    }
}