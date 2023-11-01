package com.lecotech.capsuleapp

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    var selectedOption: Int = -1 
    
)




