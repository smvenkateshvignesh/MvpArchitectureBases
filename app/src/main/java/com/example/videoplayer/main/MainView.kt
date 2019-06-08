package com.example.videoplayer.main

import com.example.videoplayer.base.MvpView

/**
 * Created by Venkatesh Vignesh on 6/7/2019.
 */
interface MainView:MvpView {
     fun showList(videosLists: ArrayList<VideoListModel>?)
}