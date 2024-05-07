package com.bodan.maplecalendar.presentation.views.equipment

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.core.content.withStyledAttributes
import com.bodan.maplecalendar.R
import timber.log.Timber

class StarforceItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.starforceItemViewStyle,
    defStyleRes: Int = R.style.Starforce_StarforceItemViewStyle,
    starType: Int = 0
) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    init {
        context.withStyledAttributes(attrs, R.styleable.StarforceView, defStyleAttr, defStyleRes) {
            when (starType) {
                0 -> {
                    setBackgroundResource(R.drawable.ic_starforce_none)
                }

                1 -> {
                    setBackgroundResource(R.drawable.ic_starforce_yellow)
                }

                2 -> {
                    setBackgroundResource(R.drawable.ic_starforce_blue)
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        Timber.d("Drawing Star")
    }
}