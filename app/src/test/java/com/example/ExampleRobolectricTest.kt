package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("DeutschLernen", appName)
  }

  @Test
  fun `verify german learning lessons and culture data loaded`() {
    val lessons = com.example.data.content.GermanLearningData.lessons
    assertTrue(lessons.isNotEmpty())
    assertTrue(lessons.any { it.level.startsWith("A1") })

    val cultureTopics = com.example.data.content.GermanLearningData.cultureTopics
    assertTrue(cultureTopics.isNotEmpty())

    val historyMilestones = com.example.data.content.GermanLearningData.historyMilestones
    assertTrue(historyMilestones.isNotEmpty())
  }
}
