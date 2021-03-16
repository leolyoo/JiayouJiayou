package leolyoo.jiayoujiayou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BlankQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_quiz)
    }

    fun onChoice1Click(v: View) {}
    fun onChoice2Click(v: View) {}
    fun onChoice3Click(v: View) {}
    fun onChoice4Click(v: View) {}
}