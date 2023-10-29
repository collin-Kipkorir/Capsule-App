package com.lecotech.capsuleapp

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class VideoScreenFragment : Fragment() {

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_video_screen, container, false)

        videoView = rootView.findViewById(R.id.videoView)

        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.video
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false // Set true if you want to loop the video
            videoView.start()
        }
      
        val openNotesCardView: CardView = rootView.findViewById(R.id.openNotes)
        openNotesCardView.setOnClickListener {
            val fragment = NotesScreenFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return rootView
    }
}
