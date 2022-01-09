package com.sameep.iiflassignment.customviews

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.*
import android.text.style.BulletSpan
import android.text.style.LeadingMarginSpan
import android.text.style.URLSpan
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.sameep.iiflassignment.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HtmlTextView : AppCompatTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val imageGetter: GlideImageGetter by lazy {
        GlideImageGetter(this)
    }

    fun setPureHtmlText(htmlText: String?) {
        if (htmlText != null) {
            post {
                text = formatPureHtmlText(htmlText)
            }
        }
    }

    private fun formatPureHtmlText(htmlText: String): Spannable {
        val formattedHtml = HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            .split("\n")
            .filter { it.isNotEmpty() }
            .joinToString("\n")
        val spannableStringBuilder = SpannableStringBuilder(formattedHtml)
        val linkSpans = spannableStringBuilder.getSpans(
            0,
            formattedHtml.length,
            URLSpan::class.java
        )
        linkSpans.forEach { span ->
            val start = spannableStringBuilder.getSpanStart(span)
            val end = spannableStringBuilder.getSpanEnd(span)
            spannableStringBuilder.removeSpan(span)
            spannableStringBuilder.setSpan(
                CustomLinkSpan(span.url, false),
                start,
                end,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
        }
        return spannableStringBuilder
    }

    fun setHtmlText(htmlText: String?) {
        if (htmlText != null) {
            post {
                text = formatHtmlText(htmlText)
            }
        }
    }

    private fun formatHtmlText(
        htmlText: String,
           ): Spannable {
        val formattedHtml = HtmlCompat.fromHtml(
            htmlText,
            HtmlCompat.FROM_HTML_MODE_LEGACY,
            imageGetter,
            null
        ).trim()

        val spannableStringBuilder = SpannableStringBuilder(formattedHtml)
        val bulletSpans = spannableStringBuilder.getSpans(
            0,
            formattedHtml.length,
            BulletSpan::class.java
        )
        val color = ResourcesCompat.getColor(resources, R.color.blue, null)
        val gapWidth = resources.getDimensionPixelOffset(R.dimen.details_bullet_span_gap_width)
        val radius = resources.getDimensionPixelOffset(R.dimen.details_bullet_span_gap_width) / 2
        bulletSpans.forEach { bulletSpan ->
            val spanStart = spannableStringBuilder.getSpanStart(bulletSpan)
            spannableStringBuilder.setSpan(
                CustomBulletSpan(gapWidth, radius, color),
                spanStart,
                spanStart + 1,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            spannableStringBuilder.removeSpan(bulletSpan)
        }

        val linkSpans = spannableStringBuilder.getSpans(
            0,
            formattedHtml.length,
            URLSpan::class.java
        )
        linkSpans.forEach { span ->
            val start = spannableStringBuilder.getSpanStart(span)
            val end = spannableStringBuilder.getSpanEnd(span)
            spannableStringBuilder.removeSpan(span)
            spannableStringBuilder.setSpan(
                CustomLinkSpan(
                    span.url,
                    true,
                ),
                start,
                end,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
        }
        return spannableStringBuilder
    }

    private class CustomLinkSpan(
        url: String?,
        private val isUnderline: Boolean,
        @ColorInt private val color: Int? = null
    ) : URLSpan(url) {
        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.isUnderlineText = isUnderline
            if (color != null) {
                ds.color = color
            }
        }
    }

    private class CustomBulletSpan(
        val gapWidth: Int = STANDARD_GAP_WIDTH,
        @IntRange(from = 0) val bulletRadius: Int = STANDARD_BULLET_RADIUS,
        @ColorInt val color: Int = STANDARD_COLOR
    ) : LeadingMarginSpan {

        companion object {
            // Bullet is slightly bigger to avoid aliasing artifacts on mdpi devices.
            private const val STANDARD_BULLET_RADIUS = 4
            private const val STANDARD_GAP_WIDTH = 2
            private const val STANDARD_COLOR = 0
        }

        private var mBulletPath: Path? = null

        override fun getLeadingMargin(first: Boolean): Int {
            return 2 * bulletRadius + gapWidth
        }

        override fun drawLeadingMargin(
            canvas: Canvas, paint: Paint, x: Int, dir: Int,
            top: Int, baseline: Int, bottom: Int,
            text: CharSequence, start: Int, end: Int,
            first: Boolean,
            layout: Layout?
        ) {
            if ((text as Spanned).getSpanStart(this) == start) {
                val style = paint.style
                paint.style = Paint.Style.FILL
                val oldColor = paint.color
                paint.color = color

                val yPosition = if (layout != null) {
                    val line = layout.getLineForOffset(start)
                    layout.getLineBaseline(line).toFloat() - bulletRadius * 2f
                } else {
                    (top + bottom) / 2f
                }

                val xPosition = (x + dir * bulletRadius).toFloat()

                if (canvas.isHardwareAccelerated) {
                    if (mBulletPath == null) {
                        mBulletPath = Path()
                        mBulletPath!!.addCircle(
                            0.0f,
                            0.0f,
                            bulletRadius.toFloat(),
                            Path.Direction.CW
                        )
                    }

                    canvas.save()
                    canvas.translate(xPosition, yPosition)
                    canvas.drawPath(mBulletPath!!, paint)
                    canvas.restore()
                } else {
                    canvas.drawCircle(xPosition, yPosition, bulletRadius.toFloat(), paint)
                }

                paint.color = oldColor
                paint.style = style
            }
        }
    }

    private inner class GlideImageGetter(
        private val htmlTextView: TextView
    ) : Html.ImageGetter {

        override fun getDrawable(url: String): Drawable {
            val holder = BitmapDrawablePlaceHolder(htmlTextView.context.resources, null)

            GlobalScope.launch(Dispatchers.IO) {
                runCatching {
                    val bitmap = Glide.with(htmlTextView)
                        .asBitmap()
                        .load(url)
                        .transform(CenterInside())
                        .submit()
                        .get()
                    val drawable = BitmapDrawable(htmlTextView.context.resources, bitmap)
                    val width = htmlTextView.rootView.context.resources.displayMetrics.widthPixels
                    val height =
                        if (drawable.intrinsicHeight >= ((width * 9) / 16)) drawable.intrinsicHeight else (width * 9) / 16
                    drawable.setBounds(0, 0, width, height)
                    holder.setDrawable(drawable)
                    holder.setBounds(0, 0, width, height)

                    withContext(Dispatchers.Main) { htmlTextView.text = htmlTextView.text }
                }
            }

            return holder
        }

        private inner class BitmapDrawablePlaceHolder(res: Resources, bitmap: Bitmap?) :
            BitmapDrawable(res, bitmap) {
            private var drawable: Drawable? = null

            override fun draw(canvas: Canvas) {
                drawable?.run { draw(canvas) }
            }

            fun setDrawable(drawable: Drawable) {
                this.drawable = drawable
            }
        }
    }
}