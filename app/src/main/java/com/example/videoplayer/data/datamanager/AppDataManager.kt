package com.example.videoplayer.data.datamanager

import com.example.videoplayer.data.datahelpers.apihelper.ApiHelper
import com.example.videoplayer.data.datahelpers.preferencehelper.PreferenceHelper
import com.example.videoplayer.main.VideoListModel
import retrofit2.Call

class AppDataManager(private val apiHelper: ApiHelper = ApiHelper(), private val preferenceHelper: PreferenceHelper = PreferenceHelper.getInstance()) : DataManager {


    companion object{
        private var mAppDataManager:AppDataManager?=null
         fun getInstance():AppDataManager{
            return mAppDataManager?:AppDataManager()
        }
    }
    override fun getVideoLists(print: String): Call<ArrayList<VideoListModel>> {
        return apiHelper.getApi().getVideoLists("pretty")
    }
}




