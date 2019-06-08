package com.example.videoplayer.data.datahelpers.apihelper

import com.example.videoplayer.data.remote.BaseRetrofit


class ApiHelper {
     fun getApi(): API {
        return BaseRetrofit.getRetrofit().create(API::class.java)
    }
}