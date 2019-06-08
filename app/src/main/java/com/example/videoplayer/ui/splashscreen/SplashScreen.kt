package com.example.videoplayer.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.example.videoplayer.R
import com.example.videoplayer.ui.videoList.VideoListActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val animZoomIn = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_out)
        imgAppLogo.startAnimation(animZoomIn)
        runHandler()
    }
    private fun runHandler() {
        Handler().postDelayed({
            navigateToScreen()
        }, SPLASH_TIME_OUT)
    }

    private fun navigateToScreen() {
        startActivity(Intent(this, VideoListActivity::class.java))
        finish()
    }

}
