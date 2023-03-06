package com.example.myquizapp

import android.content.Context
import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity() {
    private lateinit var tvQuestion: TextView
    private lateinit var imgFlag: ImageView
    private lateinit var progressView: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var listAnswers: ListView
    private lateinit var btnSubmit: Button

    private var listAnswersAdapter: ListQuestionAdapter? = null
    private var questions: List<QuestionModel> = arrayListOf()
    private var questionIndex = 0
    private var answerIndex = -1
    private var isGoToNextQuestion = false
    private var yourScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        getUIComponents()
        setupUIs()
        questions = Constants.getQuestions()
        progressView.min = 0
        progressView.max = questions.size
        loadData(0)
    }

    private fun getUIComponents() {
        tvQuestion = findViewById(R.id.tvQuestion)
        imgFlag = findViewById(R.id.imgFlag)
        progressView = findViewById(R.id.progressView)
        tvProgress = findViewById(R.id.tvProgress)
        listAnswers = findViewById(R.id.listAnswers)
        btnSubmit = findViewById(R.id.btnSubmit)
    }

    private fun setupUIs() {
        btnSubmit.setOnClickListener{
            onClickSubmit()
        }
        listAnswers.setOnItemClickListener { parent, view, position, id ->
            run {
                answerIndex = position
                listAnswersAdapter?.indexSelected = position
                listAnswersAdapter?.notifyDataSetChanged()
            }
        }
    }

    private fun onClickSubmit() {
        if (questionIndex < 0 || questionIndex >= questions.size) { return }
        if (isGoToNextQuestion) {
            goToNextQuestion()
            isGoToNextQuestion = false
        } else {
            val question = questions[questionIndex]
            if (question.answerCorrect == answerIndex) {
                yourScore ++
                goToNextQuestion()
            } else {
                listAnswersAdapter?.indexCorrectAnswer = question.answerCorrect
                listAnswersAdapter?.notifyDataSetChanged()
                if (questionIndex == questions.size - 1) {
                    btnSubmit.text = resources.getText(R.string.finish)
                } else {
                    btnSubmit.text = resources.getText(R.string.goToNextQuestion)
                }
                isGoToNextQuestion = true
            }
        }
    }

    private fun goToNextQuestion() {
        if (questionIndex == questions.size - 1) {

        } else {
            loadData(questionIndex + 1)
            answerIndex = -1
            listAnswersAdapter?.indexCorrectAnswer = -1
            btnSubmit.text = resources.getText(R.string.submit)
        }
    }

    private fun loadData(questionIndex: Int) {
        if (questionIndex < 0 || questionIndex >= questions.size) { return }
        this.questionIndex = questionIndex
        progressView.progress = questionIndex + 1
        val question = questions[questionIndex]
        tvQuestion.text = question.question
        imgFlag.setImageResource(question.image)
        tvProgress.text = "${questionIndex + 1}/${questions.size}"
        val adapter = ListQuestionAdapter(this, question.answerOptions)
        listAnswers.adapter = adapter
        listAnswersAdapter = adapter
    }

}