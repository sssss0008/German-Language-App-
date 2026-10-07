package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.ui.theme.*

@Composable
fun GrammarReferenceScreen(
  currentLanguage: AppLanguage,
  onBack: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .testTag("grammar_reference_screen")
  ) {
    // Header
    Surface(
      color = MaterialTheme.colorScheme.surface,
      shadowElevation = 2.dp
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(onClick = onBack) {
          Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(
          text = LocalizationManager.string("grammar_guide", currentLanguage),
          style = MaterialTheme.typography.titleLarge,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(start = 8.dp)
        )
      }
    }

    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      // 1. Article Declension Table
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Text(
              text = "1. Bestimmte Artikel (Definite Articles)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Table Header
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(8.dp)
            ) {
              Text("Fall", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.2f), fontSize = 12.sp)
              Text("Maskulin", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp, color = MasculineDer)
              Text("Feminin", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp, color = FeminineDie)
              Text("Neutral", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp, color = NeuterDas)
              Text("Plural", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp, color = PluralDie)
            }

            Spacer(modifier = Modifier.height(6.dp))
            ArticleRow("Nominativ (1)", "der", "die", "das", "die")
            ArticleRow("Akkusativ (4)", "den", "die", "das", "die", highlightMasculine = true)
            ArticleRow("Dativ (3)", "dem", "der", "dem", "den+n")
            ArticleRow("Genitiv (2)", "des+s", "der", "des+s", "der")
          }
        }
      }

      // 2. Personal Pronouns Table
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Text(
              text = "2. Personalpronomen (Personal Pronouns)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(8.dp)
            ) {
              Text("Pronoun", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.2f), fontSize = 12.sp)
              Text("Nominativ", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp)
              Text("Akkusativ", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp)
              Text("Dativ", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))
            PronounRow("I / म / 私", "ich", "mich", "mir")
            PronounRow("You / तँ / 君", "du", "dich", "dir")
            PronounRow("He / उ / 彼", "er", "ihn", "ihm")
            PronounRow("She / उनी / 彼女", "sie", "sie", "ihr")
            PronounRow("It / यो / それ", "es", "es", "ihm")
            PronounRow("We / हामी / 私たち", "wir", "uns", "uns")
            PronounRow("You all / तिमीहरू / 君たち", "ihr", "euch", "euch")
            PronounRow("You (formal) / तपाईं / 貴方", "Sie", "Sie", "Ihnen")
          }
        }
      }

      // 3. Essential Verbs Table
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Text(
              text = "3. Wichtige Verben (Essential Core Verbs)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text("• sein (to be): ich bin, du bist, er ist, wir sind, ihr seid, sie sind", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("• haben (to have): ich habe, du hast, er hat, wir haben, ihr habt, sie haben", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("• können (can/able): ich kann, du kannst, er kann, wir können, ihr könnt, sie können", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("• müssen (must/have to): ich muss, du musst, er muss, wir müssen, ihr müsst, sie müssen", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("• möchten (would like): ich möchte, du möchtest, er möchte, wir möchten, ihr möchtet, sie möchten", style = MaterialTheme.typography.bodyMedium)
          }
        }
      }

      // 4. Word Order Rules
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
          )
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Text(
              text = "4. Satzbau (Word Order Rules)",
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "• Rule 1: In normal main clauses, the conjugated verb is ALWAYS in Position 2.\n  Example: Heute [Pos 1] gehe [Pos 2] ich ins Kino.\n\n• Rule 2: In questions without question word, verb is in Position 1.\n  Example: Lernst [Pos 1] du Deutsch?\n\n• Rule 3: With subordinate conjunctions (weil, dass, wenn), the verb goes to the END.\n  Example: Ich lerne Deutsch, weil es interessant IST.",
              style = MaterialTheme.typography.bodyMedium,
              lineHeight = 22.sp
            )
          }
        }
      }
    }
  }
}

@Composable
private fun ArticleRow(
  fall: String,
  masc: String,
  fem: String,
  neut: String,
  plur: String,
  highlightMasculine: Boolean = false
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(fall, modifier = Modifier.weight(1.2f), fontSize = 12.sp)
    Text(
      masc,
      modifier = Modifier.weight(1f),
      fontSize = 13.sp,
      fontWeight = if (highlightMasculine) FontWeight.Bold else FontWeight.Normal,
      color = if (highlightMasculine) Color(0xFFDC2626) else MasculineDer
    )
    Text(fem, modifier = Modifier.weight(1f), fontSize = 13.sp, color = FeminineDie)
    Text(neut, modifier = Modifier.weight(1f), fontSize = 13.sp, color = NeuterDas)
    Text(plur, modifier = Modifier.weight(1f), fontSize = 13.sp, color = PluralDie)
  }
}

@Composable
private fun PronounRow(meaning: String, nom: String, akk: String, dat: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(meaning, modifier = Modifier.weight(1.2f), fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    Text(nom, modifier = Modifier.weight(1f), fontSize = 13.sp, fontWeight = FontWeight.Bold)
    Text(akk, modifier = Modifier.weight(1f), fontSize = 13.sp)
    Text(dat, modifier = Modifier.weight(1f), fontSize = 13.sp)
  }
}
