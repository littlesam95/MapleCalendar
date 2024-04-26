package com.bodan.maplecalendar.presentation.views.lobby

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

@BindingAdapter("app:profileImage")
fun ImageView.bindUrl(url: String?) {
    load(url)
}

@BindingAdapter("app:submitData")
fun <T, VH : RecyclerView.ViewHolder> RecyclerView.bindItems(items: List<T>) {
    val adapter = this.adapter
    adapter?.let {
        val listAdapter: ListAdapter<T, VH> = it as ListAdapter<T, VH>
        listAdapter.submitList(items)
    }
}