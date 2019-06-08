package com.example.videoplayer.data.datahelpers.apihelper

import com.example.videoplayer.ui.videoList.VideoListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/media.json")
    fun getVideoLists(@Query("print") print:String): Call<ArrayList<VideoListModel>>
}