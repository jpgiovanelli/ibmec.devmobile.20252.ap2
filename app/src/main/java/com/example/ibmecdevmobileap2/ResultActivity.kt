package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("USER_NAME") ?: "Usuário"
        val answer1 = intent.getStringExtra("ANSWER_1")
        val answer2 = intent.getStringArrayListExtra("ANSWER_2")
        val answer3 = intent.getStringExtra("ANSWER_3")
        val answer4 = intent.getStringExtra("ANSWER_4")

        val resultDescription = findViewById<TextView>(R.id.result_description)
        val shareButton = findViewById<Button>(R.id.share_button)

        val profile = calculateProfile(answer1, answer2, answer3, answer4)
        val resultText = "Parabéns, $name!\n\nBaseado em suas respostas, seu perfil é:\n\n$profile"
        resultDescription.text = resultText

        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Meu perfil de dev é: $profile. Descubra o seu também!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar resultado com:"))
        }

        if (savedInstanceState == null) {
            val fragment = RestartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.restart_fragment_container, fragment)
                .commit()
        }
    }

    private fun calculateProfile(answer1: String?, answer2: ArrayList<String>?, answer3: String?, answer4: String?): String {
        if (answer1 == "Kotlin" && answer2?.contains("Mobile") == true) {
            return "Desenvolvedor Mobile Android Nativo"
        }
        if (answer2?.contains("Front-end") == true && answer1 == "JavaScript") {
            return "Desenvolvedor Front-end Web"
        }
        if (answer2?.contains("Back-end") == true && (answer1 == "Java" || answer1 == "Python")) {
            return "Desenvolvedor Back-end"
        }
        if (answer3 == "Linux" && answer2?.contains("DevOps") == true) {
            return "Engenheiro DevOps"
        }
        if (answer4 == "Em equipe") {
            return "Desenvolvedor Full-Stack Colaborativo"
        }

        return "Desenvolvedor Full-Stack Versátil"
    }
}