package com.bodan.maplecalendar.presentation.lobby

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.MotionEvent
import android.view.View
import androidx.core.content.withStyledAttributes
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.presentation.MainViewModel
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.getDateColor
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.isSearchDateRange
import timber.log.Timber

@SuppressLint("ClickableViewAccessibility")
class CalendarItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.calendarItemViewStyle,
    defStyleRes: Int = R.style.Calendar_CalendarItemViewStyle,
    private val year: Int = 0,
    private val month: Int = 0,
    private val day: Int = 0,
    private val viewModel: MainViewModel? = null
) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val textBounds = Rect()
    private val textPaint = TextPaint()

    init {
        context.withStyledAttributes(attrs, R.styleable.CalendarView, defStyleAttr, defStyleRes) {
            textPaint.apply {
                isAntiAlias = true
                textSize = getDimensionPixelSize(
                    R.styleable.CalendarView_calendarItemTextSize,
                    0
                ).toFloat()
                color = getDateColor(year, month, day)
                typeface = getFont(R.styleable.CalendarView_calendarItemFontFamily)
                if (!isSearchDateRange(year, month, day)) {
                    alpha = 50
                    color = context.resources.getColor(R.color.gray, context.theme)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return true

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                invalidate()
                Timber.d("${year}년 ${month}월 ${day}일")
                if (isSearchDateRange(year, month, day)) viewModel?.selectSearchDate(
                    year,
                    month,
                    day
                )
            }
        }

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (day == -1) return

        val nowDate = day.toString()
        textPaint.getTextBounds(nowDate, 0, nowDate.length, textBounds)
        canvas.drawText(
            nowDate,
            (width / 2 - textBounds.width() / 2).toFloat() - 2,
            (height / 2 + textBounds.height() / 2).toFloat(),
            textPaint
        )
    }
}