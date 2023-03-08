package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUIComponents()
        setupUIs()
    }

    private fun getUIComponents() {
        etName = findViewById(R.id.etName)
        btnStart = findViewById(R.id.btnStart)
    }

    private fun setupUIs() {
        btnStart.setOnClickListener {
            if (etName.text.trim().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            } else {
                val username = etName.text.trim().toString()
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, username)
                startActivity(intent)
                finish()
            }
        }
    }
}