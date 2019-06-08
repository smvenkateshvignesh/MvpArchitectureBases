package com.example.videoplayer.data.datahelpers.preferencehelper

import android.content.Context
import android.content.SharedPreferences
import com.example.videoplayer.application.MyApplication


class PreferenceHelper {
companion object{
    private var mPreferenceHelper:PreferenceHelper?=null
    fun getInstance():PreferenceHelper{
      return mPreferenceHelper?: PreferenceHelper()
  }
}
    private var userPrefs: SharedPreferences = MyApplication.applicationContext().getSharedPreferences("MyFile", Context.MODE_PRIVATE)

}