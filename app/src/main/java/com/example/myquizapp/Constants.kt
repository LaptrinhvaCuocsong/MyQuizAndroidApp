package com.example.myquizapp

object Constants {
    const val USER_NAME = "user_name"
    const val CORRECT_POINT = "correct_point"

    fun getQuestions(): List<QuestionModel> {
        var questions = ArrayList<QuestionModel>()
        questions.addAll(
            listOf(
                QuestionModel(
                    "1",
                    "What is country of flag?",
                    R.drawable.ar_flag,
                    listOf("China", "Korea", "Argentina"),
                    2
                ),
                QuestionModel(
                    "2",
                    "What is country of flag?",
                    R.drawable.br_flag,
                    listOf("Brazil", "Korea", "Viet Nam"),
                    0
                ),
                QuestionModel(
                    "3",
                    "What is country of flag?",
                    R.drawable.vm_flag,
                    listOf("China", "Viet Nam", "Japan"),
                    1
                )
            )
        )
        return questions
    }
}