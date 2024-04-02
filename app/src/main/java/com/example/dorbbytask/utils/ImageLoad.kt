package com.example.dorbbytask.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.dorbbytask.R

object ImageLoad {
    fun loadImage(context: Context, imageUrl: String?, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_launcher_background) // Placeholder image while loading
                .diskCacheStrategy(DiskCacheStrategy.ALL)) // Caching strategy
            .into(imageView)
    }
}