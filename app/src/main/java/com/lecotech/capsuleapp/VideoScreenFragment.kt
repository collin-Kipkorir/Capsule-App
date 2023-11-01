package com.lecotech.capsuleapp

import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment

class VideoScreenFragment : Fragment() {

    private lateinit var videoView: VideoView
    private lateinit var button: Button
    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_video_screen, container, false)

        videoView = rootView.findViewById(R.id.videoView)
        button = rootView.findViewById(R.id.button)
        val videoUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        button.setOnClickListener {
            progressDialog = ProgressDialog(requireContext())
            progressDialog?.setMessage("Loading video...")
            progressDialog?.setCancelable(false)
            progressDialog?.show()

            videoView.setVideoURI(Uri.parse(videoUrl))
            videoView.requestFocus()
            videoView.start()
        }

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false // Set true if you want to loop the video
            videoView.start()
            progressDialog?.dismiss()
        }

        videoView.setOnErrorListener { mp, what, extra ->
            // Handle any errors or exceptions here
            progressDialog?.dismiss()
            true
        }

        return rootView
    }
}
