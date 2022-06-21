package com.marianunez.ghibliworld.commons

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ImageView.loadImageByUrl(url: String?) =
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(ColorDrawable(Color.LTGRAY))
        .into(this)


// función para inflar vistas
fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater
        .from(context)
        .inflate(layoutRes, this, false)