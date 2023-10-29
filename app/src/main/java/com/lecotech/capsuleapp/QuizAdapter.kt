package com.lecotech.capsuleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(private val questions: List<QuizQuestion>) :
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
            }

            answersRadioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton = group.findViewById<RadioButton>(checkedId)
                val selectedIndex = group.indexOfChild(selectedRadioButton)

                // Perform necessary logic with the selected index
                // You can save the selected answer and perform further actions here
            }
        }
    }

}
