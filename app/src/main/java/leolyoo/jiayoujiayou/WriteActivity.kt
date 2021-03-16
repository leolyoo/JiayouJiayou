package leolyoo.jiayoujiayou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import com.bumptech.glide.Glide

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val gif = intent.getIntExtra(EXTRA_GIF, R.raw.gif_error)

        val paintView = PaintView(this)
        findViewById<GridLayout>(R.id.view_paint).addView(paintView)

        val gifImageView:ImageView = findViewById(R.id.image_gif)
        Glide.with(this).load(gif).into(gifImageView)

        findViewById<Button>(R.id.button_clear).setOnClickListener {
            paintView.points.clear()
            paintView.invalidate()
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}