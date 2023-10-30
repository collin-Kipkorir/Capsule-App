package com.lecotech.capsuleapp

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    var selectedOption: Int = -1 
)




