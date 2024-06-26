package com.bodan.maplecalendar.presentation.utils

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.domain.entity.EventType
import com.bodan.maplecalendar.presentation.views.calendar.DayType
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

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

@BindingAdapter("app:image_background")
fun ImageView.bindBackground(backgroundResId: Int) {
    setBackgroundResource(backgroundResId)
}

@BindingAdapter("app:set_chip")
fun ChipGroup.bindChipGroup(eventTypes: List<EventType>) {
    removeAllViews()

    for (eventType in eventTypes) {
        val chipView = Chip(context).apply {
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setLayoutParams(layoutParams)

            setChipBackgroundColorResource(eventType.backgroundColor)
            setChipStrokeColorResource(eventType.backgroundColor)

            text = eventType.tag
            maxLines = 1
            setTextAppearanceResource(R.style.AppTheme_EventTypeChipText)
            setTextColor(resources.getColorStateList(eventType.textColor, context.theme))

            isCheckable = false
            isClickable = false

        }
        addView(chipView)
    }
    chipSpacingHorizontal = 8
}

@BindingAdapter("app:submitData")
fun <T, VH : RecyclerView.ViewHolder> RecyclerView.bindItems(items: List<T>) {
    val adapter = this.adapter
    adapter?.let {
        val listAdapter: ListAdapter<T, VH> = it as ListAdapter<T, VH>
        listAdapter.submitList(items)
    }
}