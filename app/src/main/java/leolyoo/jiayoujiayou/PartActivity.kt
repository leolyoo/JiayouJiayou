package leolyoo.jiayoujiayou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part)

        val stageText: TextView = findViewById(R.id.text_stage)
        stageText.text = getString(R.string.stage, App.INSTANCE.stage)

        val partText: TextView = findViewById(R.id.text_part)
        partText.text = getString(R.string.part, App.INSTANCE.part)

        val sentenceLayoutManager = LinearLayoutManager(this)
        val sentenceRecyclerView: RecyclerView = findViewById(R.id.recycler_sentence)
        val sentenceAdapter = SentenceAdapter(loadSentences(App.INSTANCE.stage, App.INSTANCE.part))
        sentenceRecyclerView.adapter = sentenceAdapter
        sentenceRecyclerView.layoutManager = sentenceLayoutManager

        val wordLayoutManager = LinearLayoutManager(this)
        val wordRecyclerView: RecyclerView = findViewById(R.id.recycler_word)
        val wordAdapter = WordAdapter(loadWords(App.INSTANCE.stage, App.INSTANCE.part))
        wordRecyclerView.adapter = wordAdapter
        wordRecyclerView.layoutManager = wordLayoutManager
    }

    fun onWordQuizClick(view: View) = startActivity(Intent(this, WordQuizActivity::class.java))
    fun onBlankQuizClick(view: View) = startActivity(Intent(this, BlankQuizActivity::class.java))
    fun onArrangeQuizClick(view: View) {}
}