package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.content.GermanLearningData
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.GermanGold

@Composable
fun CultureHistoryScreen(
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  initialTab: Int = 0,
  onBack: () -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedTab by remember { mutableStateOf(initialTab) }
  val tabTitles = listOf(
    LocalizationManager.string("culture_traditions", currentLanguage),
    LocalizationManager.string("history_milestones", currentLanguage)
  )

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .testTag("culture_history_screen")
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
          Text(
            text = tabTitles[selectedTab],
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
          )
        }

        TabRow(selectedTabIndex = selectedTab) {
          tabTitles.forEachIndexed { index, title ->
            Tab(
              selected = selectedTab == index,
              onClick = { selectedTab = index },
              text = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = 13.sp) }
            )
          }
        }
      }
    }

    if (selectedTab == 0) {
      // Culture & Traditions Tab
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(GermanLearningData.cultureTopics, key = { it.id }) { topic ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .testTag("culture_card_${topic.id}"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
          ) {
            Column {
              // Illustration Banner
              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .height(140.dp)
                  .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
              ) {
                Image(
                  painter = painterResource(id = topic.drawableRes),
                  contentDescription = topic.getTitle(currentLanguage),
                  modifier = Modifier.size(110.dp)
                )
                Surface(
                  color = MaterialTheme.colorScheme.primary,
                  shape = RoundedCornerShape(8.dp),
                  modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp)
                ) {
                  Text(
                    text = topic.badgeText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                  )
                }
              }

              Column(modifier = Modifier.padding(18.dp)) {
                Text(
                  text = topic.titleDe,
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold
                )
                Text(
                  text = topic.getTitle(currentLanguage),
                  style = MaterialTheme.typography.titleSmall,
                  color = MaterialTheme.colorScheme.primary,
                  fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = topic.getStory(currentLanguage),
                  style = MaterialTheme.typography.bodyMedium,
                  lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Fun Fact Banner
                Surface(
                  color = GermanGold.copy(alpha = 0.15f),
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.Top
                  ) {
                    Icon(
                      imageVector = Icons.Default.Lightbulb,
                      contentDescription = null,
                      tint = GermanGold,
                      modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                      Text(
                        text = "Wusstest du? / Did you know?",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                      )
                      Spacer(modifier = Modifier.height(2.dp))
                      Text(
                        text = topic.getFunFact(currentLanguage),
                        style = MaterialTheme.typography.bodySmall
                      )
                    }
                  }
                }

                // Cultural Vocabulary
                if (topic.vocabulary.isNotEmpty()) {
                  Spacer(modifier = Modifier.height(12.dp))
                  Text(
                    text = "Kultur-Wortschatz / Vocabulary:",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                  )
                  Spacer(modifier = Modifier.height(6.dp))
                  topic.vocabulary.forEach { item ->
                    Surface(
                      color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                      shape = RoundedCornerShape(10.dp),
                      modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                    ) {
                      Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                        Column(modifier = Modifier.weight(1f)) {
                          Text(
                            text = item.fullGerman,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                          )
                          Text(
                            text = item.getTranslation(currentLanguage),
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                          )
                        }
                        AudioSpeakerButton(
                          textToSpeak = item.fullGerman,
                          onSpeak = onSpeak,
                          isSmall = true
                        )
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    } else {
      // History Milestones Tab
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(GermanLearningData.historyMilestones, key = { it.id }) { milestone ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .testTag("history_card_${milestone.id}"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
          ) {
            Column {
              // Year Badge Header
              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .background(MaterialTheme.colorScheme.surfaceVariant)
                  .padding(14.dp)
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween,
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                  ) {
                    Text(
                      text = milestone.year,
                      color = Color.White,
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                  Image(
                    painter = painterResource(id = milestone.drawableRes),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                  )
                }
              }

              Column(modifier = Modifier.padding(18.dp)) {
                Text(
                  text = milestone.titleDe,
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold
                )
                Text(
                  text = milestone.getTitle(currentLanguage),
                  style = MaterialTheme.typography.titleSmall,
                  color = MaterialTheme.colorScheme.primary,
                  fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = milestone.getDetails(currentLanguage),
                  style = MaterialTheme.typography.bodyMedium,
                  lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Linguistic impact
                Surface(
                  color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                      text = "Linguistischer Einfluss / Language Impact:",
                      fontWeight = FontWeight.Bold,
                      style = MaterialTheme.typography.labelMedium,
                      color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                      text = milestone.getLinguisticNote(currentLanguage),
                      style = MaterialTheme.typography.bodySmall
                    )
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
