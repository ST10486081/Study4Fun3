package com.example.study4fun

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBegin: Button = findViewById(R.id.btnBegin)
        btnBegin.setOnClickListener {
            val intent = Intent(this, FlashcardQuestionsActivity::class.java)
            startActivity(intent)
        }
    }
}
