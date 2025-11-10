package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class Question4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        val switch = findViewById<Switch>(R.id.switch_question4)
        val finishButton = findViewById<Button>(R.id.finish_button_q4)
        val backButton = findViewById<Button>(R.id.back_button_q4)

        finishButton.setOnClickListener {
            val answer4 = if (switch.isChecked) "Em equipe" else "Sozinho"
            val name = intent.getStringExtra("USER_NAME")
            val answer1 = intent.getStringExtra("ANSWER_1")
            val answer2 = intent.getStringArrayListExtra("ANSWER_2")
            val answer3 = intent.getStringExtra("ANSWER_3")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("ANSWER_1", answer1)
            intent.putStringArrayListExtra("ANSWER_2", answer2)
            intent.putExtra("ANSWER_3", answer3)
            intent.putExtra("ANSWER_4", answer4)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }

        if (savedInstanceState == null) {
            val fragment = RestartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.restart_fragment_container_q4, fragment)
                .commit()
        }
    }
}