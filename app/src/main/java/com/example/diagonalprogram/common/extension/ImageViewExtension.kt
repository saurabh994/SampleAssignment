package com.example.diagonalprogram.common.extension

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.diagonalprogram.di.module.GlideApp

@BindingAdapter(value = ["imageAsset", "placeHolder"], requireAll = false)
fun ImageView.setImageFromAsset(image: String?, placeHolder: Drawable?) {
    GlideApp.with(context)
        .asBitmap()
        .load(Uri.parse("file:///android_asset/$image"))
        .thumbnail(0.25f)
        .placeholder(placeHolder)
        .dontAnimate()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}