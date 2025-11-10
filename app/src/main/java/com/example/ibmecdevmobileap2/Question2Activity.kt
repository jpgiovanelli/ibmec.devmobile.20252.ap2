package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Question2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        val option1 = findViewById<CheckBox>(R.id.option1_q2)
        val option2 = findViewById<CheckBox>(R.id.option2_q2)
        val option3 = findViewById<CheckBox>(R.id.option3_q2)
        val option4 = findViewById<CheckBox>(R.id.option4_q2)
        val nextButton = findViewById<Button>(R.id.next_button_q2)
        val backButton = findViewById<Button>(R.id.back_button_q2)

        nextButton.setOnClickListener {
            val answers = mutableListOf<String>()
            if (option1.isChecked) answers.add(option1.text.toString())
            if (option2.isChecked) answers.add(option2.text.toString())
            if (option3.isChecked) answers.add(option3.text.toString())
            if (option4.isChecked) answers.add(option4.text.toString())

            if (answers.isNotEmpty()) {
                val name = intent.getStringExtra("USER_NAME")
                val answer1 = intent.getStringExtra("ANSWER_1")

                val intent = Intent(this, Question3Activity::class.java)
                intent.putExtra("USER_NAME", name)
                intent.putExtra("ANSWER_1", answer1)
                intent.putStringArrayListExtra("ANSWER_2", ArrayList(answers))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Selecione ao menos uma área de interesse.", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish()
        }

        if (savedInstanceState == null) {
            val fragment = RestartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.restart_fragment_container_q2, fragment)
                .commit()
        }
    }
}