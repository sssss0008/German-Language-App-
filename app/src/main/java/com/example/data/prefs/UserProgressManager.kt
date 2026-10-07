package com.example.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.data.model.AppLanguage
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserProgressManager(context: Context) {
  private val prefs: SharedPreferences =
    context.getSharedPreferences("deutsch_lernen_prefs", Context.MODE_PRIVATE)

  var currentLanguage: AppLanguage
    get() {
      val code = prefs.getString("selected_language", AppLanguage.ENGLISH.code)
      return AppLanguage.entries.find { it.code == code } ?: AppLanguage.ENGLISH
    }
    set(value) {
      prefs.edit().putString("selected_language", value.code).apply()
    }

  var isSlowAudio: Boolean
    get() = prefs.getBoolean("is_slow_audio", false)
    set(value) = prefs.edit().putBoolean("is_slow_audio", value).apply()

  var derDieDasHighScore: Int
    get() = prefs.getInt("der_die_das_high_score", 0)
    set(value) = prefs.edit().putInt("der_die_das_high_score", value).apply()

  var totalQuizzesCompleted: Int
    get() = prefs.getInt("total_quizzes_completed", 0)
    set(value) = prefs.edit().putInt("total_quizzes_completed", value).apply()

  var totalCorrectAnswers: Int
    get() = prefs.getInt("total_correct_answers", 0)
    set(value) = prefs.edit().putInt("total_correct_answers", value).apply()

  fun getCompletedLessons(): Set<String> {
    return prefs.getStringSet("completed_lessons", emptySet()) ?: emptySet()
  }

  fun setLessonCompleted(lessonId: String) {
    val current = getCompletedLessons().toMutableSet()
    current.add(lessonId)
    prefs.edit().putStringSet("completed_lessons", current).apply()
  }

  fun getBookmarkedVocab(): Set<String> {
    return prefs.getStringSet("bookmarked_vocab", emptySet()) ?: emptySet()
  }

  fun toggleBookmarkVocab(vocabId: String): Boolean {
    val current = getBookmarkedVocab().toMutableSet()
    val isAdded = if (current.contains(vocabId)) {
      current.remove(vocabId)
      false
    } else {
      current.add(vocabId)
      true
    }
    prefs.edit().putStringSet("bookmarked_vocab", current).apply()
    return isAdded
  }

  fun getDailyStreak(): Int {
    val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    val lastDate = prefs.getString("last_active_date", "")
    var streak = prefs.getInt("current_streak", 1)

    if (lastDate != today) {
      if (lastDate.isNullOrEmpty()) {
        streak = 1
      } else {
        try {
          val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
          val d1 = sdf.parse(lastDate)
          val d2 = sdf.parse(today)
          if (d1 != null && d2 != null) {
            val diffDays = ((d2.time - d1.time) / (1000 * 60 * 60 * 24)).toInt()
            streak = if (diffDays == 1) streak + 1 else if (diffDays > 1) 1 else streak
          }
        } catch (_: Exception) {
          streak = 1
        }
      }
      prefs.edit()
        .putString("last_active_date", today)
        .putInt("current_streak", streak)
        .apply()
    }
    return streak
  }

  fun resetAllProgress() {
    prefs.edit()
      .remove("completed_lessons")
      .remove("bookmarked_vocab")
      .remove("der_die_das_high_score")
      .remove("total_quizzes_completed")
      .remove("total_correct_answers")
      .putInt("current_streak", 1)
      .apply()
  }
}
