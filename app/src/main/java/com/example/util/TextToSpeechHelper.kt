package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {
  private var tts: TextToSpeech? = null
  private var isInitialized = false

  init {
    try {
      tts = TextToSpeech(context.applicationContext, this)
    } catch (e: Exception) {
      Log.e("TTSHelper", "Error initializing TTS", e)
    }
  }

  override fun onInit(status: Int) {
    if (status == TextToSpeech.SUCCESS) {
      val result = tts?.setLanguage(Locale.GERMAN)
      if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        Log.w("TTSHelper", "German TTS not fully supported, falling back to default")
      } else {
        isInitialized = true
      }
    } else {
      Log.e("TTSHelper", "TTS Initialization failed with status: $status")
    }
  }

  fun speak(text: String, isSlow: Boolean = false) {
    if (!isInitialized || tts == null) {
      // Retry setting locale if needed
      tts?.language = Locale.GERMAN
    }
    try {
      tts?.stop()
      tts?.setSpeechRate(if (isSlow) 0.72f else 1.0f)
      tts?.setPitch(1.0f)
      tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "GermanSpeech_${System.currentTimeMillis()}")
    } catch (e: Exception) {
      Log.e("TTSHelper", "Error speaking text: $text", e)
    }
  }

  fun stop() {
    try {
      tts?.stop()
    } catch (_: Exception) {}
  }

  fun shutdown() {
    try {
      tts?.stop()
      tts?.shutdown()
      tts = null
    } catch (_: Exception) {}
  }
}
