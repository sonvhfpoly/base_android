package com.vnextglobal.aframework.xml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

fun ViewGroup.getLayoutInflater(): LayoutInflater = LayoutInflater.from(this.context)

open class BaseBindingHolder<VB : ViewBinding>(protected val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
}