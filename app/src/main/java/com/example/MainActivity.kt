package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.data.model.AppLanguage
import com.example.data.model.LocalizationManager
import com.example.data.prefs.UserProgressManager
import com.example.ui.components.GermanFlagBadge
import com.example.ui.components.LanguageSwitchDialog
import com.example.ui.screens.*
import com.example.ui.theme.DeutschLernenTheme
import com.example.ui.theme.GermanGold
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch

enum class AppNavTab {
  HOME,
  LEARN,
  PRACTICE,
  ABOUT
}

enum class SubScreen {
  NONE,
  CULTURE_HISTORY,
  GRAMMAR_REFERENCE
}

class MainActivity : ComponentActivity() {
  private lateinit var ttsHelper: TextToSpeechHelper
  private lateinit var progressManager: UserProgressManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    ttsHelper = TextToSpeechHelper(this)
    progressManager = UserProgressManager(this)

    setContent {
      DeutschLernenTheme {
        MainAppContent(
          ttsHelper = ttsHelper,
          progressManager = progressManager
        )
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    ttsHelper.shutdown()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContent(
  ttsHelper: TextToSpeechHelper,
  progressManager: UserProgressManager
) {
  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val coroutineScope = rememberCoroutineScope()

  var currentTab by remember { mutableStateOf(AppNavTab.HOME) }
  var subScreen by remember { mutableStateOf(SubScreen.NONE) }
  var initialCultureTab by remember { mutableIntStateOf(0) }
  var practiceInitialMode by remember { mutableStateOf<String?>(null) }
  var learnLessonIdToOpen by remember { mutableStateOf<String?>(null) }

  var currentLanguage by remember { mutableStateOf(progressManager.currentLanguage) }
  var isSlowAudio by remember { mutableStateOf(progressManager.isSlowAudio) }
  var completedLessons by remember { mutableStateOf(progressManager.getCompletedLessons()) }
  var bookmarkedVocabs by remember { mutableStateOf(progressManager.getBookmarkedVocab()) }
  var derDieDasHighScore by remember { mutableIntStateOf(progressManager.derDieDasHighScore) }
  var dailyStreak by remember { mutableIntStateOf(progressManager.getDailyStreak()) }

  var showLanguageDialog by remember { mutableStateOf(false) }

  // Back button handling when on sub-screens
  if (subScreen != SubScreen.NONE) {
    BackHandler {
      subScreen = SubScreen.NONE
    }
  } else if (currentTab != AppNavTab.HOME) {
    BackHandler {
      currentTab = AppNavTab.HOME
    }
  }

  fun handleSpeak(text: String) {
    ttsHelper.speak(text, isSlow = isSlowAudio)
  }

  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
      ModalDrawerSheet(
        modifier = Modifier.width(320.dp)
      ) {
        // Drawer Header with German Flag and App Title
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(20.dp)
        ) {
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              GermanFlagBadge()
              Spacer(modifier = Modifier.width(10.dp))
              Text(
                text = "DeutschLernen",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
              )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = LocalizationManager.string("app_subtitle", currentLanguage),
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Language Switcher Tile in Drawer
        Surface(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              coroutineScope.launch { drawerState.close() }
              showLanguageDialog = true
            },
          color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(imageVector = Icons.Default.Language, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = LocalizationManager.string("select_language", currentLanguage),
                  style = MaterialTheme.typography.titleSmall,
                  fontWeight = FontWeight.SemiBold
                )
                Text(
                  text = "${currentLanguage.flagEmoji} ${currentLanguage.nativeName}",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.primary
                )
              }
            }
            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
          }
        }

        // Slow / Normal Speed Toggle Tile in Drawer
        Surface(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              isSlowAudio = !isSlowAudio
              progressManager.isSlowAudio = isSlowAudio
            },
          color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = if (isSlowAudio) Icons.Default.DirectionsWalk else Icons.Default.DirectionsRun,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = "Audio-Geschwindigkeit",
                  style = MaterialTheme.typography.titleSmall,
                  fontWeight = FontWeight.SemiBold
                )
                Text(
                  text = if (isSlowAudio) LocalizationManager.string("slow_audio", currentLanguage) else LocalizationManager.string("normal_audio", currentLanguage),
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.primary
                )
              }
            }
            Switch(
              checked = isSlowAudio,
              onCheckedChange = {
                isSlowAudio = it
                progressManager.isSlowAudio = it
              }
            )
          }
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

        // Navigation Items in Drawer
        NavigationDrawerItem(
          label = { Text(LocalizationManager.string("culture_traditions", currentLanguage)) },
          icon = { Icon(Icons.Default.Festival, contentDescription = null) },
          selected = subScreen == SubScreen.CULTURE_HISTORY && initialCultureTab == 0,
          onClick = {
            coroutineScope.launch { drawerState.close() }
            initialCultureTab = 0
            subScreen = SubScreen.CULTURE_HISTORY
          },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
          label = { Text(LocalizationManager.string("history_milestones", currentLanguage)) },
          icon = { Icon(Icons.Default.AccountBalance, contentDescription = null) },
          selected = subScreen == SubScreen.CULTURE_HISTORY && initialCultureTab == 1,
          onClick = {
            coroutineScope.launch { drawerState.close() }
            initialCultureTab = 1
            subScreen = SubScreen.CULTURE_HISTORY
          },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
          label = { Text(LocalizationManager.string("grammar_guide", currentLanguage)) },
          icon = { Icon(Icons.Default.MenuBook, contentDescription = null) },
          selected = subScreen == SubScreen.GRAMMAR_REFERENCE,
          onClick = {
            coroutineScope.launch { drawerState.close() }
            subScreen = SubScreen.GRAMMAR_REFERENCE
          },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

        NavigationDrawerItem(
          label = { Text(LocalizationManager.string("about_developer", currentLanguage)) },
          icon = { Icon(Icons.Default.ContactSupport, contentDescription = null) },
          selected = currentTab == AppNavTab.ABOUT && subScreen == SubScreen.NONE,
          onClick = {
            coroutineScope.launch { drawerState.close() }
            subScreen = SubScreen.NONE
            currentTab = AppNavTab.ABOUT
          },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
      }
    }
  ) {
    Scaffold(
      modifier = Modifier.fillMaxSize(),
      topBar = {
        TopAppBar(
          title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
              GermanFlagBadge()
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "DeutschLernen",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
              )
            }
          },
          navigationIcon = {
            IconButton(
              onClick = { coroutineScope.launch { drawerState.open() } },
              modifier = Modifier.testTag("drawer_menu_button")
            ) {
              Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
          },
          actions = {
            // Speed toggle in top bar (turtle icon when slow, speed indicator)
            IconButton(
              onClick = {
                isSlowAudio = !isSlowAudio
                progressManager.isSlowAudio = isSlowAudio
              },
              modifier = Modifier.testTag("topbar_speed_toggle")
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isSlowAudio) GermanGold.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.padding(2.dp)
              ) {
                Text(
                  text = if (isSlowAudio) "0.7x" else "1.0x",
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.sp,
                  color = if (isSlowAudio) GermanGold else MaterialTheme.colorScheme.onSurfaceVariant,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                )
              }
            }

            // Language switch icon in top bar
            IconButton(
              onClick = { showLanguageDialog = true },
              modifier = Modifier.testTag("topbar_language_button")
            ) {
              Text(text = currentLanguage.flagEmoji, fontSize = 20.sp)
            }
          },
          colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
          )
        )
      },
      bottomBar = {
        if (subScreen == SubScreen.NONE) {
          NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp
          ) {
            // 1. Home Tab
            NavigationBarItem(
              selected = currentTab == AppNavTab.HOME,
              onClick = { currentTab = AppNavTab.HOME },
              icon = {
                Icon(
                  imageVector = if (currentTab == AppNavTab.HOME) Icons.Default.Home else Icons.Default.Home,
                  contentDescription = "Home"
                )
              },
              label = {
                Text(
                  text = LocalizationManager.string("nav_home", currentLanguage),
                  fontSize = 11.sp,
                  fontWeight = if (currentTab == AppNavTab.HOME) FontWeight.Bold else FontWeight.Normal
                )
              },
              modifier = Modifier.testTag("nav_tab_home")
            )

            // 2. Learn Tab
            NavigationBarItem(
              selected = currentTab == AppNavTab.LEARN,
              onClick = {
                learnLessonIdToOpen = null
                currentTab = AppNavTab.LEARN
              },
              icon = {
                Icon(
                  imageVector = Icons.Default.School,
                  contentDescription = "Learn"
                )
              },
              label = {
                Text(
                  text = LocalizationManager.string("nav_learn", currentLanguage),
                  fontSize = 11.sp,
                  fontWeight = if (currentTab == AppNavTab.LEARN) FontWeight.Bold else FontWeight.Normal
                )
              },
              modifier = Modifier.testTag("nav_tab_learn")
            )

            // 3. Practice Tab
            NavigationBarItem(
              selected = currentTab == AppNavTab.PRACTICE,
              onClick = { currentTab = AppNavTab.PRACTICE },
              icon = {
                Icon(
                  imageVector = Icons.Default.SportsEsports,
                  contentDescription = "Practice"
                )
              },
              label = {
                Text(
                  text = LocalizationManager.string("nav_practice", currentLanguage),
                  fontSize = 11.sp,
                  fontWeight = if (currentTab == AppNavTab.PRACTICE) FontWeight.Bold else FontWeight.Normal
                )
              },
              modifier = Modifier.testTag("nav_tab_practice")
            )

            // 4. About Tab
            NavigationBarItem(
              selected = currentTab == AppNavTab.ABOUT,
              onClick = { currentTab = AppNavTab.ABOUT },
              icon = {
                Icon(
                  imageVector = Icons.Default.Info,
                  contentDescription = "About"
                )
              },
              label = {
                Text(
                  text = LocalizationManager.string("nav_about", currentLanguage),
                  fontSize = 11.sp,
                  fontWeight = if (currentTab == AppNavTab.ABOUT) FontWeight.Bold else FontWeight.Normal
                )
              },
              modifier = Modifier.testTag("nav_tab_about")
            )
          }
        }
      }
    ) { innerPadding ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding)
      ) {
        when {
          subScreen == SubScreen.CULTURE_HISTORY -> {
            CultureHistoryScreen(
              currentLanguage = currentLanguage,
              onSpeak = ::handleSpeak,
              initialTab = initialCultureTab,
              onBack = { subScreen = SubScreen.NONE }
            )
          }
          subScreen == SubScreen.GRAMMAR_REFERENCE -> {
            GrammarReferenceScreen(
              currentLanguage = currentLanguage,
              onBack = { subScreen = SubScreen.NONE }
            )
          }
          else -> {
            when (currentTab) {
              AppNavTab.HOME -> {
                HomeScreen(
                  currentLanguage = currentLanguage,
                  onLanguageSelected = { lang ->
                    currentLanguage = lang
                    progressManager.currentLanguage = lang
                  },
                  onSpeak = ::handleSpeak,
                  dailyStreak = dailyStreak,
                  onNavigateToPracticeMode = { mode ->
                    practiceInitialMode = mode
                    currentTab = AppNavTab.PRACTICE
                  },
                  onNavigateToLearnLesson = { lessonId ->
                    learnLessonIdToOpen = lessonId
                    currentTab = AppNavTab.LEARN
                  },
                  onNavigateToCulture = {
                    initialCultureTab = 0
                    subScreen = SubScreen.CULTURE_HISTORY
                  },
                  onNavigateToHistory = {
                    initialCultureTab = 1
                    subScreen = SubScreen.CULTURE_HISTORY
                  }
                )
              }
              AppNavTab.LEARN -> {
                LearnScreen(
                  currentLanguage = currentLanguage,
                  onSpeak = ::handleSpeak,
                  completedLessonIds = completedLessons,
                  onLessonCompleted = { id ->
                    progressManager.setLessonCompleted(id)
                    completedLessons = progressManager.getCompletedLessons()
                  },
                  bookmarkedVocabIds = bookmarkedVocabs,
                  onToggleBookmark = { id ->
                    progressManager.toggleBookmarkVocab(id)
                    bookmarkedVocabs = progressManager.getBookmarkedVocab()
                  },
                  selectedLessonIdFromExternal = learnLessonIdToOpen
                )
              }
              AppNavTab.PRACTICE -> {
                PracticeScreen(
                  currentLanguage = currentLanguage,
                  onSpeak = ::handleSpeak,
                  highScore = derDieDasHighScore,
                  onUpdateHighScore = { score ->
                    derDieDasHighScore = score
                    progressManager.derDieDasHighScore = score
                  },
                  initialMode = practiceInitialMode
                )
              }
              AppNavTab.ABOUT -> {
                AboutScreen(
                  currentLanguage = currentLanguage,
                  onResetProgress = {
                    progressManager.resetAllProgress()
                    completedLessons = emptySet()
                    bookmarkedVocabs = emptySet()
                    derDieDasHighScore = 0
                    dailyStreak = 1
                  }
                )
              }
            }
          }
        }
      }
    }
  }

  if (showLanguageDialog) {
    LanguageSwitchDialog(
      currentLanguage = currentLanguage,
      onLanguageSelected = { lang ->
        currentLanguage = lang
        progressManager.currentLanguage = lang
      },
      onDismiss = { showLanguageDialog = false }
    )
  }
}
