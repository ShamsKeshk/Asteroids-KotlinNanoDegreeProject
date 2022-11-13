package com.example.nasaapp.bindingAdapters

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.example.nasaapp.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage","shouldLoadImage", requireAll = true)
fun loadRemoteImage(imageView: ImageView, imageUrl: String?,shouldLoadImage: Boolean = false) {
    if (!shouldLoadImage) return

    imageUrl?.let {
        Picasso.get().load(it).into(imageView)
    }
}

@BindingAdapter("loadImageResource")
fun loadImageResource(imageView: ImageView, @DrawableRes imageResource: Int) {
    imageView.setImageResource(imageResource)
}

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage", requireAll = true)
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("asteroidStatusContentDescription", requireAll = true)
fun bindDetailsStatusContentDescription(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.contentDescription = imageView.context.getString(R.string.potentially_hazardous_asteroid_image)
    } else {
        imageView.contentDescription = imageView.context.getString(R.string.not_hazardous_asteroid_image)
    }
}