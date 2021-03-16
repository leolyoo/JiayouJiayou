package leolyoo.jiayoujiayou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class StageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage)

        val stageText: TextView = findViewById(R.id.text_stage)
        stageText.text = getString(R.string.stage, App.INSTANCE.stage)
    }

    fun onVideoClick(view: View) {
        startActivity(Intent(this, VideoActivity::class.java))
    }

    fun onPart1Click(view: View) {
        App.INSTANCE.part = 1
        startActivity(Intent(this, PartActivity::class.java))
    }

    fun onPart2Click(view: View) {
        App.INSTANCE.part = 2
        startActivity(Intent(this, PartActivity::class.java))
    }

    fun onExamClick(view: View) {
        startActivity(Intent(this, ExamActivity::class.java))
    }
}