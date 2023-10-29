package com.lecotech.capsuleapp

data class QuizQuestion(
    val question: String,
    val options: List<String>, // Ensure this is a list of strings
    val correctAnswerIndex: Int
)



