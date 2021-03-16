package leolyoo.jiayoujiayou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val stageText: TextView = findViewById(R.id.text_stage)
        stageText.text = getString(R.string.stage, App.INSTANCE.stage)
    }
}