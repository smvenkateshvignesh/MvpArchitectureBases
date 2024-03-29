package com.example.videoplayer.base

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import com.example.videoplayer.R
import android.content.Context.CONNECTIVITY_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.content.Context


/**
 * Created by Venkatesh Vignesh on 6/7/2019.
 */
abstract class BaseActivity<P : BasePresenter<V>, V : MvpView> : AppCompatActivity(), MvpView {
    private lateinit var mPresenter: P
    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        mPresenter = setPresenter()
        mPresenter.setMvpView(setMvpView())
        init()

    }

    abstract fun setLayout(): Int
    abstract fun setPresenter(): P
    abstract fun setMvpView(): V
    abstract fun init()

    fun getPresenter(): P {
        return mPresenter
    }

    fun showToast(mess: String) {
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        try {
            if (progressDialog != null && progressDialog?.isShowing!!) {
//                progressDialog?.dismiss()
                return
            }
            progressDialog = Dialog(this, R.style.Theme_Dialog)
            progressDialog?.setCanceledOnTouchOutside(false)
            progressDialog?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            progressDialog?.setContentView(com.example.videoplayer.R.layout.show_progress_dialog)
            progressDialog?.window!!.setBackgroundDrawable(ColorDrawable(0))
            progressDialog?.window!!.attributes.windowAnimations = com.example.videoplayer.R.style.dialog_open_animation
            progressDialog?.setCancelable(false)
            progressDialog?.window!!.setGravity(Gravity.CENTER)
            progressDialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun hideProgress() {
        if (progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
            progressDialog =null
        }

    }

    override fun showError(mess: String) {
        showToast(mess)
    }
    fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }
}