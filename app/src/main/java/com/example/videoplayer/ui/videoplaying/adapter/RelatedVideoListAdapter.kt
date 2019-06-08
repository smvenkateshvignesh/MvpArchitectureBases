package com.example.videoplayer.ui.videoplaying.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.videoplayer.R
import com.example.videoplayer.ui.videoList.VideoListModel


class RelatedVideoListAdapter(private val mContext: Context, private val videoList: ArrayList<VideoListModel>) :
    RecyclerView.Adapter<RelatedVideoListAdapter.MyHolder>() {
    private var onClickListener: OnClickListener?=null

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgVideoThumbnail: ImageView = itemView.findViewById(R.id.imgRelatedVideoThumbnail)
        private val tvVideoDescription: TextView = itemView.findViewById(R.id.tvRelatedVideoDescription)
        private val tvVideoTitle: TextView = itemView.findViewById(R.id.tvRelatedVideoTitle)
        fun onBind(videoListModel: VideoListModel) {
            tvVideoTitle.text = videoListModel.title
            tvVideoDescription.text = videoListModel.description
            Glide.with(mContext).load(videoListModel.thumb).into(imgVideoThumbnail)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.related_video_layout, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(videoList[holder.adapterPosition])
        holder.itemView.setOnClickListener{
            onClickListener?.onClick(videoList,holder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        return videoList.size
    }
    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }
    interface OnClickListener{
        fun onClick(videoList: ArrayList<VideoListModel>, adapterPosition: Int)
    }
}
