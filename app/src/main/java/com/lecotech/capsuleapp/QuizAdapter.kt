package com.lecotech.capsuleapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(private val questions: List<QuizQuestion>) : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    private val answeredQuestions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return QuizViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val currentQuestion = questions[position]
        holder.bind(currentQuestion)

        holder.answersRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            val index = group.indexOfChild(radioButton)
            answeredQuestions.add(position)
            currentQuestion.selectedOption = index
        }
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    fun getUnansweredQuestions(): List<Int> {
        return questions.indices.filter { it !in answeredQuestions }
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val answersRadioGroup: RadioGroup = itemView.findViewById(R.id.answersRadioGroup)

        fun bind(quizQuestion: QuizQuestion) {
            questionTextView.text = quizQuestion.question
            for (i in 0 until answersRadioGroup.childCount) {
                val radioButton = answersRadioGroup.getChildAt(i) as RadioButton
                radioButton.text = quizQuestion.options[i]
            }
        }
    }
}
