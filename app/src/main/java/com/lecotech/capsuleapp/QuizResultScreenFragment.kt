package com.lecotech.capsuleapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lecotech.capsuleapp.QuizQuestion
import com.lecotech.capsuleapp.QuizResultAdapter
import com.lecotech.capsuleapp.R

class QuizResultScreenFragment : Fragment() {
    private val quizResults: List<QuizQuestion> = listOf(
        QuizQuestion("What is the capital of France?", listOf("London", "Berlin", "Paris", "Rome"), 2, 2),
        QuizQuestion("What is the powerhouse of the cell?", listOf("Nucleus", "Mitochondria", "Ribosome", "Golgi apparatus"), 1, 1),
        QuizQuestion("Which planet is known as the Red Planet?", listOf("Jupiter", "Mars", "Saturn", "Neptune"), 1, 1),
        QuizQuestion("What is the chemical symbol for water?", listOf("O2", "CO2", "H2O", "NaCl"), 2, 2),
        QuizQuestion("Who is the author of \"To Kill a Mockingbird\"?", listOf("William Shakespeare", "Jane Austen", "Harper Lee", "J.K. Rowling"), 2, 2)
        // Add more QuizQuestion objects as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_quiz_result_screen, container, false)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.resultRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = QuizResultAdapter(quizResults)
        recyclerView.adapter = adapter

        return rootView
    }
}
