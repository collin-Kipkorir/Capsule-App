package com.lecotech.capsuleapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class NotesScreenFragment : Fragment() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notes_screen, container, false)
        webView = view.findViewById(R.id.webView)

        // Load the HTML file from the assets folder
        webView.loadUrl("file:///android_asset/notes.html")

        // Enable JavaScript if necessary
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val notesButton = view.findViewById<CardView>(R.id.notesButton)

        notesButton.setOnClickListener {
            // Add the code to navigate to the desired tab index here
            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
            viewPager.currentItem = 2
        }
        return view
    }
}
