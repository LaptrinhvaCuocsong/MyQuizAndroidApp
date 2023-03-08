package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvUsername: TextView
    private lateinit var tvYourPoint: TextView
    private lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        getUIComponents()
        setupUIs()
    }

    private fun getUIComponents() {
        tvUsername = findViewById(R.id.tvUsername)
        tvYourPoint = findViewById(R.id.tvScorePoint)
        btnFinish = findViewById(R.id.btnFinish)
    }

    private fun setupUIs() {
        val username = intent.getStringExtra(Constants.USER_NAME) ?: "Guest"
        val point = intent.getIntExtra(Constants.CORRECT_POINT, 0)
        tvUsername.text = username.uppercase()
        tvYourPoint.text = "Your core is $point"

        btnFinish.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}