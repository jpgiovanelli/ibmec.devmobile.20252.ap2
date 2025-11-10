package com.example.ibmecdevmobileap2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class Question1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question1, container, false)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group_question1)
        val nextButton = view.findViewById<Button>(R.id.next_button_q1)
        val backButton = view.findViewById<Button>(R.id.back_button_q1)

        nextButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = view.findViewById<RadioButton>(selectedId)
                val answer1 = selectedRadioButton.text.toString()
                val name = activity?.intent?.getStringExtra("USER_NAME") ?: ""

                val intent = Intent(activity, Question2Activity::class.java)
                intent.putExtra("USER_NAME", name)
                intent.putExtra("ANSWER_1", answer1)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            activity?.finish()
        }

        if (savedInstanceState == null) {
            val fragment = RestartFragment()
            childFragmentManager.beginTransaction()
                .add(R.id.restart_fragment_container_q1, fragment)
                .commit()
        }

        return view
    }
}