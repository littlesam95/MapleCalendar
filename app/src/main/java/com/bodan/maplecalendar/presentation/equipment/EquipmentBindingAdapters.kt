package com.bodan.maplecalendar.presentation.equipment

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:grade_color")
fun TextView.bindTextColor(colorResId: Int) {
    setTextColor(resources.getColor(colorResId, context.theme))
}