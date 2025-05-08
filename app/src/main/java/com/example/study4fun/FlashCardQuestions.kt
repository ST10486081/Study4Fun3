package com.example.study4fun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardQuestionsActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is in Japan.",
        "World War II ended in 1945.",
        "Julius Caesar was a Roman Emperor.",
        "The Berlin Wall fell in 1989."
    )

    private val answers = arrayOf(true, false, true, false, true)
    private var score = 0
    private var currentQuestionIndex = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnCheckScore: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_questions)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnCheckScore = findViewById(R.id.btnCheckScore)

        // Display the first question
        displayQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnCheckScore.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionText.text = questions[currentQuestionIndex]
            feedbackText.text = ""
        } else {
            // No more questions, disable buttons
            btnTrue.visibility = View.GONE
            btnFalse.visibility = View.GONE
            btnCheckScore.visibility = View.VISIBLE
            questionText.text = "Quiz Finished! Check your score."
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]) {
            feedbackText.text = "CORRECT"
            score++
        } else {
            feedbackText.text = "INCORRECT"
        }
        currentQuestionIndex++
        displayQuestion()
    }
}
