package leolyoo.jiayoujiayou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onStage1Click(view: View) {
        App.INSTANCE.stage = 1
        startActivity(Intent(this, StageActivity::class.java))
    }
}