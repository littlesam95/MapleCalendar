package com.bodan.maplecalendar.presentation.views.hyperstat

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.domain.entity.CharacterHyperStatInfo
import kotlin.math.max

class HyperStatView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.hyperStatViewStyle,
    defStyleRes: Int = R.style.HyperStat_HyperStatViewStyle
) : ViewGroup(context, attrs, defStyleAttr, defStyleRes) {

    private val _itemCount: Int = 10
    private var _hyperStatItemHeight: Float = 0F

    init {
        context.withStyledAttributes(attrs, R.styleable.HyperStatView, defStyleAttr, defStyleRes) {
            _hyperStatItemHeight = getDimension(R.styleable.HyperStatView_hyperStatItemHeight, 0F)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = paddingTop + paddingBottom + max(
            suggestedMinimumHeight,
            (_hyperStatItemHeight * _itemCount).toInt()
        )
        setMeasuredDimension(width, height)
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        val childHeight = height / _itemCount

        var childTop = 0
        for (child in children) {
            child.layout(
                0,
                childTop,
                width,
                childTop + childHeight
            )
            childTop += childHeight
        }
    }

    fun initHyperStatView(hyperStatInfos: List<CharacterHyperStatInfo>) {
        for (hyperStatInfo in hyperStatInfos) {
            addView(
                HyperStatItemView(
                    context = context,
                    statType = hyperStatInfo.statType,
                    statLevel = hyperStatInfo.statLevel
                )
            )
        }
    }
}