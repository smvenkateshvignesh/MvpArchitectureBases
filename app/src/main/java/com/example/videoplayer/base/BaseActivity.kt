package com.example.videoplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Venkatesh Vignesh on 6/7/2019.
 */
abstract class BaseActivity<P :BasePresenter<V>,V:MvpView>:AppCompatActivity(),MvpView{
private lateinit var mPresenter:P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        mPresenter = setPresenter()
        mPresenter.setMvpView(setMvpView())
        init()

    }
    abstract fun setLayout():Int
    abstract fun setPresenter():P
    abstract fun setMvpView():V
    abstract fun init()

    fun getPresenter():P{
        return mPresenter
    }
    fun showToast(mess:String){
        Toast.makeText(this,mess,Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress() {

    }

    override fun showProgress() {

    }
}