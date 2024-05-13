package com.bodan.maplecalendar.presentation.views.hyperstat

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.core.content.withStyledAttributes
import com.bodan.maplecalendar.R

class HyperStatItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.hyperStatItemViewStyle,
    defStyleRes: Int = R.style.HyperStat_HyperStatItemViewStyle,
    private val statType: String = "",
    private val statLevel: Int = 0
) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val hyperStatBounds = Rect()
    private val hyperStatPaint = TextPaint()

    init {
        context.withStyledAttributes(attrs, R.styleable.HyperStatView, defStyleAttr, defStyleRes) {
            hyperStatPaint.apply {
                isAntiAlias = true
                textSize = getDimensionPixelSize(
                    R.styleable.HyperStatView_hyperStatItemTextSize,
                    0
                ).toFloat()
                typeface = getFont(R.styleable.HyperStatView_hyperStatItemFontFamily)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        hyperStatPaint.getTextBounds(statType, 0, statType.length, hyperStatBounds)
        canvas.drawText(statType, left.toFloat(), top.toFloat(), hyperStatPaint)
    }
}