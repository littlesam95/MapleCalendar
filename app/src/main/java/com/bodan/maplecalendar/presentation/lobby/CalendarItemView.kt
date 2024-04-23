package com.bodan.maplecalendar.presentation.lobby

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.core.content.withStyledAttributes
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.getDateColor
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.isSameMonth
import org.joda.time.DateTime

class CalendarItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.calendarItemViewStyle,
    defStyleRes: Int = R.style.Calendar_CalendarItemViewStyle,
    private val date: DateTime = DateTime(),
    private val firstDayOfMonth: DateTime = DateTime()
) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val textBounds = Rect()
    private val textPaint = TextPaint()

    init {
        context.withStyledAttributes(attrs, R.styleable.CalendarView, defStyleAttr, defStyleRes) {
            textPaint.apply {
                isAntiAlias = true
                textSize = getDimensionPixelSize(R.styleable.CalendarView_calendarItemTextSize, 0).toFloat()
                color = getDateColor(date.dayOfWeek)
                if (!isSameMonth(date, firstDayOfMonth)) alpha = 50
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val nowDate = date.dayOfMonth().toString()
        textPaint.getTextBounds(nowDate, 0, nowDate.length, textBounds)
        canvas.drawText(
            nowDate,
            (width / 2 - textBounds.width() / 2).toFloat() - 2,
            (height / 2 + textBounds.height() / 2).toFloat(),
            textPaint
        )
    }
}