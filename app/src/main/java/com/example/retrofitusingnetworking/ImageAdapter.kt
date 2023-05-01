package com.example.retrofitusingnetworking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

class ImageAdapter(var imageList: List<ImageItem>, var applicationContext: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var imageView = itemView.findViewById<PhotoView>(R.id.imgWallpaper)
        var updatedAt = itemView.findViewById<TextView>(R.id.txtUpdatedAt)
        var createdAt = itemView.findViewById<TextView>(R.id.txtCreatedAt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(applicationContext).load(imageList[position].name).into(holder.imageView)
        holder.updatedAt.text = imageList[position].updatedAt
        holder.createdAt.text = imageList[position].createdAt

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}