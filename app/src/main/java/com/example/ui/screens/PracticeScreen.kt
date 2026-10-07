package com.example.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.content.GermanLearningData
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.data.model.QuizType
import com.example.data.model.VocabularyItem
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.GenderChip
import com.example.ui.theme.*

@Composable
fun PracticeScreen(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  highScore: Int,
  onUpdateHighScore: (Int) -> Unit,
  initialMode: String? = null,
  modifier: Modifier = Modifier
) {
  var selectedModeIndex by remember {
    mutableStateOf(
      when (initialMode) {
        "gender" -> 0
        "flashcards" -> 1
        "quiz" -> 2
        else -> 0
      }
    )
  }

  val modes = listOf(
    "Der•Die•Das",
    LocalizationManager.string("flashcards", currentLanguage),
    LocalizationManager.string("quiz", currentLanguage)
  )

  Column(
    modifier = modifier
      .fillMaxSize()
      .testTag("practice_screen")
  ) {
    // Mode Switcher Tabs
    Surface(
      color = MaterialTheme.colorScheme.surface,
      shadowElevation = 2.dp
    ) {
      TabRow(selectedTabIndex = selectedModeIndex) {
        modes.forEachIndexed { index, title ->
          Tab(
            selected = selectedModeIndex == index,
            onClick = { selectedModeIndex = index },
            text = {
              Text(
                text = title,
                fontWeight = if (selectedModeIndex == index) FontWeight.Bold else FontWeight.Normal,
                fontSize = 13.sp
              )
            }
          )
        }
      }
    }

    AnimatedContent(targetState = selectedModeIndex, label = "PracticeModeAnimation") { index ->
      when (index) {
        0 -> DerDieDasGame(
          currentLanguage = currentLanguage,
          onSpeak = onSpeak,
          highScore = highScore,
          onUpdateHighScore = onUpdateHighScore
        )
        1 -> FlashcardsPractice(
          currentLanguage = currentLanguage,
          onSpeak = onSpeak
        )
        2 -> KnowledgeQuizPractice(
          currentLanguage = currentLanguage,
          onSpeak = onSpeak
        )
      }
    }
  }
}

// ----------------------------------------------------
// 1. DER DIE DAS GAME TRAINER
// ----------------------------------------------------
@Composable
fun DerDieDasGame(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  highScore: Int,
  onUpdateHighScore: (Int) -> Unit
) {
  val nounList = remember { GermanLearningData.genderTrainingNouns.shuffled() }
  var currentIndex by remember { mutableStateOf(0) }
  var currentScore by remember { mutableStateOf(0) }
  var comboCount by remember { mutableStateOf(0) }
  var lastAnswerResult by remember { mutableStateOf<Boolean?>(null) }
  var selectedChoice by remember { mutableStateOf<String?>(null) }

  val currentNoun = nounList[currentIndex % nounList.size]

  fun handleAnswer(choice: String) {
    if (selectedChoice != null) return // Already answered this card
    selectedChoice = choice
    val isCorrect = choice.equals(currentNoun.article, ignoreCase = true)
    lastAnswerResult = isCorrect
    if (isCorrect) {
      val newScore = currentScore + 10 + (comboCount * 2)
      currentScore = newScore
      comboCount += 1
      if (newScore > highScore) {
        onUpdateHighScore(newScore)
      }
    } else {
      comboCount = 0
    }
  }

  fun nextCard() {
    selectedChoice = null
    lastAnswerResult = null
    currentIndex = (currentIndex + 1) % nounList.size
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 20.dp, vertical = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Score Bar
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(12.dp)
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = Icons.Default.Stars,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "${LocalizationManager.string("score", currentLanguage)}: $currentScore",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
          )
        }
      }

      if (comboCount > 1) {
        Surface(
          color = Color(0xFFFF6D00).copy(alpha = 0.15f),
          shape = RoundedCornerShape(12.dp)
        ) {
          Text(
            text = "🔥 ${comboCount}x Combo!",
            color = Color(0xFFFF6D00),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
          )
        }
      }

      Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(12.dp)
      ) {
        Text(
          text = "🏆 ${LocalizationManager.string("high_score", currentLanguage)}: $highScore",
          fontWeight = FontWeight.SemiBold,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Interactive Question Card
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(240.dp)
        .testTag("der_die_das_card"),
      shape = RoundedCornerShape(24.dp),
      colors = CardDefaults.cardColors(
        containerColor = when (lastAnswerResult) {
          true -> Color(0xFF10B981).copy(alpha = 0.12f)
          false -> Color(0xFFEF4444).copy(alpha = 0.12f)
          else -> MaterialTheme.colorScheme.surface
        }
      ),
      elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.padding(20.dp)
        ) {
          Text(
            text = "Welcher Artikel?",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
          Spacer(modifier = Modifier.height(10.dp))

          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = currentNoun.german,
              style = MaterialTheme.typography.headlineLarge,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(8.dp))
            AudioSpeakerButton(
              textToSpeak = currentNoun.fullGerman,
              onSpeak = onSpeak,
              isSmall = true
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = currentNoun.getTranslation(currentLanguage),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary
          )

          if (currentNoun.plural != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "Plural: ${currentNoun.plural}",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }

          // Feedback message
          if (lastAnswerResult != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = if (lastAnswerResult == true) {
                "✓ ${LocalizationManager.string("correct", currentLanguage)} (${currentNoun.fullGerman})"
              } else {
                "✗ ${LocalizationManager.string("try_again", currentLanguage)} -> ${currentNoun.fullGerman}"
              },
              color = if (lastAnswerResult == true) Color(0xFF047857) else Color(0xFFDC2626),
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(28.dp))

    // 3 Article Action Buttons: DER (Blue), DIE (Red), DAS (Green)
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // DER
      Button(
        onClick = { handleAnswer("der") },
        modifier = Modifier
          .weight(1f)
          .height(58.dp)
          .testTag("btn_der"),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = MasculineDer,
          contentColor = Color.White
        )
      ) {
        Text("DER", fontWeight = FontWeight.Bold, fontSize = 18.sp)
      }

      // DIE
      Button(
        onClick = { handleAnswer("die") },
        modifier = Modifier
          .weight(1f)
          .height(58.dp)
          .testTag("btn_die"),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = FeminineDie,
          contentColor = Color.White
        )
      ) {
        Text("DIE", fontWeight = FontWeight.Bold, fontSize = 18.sp)
      }

      // DAS
      Button(
        onClick = { handleAnswer("das") },
        modifier = Modifier
          .weight(1f)
          .height(58.dp)
          .testTag("btn_das"),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = NeuterDas,
          contentColor = Color.White
        )
      ) {
        Text("DAS", fontWeight = FontWeight.Bold, fontSize = 18.sp)
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Next Button (enabled once answered)
    Button(
      onClick = { nextCard() },
      enabled = selectedChoice != null,
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .testTag("btn_next_card"),
      shape = RoundedCornerShape(14.dp)
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(LocalizationManager.string("next_card", currentLanguage), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(6.dp))
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
      }
    }
  }
}

// ----------------------------------------------------
// 2. FLASHCARDS PRACTICE
// ----------------------------------------------------
@Composable
fun FlashcardsPractice(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit
) {
  val flashcards = remember {
    GermanLearningData.lessons.flatMap { it.vocabulary }.shuffled()
  }
  var cardIndex by remember { mutableStateOf(0) }
  var isFlipped by remember { mutableStateOf(false) }

  val currentCard = flashcards[cardIndex % flashcards.size]
  val rotation by animateFloatAsState(
    targetValue = if (isFlipped) 180f else 0f,
    animationSpec = tween(durationMillis = 400),
    label = "CardFlip"
  )

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 20.dp, vertical = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "${LocalizationManager.string("flashcards", currentLanguage)} (${(cardIndex % flashcards.size) + 1}/${flashcards.size})",
      style = MaterialTheme.typography.titleSmall,
      color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    Spacer(modifier = Modifier.height(16.dp))

    // 3D Flip Card
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .graphicsLayer {
          rotationY = rotation
          cameraDistance = 12f * density
        }
        .clickable { isFlipped = !isFlipped }
        .testTag("flashcard_flip_box"),
      shape = RoundedCornerShape(24.dp),
      colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
      ),
      elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(24.dp),
        contentAlignment = Alignment.Center
      ) {
        if (rotation <= 90f) {
          // FRONT: German word
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (currentCard.article != null) {
              GenderChip(article = currentCard.article)
              Spacer(modifier = Modifier.height(12.dp))
            }
            Text(
              text = currentCard.german,
              style = MaterialTheme.typography.headlineLarge,
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center
            )
            if (!currentCard.ipa.isNullOrEmpty()) {
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = currentCard.ipa,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
            Spacer(modifier = Modifier.height(16.dp))
            AudioSpeakerButton(
              textToSpeak = currentCard.fullGerman,
              onSpeak = onSpeak
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
              text = LocalizationManager.string("flip_card", currentLanguage),
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        } else {
          // BACK: Translations (Rotated 180 so it appears upright)
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.graphicsLayer { rotationY = 180f }
          ) {
            Text(
              text = currentCard.getTranslation(currentLanguage),
              style = MaterialTheme.typography.headlineSmall,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary,
              textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "🇺🇸 EN: ${currentCard.english}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "🇳🇵 NE: ${currentCard.nepali}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "🇯🇵 JA: ${currentCard.japanese}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
              text = currentCard.exampleGerman,
              style = MaterialTheme.typography.bodySmall,
              fontWeight = FontWeight.Medium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Learning feedback buttons
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      OutlinedButton(
        onClick = {
          isFlipped = false
          cardIndex = (cardIndex + 1) % flashcards.size
        },
        modifier = Modifier
          .weight(1f)
          .height(52.dp)
          .testTag("flashcard_review_btn"),
        shape = RoundedCornerShape(14.dp)
      ) {
        Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
        Spacer(modifier = Modifier.width(6.dp))
        Text(LocalizationManager.string("review", currentLanguage))
      }

      Button(
        onClick = {
          isFlipped = false
          cardIndex = (cardIndex + 1) % flashcards.size
        },
        modifier = Modifier
          .weight(1f)
          .height(52.dp)
          .testTag("flashcard_known_btn"),
        shape = RoundedCornerShape(14.dp)
      ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = null)
        Spacer(modifier = Modifier.width(6.dp))
        Text(LocalizationManager.string("known", currentLanguage))
      }
    }
  }
}

// ----------------------------------------------------
// 3. KNOWLEDGE QUIZ PRACTICE
// ----------------------------------------------------
@Composable
fun KnowledgeQuizPractice(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit
) {
  val questions = remember { GermanLearningData.quizQuestions }
  var questionIndex by remember { mutableStateOf(0) }
  var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }
  var score by remember { mutableStateOf(0) }

  val q = questions[questionIndex % questions.size]

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 20.dp, vertical = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Header
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "Frage ${(questionIndex % questions.size) + 1} / ${questions.size}",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
      )
      Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(10.dp)
      ) {
        Text(
          text = "${LocalizationManager.string("score", currentLanguage)}: $score",
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
          color = MaterialTheme.colorScheme.onPrimaryContainer
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Question Box
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .testTag("quiz_question_card"),
      shape = RoundedCornerShape(20.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(modifier = Modifier.padding(18.dp)) {
        if (q.type == QuizType.LISTENING && q.audioToPlay != null) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "🎧 Hörverständnis:",
              style = MaterialTheme.typography.labelLarge,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            AudioSpeakerButton(
              textToSpeak = q.audioToPlay,
              onSpeak = onSpeak,
              isSmall = true
            )
          }
          Spacer(modifier = Modifier.height(6.dp))
        }

        Text(
          text = q.getPrompt(currentLanguage),
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Options List
    q.options.forEachIndexed { optIndex, optionText ->
      val isSelected = selectedAnswerIndex == optIndex
      val isCorrect = optIndex == q.correctOptionIndex
      val showResult = selectedAnswerIndex != null

      val (bgColor, textColor) = when {
        showResult && isCorrect -> Pair(Color(0xFF10B981).copy(alpha = 0.2f), Color(0xFF047857))
        showResult && isSelected && !isCorrect -> Pair(Color(0xFFEF4444).copy(alpha = 0.2f), Color(0xFFDC2626))
        isSelected -> Pair(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.primary)
        else -> Pair(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.onSurface)
      }

      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 5.dp)
          .clip(RoundedCornerShape(14.dp))
          .clickable(enabled = selectedAnswerIndex == null) {
            selectedAnswerIndex = optIndex
            if (isCorrect) score += 10
          }
          .testTag("quiz_opt_$optIndex"),
        color = bgColor,
        shape = RoundedCornerShape(14.dp),
        shadowElevation = 1.dp
      ) {
        Row(
          modifier = Modifier.padding(16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(28.dp)
          ) {
            Box(contentAlignment = Alignment.Center) {
              Text(
                text = "${('A'.code + optIndex).toChar()}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
              )
            }
          }
          Spacer(modifier = Modifier.width(12.dp))
          Text(
            text = optionText,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = textColor
          )
        }
      }
    }

    // Explanation & Next Button
    if (selectedAnswerIndex != null) {
      Spacer(modifier = Modifier.height(12.dp))
      Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(
            text = "Erklärung / Info:",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = q.getExplanation(currentLanguage),
            style = MaterialTheme.typography.bodySmall
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))
      Button(
        onClick = {
          selectedAnswerIndex = null
          questionIndex = (questionIndex + 1) % questions.size
        },
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
          .testTag("quiz_next_btn"),
        shape = RoundedCornerShape(12.dp)
      ) {
        Text(LocalizationManager.string("next_card", currentLanguage), fontWeight = FontWeight.Bold)
      }
    }
  }
}
