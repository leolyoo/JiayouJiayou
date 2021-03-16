package leolyoo.jiayoujiayou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class WordQuizActivity : AppCompatActivity(), WordQuizManager.Listener {
    private lateinit var questionTextView: TextView
    private lateinit var choice1Button: Button
    private lateinit var choice2Button: Button
    private lateinit var choice3Button: Button
    private lateinit var choice4Button: Button
    private lateinit var wordQuizManager: WordQuizManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_quiz)
        questionTextView = findViewById(R.id.text_question)
        choice1Button = findViewById(R.id.button_choice1)
        choice2Button = findViewById(R.id.button_choice2)
        choice3Button = findViewById(R.id.button_choice3)
        choice4Button = findViewById(R.id.button_choice4)
        wordQuizManager = WordQuizManager(loadWords(App.INSTANCE.stage, App.INSTANCE.part), this)
    }

    fun onChoice1Click(v: View) {
        wordQuizManager.choose(1)
    }

    fun onChoice2Click(v: View) {
        wordQuizManager.choose(2)
    }

    fun onChoice3Click(v: View) {
        wordQuizManager.choose(3)
    }

    fun onChoice4Click(v: View) {
        wordQuizManager.choose(4)
    }

    override fun onUpdate(
        life: Int,
        countRemaining: Int,
        question: String,
        choice1: String,
        choice2: String,
        choice3: String,
        choice4: String
    ) {
        questionTextView.text = question
        choice1Button.text = choice1
        choice2Button.text = choice2
        choice3Button.text = choice3
        choice4Button.text = choice4
    }

    override fun onCorrect() {
        Toast.makeText(this, "Good!", Toast.LENGTH_SHORT).show()
    }

    override fun onWrong() {
        Toast.makeText(this, "Bad...", Toast.LENGTH_SHORT).show()
    }

    override fun onPass(countWrong: Int) {
        Toast.makeText(this, "Pass!\n틀린 문제: " + countWrong + "개", Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onFail() {
        Toast.makeText(this, "Fail...", Toast.LENGTH_LONG).show()
        finish()
    }
}