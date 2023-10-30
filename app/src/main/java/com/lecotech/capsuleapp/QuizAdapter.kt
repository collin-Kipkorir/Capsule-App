package com.lecotech.capsuleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(private val questions: List<QuizQuestion>, private val checkResultsCallback: () -> Unit) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return QuizViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val currentQuestion = questions[position]
        holder.bind(currentQuestion)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        private val answersRadioGroup: RadioGroup = itemView.findViewById(R.id.answersRadioGroup)

        fun bind(quizQuestion: QuizQuestion) {
            questionTextView.text = quizQuestion.question

            for (i in 0 until answersRadioGroup.childCount) {
                val radioButton = answersRadioGroup.getChildAt(i) as RadioButton
                radioButton.text = quizQuestion.options[i]

                radioButton.setOnClickListener {
                    quizQuestion.selectedOption = i
                }
            }
        }
    }

    fun checkAllQuestionsAnswered(itemView: View) {
        for (question in questions) {
            if (question.selectedOption == -1) {
                val context = itemView.context
                Toast.makeText(context, "Please answer all the questions", Toast.LENGTH_SHORT).show()
                return
            }
        }
        checkResultsCallback.invoke()
    }

}

