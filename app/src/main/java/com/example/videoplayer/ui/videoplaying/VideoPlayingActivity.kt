package com.example.videoplayer.ui.videoplaying

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.videoplayer.R
import com.example.videoplayer.base.BaseActivity
import com.example.videoplayer.ui.videoList.VideoListModel
import com.example.videoplayer.ui.videoplaying.adapter.RelatedVideoListAdapter
import kotlinx.android.synthetic.main.activity_video_playing.*

class VideoPlayingActivity : BaseActivity<VideoPlayingPresenter, VideoPlayingView>(), VideoPlayingView {
    override fun setLayout(): Int {
        return R.layout.activity_video_playing
    }

    override fun setPresenter(): VideoPlayingPresenter {
        return VideoPlayingPresenter()
    }

    override fun setMvpView(): VideoPlayingView {
        return this
    }

    override fun init() {
        rvRelatedVideos.layoutManager = LinearLayoutManager(this)
        showRelatedData()
    }

    private fun showRelatedData() {
        val intent:Bundle? = intent.extras
        val videoList: ArrayList<VideoListModel>? = intent?.getSerializable("videoList") as ArrayList<VideoListModel>
        val videoListAdapter = RelatedVideoListAdapter(this,videoList!!)
        videoListAdapter.setOnClickListener(object : RelatedVideoListAdapter.OnClickListener{
            override fun onClick(videoList: ArrayList<VideoListModel>, adapterPosition: Int) {

            }

        })
        rvRelatedVideos.adapter = videoListAdapter
    }

}
