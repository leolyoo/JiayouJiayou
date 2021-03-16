package leolyoo.jiayoujiayou

import android.app.Application
import android.content.Intent
import android.os.Build
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*

class App : Application() {

    var tts: TextToSpeech? = null

    var stage: Int = 0
    var part: Int = 0

    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: App

    }

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            tts = TextToSpeech(this) {
                if (it == TextToSpeech.SUCCESS) {
                    val result = tts?.setLanguage(Locale.CHINA)
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(this, "지원하지 않는 언어입니다.", Toast.LENGTH_LONG).show()
                        val installIntent = Intent()
                        installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                        installIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(installIntent)
                    } else {
                        Toast.makeText(this, "TTS 초기화 성공", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "TTS 초기화 실패", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onTerminate() {
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
            tts = null
        }
        super.onTerminate()
    }

    fun speech(text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            Toast.makeText(this, "TTS : $text", Toast.LENGTH_SHORT).show()
        }
    }
}