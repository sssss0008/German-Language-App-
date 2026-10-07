package com.example.data.model

data class VocabularyItem(
  val id: String,
  val german: String,
  val article: String? = null, // "der", "die", "das"
  val plural: String? = null,
  val ipa: String? = null,
  val english: String,
  val nepali: String,
  val japanese: String,
  val exampleGerman: String,
  val exampleEnglish: String,
  val exampleNepali: String,
  val exampleJapanese: String,
  val category: String = "General"
) {
  fun getTranslation(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> english
      AppLanguage.GERMAN -> german
      AppLanguage.NEPALI -> nepali
      AppLanguage.JAPANESE -> japanese
    }
  }

  fun getExampleTranslation(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> exampleEnglish
      AppLanguage.GERMAN -> exampleGerman
      AppLanguage.NEPALI -> exampleNepali
      AppLanguage.JAPANESE -> exampleJapanese
    }
  }

  val fullGerman: String
    get() = if (article != null) "$article $german" else german
}

data class DialogueTurn(
  val speaker: String,
  val german: String,
  val english: String,
  val nepali: String,
  val japanese: String
) {
  fun getTranslation(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> english
      AppLanguage.GERMAN -> german
      AppLanguage.NEPALI -> nepali
      AppLanguage.JAPANESE -> japanese
    }
  }
}

data class Lesson(
  val id: String,
  val level: String, // "A1.1", "A1.2", "A2.1", "A2.2", "B1"
  val titleDe: String,
  val titleEn: String,
  val titleNe: String,
  val titleJa: String,
  val descriptionEn: String,
  val descriptionNe: String,
  val descriptionJa: String,
  val grammarRuleTitle: String,
  val grammarRuleDe: String,
  val grammarRuleEn: String,
  val grammarRuleNe: String,
  val grammarRuleJa: String,
  val cultureTipDe: String,
  val cultureTipEn: String,
  val cultureTipNe: String,
  val cultureTipJa: String,
  val dialogue: List<DialogueTurn>,
  val vocabulary: List<VocabularyItem>
) {
  fun getTitle(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> "$titleDe ($titleEn)"
      AppLanguage.GERMAN -> titleDe
      AppLanguage.NEPALI -> "$titleDe ($titleNe)"
      AppLanguage.JAPANESE -> "$titleDe ($titleJa)"
    }
  }

  fun getDescription(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> descriptionEn
      AppLanguage.GERMAN -> descriptionEn
      AppLanguage.NEPALI -> descriptionNe
      AppLanguage.JAPANESE -> descriptionJa
    }
  }

  fun getGrammarExplanation(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> grammarRuleEn
      AppLanguage.GERMAN -> grammarRuleDe
      AppLanguage.NEPALI -> grammarRuleNe
      AppLanguage.JAPANESE -> grammarRuleJa
    }
  }

  fun getCultureTip(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> cultureTipEn
      AppLanguage.GERMAN -> cultureTipDe
      AppLanguage.NEPALI -> cultureTipNe
      AppLanguage.JAPANESE -> cultureTipJa
    }
  }
}

data class CultureTopic(
  val id: String,
  val titleDe: String,
  val titleEn: String,
  val titleNe: String,
  val titleJa: String,
  val category: String, // Tradition, Landmark, Food, Lifestyle
  val drawableRes: Int,
  val badgeText: String,
  val summaryEn: String,
  val summaryNe: String,
  val summaryJa: String,
  val fullStoryEn: String,
  val fullStoryNe: String,
  val fullStoryJa: String,
  val funFactDe: String,
  val funFactEn: String,
  val funFactNe: String,
  val funFactJa: String,
  val vocabulary: List<VocabularyItem>
) {
  fun getTitle(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> titleEn
      AppLanguage.GERMAN -> titleDe
      AppLanguage.NEPALI -> titleNe
      AppLanguage.JAPANESE -> titleJa
    }
  }

  fun getSummary(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> summaryEn
      AppLanguage.GERMAN -> summaryEn
      AppLanguage.NEPALI -> summaryNe
      AppLanguage.JAPANESE -> summaryJa
    }
  }

  fun getStory(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> fullStoryEn
      AppLanguage.GERMAN -> fullStoryEn
      AppLanguage.NEPALI -> fullStoryNe
      AppLanguage.JAPANESE -> fullStoryJa
    }
  }

  fun getFunFact(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> funFactEn
      AppLanguage.GERMAN -> funFactDe
      AppLanguage.NEPALI -> funFactNe
      AppLanguage.JAPANESE -> funFactJa
    }
  }
}

data class HistoryMilestone(
  val id: String,
  val era: String,
  val year: String,
  val titleDe: String,
  val titleEn: String,
  val titleNe: String,
  val titleJa: String,
  val drawableRes: Int,
  val overviewEn: String,
  val overviewNe: String,
  val overviewJa: String,
  val detailsEn: String,
  val detailsNe: String,
  val detailsJa: String,
  val languageEvolutionNoteEn: String,
  val languageEvolutionNoteNe: String,
  val languageEvolutionNoteJa: String
) {
  fun getTitle(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> titleEn
      AppLanguage.GERMAN -> titleDe
      AppLanguage.NEPALI -> titleNe
      AppLanguage.JAPANESE -> titleJa
    }
  }

  fun getOverview(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> overviewEn
      AppLanguage.GERMAN -> overviewEn
      AppLanguage.NEPALI -> overviewNe
      AppLanguage.JAPANESE -> overviewJa
    }
  }

  fun getDetails(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> detailsEn
      AppLanguage.GERMAN -> detailsEn
      AppLanguage.NEPALI -> detailsNe
      AppLanguage.JAPANESE -> detailsJa
    }
  }

  fun getLinguisticNote(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> languageEvolutionNoteEn
      AppLanguage.GERMAN -> languageEvolutionNoteEn
      AppLanguage.NEPALI -> languageEvolutionNoteNe
      AppLanguage.JAPANESE -> languageEvolutionNoteJa
    }
  }
}

enum class QuizType {
  MULTIPLE_CHOICE,
  GENDER_DER_DIE_DAS,
  LISTENING,
  GRAMMAR_CASE
}

data class QuizQuestion(
  val id: String,
  val type: QuizType,
  val promptGerman: String,
  val promptEnglish: String,
  val promptNepali: String,
  val promptJapanese: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanationEnglish: String,
  val explanationNepali: String,
  val explanationJapanese: String,
  val audioToPlay: String? = null
) {
  fun getPrompt(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> promptEnglish
      AppLanguage.GERMAN -> promptGerman
      AppLanguage.NEPALI -> promptNepali
      AppLanguage.JAPANESE -> promptJapanese
    }
  }

  fun getExplanation(language: AppLanguage): String {
    return when (language) {
      AppLanguage.ENGLISH -> explanationEnglish
      AppLanguage.GERMAN -> explanationEnglish
      AppLanguage.NEPALI -> explanationNepali
      AppLanguage.JAPANESE -> explanationJapanese
    }
  }
}
