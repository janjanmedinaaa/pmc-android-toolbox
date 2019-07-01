package com.paulmarkcastillo.androidtoolbox.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.paulmarkcastillo.androidtoolbox.R
import com.paulmarkcastillo.androidtoolbox.converters.DisplayUnitConverter

@SuppressLint("AppCompatCustomView")
class CustomButton(context: Context, attrs: AttributeSet?) : AppCompatButton(context, attrs) {
    private lateinit var mainTextPaint: Paint
    private lateinit var subTextPaint: Paint
    private val strokeWidth = 2f
    private var radius = 8f
    private var primaryColor = 0
    private var secondaryColor = 0
    private var highlighted: Boolean
    private var roundedCorners: Boolean
    private var subText: String?
    private var subTextSize = textSize
    private var subTextColor = 0

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomButton,
            0,
            0
        ).apply {
            highlighted = getBoolean(R.styleable.CustomButton_highlighted, false)

            primaryColor = getColor(
                R.styleable.CustomButton_primaryColor,
                ContextCompat.getColor(context, android.R.color.black)
            )

            secondaryColor = getColor(
                R.styleable.CustomButton_secondaryColor,
                ContextCompat.getColor(context, android.R.color.white)
            )

            roundedCorners = getBoolean(R.styleable.CustomButton_roundedCorners, true)

            radius = getDimension(R.styleable.CustomButton_cornerRadius, radius)

            if (highlighted) {
                setTextColor(secondaryColor)
            } else {
                setTextColor(primaryColor)
            }

            subText = getString(R.styleable.CustomButton_subText)

            subTextColor = getColor(
                R.styleable.CustomButton_subTextColor,
                currentTextColor
            )

            subTextSize = getDimension(
                R.styleable.CustomButton_subTextSize,
                (textSize * .72).toFloat()
            )
        }

        if (!subText.isNullOrEmpty()) {
            mainTextPaint = Paint()
            subTextPaint = Paint()
            mainTextPaint.textSize = textSize
            mainTextPaint.color = currentTextColor
            mainTextPaint.typeface = typeface
            mainTextPaint.textAlign = Paint.Align.CENTER
            mainTextPaint.isAntiAlias = true

            subTextPaint.textSize = subTextSize
            subTextPaint.typeface = typeface
            subTextPaint.color = subTextColor
            subTextPaint.textAlign = Paint.Align.CENTER
            subTextPaint.isAntiAlias = true
        }

        isAllCaps = false
        background = createShape()
    }

    override fun onDraw(canvas: Canvas) {
        if (!subText.isNullOrEmpty()) {
            val xCenterCoordinate = (width * .5).toFloat()
            val mainTextYCoordinates = (height * .48).toFloat()
            val subTextYCoordinates = (height * .78).toFloat()
            canvas.drawText(
                text.toString(),
                xCenterCoordinate,
                mainTextYCoordinates,
                mainTextPaint
            )
            canvas.drawText(
                subText ?: "",
                xCenterCoordinate,
                subTextYCoordinates,
                subTextPaint
            )
        } else {
            super.onDraw(canvas)
        }
    }

    private fun createShape(): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        if (roundedCorners) {
            gradientDrawable.cornerRadius = convertDpToPx(radius)
        }
        if (highlighted) {
            gradientDrawable.setColor(primaryColor)
        } else {
            gradientDrawable.setStroke(convertDpToPx(strokeWidth).toInt(), primaryColor)
        }
        return gradientDrawable
    }

    private fun convertDpToPx(dp: Float): Float {
        val displayUnitConverter = DisplayUnitConverter()
        return displayUnitConverter.convertDpToPx(dp)
    }
}