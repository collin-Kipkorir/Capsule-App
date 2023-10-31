package com.lecotech.capsuleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuizResultScreenFragment : Fragment() {

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
        // Add more questions here as needed
    )

    private val correctAnswers = listOf("Paris", "Mitochondria") // Add more correct answers as needed
    private var userAnswers: List<String>? = null // Initialize this list with user's selected answers

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_quiz_result_screen, container, false)

        val resultRecyclerView: RecyclerView = rootView.findViewById(R.id.resultRecyclerView)
        resultRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = userAnswers?.let { QuizResultAdapter(questions, correctAnswers, it) }
        resultRecyclerView.adapter = adapter

        return rootView
    }
}
