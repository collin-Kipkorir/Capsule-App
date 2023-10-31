package com.lecotech.capsuleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuizResultAdapter(
    private val questions: List<QuizQuestion>,
    private val correctAnswers: List<String>,
    private val userAnswers: List<String>
) : RecyclerView.Adapter<QuizResultAdapter.QuizResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizResultViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return QuizResultViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizResultViewHolder, position: Int) {
        val currentQuestion = questions[position]
        val userAnswer = userAnswers[position]
        val correctAnswer = correctAnswers[position]

        holder.questionTextView.text = currentQuestion.question
        holder.userAnswerTextView.text = "Your answer: $userAnswer"
        holder.correctAnswerTextView.text = "Correct answer: $correctAnswer"
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class QuizResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val userAnswerTextView: TextView = itemView.findViewById(R.id.userAnswerTextView)
        val correctAnswerTextView: TextView = itemView.findViewById(R.id.correctAnswerTextView)
    }
}
