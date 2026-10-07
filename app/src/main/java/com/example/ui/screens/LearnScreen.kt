package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.content.GermanLearningData
import com.example.data.model.AppLanguage
import com.example.data.model.Lesson
import com.example.data.model.LocalizationManager
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.VocabularyCard
import com.example.ui.theme.GermanGold

@Composable
fun LearnScreen(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  completedLessonIds: Set<String>,
  onLessonCompleted: (String) -> Unit,
  bookmarkedVocabIds: Set<String>,
  onToggleBookmark: (String) -> Unit,
  selectedLessonIdFromExternal: String? = null,
  modifier: Modifier = Modifier
) {
  var selectedFilter by remember { mutableStateOf("ALL") }
  var activeLesson by remember {
    mutableStateOf(
      if (selectedLessonIdFromExternal != null) {
        GermanLearningData.lessons.find { it.id == selectedLessonIdFromExternal }
      } else null
    )
  }

  // Handle hardware back when viewing a lesson detail
  if (activeLesson != null) {
    BackHandler {
      activeLesson = null
    }
  }

  AnimatedContent(targetState = activeLesson, label = "LessonTransition") { targetLesson ->
    if (targetLesson != null) {
      LessonDetailView(
        lesson = targetLesson,
        currentLanguage = currentLanguage,
        onSpeak = onSpeak,
        isCompleted = completedLessonIds.contains(targetLesson.id),
        onToggleCompleted = { onLessonCompleted(targetLesson.id) },
        bookmarkedVocabIds = bookmarkedVocabIds,
        onToggleBookmark = onToggleBookmark,
        onBack = { activeLesson = null }
      )
    } else {
      Column(
        modifier = modifier
          .fillMaxSize()
          .testTag("learn_screen")
      ) {
        // Filter Chips Row
        val filters = listOf(
          "ALL" to LocalizationManager.string("level_all", currentLanguage),
          "A1" to LocalizationManager.string("level_a1", currentLanguage),
          "A2" to LocalizationManager.string("level_a2", currentLanguage),
          "B1" to LocalizationManager.string("level_b1", currentLanguage)
        )

        ScrollableTabRow(
          selectedTabIndex = filters.indexOfFirst { it.first == selectedFilter }.coerceAtLeast(0),
          edgePadding = 16.dp,
          divider = {}
        ) {
          filters.forEach { (key, label) ->
            Tab(
              selected = selectedFilter == key,
              onClick = { selectedFilter = key },
              text = {
                Text(
                  text = label,
                  fontWeight = if (selectedFilter == key) FontWeight.Bold else FontWeight.Normal
                )
              }
            )
          }
        }

        val filteredLessons = remember(selectedFilter) {
          if (selectedFilter == "ALL") {
            GermanLearningData.lessons
          } else {
            GermanLearningData.lessons.filter { it.level.startsWith(selectedFilter) }
          }
        }

        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 96.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          items(filteredLessons, key = { it.id }) { lesson ->
            val isCompleted = completedLessonIds.contains(lesson.id)
            Card(
              modifier = Modifier
                .fillMaxWidth()
                .testTag("lesson_card_${lesson.id}")
                .clickable { activeLesson = lesson },
              shape = RoundedCornerShape(18.dp),
              colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
              ),
              elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                // Level Badge Circle
                Surface(
                  shape = CircleShape,
                  color = if (isCompleted) Color(0xFF10B981) else MaterialTheme.colorScheme.primaryContainer,
                  modifier = Modifier.size(52.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    if (isCompleted) {
                      Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Completed",
                        tint = Color.White
                      )
                    } else {
                      Text(
                        text = lesson.level,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary
                      )
                    }
                  }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = lesson.getTitle(currentLanguage),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = lesson.getDescription(currentLanguage),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(
                      color = MaterialTheme.colorScheme.surfaceVariant,
                      shape = RoundedCornerShape(6.dp)
                    ) {
                      Text(
                        text = "${lesson.vocabulary.size} ${LocalizationManager.string("lesson_vocab", currentLanguage)}",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                    if (isCompleted) {
                      Surface(
                        color = Color(0xFF10B981).copy(alpha = 0.15f),
                        shape = RoundedCornerShape(6.dp)
                      ) {
                        Text(
                          text = LocalizationManager.string("completed", currentLanguage),
                          color = Color(0xFF047857),
                          fontWeight = FontWeight.Bold,
                          style = MaterialTheme.typography.labelSmall,
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                      }
                    }
                  }
                }

                Icon(
                  imageVector = Icons.Default.ChevronRight,
                  contentDescription = null,
                  tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun LessonDetailView(
  lesson: Lesson,
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  isCompleted: Boolean,
  onToggleCompleted: () -> Unit,
  bookmarkedVocabIds: Set<String>,
  onToggleBookmark: (String) -> Unit,
  onBack: () -> Unit
) {
  var selectedTab by remember { mutableStateOf(0) }
  val tabs = listOf(
    LocalizationManager.string("lesson_vocab", currentLanguage),
    LocalizationManager.string("lesson_grammar", currentLanguage),
    LocalizationManager.string("lesson_dialogue", currentLanguage),
    LocalizationManager.string("lesson_culture", currentLanguage)
  )

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
  ) {
    // Header
    Surface(
      color = MaterialTheme.colorScheme.surface,
      shadowElevation = 2.dp
    ) {
      Column {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          IconButton(onClick = onBack) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
          }
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = lesson.titleDe,
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "${lesson.level} • ${lesson.getDescription(currentLanguage)}",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              maxLines = 1
            )
          }

          IconButton(onClick = onToggleCompleted) {
            Icon(
              imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.CheckCircleOutline,
              contentDescription = "Complete lesson",
              tint = if (isCompleted) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }

        TabRow(selectedTabIndex = selectedTab) {
          tabs.forEachIndexed { index, title ->
            Tab(
              selected = selectedTab == index,
              onClick = { selectedTab = index },
              text = { Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold) }
            )
          }
        }
      }
    }

    // Content by tab
    when (selectedTab) {
      0 -> { // Vocabulary Tab
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 96.dp),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          items(lesson.vocabulary, key = { it.id }) { item ->
            VocabularyCard(
              item = item,
              currentLanguage = currentLanguage,
              onSpeak = onSpeak,
              isBookmarked = bookmarkedVocabIds.contains(item.id),
              onToggleBookmark = onToggleBookmark
            )
          }
        }
      }

      1 -> { // Grammar Tab
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp)
        ) {
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(18.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.AutoStories,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = lesson.grammarRuleTitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                  )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                  text = lesson.getGrammarExplanation(currentLanguage),
                  style = MaterialTheme.typography.bodyLarge,
                  lineHeight = 24.sp
                )
              }
            }
          }
        }
      }

      2 -> { // Dialogue Tab
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          items(lesson.dialogue) { turn ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(
                containerColor = if (turn.speaker == "A" || turn.speaker.contains("1") || turn.speaker.contains("Herr")) {
                  MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                } else {
                  MaterialTheme.colorScheme.surface
                }
              )
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.primary
                  ) {
                    Text(
                      text = turn.speaker,
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                  }

                  AudioSpeakerButton(
                    textToSpeak = turn.german,
                    onSpeak = onSpeak,
                    isSmall = true
                  )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = turn.german,
                  style = MaterialTheme.typography.titleSmall,
                  fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = turn.getTranslation(currentLanguage),
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }
        }
      }

      3 -> { // Culture Tip Tab
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp)
        ) {
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(18.dp),
              colors = CardDefaults.cardColors(
                containerColor = GermanGold.copy(alpha = 0.15f)
              )
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.Explore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = LocalizationManager.string("lesson_culture", currentLanguage),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                  )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                  text = lesson.getCultureTip(currentLanguage),
                  style = MaterialTheme.typography.bodyLarge,
                  lineHeight = 24.sp
                )
              }
            }
          }
        }
      }
    }
  }
}
