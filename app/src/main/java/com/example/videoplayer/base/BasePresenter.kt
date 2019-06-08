package com.example.videoplayer.base

import com.example.videoplayer.data.datamanager.AppDataManager


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
abstract class BasePresenter<V : MvpView>{
    private lateinit var mMvpView:V
    fun getMvpView():V{
        return mMvpView
    }
    fun setMvpView(mvpView: V) {
        this.mMvpView = mvpView
    }
    fun getAppDataManager():AppDataManager{
        return AppDataManager.getInstance()
    }
}
