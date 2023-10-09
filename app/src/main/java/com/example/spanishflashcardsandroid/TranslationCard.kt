package com.example.spanishflashcardsandroid

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class TranslationCard (
    val typeFront: String,
    val wordFront: String,
    val sentenceFront: String,
    val typeBack: String,
    val wordBack: String,
    val sentenceBack: String
)