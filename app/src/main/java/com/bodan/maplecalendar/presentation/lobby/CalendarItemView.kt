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
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.getDayOfWeekColor
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.isSearchDateRange

@SuppressLint("ClickableViewAccessibility")
class CalendarItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.calendarItemViewStyle,
    defStyleRes: Int = R.style.Calendar_CalendarItemViewStyle,
    private val year: Int = 0,
    private val month: Int = 0,
    private val day: Int = 0,
    private val dayOfWeek: String = "",
    private val viewModel: MainViewModel? = null
) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val dayBounds = Rect()
    private val dayOfWeekBounds = Rect()
    private val dayPaint = TextPaint()
    private val dayOfWeekPaint = TextPaint()

    init {
        context.withStyledAttributes(attrs, R.styleable.CalendarView, defStyleAttr, defStyleRes) {
            setBackgroundColor(context.resources.getColor(R.color.white, context.theme))
            dayPaint.apply {
                isAntiAlias = true
                textSize = getDimensionPixelSize(
                    R.styleable.CalendarView_calendarItemTextSize,
                    0
                ).toFloat()
                color = getDateColor(year, month, day)
                typeface = getFont(R.styleable.CalendarView_calendarItemFontFamily)
                if ((dayOfWeek == "") && !isSearchDateRange(year, month, day)) {
                    alpha = 50
                    color = context.resources.getColor(R.color.gray, context.theme)
                }
            }
            dayOfWeekPaint.apply {
                isAntiAlias = true
                textSize = getDimensionPixelSize(
                    R.styleable.CalendarView_calendarItemTextSize,
                    0
                ).toFloat()
                color = getDayOfWeekColor(dayOfWeek)
                typeface = getFont(R.styleable.CalendarView_calendarItemFontFamily)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return true

        if ((dayOfWeek != "") || !isSearchDateRange(year, month, day)) return true

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                setBackgroundColor(context.resources.getColor(R.color.main, context.theme))
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                setBackgroundColor(context.resources.getColor(R.color.white, context.theme))
                invalidate()
                viewModel?.selectSearchDate(year, month, day)
            }

            MotionEvent.ACTION_MOVE -> {
                setBackgroundColor(context.resources.getColor(R.color.main, context.theme))
                invalidate()
            }

            MotionEvent.ACTION_CANCEL -> {
                setBackgroundColor(context.resources.getColor(R.color.white, context.theme))
                invalidate()
            }
        }

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (day == -1) return

        if (dayOfWeek == "") {
            val nowDate = day.toString()
            dayPaint.getTextBounds(nowDate, 0, nowDate.length, dayBounds)
            canvas.drawText(
                nowDate,
                (width / 2 - dayBounds.width() / 2).toFloat() - 2,
                (height / 2 + dayBounds.height() / 2).toFloat(),
                dayPaint
            )
        } else {
            dayOfWeekPaint.getTextBounds(dayOfWeek, 0, dayOfWeek.length, dayOfWeekBounds)
            canvas.drawText(
                dayOfWeek,
                (width / 2 - dayOfWeekBounds.width() / 2).toFloat() - 2,
                (height / 2 + dayOfWeekBounds.height() / 2).toFloat(),
                dayOfWeekPaint
            )
            setBackgroundColor(context.resources.getColor(R.color.gray, context.theme))
        }
    }
}