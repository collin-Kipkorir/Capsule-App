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
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

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

        val adapter = QuizAdapter(questions)
        recyclerView.adapter = adapter

        val checkResultsCardView: CardView = rootView.findViewById(R.id.quizButton)
        checkResultsCardView.setOnClickListener {
            checkAllQuestionsAnswered(adapter)
        }

        return rootView
    }

    private fun checkAllQuestionsAnswered(adapter: QuizAdapter) {
        val unansweredQuestions = adapter.getUnansweredQuestions()

        if (unansweredQuestions.isNotEmpty()) {
            // Not all questions have been answered
            val context = requireContext()
            Toast.makeText(context, "Please answer all questions", Toast.LENGTH_SHORT).show()
        } else {
            openQuizResultScreenFragment(adapter)
        }
    }

    private fun openQuizResultScreenFragment(adapter: QuizAdapter) {
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        viewPager.currentItem = 3
    }
}
