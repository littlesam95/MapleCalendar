package com.bodan.maplecalendar.presentation.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.presentation.views.calendar.DayType

@BindingAdapter("app:calendar_background")
fun ConstraintLayout.bindBackground(backgroundResId: Int) {
    setBackgroundResource(backgroundResId)
}

@BindingAdapter("app:day_color")
fun TextView.bindTextColor(dayType: DayType) {
    when (dayType) {
        DayType.SATURDAY -> setTextColor(resources.getColor(R.color.submit, context.theme))

        DayType.SUNDAY -> setTextColor(resources.getColor(R.color.alert, context.theme))

        else -> setTextColor(resources.getColor(R.color.black, context.theme))
    }
}

@BindingAdapter("app:grade_color")
fun TextView.bindTextColor(colorResId: Int) {
    setTextColor(resources.getColor(colorResId, context.theme))
}

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