package com.example.myquizapp

data class QuestionModel(
    val id: String,
    val question: String,
    val image: Int,
    val answerOptions: List<String>,
    val answerCorrect: Int
)
