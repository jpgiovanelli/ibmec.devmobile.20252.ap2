package com.example.ibmecdevmobileap2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        if (savedInstanceState == null) {
            val fragment = Question1Fragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}