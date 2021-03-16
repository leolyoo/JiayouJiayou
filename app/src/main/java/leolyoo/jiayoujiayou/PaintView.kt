package leolyoo.jiayoujiayou

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View

class PaintView(context: Context) : View(context) {
    val points = ArrayList<Point>()
    private val paint = Paint()
    val color = Color.BLACK

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.strokeWidth = 4F
        for (i in 1 until points.size) {
            paint.color = points[i].color
            if (!points[i].check)
                continue
            canvas?.drawLine(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> points.add(Point(event.x, event.y, false, color))
            MotionEvent.ACTION_MOVE -> points.add(Point(event.x, event.y, true, color))
            MotionEvent.ACTION_UP -> performClick()
        }
        invalidate()
        return true
    }

    override fun performClick(): Boolean {
        Log.d(javaClass.name, "performClick()")
        return super.performClick()
    }
}