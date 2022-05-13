package com.kat.config.ui

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

object LoadImage {

    @SuppressLint("UseCompatLoadingForDrawables")
    fun loadImageResource(image: ImageView, url: String) {
        ResourcesCompat.getDrawable()
        val imagePlaceholder = image.context.getDrawable(R.drawable.no_recourse_found)
        Picasso.get()
            .load(url)
            .placeholder()
            .error()
            .into(image)
    }

}