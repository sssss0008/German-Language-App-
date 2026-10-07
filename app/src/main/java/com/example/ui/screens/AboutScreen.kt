package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.ui.components.GermanFlagBadge
import com.example.ui.theme.GermanGold

@Composable
fun AboutScreen(
  currentLanguage: AppLanguage,
  onResetProgress: () -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  var showResetDialog by remember { mutableStateOf(false) }

  fun copyToClipboard(label: String, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(
      context,
      "${LocalizationManager.string("copy_success", currentLanguage)}: $text",
      Toast.LENGTH_SHORT
    ).show()
  }

  fun openEmail() {
    try {
      val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:awiskaracharya@gmail.com")
        putExtra(Intent.EXTRA_SUBJECT, "Feedback - DeutschLernen German Bhasa App")
      }
      context.startActivity(intent)
    } catch (_: Exception) {
      copyToClipboard("Email", "awiskaracharya@gmail.com")
    }
  }

  fun openWhatsApp() {
    try {
      val url = "https://wa.me/9779827106244?text=Hello%20Awiskar,%20I%20am%20using%20the%20DeutschLernen%20German%20Language%20App!"
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      context.startActivity(intent)
    } catch (_: Exception) {
      copyToClipboard("WhatsApp", "+9779827106244")
    }
  }

  fun openLinkedIn() {
    try {
      val url = "https://www.linkedin.com/in/awiskaracharya/"
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      context.startActivity(intent)
    } catch (_: Exception) {
      copyToClipboard("LinkedIn", "https://www.linkedin.com/in/awiskaracharya/")
    }
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .testTag("about_screen"),
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 96.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // App Header Card
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer
        )
      ) {
        Column(
          modifier = Modifier.padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            GermanFlagBadge()
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "DeutschLernen",
              style = MaterialTheme.typography.headlineMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onPrimaryContainer
            )
          }

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = "Complete German Bhasa Language Learning App",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.9f)
          )

          Spacer(modifier = Modifier.height(8.dp))

          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AssistChip(
              onClick = {},
              label = { Text("🇩🇪 Deutsch") },
              colors = AssistChipDefaults.assistChipColors(containerColor = MaterialTheme.colorScheme.surface)
            )
            AssistChip(
              onClick = {},
              label = { Text("🇳🇵 नेपाली") },
              colors = AssistChipDefaults.assistChipColors(containerColor = MaterialTheme.colorScheme.surface)
            )
            AssistChip(
              onClick = {},
              label = { Text("🇯🇵 日本語") },
              colors = AssistChipDefaults.assistChipColors(containerColor = MaterialTheme.colorScheme.surface)
            )
            AssistChip(
              onClick = {},
              label = { Text("🇺🇸 English") },
              colors = AssistChipDefaults.assistChipColors(containerColor = MaterialTheme.colorScheme.surface)
            )
          }

          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "v1.0.0 • Designed for global learners",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
          )
        }
      }
    }

    // Contact & Feedback Section (Awiskar Acharya)
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .testTag("contact_developer_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Person,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = LocalizationManager.string("about_developer", currentLanguage),
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Awiskar Acharya",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
          )
          Text(
            text = "Lead Developer & German Language Education Specialist",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(16.dp))

          // 1. Email Button
          Surface(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .clickable { openEmail() }
              .testTag("btn_email_feedback"),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
          ) {
            Row(
              modifier = Modifier.padding(14.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFFEA4335).copy(alpha = 0.15f),
                  modifier = Modifier.size(36.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Icon(
                      imageVector = Icons.Default.Email,
                      contentDescription = "Email",
                      tint = Color(0xFFEA4335),
                      modifier = Modifier.size(20.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = LocalizationManager.string("contact_email", currentLanguage),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                  )
                  Text(
                    text = "awiskaracharya@gmail.com",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
              IconButton(onClick = { copyToClipboard("Email", "awiskaracharya@gmail.com") }) {
                Icon(
                  imageVector = Icons.Default.ContentCopy,
                  contentDescription = "Copy email",
                  modifier = Modifier.size(18.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // 2. WhatsApp Button
          Surface(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .clickable { openWhatsApp() }
              .testTag("btn_whatsapp_contact"),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
          ) {
            Row(
              modifier = Modifier.padding(14.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFF25D366).copy(alpha = 0.15f),
                  modifier = Modifier.size(36.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Icon(
                      imageVector = Icons.Default.Chat,
                      contentDescription = "WhatsApp",
                      tint = Color(0xFF25D366),
                      modifier = Modifier.size(20.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = LocalizationManager.string("contact_whatsapp", currentLanguage),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                  )
                  Text(
                    text = "+977 9827106244",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
              IconButton(onClick = { copyToClipboard("WhatsApp", "+9779827106244") }) {
                Icon(
                  imageVector = Icons.Default.ContentCopy,
                  contentDescription = "Copy WhatsApp",
                  modifier = Modifier.size(18.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // 3. LinkedIn Button
          Surface(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .clickable { openLinkedIn() }
              .testTag("btn_linkedin_profile"),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
          ) {
            Row(
              modifier = Modifier.padding(14.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                  shape = CircleShape,
                  color = Color(0xFF0A66C2).copy(alpha = 0.15f),
                  modifier = Modifier.size(36.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Icon(
                      imageVector = Icons.Default.AccountBox,
                      contentDescription = "LinkedIn",
                      tint = Color(0xFF0A66C2),
                      modifier = Modifier.size(20.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = LocalizationManager.string("contact_linkedin", currentLanguage),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                  )
                  Text(
                    text = "linkedin.com/in/awiskaracharya",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
              IconButton(onClick = { copyToClipboard("LinkedIn", "https://www.linkedin.com/in/awiskaracharya/") }) {
                Icon(
                  imageVector = Icons.Default.OpenInNew,
                  contentDescription = "Open LinkedIn",
                  modifier = Modifier.size(18.dp)
                )
              }
            }
          }
        }
      }
    }

    // German Language Exam Info Card
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Official German Exams (Goethe & TestDaF)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "• Goethe-Zertifikat A1-B1: Essential for family reunion and Ausbildung (vocational training) in Germany.\n• TestDaF & DSH: B2/C1 levels required for university admissions.\n• ÖSD (Austrian Diploma): Recognized in Germany, Austria, and Switzerland.",
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 22.sp
          )
        }
      }
    }

    // Reset Progress Button
    item {
      OutlinedButton(
        onClick = { showResetDialog = true },
        modifier = Modifier
          .fillMaxWidth()
          .height(50.dp)
          .testTag("btn_reset_progress"),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626))
      ) {
        Icon(imageVector = Icons.Default.DeleteOutline, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(LocalizationManager.string("reset_progress", currentLanguage), fontWeight = FontWeight.SemiBold)
      }
    }
  }

  if (showResetDialog) {
    AlertDialog(
      onDismissRequest = { showResetDialog = false },
      title = { Text("Reset Progress?") },
      text = { Text("Are you sure you want to reset all your completed lessons and scores? This action cannot be undone.") },
      confirmButton = {
        TextButton(
          onClick = {
            onResetProgress()
            showResetDialog = false
            Toast.makeText(context, "Progress reset successfully", Toast.LENGTH_SHORT).show()
          }
        ) {
          Text("Reset", color = Color(0xFFDC2626), fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(onClick = { showResetDialog = false }) {
          Text("Cancel")
        }
      }
    )
  }
}
