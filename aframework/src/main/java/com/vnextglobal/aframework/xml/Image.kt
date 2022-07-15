package com.vnextglobal.aframework.xml

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

fun ImageView.progressLoading(url: String){
    load(url){
        crossfade(true)
        placeholder(buildCircularProgressDrawable(context))
    }
}

internal fun buildCircularProgressDrawable(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}