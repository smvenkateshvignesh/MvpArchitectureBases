package com.example.videoplayer.ui.videoList

import com.example.videoplayer.base.MvpView

/**
 * Created by Venkatesh Vignesh on 6/7/2019.
 */
interface VideoListView:MvpView {
     fun showList(videosLists: ArrayList<VideoListModel>?)
}