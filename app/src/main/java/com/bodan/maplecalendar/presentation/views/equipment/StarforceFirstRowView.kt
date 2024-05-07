package com.bodan.maplecalendar.presentation.views.equipment

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import com.bodan.maplecalendar.R
import kotlin.math.max
import kotlin.math.min

class StarforceFirstRowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.starforceViewStyle,
    defStyleRes: Int = R.style.Starforce_StarforceViewStyle
) : ViewGroup(context, attrs, defStyleAttr, defStyleRes) {

    private var _starWidth: Float = 0F
    private var _starHeight: Float = 0F
    private var _childCount: Float = 16F

    init {
        context.withStyledAttributes(attrs, R.styleable.StarforceView, defStyleAttr, defStyleRes) {
            _starWidth = getDimension(R.styleable.StarforceView_starWidth, 0F)
            _starHeight = getDimension(R.styleable.StarforceView_starHeight, 0F)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measuredWidth = paddingStart + paddingEnd + max(
            suggestedMinimumWidth,
            (_starWidth * _childCount).toInt()
        )
        val measuredHeight = paddingTop + paddingBottom + max(
            suggestedMinimumHeight,
            _starHeight.toInt()
        )
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        val childWidth = ((width * 2) / (_childCount * 2)).toInt()

        var childLeft = 0
        for ((index, child) in children.withIndex()) {
            child.layout(
                childLeft,
                0,
                (childLeft + childWidth),
                height
            )
            childLeft += childWidth
            if ((index + 1) % 5 == 0) {
                childLeft += (childWidth / 2)
            }
        }
    }

    private fun setChildCount(firstMaxStarforceValue: Int) {
        _childCount = 0F
        if (firstMaxStarforceValue >= 6) {
            _childCount += 0.5F
        }
        if (firstMaxStarforceValue >= 11) {
            _childCount += 0.5F
        }
        _childCount += firstMaxStarforceValue.toFloat()
    }

    fun initStarforceView(starforceValue: Int, maxStarforceValue: Int) {
        val firstMaxStarforceValue = min(15, maxStarforceValue)
        setChildCount(firstMaxStarforceValue)
        val firstStarforceValue = min(15, starforceValue)

        requestLayout()

        for (starforce in 0 until firstStarforceValue) {
            addView(
                StarforceItemView(
                    context = context,
                    starType = 1
                )
            )
        }
        for (starforce in firstStarforceValue until firstMaxStarforceValue) {
            addView(
                StarforceItemView(
                    context = context
                )
            )
        }
    }
}