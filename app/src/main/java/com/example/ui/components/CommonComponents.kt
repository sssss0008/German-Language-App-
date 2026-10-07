package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.data.model.VocabularyItem
import com.example.ui.theme.*

@Composable
fun GermanFlagBadge(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .width(28.dp)
      .height(18.dp)
      .clip(RoundedCornerShape(3.dp))
  ) {
    Column(modifier = Modifier.fillMaxSize()) {
      Box(modifier = Modifier.fillMaxWidth().weight(1f).background(GermanBlack))
      Box(modifier = Modifier.fillMaxWidth().weight(1f).background(GermanRed))
      Box(modifier = Modifier.fillMaxWidth().weight(1f).background(GermanGold))
    }
  }
}

@Composable
fun GenderChip(article: String?, modifier: Modifier = Modifier) {
  if (article == null) return
  val (bgColor, textColor, label) = when (article.lowercase()) {
    "der" -> Triple(MasculineDer.copy(alpha = 0.15f), MasculineDer, "der (m.)")
    "die" -> Triple(FeminineDie.copy(alpha = 0.15f), FeminineDie, "die (f.)")
    "das" -> Triple(NeuterDas.copy(alpha = 0.15f), NeuterDas, "das (n.)")
    else -> Triple(PluralDie.copy(alpha = 0.15f), PluralDie, article)
  }

  Surface(
    color = bgColor,
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
  ) {
    Text(
      text = label,
      color = textColor,
      fontWeight = FontWeight.Bold,
      fontSize = 12.sp,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
    )
  }
}

@Composable
fun AudioSpeakerButton(
  textToSpeak: String,
  onSpeak: (String) -> Unit,
  modifier: Modifier = Modifier,
  isSmall: Boolean = false
) {
  IconButton(
    onClick = { onSpeak(textToSpeak) },
    modifier = modifier
      .testTag("audio_speaker_button_${textToSpeak.take(10)}")
      .size(if (isSmall) 36.dp else 44.dp)
      .clip(CircleShape)
      .background(MaterialTheme.colorScheme.primaryContainer)
  ) {
    Icon(
      imageVector = Icons.Default.VolumeUp,
      contentDescription = "Speak pronunciation of $textToSpeak",
      tint = MaterialTheme.colorScheme.primary,
      modifier = Modifier.size(if (isSmall) 18.dp else 22.dp)
    )
  }
}

@Composable
fun VocabularyCard(
  item: VocabularyItem,
  currentLanguage: AppLanguage,
  onSpeak: (String) -> Unit,
  isBookmarked: Boolean,
  onToggleBookmark: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  var isExpanded by remember { mutableStateOf(false) }

  Card(
    modifier = modifier
      .fillMaxWidth()
      .testTag("vocab_card_${item.id}")
      .clickable { isExpanded = !isExpanded },
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surface
    ),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f)
        ) {
          if (item.article != null) {
            GenderChip(article = item.article)
            Spacer(modifier = Modifier.width(8.dp))
          }
          Column {
            Text(
              text = item.german,
              style = MaterialTheme.typography.titleLarge,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface
            )
            if (!item.ipa.isNullOrEmpty()) {
              Text(
                text = item.ipa,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
          IconButton(
            onClick = { onToggleBookmark(item.id) },
            modifier = Modifier.size(36.dp)
          ) {
            Icon(
              imageVector = if (isBookmarked) Icons.Default.Star else Icons.Default.StarBorder,
              contentDescription = if (isBookmarked) "Bookmarked" else "Bookmark",
              tint = if (isBookmarked) GermanGold else MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
          Spacer(modifier = Modifier.width(4.dp))
          AudioSpeakerButton(
            textToSpeak = item.fullGerman,
            onSpeak = onSpeak,
            isSmall = true
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Primary Translation based on user active language
      val primaryTranslation = item.getTranslation(currentLanguage)
      Text(
        text = primaryTranslation,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary
      )

      if (item.plural != null) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "Plural: ${item.plural}",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }

      // Expandable section with translations in ALL 4 languages and example sentence
      AnimatedVisibility(visible = isExpanded) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .padding(12.dp)
        ) {
          Text(
            text = "Translations / अनुवाद / 翻訳:",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = "🇺🇸 EN: ${item.english}", style = MaterialTheme.typography.bodyMedium)
          Text(text = "🇳🇵 NE: ${item.nepali}", style = MaterialTheme.typography.bodyMedium)
          Text(text = "🇯🇵 JA: ${item.japanese}", style = MaterialTheme.typography.bodyMedium)

          Spacer(modifier = Modifier.height(8.dp))
          Divider(color = MaterialTheme.colorScheme.outlineVariant)
          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "Example / उदाहरण / 例文:",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(2.dp))
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = item.exampleGerman,
              style = MaterialTheme.typography.bodyMedium,
              fontWeight = FontWeight.Medium,
              modifier = Modifier.weight(1f)
            )
            IconButton(
              onClick = { onSpeak(item.exampleGerman) },
              modifier = Modifier.size(32.dp)
            ) {
              Icon(
                imageVector = Icons.Default.VolumeUp,
                contentDescription = "Speak example",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(16.dp)
              )
            }
          }
          Text(
            text = item.getExampleTranslation(currentLanguage),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }
  }
}

@Composable
fun LanguageSwitchDialog(
  currentLanguage: AppLanguage,
  onLanguageSelected: (AppLanguage) -> Unit,
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    title = {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          imageVector = Icons.Default.Language,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = LocalizationManager.string("select_language", currentLanguage))
      }
    },
    text = {
      Column(modifier = Modifier.fillMaxWidth()) {
        AppLanguage.entries.forEach { lang ->
          val isSelected = lang == currentLanguage
          Surface(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 4.dp)
              .clip(RoundedCornerShape(12.dp))
              .clickable {
                onLanguageSelected(lang)
                onDismiss()
              },
            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
            tonalElevation = if (isSelected) 4.dp else 0.dp
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = lang.flagEmoji, fontSize = 24.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = lang.nativeName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                  )
                  Text(
                    text = lang.displayName,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
              if (isSelected) {
                Icon(
                  imageVector = Icons.Default.CheckCircle,
                  contentDescription = "Selected",
                  tint = MaterialTheme.colorScheme.primary
                )
              }
            }
          }
        }
      }
    },
    confirmButton = {
      TextButton(onClick = onDismiss) {
        Text("OK")
      }
    }
  )
}
