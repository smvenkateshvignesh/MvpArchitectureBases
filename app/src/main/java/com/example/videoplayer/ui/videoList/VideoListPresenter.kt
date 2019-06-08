package com.example.videoplayer.ui.videoList

import com.example.videoplayer.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Venkatesh Vignesh on 6/7/2019.
 */
class VideoListPresenter:BasePresenter<VideoListView>() {
    fun callVideoApi() {
        getMvpView().showProgress()
        getAppDataManager().getVideoLists("pretty").enqueue(object : Callback<ArrayList<VideoListModel>>{
            override fun onFailure(call: Call<ArrayList<VideoListModel>>, t: Throwable) {
                getMvpView().hideProgress()
                getMvpView().showError("Something went wrong!")
            }

            override fun onResponse(
                call: Call<ArrayList<VideoListModel>>,
                response: Response<ArrayList<VideoListModel>>
            ) {
                getMvpView().hideProgress()
                val videosLists:ArrayList<VideoListModel>? = response.body()
                getMvpView().showList(videosLists)
            }
        })
    }

}