package com.example.videoplayer.ui.videoList


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VideoListModel (
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
):Serializable