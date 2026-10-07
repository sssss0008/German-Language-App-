package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.content.GermanLearningData
import com.example.data.model.AppLanguage
import com.example.data.model.CultureTopic
import com.example.data.model.LocalizationManager
import com.example.data.model.VocabularyItem
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.GenderChip
import com.example.ui.components.GermanFlagBadge
import com.example.ui.theme.*

@Composable
fun HomeScreen(
  currentLanguage: AppLanguage,
  onLanguageSelected: (AppLanguage) -> Unit,
  onSpeak: (String) -> Unit,
  dailyStreak: Int,
  onNavigateToPracticeMode: (String) -> Unit,
  onNavigateToLearnLesson: (String) -> Unit,
  onNavigateToCulture: () -> Unit,
  onNavigateToHistory: () -> Unit,
  modifier: Modifier = Modifier
) {
  val wordOfDay = remember { GermanLearningData.wordsOfTheDay.first() }
  val phraseOfDay = remember { GermanLearningData.phrasesOfTheDay.first() }
  var isWordExpanded by remember { mutableStateOf(false) }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .testTag("home_screen"),
    contentPadding = PaddingValues(bottom = 96.dp)
  ) {
    // Top Greeting & Language Switcher Header
    item {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(
            Brush.verticalGradient(
              listOf(
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.colorScheme.surface
              )
            )
          )
          .padding(horizontal = 20.dp, vertical = 16.dp)
      ) {
        Column {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              GermanFlagBadge()
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text(
                  text = when (currentLanguage) {
                    AppLanguage.GERMAN -> "Guten Tag, Lerner!"
                    AppLanguage.NEPALI -> "नमस्ते, जर्मन सिकारु!"
                    AppLanguage.JAPANESE -> "こんにちは、学習者さん！"
                    AppLanguage.ENGLISH -> "Hello, Learner!"
                  },
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold,
                  color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                  text = LocalizationManager.string("app_subtitle", currentLanguage),
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
              }
            }

            // Streak Badge
            Surface(
              shape = RoundedCornerShape(20.dp),
              color = MaterialTheme.colorScheme.surface,
              shadowElevation = 2.dp
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  imageVector = Icons.Default.LocalFireDepartment,
                  contentDescription = "Streak",
                  tint = Color(0xFFFF6D00),
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "$dailyStreak ${LocalizationManager.string("streak_days", currentLanguage)}",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // 4-Language Quick Selector Bar
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            AppLanguage.entries.forEach { lang ->
              val isSelected = lang == currentLanguage
              FilterChip(
                selected = isSelected,
                onClick = { onLanguageSelected(lang) },
                label = {
                  Text(
                    text = "${lang.flagEmoji} ${lang.nativeName}",
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.weight(1f),
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = MaterialTheme.colorScheme.primary,
                  selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                )
              )
            }
          }
        }
      }
    }

    // Word of the Day Card
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 8.dp)
          .testTag("word_of_day_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                shape = CircleShape,
                color = GermanGold.copy(alpha = 0.2f),
                modifier = Modifier.size(32.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.Default.Lightbulb,
                    contentDescription = null,
                    tint = GermanGold,
                    modifier = Modifier.size(18.dp)
                  )
                }
              }
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = LocalizationManager.string("word_of_day", currentLanguage),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
              )
            }

            AudioSpeakerButton(
              textToSpeak = wordOfDay.fullGerman,
              onSpeak = onSpeak,
              isSmall = true
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          Row(verticalAlignment = Alignment.CenterVertically) {
            if (wordOfDay.article != null) {
              GenderChip(article = wordOfDay.article)
              Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
              text = wordOfDay.german,
              style = MaterialTheme.typography.headlineMedium,
              fontWeight = FontWeight.Bold
            )
          }

          if (!wordOfDay.ipa.isNullOrEmpty()) {
            Text(
              text = wordOfDay.ipa,
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Primary translation
          Text(
            text = wordOfDay.getTranslation(currentLanguage),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
          )

          Spacer(modifier = Modifier.height(8.dp))

          // Example box
          Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = wordOfDay.exampleGerman,
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Medium,
                  modifier = Modifier.weight(1f)
                )
                IconButton(
                  onClick = { onSpeak(wordOfDay.exampleGerman) },
                  modifier = Modifier.size(28.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.VolumeUp,
                    contentDescription = "Speak",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                  )
                }
              }
              Text(
                text = wordOfDay.getExampleTranslation(currentLanguage),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }
        }
      }
    }

    // Quick Practice Grid / Mode Buttons
    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 8.dp)
      ) {
        Text(
          text = LocalizationManager.string("quick_practice", currentLanguage),
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          // Der Die Das Trainer Card
          Card(
            modifier = Modifier
              .weight(1f)
              .testTag("quick_der_die_das_card")
              .clickable { onNavigateToPracticeMode("gender") },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Icon(
                imageVector = Icons.Default.SportsEsports,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
              )
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "Der • Die • Das",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
              )
              Text(
                text = when (currentLanguage) {
                  AppLanguage.GERMAN -> "Artikel-Spiel"
                  AppLanguage.NEPALI -> "लिङ्ग खेल"
                  AppLanguage.JAPANESE -> "冠詞ゲーム"
                  AppLanguage.ENGLISH -> "Gender Game"
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
              )
            }
          }

          // Flashcards Card
          Card(
            modifier = Modifier
              .weight(1f)
              .testTag("quick_flashcards_card")
              .clickable { onNavigateToPracticeMode("flashcards") },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Icon(
                imageVector = Icons.Default.Style,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(28.dp)
              )
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = LocalizationManager.string("flashcards", currentLanguage),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
              )
              Text(
                text = when (currentLanguage) {
                  AppLanguage.GERMAN -> "Karten drehen"
                  AppLanguage.NEPALI -> "शब्द सम्झिने"
                  AppLanguage.JAPANESE -> "単語暗記"
                  AppLanguage.ENGLISH -> "Flip & Learn"
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
              )
            }
          }

          // Quiz Card
          Card(
            modifier = Modifier
              .weight(1f)
              .testTag("quick_quiz_card")
              .clickable { onNavigateToPracticeMode("quiz") },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Icon(
                imageVector = Icons.Default.Quiz,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(28.dp)
              )
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = LocalizationManager.string("quiz", currentLanguage),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onTertiaryContainer
              )
              Text(
                text = when (currentLanguage) {
                  AppLanguage.GERMAN -> "Wissenstest"
                  AppLanguage.NEPALI -> "प्रश्नोत्तरी"
                  AppLanguage.JAPANESE -> "確認テスト"
                  AppLanguage.ENGLISH -> "Test skills"
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.8f)
              )
            }
          }
        }
      }
    }

    // German Culture & Traditions Spotlight Header
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = LocalizationManager.string("culture_traditions", currentLanguage),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
          )
          Text(
            text = when (currentLanguage) {
              AppLanguage.GERMAN -> "Oktoberfest, Schlösser & Bräuche"
              AppLanguage.NEPALI -> "परम्परा, चाडपर्व र जीवनशैली"
              AppLanguage.JAPANESE -> "古城・ビール・祝祭と暮らし"
              AppLanguage.ENGLISH -> "Festivals, castles & heritage"
            },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        TextButton(onClick = onNavigateToCulture) {
          Text(
            text = when (currentLanguage) {
              AppLanguage.GERMAN -> "Alle anzeigen"
              AppLanguage.NEPALI -> "सबै हेर्नुहोस्"
              AppLanguage.JAPANESE -> "すべて見る"
              AppLanguage.ENGLISH -> "View All"
            },
            fontWeight = FontWeight.Bold
          )
        }
      }
    }

    // Culture Carousel
    item {
      LazyRow(
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
      ) {
        items(GermanLearningData.cultureTopics) { topic ->
          Card(
            modifier = Modifier
              .width(260.dp)
              .testTag("culture_preview_${topic.id}")
              .clickable { onNavigateToCulture() },
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
          ) {
            Column {
              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .height(120.dp)
                  .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
              ) {
                Image(
                  painter = painterResource(id = topic.drawableRes),
                  contentDescription = topic.getTitle(currentLanguage),
                  modifier = Modifier.size(90.dp)
                )
                Surface(
                  color = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                  shape = RoundedCornerShape(6.dp),
                  modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                ) {
                  Text(
                    text = topic.badgeText,
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }

              Column(modifier = Modifier.padding(14.dp)) {
                Text(
                  text = topic.getTitle(currentLanguage),
                  style = MaterialTheme.typography.titleSmall,
                  fontWeight = FontWeight.Bold,
                  maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = topic.getSummary(currentLanguage),
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  maxLines = 2
                )
              }
            }
          }
        }
      }
    }

    // German History Spotlight
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 14.dp)
          .testTag("history_spotlight_card")
          .clickable { onNavigateToHistory() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
        )
      ) {
        Row(
          modifier = Modifier.padding(16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            painter = painterResource(id = R.drawable.ic_brandenburg),
            contentDescription = "German History",
            modifier = Modifier.size(70.dp)
          )
          Spacer(modifier = Modifier.width(14.dp))
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = LocalizationManager.string("history_milestones", currentLanguage),
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = when (currentLanguage) {
                AppLanguage.GERMAN -> "Von Luther & Goethe bis zur Berliner Mauer"
                AppLanguage.NEPALI -> "लुथर, बाउहाउस र बर्लिन पर्खालको इतिहास"
                AppLanguage.JAPANESE -> "ルター、バウハウス、ベルリンの壁の歴史"
                AppLanguage.ENGLISH -> "From Luther & Goethe to the Berlin Wall"
              },
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
          Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
          )
        }
      }
    }

    // Phrase of the Day / Wisdom Card
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
        )
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = LocalizationManager.string("phrase_of_day", currentLanguage),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
              )
            }
            AudioSpeakerButton(
              textToSpeak = phraseOfDay.german,
              onSpeak = onSpeak,
              isSmall = true
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "„${phraseOfDay.german}”",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = phraseOfDay.getTranslation(currentLanguage),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.9f)
          )
        }
      }
    }
  }
}
