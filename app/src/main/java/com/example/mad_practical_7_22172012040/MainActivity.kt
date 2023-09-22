package com.example.mad_practical_7_22172012040

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView: VideoView=findViewById(R.id.videoView)
        val button: FloatingActionButton= findViewById(R.id.floatingActionButton)
        videoplayer()
        button.setOnClickListener {
            Intent(this@MainActivity,YoutubeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    fun videoplayer(){
        val myvideoView: VideoView=findViewById(R.id.videoView)
        val mediaController=MediaController(this)
        val uri: Uri =Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        myvideoView.setMediaController(mediaController)
        mediaController.setAnchorView(myvideoView)
        myvideoView.setVideoURI(uri)
        myvideoView.requestFocus()
        myvideoView.start()
    }

}