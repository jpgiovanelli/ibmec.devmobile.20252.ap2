package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.name_input)
        val startButton = findViewById<Button>(R.id.start_button)

        startButton.setOnClickListener {
            val name = nameInput.text.toString()
            if (name.isNotBlank()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, digite seu nome.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
