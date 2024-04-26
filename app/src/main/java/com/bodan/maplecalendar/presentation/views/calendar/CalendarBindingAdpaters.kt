package com.bodan.maplecalendar.presentation.views.calendar

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.bodan.maplecalendar.R

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