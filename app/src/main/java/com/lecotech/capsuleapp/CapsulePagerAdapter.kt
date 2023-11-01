package com.lecotech.capsuleapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.lecotech.capsuleapp.QuizResultScreenFragment

class CapsulePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VideoScreenFragment()
            1 -> NotesScreenFragment()
            2 -> QuizScreenFragment()
            3 -> QuizResultScreenFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
