package com.example.study4fun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var btnReview: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_screen) // Ensure this matches your XML layout file name

        scoreText = findViewById(R.id.scoreText)
        btnReview = findViewById(R.id.btnReview)
        btnExit = findViewById(R.id.btnExit)

        // Get the score from the intent
        val score = intent.getIntExtra("SCORE", 0) // Provide a default value of 0

        // Display the score
        scoreText.text = "Your score: $score"

        // Set up button click listeners
        btnReview.setOnClickListener {
            // Navigate back to the FlashcardQuestionsActivity
            val intent = Intent(this, FlashcardQuestionsActivity::class.java)
            startActivity(intent)
            finish() // Optional: Call finish() if you want to remove this activity from the back stack
        }

        btnExit.setOnClickListener {
            // Exit the app
            finishAffinity() // This will close the app
        }
    }
}
