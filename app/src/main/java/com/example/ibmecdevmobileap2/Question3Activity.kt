package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Question3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        val spinner = findViewById<Spinner>(R.id.spinner_question3)
        val nextButton = findViewById<Button>(R.id.next_button_q3)
        val backButton = findViewById<Button>(R.id.back_button_q3)

        ArrayAdapter.createFromResource(
            this,
            R.array.os_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        nextButton.setOnClickListener {
            val answer3 = spinner.selectedItem.toString()
            val name = intent.getStringExtra("USER_NAME")
            val answer1 = intent.getStringExtra("ANSWER_1")
            val answer2 = intent.getStringArrayListExtra("ANSWER_2")

            val intent = Intent(this, Question4Activity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("ANSWER_1", answer1)
            intent.putStringArrayListExtra("ANSWER_2", answer2)
            intent.putExtra("ANSWER_3", answer3)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }

        if (savedInstanceState == null) {
            val fragment = RestartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.restart_fragment_container_q3, fragment)
                .commit()
        }
    }
}