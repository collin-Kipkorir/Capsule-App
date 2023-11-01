package com.lecotech.capsuleapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lecotech.capsuleapp.QuizQuestion
import com.lecotech.capsuleapp.R

class QuizResultAdapter(private val quizResults: List<QuizQuestion>) :
    RecyclerView.Adapter<QuizResultAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val chosenAnswerTextView: TextView = itemView.findViewById(R.id.choosenAnswerTextView)
        val correctAnswerTextView: TextView = itemView.findViewById(R.id.correctAnswerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quizQuestion = quizResults[position]
        holder.questionTextView.text = quizQuestion.question
        holder.chosenAnswerTextView.text =
            "Chosen answer: ${quizQuestion.options[quizQuestion.selectedOption]}"
        holder.correctAnswerTextView.text =
            "Correct answer: ${quizQuestion.options[quizQuestion.correctAnswerIndex]}"
    }

    override fun getItemCount(): Int {
        return quizResults.size
    }
}
