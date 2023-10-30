package com.lecotech.capsuleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuizScreenFragment : Fragment() {

    private val questions = listOf(
        QuizQuestion(
            "What is the capital of France?",
            listOf("London", "Berlin", "Paris", "Rome"),
            2
        ),
        QuizQuestion(
            "What is the powerhouse of the cell?",
            listOf("Nucleus", "Mitochondria", "Ribosome", "Golgi apparatus"),
            1
        ),
        QuizQuestion(
            "Which planet is known as the Red Planet?",
            listOf("Jupiter", "Mars", "Saturn", "Neptune"),
            1
        ),
        QuizQuestion(
            "What is the chemical symbol for water?",
            listOf("O2", "CO2", "H2O", "NaCl"),
            2
        ),
        QuizQuestion(
            "Who is the author of \"To Kill a Mockingbird\"?",
            listOf("William Shakespeare", "Jane Austen", "Harper Lee", "J.K. Rowling"),
            2
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_quiz_screen, container, false)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = QuizAdapter(questions) {
            checkAllQuestionsAnswered()
        }

        return rootView
    }

    private fun checkAllQuestionsAnswered() {
        for (question in questions) {
            if (question.selectedOption == -1) {
                val context = requireContext()
                Toast.makeText(context, "Please answer all the questions", Toast.LENGTH_SHORT).show()
                return
            }
        }
        // Implement your logic here to open the Results Fragment view
    }
}
