package com.example.videoplayer.main

import android.support.v7.widget.LinearLayoutManager
import com.example.videoplayer.R
import com.example.videoplayer.base.BaseActivity
import com.example.videoplayer.main.adapter.VideoListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter,MainView>(),MainView {
    override fun showList(videosLists: ArrayList<VideoListModel>?) {
        val videoListAdapter = VideoListAdapter(this,videosLists!!)
        videoListAdapter.setOnClickListener(object :VideoListAdapter.OnClickListener{
            override fun onClick(videoList: ArrayList<VideoListModel>, adapterPosition: Int) {
                showToast("Selected Item is " +videoList[adapterPosition].title)
            }

        })
        rvVideo.adapter = videoListAdapter

    }
    override fun setLayout(): Int {
        return R.layout.activity_main
    }
    override fun setPresenter(): MainPresenter {
       return MainPresenter()
    }
    override fun setMvpView(): MainView {
        return this
    }
    override fun init() {
        rvVideo.layoutManager = LinearLayoutManager(this)
        getPresenter().callVideoApi()
    }
}
