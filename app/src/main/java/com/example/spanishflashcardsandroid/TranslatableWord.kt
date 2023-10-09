package com.example.spanishflashcardsandroid

data class TranslatableWord (
    var spanishWord: String,
    var englishWord: String,
    var spanishType: String,
    var englishType: String,
    var spanishSentence: String,
    var englishSentence: String
)
data class TranslatableWordList (var translatableWords: List<TranslatableWord>)