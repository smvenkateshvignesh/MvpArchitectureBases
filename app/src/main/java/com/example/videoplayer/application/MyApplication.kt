package com.example.videoplayer.application

import android.app.Application

class MyApplication: Application() {

    companion object {
        private lateinit var context: MyApplication
        fun applicationContext(): MyApplication {
            return context
        }
    }

    init {
        context = this
    }

}