package com.example.data.content

import com.example.R
import com.example.data.model.CultureTopic
import com.example.data.model.DialogueTurn
import com.example.data.model.HistoryMilestone
import com.example.data.model.Lesson
import com.example.data.model.QuizQuestion
import com.example.data.model.QuizType
import com.example.data.model.VocabularyItem

object GermanLearningData {

  // Word of the Day collection
  val wordsOfTheDay = listOf(
    VocabularyItem(
      id = "wod_1",
      german = "Wanderlust",
      article = "die",
      plural = "die Wanderlust",
      ipa = "[ˈvandɐˌlʊst]",
      english = "Desire to travel / love of hiking",
      nepali = "यात्रा गर्ने तीव्र चाहना / घुम्ने रहर",
      japanese = "旅心 / 放浪癖",
      exampleGerman = "Die Wanderlust packt mich jeden Frühling.",
      exampleEnglish = "Wanderlust catches me every spring.",
      exampleNepali = "मलाई हरेक वसन्तमा यात्रा गर्ने रहर जाग्छ।",
      exampleJapanese = "毎春、旅に出たい衝動に駆られます。",
      category = "Culture"
    ),
    VocabularyItem(
      id = "wod_2",
      german = "Gemütlichkeit",
      article = "die",
      plural = "die Gemütlichkeit",
      ipa = "[ɡəˈmyːtlɪçkaɪt]",
      english = "Cozy friendliness / warmth & comfort",
      nepali = "न्यानोपन, आराम र आत्मीयता",
      japanese = "居心地の良さ / アットホームな温もり",
      exampleGerman = "In diesem bayerischen Café herrscht echte Gemütlichkeit.",
      exampleEnglish = "There is real coziness in this Bavarian café.",
      exampleNepali = "यो बाभारियन क्याफेमा साँच्चिकै आत्मीय न्यानोपन छ।",
      exampleJapanese = "このバイエルンのカフェには温かい居心地の良さがあります。",
      category = "Culture"
    ),
    VocabularyItem(
      id = "wod_3",
      german = "Feierabend",
      article = "der",
      plural = "die Feierabende",
      ipa = "[ˈfaɪ̯ɐˌʔaːbn̩t]",
      english = "End of workday / leisure evening",
      nepali = "काम सकिएपछिको फुर्सदको साँझ",
      japanese = "仕事終わりのくつろぎ時間 / 終業後",
      exampleGerman = "Schönen Feierabend! Bis morgen!",
      exampleEnglish = "Have a great evening after work! See you tomorrow!",
      exampleNepali = "काम सकिएपछिको साँझ शुभ रहोस्! भोलि भेटौँला!",
      exampleJapanese = "お仕事お疲れ様でした！また明日！",
      category = "Daily Life"
    ),
    VocabularyItem(
      id = "wod_4",
      german = "Fernweh",
      article = "das",
      plural = "das Fernweh",
      ipa = "[ˈfɛʁnˌveː]",
      english = "Longing for faraway places",
      nepali = "टाढाका सुन्दर ठाउँहरू पुग्ने चाहना",
      japanese = "遠い国への憧れ",
      exampleGerman = "Wenn ich Fotos von den Alpen sehe, bekomme ich Fernweh.",
      exampleEnglish = "When I see photos of the Alps, I get wanderlust for distant places.",
      exampleNepali = "आल्प्स पर्वतका तस्बिरहरू देख्दा मलाई त्यहाँ पुग्ने रहर जाग्छ।",
      exampleJapanese = "アルプスの写真を見ると、遠くへ行きたい憧れが湧きます。",
      category = "Emotion"
    )
  )

  val phrasesOfTheDay = listOf(
    VocabularyItem(
      id = "pod_1",
      german = "Übung macht den Meister",
      english = "Practice makes perfect",
      nepali = "अभ्यासले नै मानिसलाई दक्ष बनाउँछ",
      japanese = "習うより慣れろ / 継続は力なり",
      exampleGerman = "Lerne jeden Tag ein bisschen Deutsch, denn Übung macht den Meister!",
      exampleEnglish = "Learn a bit of German every day, because practice makes perfect!",
      exampleNepali = "हरेक दिन थोरै जर्मन सिक्नुहोस्, किनकि अभ्यासले नै मानिसलाई दक्ष बनाउँछ!",
      exampleJapanese = "毎日少しずつドイツ語を学びましょう。継続こそ力なり！",
      category = "Proverb"
    ),
    VocabularyItem(
      id = "pod_2",
      german = "Ich drücke dir die Daumen!",
      english = "I keep my fingers crossed for you!",
      nepali = "तिम्रो सफलताको शुभकामना दिन्छु!",
      japanese = "幸運を祈っています！",
      exampleGerman = "Viel Erfolg bei der Prüfung! Ich drücke dir die Daumen!",
      exampleEnglish = "Good luck on the exam! I keep my fingers crossed for you!",
      exampleNepali = "परीक्षामा सफलता मिलोस्! म तिम्रो सफलताको कामना गर्दछु!",
      exampleJapanese = "試験頑張って！成功を祈っています！",
      category = "Idiom"
    ),
    VocabularyItem(
      id = "pod_3",
      german = "Das Leben ist kein Ponyhof",
      english = "Life isn't always easy (life is no pony farm)",
      nepali = "जिन्दगी सधैँ सजिलो हुँदैन",
      japanese = "人生は甘くない",
      exampleGerman = "Es ist anstrengend, aber das Leben ist kein Ponyhof.",
      exampleEnglish = "It is tough, but life isn't always a walk in the park.",
      exampleNepali = "यो गाह्रो छ, तर जीवन सधैं सजिलो हुँदैन।",
      exampleJapanese = "大変だけど、人生は甘いことばかりじゃないよ。",
      category = "Idiom"
    )
  )

  // Dedicated bank of nouns for the Der/Die/Das Trainer game
  val genderTrainingNouns = listOf(
    VocabularyItem(
      id = "g_1",
      german = "Apfel",
      article = "der",
      plural = "die Äpfel",
      english = "Apple",
      nepali = "स्याउ",
      japanese = "りんご",
      exampleGerman = "Der Apfel ist rot und süß.",
      exampleEnglish = "The apple is red and sweet.",
      exampleNepali = "स्याउ रातो र गुलियो छ।",
      exampleJapanese = "りんごは赤くて甘いです。"
    ),
    VocabularyItem(
      id = "g_2",
      german = "Sonne",
      article = "die",
      plural = "die Sonnen",
      english = "Sun",
      nepali = "सूर्य",
      japanese = "太陽",
      exampleGerman = "Die Sonne scheint heute hell.",
      exampleEnglish = "The sun is shining brightly today.",
      exampleNepali = "आज घाम चम्किलो लागेको छ।",
      exampleJapanese = "今日は太陽が明るく輝いています。"
    ),
    VocabularyItem(
      id = "g_3",
      german = "Buch",
      article = "das",
      plural = "die Bücher",
      english = "Book",
      nepali = "किताब",
      japanese = "本",
      exampleGerman = "Das Buch ist sehr spannend.",
      exampleEnglish = "The book is very exciting.",
      exampleNepali = "किताब धेरै चाखलाग्दो छ।",
      exampleJapanese = "その本はとても面白いです。"
    ),
    VocabularyItem(
      id = "g_4",
      german = "Tisch",
      article = "der",
      plural = "die Tische",
      english = "Table",
      nepali = "टेबुल",
      japanese = "机 / テーブル",
      exampleGerman = "Der Tisch steht im Zimmer.",
      exampleEnglish = "The table is in the room.",
      exampleNepali = "टेबुल कोठामा छ।",
      exampleJapanese = "テーブルは部屋の中にあります。"
    ),
    VocabularyItem(
      id = "g_5",
      german = "Katze",
      article = "die",
      plural = "die Katzen",
      english = "Cat",
      nepali = "बिरालो",
      japanese = "猫",
      exampleGerman = "Die Katze schläft auf dem Sofa.",
      exampleEnglish = "The cat is sleeping on the couch.",
      exampleNepali = "बिरालो सोफामा सुतिरहेको छ।",
      exampleJapanese = "猫はソファの上で寝ています。"
    ),
    VocabularyItem(
      id = "g_6",
      german = "Auto",
      article = "das",
      plural = "die Autos",
      english = "Car",
      nepali = "गाडी / कार",
      japanese = "車",
      exampleGerman = "Das Auto fährt sehr schnell.",
      exampleEnglish = "The car drives very fast.",
      exampleNepali = "कार धेरै छिटो गुड्छ।",
      exampleJapanese = "車はとても速く走ります。"
    ),
    VocabularyItem(
      id = "g_7",
      german = "Kaffee",
      article = "der",
      plural = "die Kaffees",
      english = "Coffee",
      nepali = "कफी",
      japanese = "コーヒー",
      exampleGerman = "Der Kaffee schmeckt fantastisch.",
      exampleEnglish = "The coffee tastes fantastic.",
      exampleNepali = "कफी निकै मिठो छ।",
      exampleJapanese = "コーヒーは素晴らしい味がします。"
    ),
    VocabularyItem(
      id = "g_8",
      german = "Blume",
      article = "die",
      plural = "die Blumen",
      english = "Flower",
      nepali = "फूल",
      japanese = "花",
      exampleGerman = "Die Blume duftet herrlich.",
      exampleEnglish = "The flower smells lovely.",
      exampleNepali = "फूलको बास्ना मिठो छ।",
      exampleJapanese = "花がとても良い香りを放っています。"
    ),
    VocabularyItem(
      id = "g_9",
      german = "Mädchen",
      article = "das",
      plural = "die Mädchen",
      english = "Girl (Diminutive -chen is always das)",
      nepali = "केटी (-chen अन्त्य हुने शब्द 'das' हुन्छ)",
      japanese = "少女（-chen語尾は中性）",
      exampleGerman = "Das Mädchen lernt fleißig Deutsch.",
      exampleEnglish = "The girl is studying German diligently.",
      exampleNepali = "केटीले मिहिनेत गरेर जर्मन सिकिरहेकी छिन्।",
      exampleJapanese = "少女は熱心にドイツ語を勉強しています。"
    ),
    VocabularyItem(
      id = "g_10",
      german = "Hund",
      article = "der",
      plural = "die Hunde",
      english = "Dog",
      nepali = "कुकुर",
      japanese = "犬",
      exampleGerman = "Der Hund spielt im Garten.",
      exampleEnglish = "The dog is playing in the garden.",
      exampleNepali = "कुकुर बगैँचामा खेलिरहेको छ।",
      exampleJapanese = "犬は庭で遊んでいます。"
    ),
    VocabularyItem(
      id = "g_11",
      german = "Zeitung",
      article = "die",
      plural = "die Zeitungen",
      english = "Newspaper (-ung ending is always die)",
      nepali = "पत्रिका (-ung अन्त्य हुने शब्द सधैँ 'die' हुन्छ)",
      japanese = "新聞（-ung語尾は女性）",
      exampleGerman = "Die Zeitung berichtet über Kultur.",
      exampleEnglish = "The newspaper reports about culture.",
      exampleNepali = "पत्रिकामा संस्कृतिको बारेमा लेखिएको छ।",
      exampleJapanese = "新聞は文化について報じています。"
    ),
    VocabularyItem(
      id = "g_12",
      german = "Brot",
      article = "das",
      plural = "die Brote",
      english = "Bread",
      nepali = "पाउरोटी / रोटी",
      japanese = "パン",
      exampleGerman = "Das deutsche Brot ist weltberühmt.",
      exampleEnglish = "German bread is world famous.",
      exampleNepali = "जर्मन पाउरोटी विश्वभर प्रसिद्ध छ।",
      exampleJapanese = "ドイツのパンは世界的に有名です。"
    ),
    VocabularyItem(
      id = "g_13",
      german = "Mond",
      article = "der",
      plural = "die Monde",
      english = "Moon",
      nepali = "चन्द्रमा",
      japanese = "月",
      exampleGerman = "Der Mond leuchtet in der Nacht.",
      exampleEnglish = "The moon shines at night.",
      exampleNepali = "चन्द्रमा रातमा चम्किन्छ।",
      exampleJapanese = "月は夜に輝きます。"
    ),
    VocabularyItem(
      id = "g_14",
      german = "Schokolade",
      article = "die",
      plural = "die Schokoladen",
      english = "Chocolate (-e ending usually die)",
      nepali = "चकलेट (-e अन्त्य हुने शब्द प्रायः 'die' हुन्छ)",
      japanese = "チョコレート（-e語尾は女性が多い）",
      exampleGerman = "Die Schokolade ist zartbitter.",
      exampleEnglish = "The chocolate is dark chocolate.",
      exampleNepali = "चकलेट डार्क चकलेट हो।",
      exampleJapanese = "チョコレートはビターです。"
    ),
    VocabularyItem(
      id = "g_15",
      german = "Haus",
      article = "das",
      plural = "die Häuser",
      english = "House",
      nepali = "घर",
      japanese = "家",
      exampleGerman = "Das Haus ist modern und gemütlich.",
      exampleEnglish = "The house is modern and cozy.",
      exampleNepali = "घर आधुनिक र आरामदायी छ।",
      exampleJapanese = "その家はモダンで居心地が良いです。"
    )
  )

  // Curriculum Lessons
  val lessons = listOf(
    Lesson(
      id = "lesson_1",
      level = "A1.1",
      titleDe = "Das Alphabet & Aussprache",
      titleEn = "Alphabet & Pronunciation",
      titleNe = "जर्मन वर्णमाला र उच्चारण",
      titleJa = "アルファベットと発音",
      descriptionEn = "Master German letters, umlauts (Ä, Ö, Ü), and the Eszett (ß)",
      descriptionNe = "जर्मन अक्षरहरू, उमलाउट (Ä, Ö, Ü) र एस्जेट (ß) को शुद्ध उच्चारण सिक्नुहोस्",
      descriptionJa = "ドイツ語の文字、ウムラウト（Ä, Ö, Ü）、エスツェット（ß）の正確な発音",
      grammarRuleTitle = "Umlauts & Special German Sounds",
      grammarRuleDe = "Im Deutschen gibt es die Umlaute Ä, Ö, Ü und das Eszett ß. 'ei' spricht man wie 'ai' aus, 'ie' wie langes 'i', 'eu'/'äu' wie 'oi'.",
      grammarRuleEn = "In German, there are 3 Umlauts (Ä, Ö, Ü) and the letter ß (Eszett / double S).\n• Ä: sounds like 'e' in 'bed' (Äpfel)\n• Ö: round lips and say 'eh' (Öl, schön)\n• Ü: round lips and say 'ee' (über, grün)\n• ei: pronounced like English 'eye' (mein, nein)\n• ie: pronounced like long 'ee' (sie, Bier)\n• eu / äu: pronounced like 'oy' in 'boy' (heute, Häuser)\n• w: sounds like English 'v' (Wasser)",
      grammarRuleNe = "जर्मन भाषामा २६ अंग्रेजी अक्षरबाहेक ४ वटा विशेष अक्षरहरू हुन्छन्:\n• Ä (ए जस्तो): Äpfel (स्याउहरू)\n• Ö (ओ-ए को संयुक्त आवाज): schön (सुन्दर)\n• Ü (उ-इ को संयुक्त आवाज): über (माथि)\n• ß (दोहोरो s, एस्जेट): Straße (सडक)\n• 'ei' को उच्चारण 'आई' हुन्छ (Nein = नाइन)\n• 'ie' को उच्चारण लामो 'ई' हुन्छ (Bier = बीर)\n• 'w' को उच्चारण 'भ' हुन्छ (Wasser = भासर)",
      grammarRuleJa = "ドイツ語には基本26文字に加え、3つのウムラウト（Ä, Ö, Ü）とエスツェット（ß）があります。\n• Ä：エの音（Äpfel）\n• Ö：オの口でエと発音（schön）\n• Ü：ウの口でイと発音（über, grün）\n• ß：鋭いス（ssと同じ）\n• ei：「アイ」と発音（mein, nein）\n• ie：長音「イー」（Bier, sie）\n• eu / äu：「オイ」と発音（heute, Euro）\n• w：「ヴ」の音（Wasser）",
      cultureTipDe = "Hochdeutsch ist die standardisierte deutsche Schriftsprache, die in ganz Deutschland, Österreich und der Schweiz verstanden wird.",
      cultureTipEn = "Standard German ('Hochdeutsch') was unified largely through Martin Luther's Bible translation in 1522. Today, it allows German speakers across Germany, Austria, and Switzerland to understand each other perfectly despite strong regional dialects (Dialekte).",
      cultureTipNe = "मानक जर्मन भाषा ('होखडोइच') मार्टिन लुथरको बाइबल अनुवादपछि स्थापित भएको हो। आज यो भाषा जर्मनी, अस्ट्रिया र स्विट्जरल्याण्डभरि बोलिन्छ र बुझिन्छ।",
      cultureTipJa = "標準ドイツ語（Hochdeutsch）は1522年のルターによる聖書翻訳を契機に普及しました。ドイツ各地に方言はありますが、ニュースや学校教育はすべて標準語で行われます。",
      dialogue = listOf(
        DialogueTurn("A", "Hallo! Wie heißt du?", "Hello! What is your name?", "नमस्ते! तिम्रो नाम के हो?", "こんにちは！お名前は何ですか？"),
        DialogueTurn("B", "Ich heiße Lukas. Und du?", "My name is Lukas. And you?", "मेरो नाम लुकास हो। अनि तिम्रो?", "私はルーカスです。あなたは？"),
        DialogueTurn("A", "Ich bin Sarah. Freut mich!", "I am Sarah. Pleased to meet you!", "म सारा हुँ। तिमीलाई भेटेर खुसी लाग्यो!", "私はサラです。はじめまして！")
      ),
      vocabulary = listOf(
        VocabularyItem("v_1_1", "Hallo", null, null, "[ˈhaloː]", "Hello / Hi", "नमस्ते / हेल्लो", "こんにちは", "Hallo, wie geht es dir?", "Hello, how are you?", "नमस्ते, तिमीलाई कस्तो छ?", "こんにちは、元気ですか？", "Greetings"),
        VocabularyItem("v_1_2", "Guten Morgen", null, null, "[ˌɡuːtn̩ ˈmɔʁɡn̩]", "Good morning", "शुभ प्रभात", "おはようございます", "Guten Morgen, Herr Müller!", "Good morning, Mr. Müller!", "शुभ प्रभात, श्रीमान म्युलर!", "ミュラーさん、おはようございます！", "Greetings"),
        VocabularyItem("v_1_3", "Guten Tag", null, null, "[ˌɡuːtn̩ ˈtaːk]", "Good day / Hello", "शुभ दिन / नमस्कार", "こんにちは", "Guten Tag! Willkommen in Deutschland.", "Good day! Welcome to Germany.", "नमस्कार! जर्मनीमा स्वागत छ।", "こんにちは！ドイツへようこそ。", "Greetings"),
        VocabularyItem("v_1_4", "Guten Abend", null, null, "[ˌɡuːtn̩ ˈʔaːbn̩t]", "Good evening", "शुभ सन्ध्या", "こんばんは", "Guten Abend allerseits!", "Good evening everyone!", "सबैलाई शुभ सन्ध्या!", "皆さん、こんばんは！", "Greetings"),
        VocabularyItem("v_1_5", "Auf Wiedersehen", null, null, "[ʔaʊ̯f ˈviːdɐˌzeːən]", "Goodbye (formal)", "पुनः भेटौँला / बिदा", "さようなら", "Auf Wiedersehen und schönen Tag noch!", "Goodbye and have a nice day!", "पुनः भेटौँला, दिन शुभ रहोस्!", "さようなら、良い一日を！", "Farewell"),
        VocabularyItem("v_1_6", "Tschüss", null, null, "[tʃʏs]", "Bye (informal)", "टाटा / बाइ", "じゃあね / バイバイ", "Tschüss! Bis bald!", "Bye! See you soon!", "बाइ! छिट्टै भेटौँला!", "じゃあね！またすぐね！", "Farewell"),
        VocabularyItem("v_1_7", "Bitte", null, null, "[ˈbɪtə]", "Please / You're welcome", "कृपया / स्वागत छ", "お願いします / どういたしまして", "Ein Wasser, bitte.", "A water, please.", "कृपया एक गिलास पानी दिनुहोस्।", "お水を一杯お願いします。", "Basics"),
        VocabularyItem("v_1_8", "Danke", null, null, "[ˈdaŋkə]", "Thank you", "धन्यवाद", "ありがとう", "Danke schön für Ihre Hilfe!", "Thank you very much for your help!", "तपाईंको सहयोगको लागि धेरै धन्यवाद!", "手助けをありがとうございます！", "Basics")
      )
    ),
    Lesson(
      id = "lesson_2",
      level = "A1.1",
      titleDe = "Begrüßungen & Höflichkeit",
      titleEn = "Greetings & Polite Etiquette",
      titleNe = "अभिवादन र शिष्टाचार (Du vs Sie)",
      titleJa = "挨拶と丁寧な表現 (DuとSie)",
      descriptionEn = "Learn polite expressions and understand the difference between informal 'du' and formal 'Sie'",
      descriptionNe = "औपचारिक 'Sie' (तपाईं) र अनौपचारिक 'du' (तिमी) को भिन्नता बुझ्नुहोस्",
      descriptionJa = "親称「du（君）」と敬称「Sie（あなた）」の使い分けと基本マナー",
      grammarRuleTitle = "The Du vs. Sie Distinction in German",
      grammarRuleDe = "'Du' nutzt man für Freunde, Familie und Kinder. 'Sie' ist die höfliche Anrede für Erwachsene, Fremde und im Beruf.",
      grammarRuleEn = "German strictly distinguishes between informal 'du' (you) and formal 'Sie' (always capitalized):\n• 'du': use with friends, fellow students, family members, and children.\n• 'Sie': use with adults you don't know, in shops, at the doctor, and in professional business settings.\nWhen in doubt in Germany, always begin with 'Sie'!",
      grammarRuleNe = "नेपाली भाषामा 'तिमी' र 'तपाईं' जस्तै जर्मनमा पनि भिन्नता छ:\n• 'du' (तिमी): साथीभाइ, परिवार, बालबालिकालाई प्रयोग गरिन्छ।\n• 'Sie' (तपाईं): अपरिचित व्यक्ति, कार्यालय, पसल र सम्मान दिनुपर्ने व्यक्तिसँग प्रयोग गरिन्छ।\nजर्मनीमा शङ्का लाग्दा सधैँ 'Sie' बाट सुरु गर्नु राम्रो मानिन्छ।",
      grammarRuleJa = "ドイツ語には親しい間柄の「du」と、敬称の「Sie（大文字）」の明確な区別があります。\n• du：友人、家族、子供、同年代の学生同士。\n• Sie：初対面の人、ビジネス、店員、医師、上司。\n社会人同士では通常Sieで話し始め、仲良くなると「Duzen（duで呼ぶこと）」を提案し合います。",
      cultureTipDe = "In Deutschland schüttelt man sich traditionell zur Begrüßung kurz und fest die Hand mit direktem Blickkontakt.",
      cultureTipEn = "Germans value firm handshakes with direct eye contact during greetings. Looking away during a greeting or toast ('Prost!') is considered impolite.",
      cultureTipNe = "जर्मनीमा अभिवादन गर्दा आँखामा हेरेर दृढतापूर्वक हात मिलाउने (Handshake) चलन छ।",
      cultureTipJa = "ドイツでは挨拶の際、相手の目を見てしっかり握手するのがマナーです。乾杯（Prost!）の時も必ず相手の目を見つめる習慣があります。",
      dialogue = listOf(
        DialogueTurn("Herr Schmidt", "Guten Tag, Frau Weber! Wie geht es Ihnen?", "Good day, Mrs. Weber! How are you? (formal)", "नमस्कार श्रीमती वेबर! तपाईंलाई कस्तो छ?", "こんにちは、ヴェーバーさん！お元気ですか？"),
        DialogueTurn("Frau Weber", "Danke, gut! Und Ihnen?", "Thanks, good! And you?", "धन्यवाद, सन्चै छ! अनि तपाईंलाई নি?", "ありがとうございます、元気です！あなたはいかがですか？"),
        DialogueTurn("Herr Schmidt", "Auch gut, danke sehr.", "Also good, thank you very much.", "मलाई पनि राम्रो छ, धेरै धन्यवाद।", "私も元気です、ありがとうございます。")
      ),
      vocabulary = listOf(
        VocabularyItem("v_2_1", "Wie geht's?", null, null, "[viː ɡeːts]", "How are you? (informal)", "कस्तो छ? (अनौपचारिक)", "元気？ / 調子はどう？", "Hallo Anna, wie geht's?", "Hi Anna, how are you?", "हेलो अन्ना, कस्तो छ?", "アンナ、元気？", "Conversational"),
        VocabularyItem("v_2_2", "Wie geht es Ihnen?", null, null, "[viː ɡeːt ɛs ˈʔiːnən]", "How are you? (formal)", "तपाईंलाई कस्तो छ? (औपचारिक)", "お元気ですか？", "Guten Tag, wie geht es Ihnen?", "Good day, how are you?", "नमस्कार, तपाईंलाई कस्तो छ?", "こんにちは、お元気ですか？", "Formal"),
        VocabularyItem("v_2_3", "Sehr gut", null, null, "[zeːɐ̯ ɡuːt]", "Very good", "धेरै राम्रो", "とても良いです", "Mir geht es sehr gut, danke!", "I am doing very well, thanks!", "मलाई धेरै राम्रो छ, धन्यवाद!", "とても元気です、ありがとう！", "Feelings"),
        VocabularyItem("v_2_4", "Es geht", null, null, "[ɛs ɡeːt]", "So-so / okay", "ठिकै छ", "まあまあです", "Wie ist die Arbeit? - Es geht.", "How is work? - So-so.", "काम कस्तो छ? - ठिकै छ।", "仕事はどう？ - まあまあかな。", "Feelings"),
        VocabularyItem("v_2_5", "Entschuldigung", "die", "die Entschuldigungen", "[ɛntˈʃʊldɪɡʊŋ]", "Excuse me / Sorry", "माफ गर्नुहोस्", "すみません / ごめんなさい", "Entschuldigung, wo ist der Bahnhof?", "Excuse me, where is the train station?", "माफ गर्नुहोस्, रेल स्टेशन कहाँ छ?", "すみません、駅はどこですか？", "Polite"),
        VocabularyItem("v_2_6", "Ja", null, null, "[jaː]", "Yes", "हो / हजुर", "はい", "Ja, gerne!", "Yes, gladly!", "हो, खुसीसाथ!", "はい、喜んで！", "Basics"),
        VocabularyItem("v_2_7", "Nein", null, null, "[naɪ̯n]", "No", "होइन / अहँ", "いいえ", "Nein, leider nicht.", "No, unfortunately not.", "अहँ, दुर्भाग्यवश होइन।", "いいえ、残念ながら違います。", "Basics"),
        VocabularyItem("v_2_8", "Freut mich", null, null, "[fʁɔɪ̯t mɪç]", "Nice to meet you", "तपाईंलाई भेटेर खुसी लाग्यो", "はじめまして / お会いできて嬉しいです", "Ich bin Alex. - Freut mich!", "I'm Alex. - Nice to meet you!", "म एलेक्स हुँ। - भेटेर खुसी लाग्यो!", "アレックスです。 - はじめまして！", "Polite")
      )
    ),
    Lesson(
      id = "lesson_3",
      level = "A1.1",
      titleDe = "Zahlen, Wochentage & Uhrzeit",
      titleEn = "Numbers, Days & Time",
      titleNe = "सङ्ख्या, हप्ताका दिन र समय",
      titleJa = "数字・曜日・時間",
      descriptionEn = "Count from 1 to 100, tell the time, and master days of the week in German",
      descriptionNe = "१ देखि १०० सम्म गणना, हप्ताका बार र जर्मनमा समय बताउन सिक्नुहोस्",
      descriptionJa = "1〜100の数え方、曜日、ドイツ語特有の時間表現を完全マスター",
      grammarRuleTitle = "German Number Structure (Ones before Tens!)",
      grammarRuleDe = "Ab 21 nennt man erst die Einer, dann 'und', dann die Zehner: 21 = einundzwanzig (eins + und + zwanzig).",
      grammarRuleEn = "In German numbers from 21 to 99, the unit comes BEFORE the ten, joined by 'und':\n• 21 = einundzwanzig (literally: one-and-twenty)\n• 35 = fünfunddreißig (five-and-thirty)\n• 99 = neunundneunzig (nine-and-ninety)\nFor telling time, 'halb vier' (half four) means 3:30 (halfway TO four)!",
      grammarRuleNe = "जर्मनमा २१ देखि ९९ सम्मका सङ्ख्याहरूमा पहिले एकको अङ्क, त्यसपछि 'und' (र), अनि दशकको अङ्क भनिन्छ:\n• २१ = einundzwanzig (एक र बीस)\n• ४५ = fünfundvierzig (पाँच र चालीस)\nसमय बताउँदा 'halb vier' को अर्थ ३:३० (४ बज्न आधा घण्टा बाँकी) हुन्छ!",
      grammarRuleJa = "ドイツ語の21〜99の数字は「1の位 + und（と） + 10の位」の順序で読みます。\n• 21 = einundzwanzig（1と20）\n• 54 = vierundfünfzig（4と50）\n時間を言う時、「halb vier」は3時30分（4時の半分手前）を意味するので注意しましょう！",
      cultureTipDe = "Pünktlichkeit ist in Deutschland ein Zeichen von Respekt und Zuverlässigkeit. Fünf Minuten vor der Zeit ist die deutsche Pünktlichkeit!",
      cultureTipEn = "Germans famously prize punctuality ('Pünktlichkeit'). Arriving 5 minutes early is considered standard, especially for doctor appointments, job interviews, and train schedules.",
      cultureTipNe = "जर्मनीमा समयको पालना (Punctuality) निकै महत्वपूर्ण मानिन्छ। तोकिएको समयभन्दा ५ मिनेट अगाडि पुग्नुलाई राम्रो मानिन्छ।",
      cultureTipJa = "ドイツでは時間を守ること（Pünktlichkeit）が信頼の基本です。面接や予約には5分前に到着するのが礼儀とされています。",
      dialogue = listOf(
        DialogueTurn("A", "Entschuldigung, wie viel Uhr ist es?", "Excuse me, what time is it?", "माफ गर्नुहोस्, कति बज्यो?", "すみません、今何時ですか？"),
        DialogueTurn("B", "Es ist genau halb drei.", "It is exactly half past two (2:30).", "ठ्याक्कै साढे दुई (२:३०) बज्यो।", "ちょうど2時半です。"),
        DialogueTurn("A", "Vielen Dank!", "Thank you very much!", "धेरै धेरै धन्यवाद!", "どうもありがとうございます！")
      ),
      vocabulary = listOf(
        VocabularyItem("v_3_1", "eins, zwei, drei", null, null, "[aɪ̯ns tsvaɪ̯ dʁaɪ̯]", "1, 2, 3", "१, २, ३ (एक, दुई, तीन)", "1, 2, 3", "Eins, zwei, drei, los geht's!", "One, two, three, let's go!", "एक, दुई, तीन, सुरु गरौँ!", "1、2、3、スタート！", "Numbers"),
        VocabularyItem("v_3_2", "vier, fünf, sechs", null, null, "[fiːɐ̯ fʏnf zɛks]", "4, 5, 6", "४, ५, ६ (चार, पाँच, छ)", "4, 5, 6", "Vier plus zwei ist sechs.", "Four plus two is six.", "चार जोड दुई बराबर छ हुन्छ।", "4足す2は6です。", "Numbers"),
        VocabularyItem("v_3_3", "sieben, acht, neun, zehn", null, null, "[ˈziːbn̩ ʔaxt nɔɪ̯n tseːn]", "7, 8, 9, 10", "७, ८, ९, १०", "7, 8, 9, 10", "Ich habe zehn Euro.", "I have ten Euros.", "मसँग १० युरो छ।", "私は10ユーロ持っています。", "Numbers"),
        VocabularyItem("v_3_4", "Montag", "der", "die Montage", "[ˈmoːntaːk]", "Monday", "सोमबार", "月曜日", "Am Montag beginnt die Schule.", "School starts on Monday.", "सोमबार विद्यालय सुरु हुन्छ।", "月曜日に学校が始まります。", "Days"),
        VocabularyItem("v_3_5", "Freitag", "der", "die Freitage", "[ˈfʁaɪ̯taːk]", "Friday", "शुक्रबार", "金曜日", "Endlich Freitag!", "Finally Friday!", "अन्ततः शुक्रबार आयो!", "やっと金曜日だ！", "Days"),
        VocabularyItem("v_3_6", "Wochenende", "das", "die Wochenenden", "[ˈvɔxn̩ˌʔɛndə]", "Weekend", "सप्ताहन्त (शनिबार/आइतबार)", "週末", "Schönes Wochenende!", "Have a nice weekend!", "सप्ताहन्त शुभ रहोस्!", "良い週末を！", "Days"),
        VocabularyItem("v_3_7", "heute / morgen / gestern", null, null, "[ˈhɔɪ̯tə ˈmɔʁɡn̩ ˈɡɛstɐn]", "today / tomorrow / yesterday", "आज / भोलि / हिजो", "今日 / 明日 / 昨日", "Heute ist ein schöner Tag.", "Today is a beautiful day.", "आजको दिन सुन्दर छ।", "今日は良い日です。", "Time"),
        VocabularyItem("v_3_8", "Uhr", "die", "die Uhren", "[uːɐ̯]", "Clock / o'clock", "घडी / बजे", "時計 / 〜時", "Es ist fünf Uhr.", "It is five o'clock.", "पाँच बज्यो।", "5時です。", "Time")
      )
    ),
    Lesson(
      id = "lesson_4",
      level = "A1.2",
      titleDe = "Essen, Trinken & Restaurant",
      titleEn = "Food, Drinks & Restaurant",
      titleNe = "खाना, पेय पदार्थ र रेस्टुरेन्ट",
      titleJa = "食事・飲み物・レストラン",
      descriptionEn = "Order food like a local, explore German dishes and essential dining vocabulary",
      descriptionNe = "जर्मन खाना, पेय पदार्थ अर्डर गर्ने तरिका र रेस्टुरेन्टको कुराकानी सिक्नुहोस्",
      descriptionJa = "ドイツ料理の注文、レストランでの会話、お会計のマナー",
      grammarRuleTitle = "Ordering Politely: 'Ich möchte bitte...'",
      grammarRuleDe = "Im Restaurant bestellt man höflich mit 'Ich möchte bitte...' oder 'Ich hätte gerne...'.",
      grammarRuleEn = "When ordering food or drinks in Germany, use:\n• 'Ich möchte bitte...' (I would like please...)\n• 'Ich hätte gerne...' (I would gladly have...)\nTo ask for the bill: 'Zahlen, bitte!' or 'Können wir bitte zahlen?'\nIn Germany, tipping (Trinkgeld) is typically around 5% to 10% rounded up to the nearest euro.",
      grammarRuleNe = "रेस्टुरेन्टमा अर्डर गर्दा शिष्ट भाषा प्रयोग गर्नुहोस्:\n• 'Ich möchte bitte...' (मलाई कृपया ... दिनुहोस्)\n• 'Ich hätte gerne...' (म ... लिन चाहन्छु)\nबिल माग्दा: 'Zahlen, bitte!' (कृपया हिसाब गर्नुहोस्)।",
      grammarRuleJa = "レストランで注文する時は以下の丁寧な表現を使います：\n• Ich möchte bitte...（〜をお願いします）\n• Ich hätte gerne...（〜をいただけますか）\nお会計は「Zahlen, bitte!（お会計お願いします）」。ドイツのチップ（Trinkgeld）は合計金額の5〜10%程度、端数を切り上げて渡すのがスマートです。",
      cultureTipDe = "Mineralwasser wird in Deutschland fast immer mit Kohlensäure (Sprudel) serviert, es sei denn, man bestellt 'stilles Wasser'.",
      cultureTipEn = "If you order 'Wasser' in a German restaurant, you will almost certainly get sparkling carbonated water (mit Kohlensäure / Sprudel). If you prefer flat water, specify 'stilles Wasser'!",
      cultureTipNe = "जर्मनीमा साधारण 'Wasser' (पानी) भन्दा ग्यास भएको सोडा पानी (Sparkling water) दिइन्छ। सामान्य पानी चाहियो भने 'stilles Wasser' भन्नुपर्छ।",
      cultureTipJa = "ドイツのレストランで「Wasser」と頼むと、通常は炭酸水（mit Kohlensäure）が出てきます。普通の水が飲みたい時は「stilles Wasser（スティレス・ヴァッサー）」と頼みましょう。",
      dialogue = listOf(
        DialogueTurn("Kellner", "Guten Abend! Was darf ich Ihnen bringen?", "Good evening! What can I bring you?", "शुभ सन्ध्या! म तपाईंलाई के ल्याइदिऊँ?", "こんばんは！何をお持ちしましょうか？"),
        DialogueTurn("Gast", "Ich hätte gerne ein Schnitzel mit Pommes und ein Bier, bitte.", "I would like a Schnitzel with fries and a beer, please.", "मलाई कृपया चिप्ससहितको स्नित्जेल र एक बियर दिनुहोस्।", "シュニッツェルとポテト、そしてビールをお願いします。"),
        DialogueTurn("Kellner", "Sehr gerne! Guten Appetit!", "With pleasure! Enjoy your meal!", "हुन्छ अवश्य! खानाको आनन्द लिनुहोस्!", "かしこまりました！どうぞ召し上がれ！")
      ),
      vocabulary = listOf(
        VocabularyItem("v_4_1", "Brot", "das", "die Brote", "[bʁoːt]", "Bread", "पाउरोटी / रोटी", "パン", "Frisches deutsches Brot riecht gut.", "Fresh German bread smells good.", "ताजा जर्मन पाउरोटीको बास्ना राम्रो आउँछ।", "焼きたてのドイツパンは良い香りがします。", "Food"),
        VocabularyItem("v_4_2", "Käse", "der", "die Käse", "[ˈkɛːzə]", "Cheese", "चीज", "チーズ", "Möchtest du Käse zum Frühstück?", "Would you like cheese for breakfast?", "के तिमी बिहानको खाजामा चीज खान्छौ?", "朝食にチーズはいかがですか？", "Food"),
        VocabularyItem("v_4_3", "Wurst", "die", "die Würste", "[vʊʁst]", "Sausage", "ससेज", "ソーセージ", "Die Bratwurst ist sehr lecker.", "The grilled sausage is very delicious.", "फ्राई गरेको ससेज धेरै मिठो छ।", "焼きソーセージはとても美味しいです。", "Food"),
        VocabularyItem("v_4_4", "Kaffee", "der", "die Kaffees", "[ˈkafe]", "Coffee", "कफी", "コーヒー", "Einen Kaffee mit Milch, bitte.", "A coffee with milk, please.", "कृपया दूधसहितको कफी दिनुहोस्।", "ミルク入りコーヒーをお願いします。", "Drinks"),
        VocabularyItem("v_4_5", "Tee", "der", "die Tees", "[teː]", "Tea", "चिया", "紅茶 / お茶", "Ich trinke gerne grünen Tee.", "I like drinking green tea.", "मलाई हरियो चिया पिउन मन पर्छ।", "私は緑茶を飲むのが好きです。", "Drinks"),
        VocabularyItem("v_4_6", "Bier", "das", "die Biere", "[biːɐ̯]", "Beer", "बियर", "ビール", "Ein Bier vom Fass, bitte.", "A draft beer, please.", "कृपया एक ड्राफ्ट बियर दिनुहोस्।", "生ビールを一杯お願いします。", "Drinks"),
        VocabularyItem("v_4_7", "Rechnung", "die", "die Rechnungen", "[ˈʁɛçnʊŋ]", "Bill / Check", "बिल / हिसाब", "お会計 / 請求書", "Die Rechnung, bitte!", "The bill, please!", "कृपया बिल दिनुहोस्!", "お会計をお願いします！", "Dining"),
        VocabularyItem("v_4_8", "lecker", null, null, "[ˈlɛkɐ]", "Delicious / Tasty", "मिठो / स्वादिष्ट", "おいしい", "Das Essen schmeckt sehr lecker!", "The food tastes very delicious!", "खाना धेरै मिठो छ!", "料理がとても美味しいです！", "Dining")
      )
    ),
    Lesson(
      id = "lesson_5",
      level = "A2.1",
      titleDe = "Die Artikel: Der, Die, Das & Plural",
      titleEn = "Articles: Der, Die, Das & Plurals",
      titleNe = "जर्मन आर्टिकलहरू (Der, Die, Das) र बहुवचन",
      titleJa = "定冠詞（Der・Die・Das）と複数形",
      descriptionEn = "Understand the 3 grammatical genders and memory tricks to identify noun articles",
      descriptionNe = "जर्मन भाषाका ३ वटा लिङ्ग (पुल्लिङ्ग, स्त्रीलिङ्ग, नपुंसकलिङ्ग) र आर्टिकल पत्ता लगाउने तरिका",
      descriptionJa = "3つの名詞の性（男性・女性・中性）の見分け方と複数形の法則",
      grammarRuleTitle = "Gender Rules & Endings",
      grammarRuleDe = "Maskulin (der): -ling, -or, -ist. Feminin (die): -ung, -heit, -keit, -schaft, -tät, -tion. Neutral (das): -chen, -lein, -ment, -um.",
      grammarRuleEn = "German nouns have three genders:\n• Masculine (der - Blue): Male persons, days, months, seasons, and words ending in -or, -ling, -ismus.\n• Feminine (die - Red): Female persons, and words ending in -ung, -heit, -keit, -schaft, -tät, -tion, -ie, -e (90%).\n• Neuter (das - Green): Words ending in diminutives -chen, -lein, -ment, -um, and most metals/letters.\nAll plural nouns use 'die' in the nominative case!",
      grammarRuleNe = "जर्मन भाषामा प्रत्येक नामपदको लिङ्ग हुन्छ:\n• Der (पुल्लिङ्ग): दिन, महिना, मौसम र -or, -ist मा अन्त्य हुने शब्दहरू।\n• Die (स्त्रीलिङ्ग): -ung, -heit, -keit, -schaft, -tät, -tion मा अन्त्य हुने शब्दहरू।\n• Das (नपुंसकलिङ्ग): -chen, -lein, -ment मा अन्त्य हुने शब्दहरू।\nसबै बहुवचन (Plural) शब्दहरूले 'die' लिन्छन्!",
      grammarRuleJa = "ドイツ語の名詞には3つの性があります：\n• 男性（der・青）：男性、曜日・月・季節、語尾が -or, -ist, -lingなど。\n• 女性（die・赤）：女性、語尾が -ung, -heit, -keit, -schaft, -tät, -tion, -ieなど（圧倒的に多い！）。\n• 中性（das・緑）：縮小語尾 -chen, -lein、外来語尾 -ment, -umなど。\n複数形は性別に関係なくすべて「die」になります！",
      cultureTipDe = "Alle Substantive (Nomen) im Deutschen werden mit einem Großbuchstaben am Anfang geschrieben!",
      cultureTipEn = "A unique rule of German grammar: ALL nouns (Substantive) are always capitalized, regardless of where they appear in a sentence! (e.g. das Buch, die Liebe, der Hund).",
      cultureTipNe = "जर्मन व्याकरणको अनौठो नियम: सबै नामपद (Nouns) हरूको पहिलो अक्षर सधैँ ठूलो (Capital letter) लेखिन्छ!",
      cultureTipJa = "ドイツ語の大原則：文の途中であっても、すべての名詞（Haus, Buch, Liebeなど）は必ず大文字で書き始めます！",
      dialogue = listOf(
        DialogueTurn("Lehrer", "Welcher Artikel gehört zu 'Wohnung'?", "Which article belongs to 'Wohnung'?", "'Wohnung' को आर्टिकल कुन हो?", "「Wohnung（アパート）」の冠詞は何ですか？"),
        DialogueTurn("Schülerin", "Die Endung ist -ung, also 'die Wohnung'!", "The ending is -ung, so it is 'die Wohnung'!", "अन्त्यमा -ung छ, त्यसैले 'die Wohnung' हो!", "語尾が-ungなので、「die Wohnung」です！"),
        DialogueTurn("Lehrer", "Ausgezeichnet! Genau richtig.", "Excellent! Exactly right.", "अति उत्तम! एकदम सही।", "素晴らしい！大正解です。")
      ),
      vocabulary = listOf(
        VocabularyItem("v_5_1", "Wohnung", "die", "die Wohnungen", "[ˈvoːnʊŋ]", "Apartment / Flat", "अपार्टमेन्ट / कोठा", "アパート / マンション", "Die Wohnung hat drei Zimmer.", "The apartment has three rooms.", "अपार्टमेन्टमा तीनवटा कोठाहरू छन्।", "そのアパートには3つの部屋があります。", "Housing"),
        VocabularyItem("v_5_2", "Schlüssel", "der", "die Schlüssel", "[ˈʃlʏsl̩]", "Key", "चाबी / साँचो", "鍵", "Wo ist der Schlüssel?", "Where is the key?", "चाबी कहाँ छ?", "鍵はどこですか？", "Objects"),
        VocabularyItem("v_5_3", "Handy", "das", "die Handys", "[ˈhɛndi]", "Mobile phone", "मोबाइल फोन", "携帯電話 / スマホ", "Das Handy klingelt laut.", "The mobile phone rings loudly.", "मोबाइल ठूलो स्वरमा बजिरहेको छ।", "スマホが大きな音で鳴っています。", "Objects"),
        VocabularyItem("v_5_4", "Freiheit", "die", "die Freiheiten", "[ˈfʁaɪ̯haɪ̯t]", "Freedom (-heit is always die)", "स्वतन्त्रता (-heit सधैँ die हुन्छ)", "自由（-heitは女性）", "Freiheit ist ein hohes Gut.", "Freedom is a high virtue.", "स्वतन्त्रता अमूल्य सम्पत्ति हो।", "自由はかけがえのない価値です。", "Abstract"),
        VocabularyItem("v_5_5", "Computer", "der", "die Computer", "[kɔmˈpjuːtɐ]", "Computer", "कम्प्युटर", "コンピューター", "Der Computer ist neu und schnell.", "The computer is new and fast.", "कम्प्युटर नयाँ र छिटो छ।", "そのコンピューターは新しくて高速です。", "Tech"),
        VocabularyItem("v_5_6", "Brötchen", "das", "die Brötchen", "[ˈbʁøːtçən]", "Bread roll (-chen is always das)", "सानो पाउरोटी (-chen सधैँ das हुन्छ)", "小型丸パン（-chenは中性）", "Zwei Brötchen bitte!", "Two bread rolls, please!", "कृपया दुईवटा साना पाउरोटी दिनुहोस्!", "丸パンを2つください！", "Food")
      )
    ),
    Lesson(
      id = "lesson_6",
      level = "A2.1",
      titleDe = "Wichtige Verben & Konjugation",
      titleEn = "Essential Verbs & Conjugation",
      titleNe = "महत्वपूर्ण क्रियापद र तिनको रूपान्तरण",
      titleJa = "重要動詞の現在形活用",
      descriptionEn = "Master regular verb endings (-e, -st, -t, -en) and irregular auxiliaries 'sein' and 'haben'",
      descriptionNe = "नियमित क्रियापदका प्रत्यय र 'sein' (हुनु) तथा 'haben' (हुनु/साथमा हुनु) को रूपान्तरण सिक्नुहोस्",
      descriptionJa = "規則動詞の活用形と、超重要不規則動詞「sein（〜である）」と「haben（持つ）」",
      grammarRuleTitle = "Present Tense Conjugation (Präsens)",
      grammarRuleDe = "ich -e, du -st, er/sie/es -t, wir -en, ihr -t, sie/Sie -en. Ausnahme: sein (ich bin, du bist, er ist...) und haben (ich habe, du hast, er hat...).",
      grammarRuleEn = "German regular verbs end in -en. Remove -en and add:\n• ich (I): -e (ich lerne)\n• du (you): -st (du lernst)\n• er/sie/es (he/she/it): -t (er lernt)\n• wir (we): -en (wir lernen)\n• ihr (you all): -t (ihr lernt)\n• sie/Sie (they/You): -en (sie lernen)\nIrregular core verbs:\n• sein: ich bin, du bist, er ist, wir sind, ihr seid, sie sind\n• haben: ich habe, du hast, er hat, wir haben, ihr habt, sie haben",
      grammarRuleNe = "जर्मन नियमित क्रियापदको अन्त्यको रूप यसरी परिवर्तन हुन्छ:\n• ich (म): -e (ich gehe - म जान्छु)\n• du (तँ/तिमी): -st (du gehst)\n• er/sie/es (उ/उनी/यो): -t (er geht)\n• wir (हामी): -en (wir gehen)\n• ihr (तिमीहरू): -t (ihr geht)\n• sie/Sie (उनीहरू/तपाईं): -en (sie gehen)\n'sein' (हुनु): ich bin (म हुँ), du bist (तिमी हौ), er ist (उ हो)\n'haben' (हुनु): ich habe (मसँग छ), du hast, er hat",
      grammarRuleJa = "ドイツ語の規則動詞は語幹に以下の語尾をつけます：\n• ich（私）：-e\n• du（君）：-st\n• er/sie/es（彼/彼女/それ）：-t\n• wir（私たち）：-en\n• ihr（君たち）：-t\n• sie/Sie（彼ら/あなた）：-en\n超重要動詞：\n• sein：bin, bist, ist, sind, seid, sind\n• haben：habe, hast, hat, haben, habt, haben",
      cultureTipDe = "Im deutschen Hauptsatz steht das konjugierte Verb IMMER an zweiter Stelle (V2-Regel).",
      cultureTipEn = "The famous 'Verb Second' (V2) rule: In a German main declarative sentence, the conjugated verb MUST always occupy the second grammatical position! (e.g. 'Heute gehe ich ins Kino', NOT 'Heute ich gehe').",
      cultureTipNe = "जर्मन वाक्य संरचनाको नियम: सामान्य वाक्यमा मुख्य क्रियापद सधैँ दोस्रो स्थानमा (Position 2) आउँछ!",
      cultureTipJa = "ドイツ語の黄金律「定動詞第2位の原則」：平叙文では、主語がどこにあろうと、変化する動詞は必ず文の「2番目の位置」に来ます！",
      dialogue = listOf(
        DialogueTurn("A", "Woher kommst du?", "Where do you come from?", "तिमी कहाँबाट आएका हौ?", "どこから来ましたか？"),
        DialogueTurn("B", "Ich komme aus Nepal und wohne jetzt in Berlin.", "I come from Nepal and live in Berlin now.", "म नेपालबाट आएको हुँ र अहिले बर्लिनमा बस्छु।", "ネパール出身で、今はベルリンに住んでいます。"),
        DialogueTurn("A", "Toll! Was machst du hier?", "Great! What are you doing here?", "धेरै राम्रो! यहाँ तिमी के गर्छौ?", "素晴らしい！ここでは何をしていますか？"),
        DialogueTurn("B", "Ich lerne Deutsch und studiere Informatik.", "I am learning German and studying Computer Science.", "म जर्मन सिक्दैछु र कम्प्युटर विज्ञान पढ्दैछु।", "ドイツ語を学び、情報科学を専攻しています。")
      ),
      vocabulary = listOf(
        VocabularyItem("v_6_1", "sein", null, null, "[zaɪ̯n]", "to be", "हुनु", "〜である（英語のbe動詞）", "Ich bin Student in München.", "I am a student in Munich.", "म म्युनिखमा विद्यार्थी हुँ।", "私はミュンヘンの学生です。", "Verbs"),
        VocabularyItem("v_6_2", "haben", null, null, "[ˈhaːbn̩]", "to have", "हुनु / साथमा हुनु", "持っている（英語のhave）", "Wir haben viel Zeit zum Üben.", "We have a lot of time to practice.", "हामीसँग अभ्यास गर्न धेरै समय छ।", "私たちには練習する時間がたくさんあります。", "Verbs"),
        VocabularyItem("v_6_3", "kommen", null, null, "[ˈkɔmən]", "to come", "आउनु", "来る", "Woher kommst du?", "Where do you come from?", "तिमी कहाँबाट आएका हौ?", "出身はどちらですか？", "Verbs"),
        VocabularyItem("v_6_4", "wohnen", null, null, "[ˈvoːnən]", "to live / reside", "बस्नु / बसोबास गर्नु", "住む", "Ich wohne in Frankfurt.", "I live in Frankfurt.", "म फ्र्याङ्कफर्टमा बस्छु।", "私はフランクフルトに住んでいます。", "Verbs"),
        VocabularyItem("v_6_5", "lernen", null, null, "[ˈlɛʁnən]", "to learn / study", "सिक्नु / अध्ययन गर्नु", "学ぶ / 勉強する", "Wir lernen fleißig Deutsch.", "We are learning German diligently.", "हामी मिहिनेतका साथ जर्मन सिक्दैछौँ।", "私たちは熱心にドイツ語を学んでいます。", "Verbs"),
        VocabularyItem("v_6_6", "sprechen", null, null, "[ˈʃpʁɛçn̩]", "to speak", "बोल्नु", "話す", "Sprechen Sie Englisch oder Deutsch?", "Do you speak English or German?", "के तपाईं अंग्रेजी वा जर्मन बोल्नुहुन्छ?", "英語かドイツ語を話しますか？", "Verbs")
      )
    ),
    Lesson(
      id = "lesson_7",
      level = "A2.2",
      titleDe = "Die Fälle: Nominativ, Akkusativ & Dativ",
      titleEn = "Cases: Nominative, Accusative & Dative",
      titleNe = "जर्मन कारकहरू: नोमिनातिभ, अकुजातिभ र दातिभ",
      titleJa = "4格の仕組み：1格・4格・3格の変化",
      descriptionEn = "Master German cases with simple visual logic: who does what to whom",
      descriptionNe = "कसले के गर्यो र कसलाई गर्यो: Nominativ, Akkusativ र Dativ बुझ्ने सरल नियम",
      descriptionJa = "主語（1格）、直接目的語（4格）、間接目的語（3格）の定冠詞変化表",
      grammarRuleTitle = "The Article Shift in Akkusativ and Dativ",
      grammarRuleDe = "Akkusativ ändert NUR maskulin: der -> den (einen). Dativ ändert: der/das -> dem (einem), die -> der (einer), Plural -> den + n.",
      grammarRuleEn = "German cases indicate the function of a noun in a sentence:\n1. Nominativ (Subject - who is doing it?): der, die, das, die\n2. Akkusativ (Direct Object - what/whom?):\n   • ONLY masculine changes: der becomes DEN (einen)!\n   • die, das, die remain unchanged.\n   • (e.g. 'Ich habe DEN Schlüssel').\n3. Dativ (Indirect Object - to whom? / after mit, bei, nach, zu):\n   • Masculine/Neuter: DEM (einem)\n   • Feminine: DER (einer)\n   • Plural: DEN ...n (den Kindern)",
      grammarRuleNe = "जर्मन भाषामा कारक (Cases) ले वाक्यमा शब्दको भूमिका बताउँछ:\n१. Nominativ (कर्ता - Subject): der, die, das, die\n२. Akkusativ (कर्म - Direct Object):\n   • केवल पुल्लिङ्ग परिवर्तन हुन्छ: der बन्छ DEN (einen)!\n   • die र das परिवर्तन हुँदैनन्।\n   • उदाहरण: 'Ich sehe DEN Mann' (म त्यो मानिसलाई देख्छु)\n३. Dativ (कसलाई? / mit, zu पछि):\n   • der/das बन्छ DEM (einem)\n   • die बन्छ DER (einer)",
      grammarRuleJa = "ドイツ語の格変化はパズルのように明快です：\n1. 1格（Nominativ：〜が、主語）：der, die, das, die\n2. 4格（Akkusativ：〜を、直接目的語）：\n   ★男性名詞だけが「den」に変化！（einen）\n   女性・中性・複数はそのまま（die, das, die）\n   例：Ich habe DEN Schlüssel.（私はその鍵を持っている）\n3. 3格（Dativ：〜に、間接目的語 / mit, zuの後）：\n   男性・中性：dem（einem）\n   女性：der（einer）\n   複数：den ...n",
      cultureTipDe = "Nach den Präpositionen 'aus, bei, mit, nach, seit, von, zu' folgt IMMER der Dativ!",
      cultureTipEn = "German mnemonic song: 'Aus, bei, mit, nach, seit, von, zu — verlangen stets den Dativ, du!' Whenever you use one of these prepositions, the noun is guaranteed to be Dative!",
      cultureTipNe = "जर्मन नियम: 'aus, bei, mit, nach, seit, von, zu' शब्दहरू आएपछि सधैँ Dativ (३格) आउँछ!",
      cultureTipJa = "ドイツ語の暗記フレーズ：「aus, bei, mit, nach, seit, von, zu」の7つの前置詞の後は必ず3格（Dativ）が来ます！",
      dialogue = listOf(
        DialogueTurn("A", "Mit wem gehst du ins Kino?", "With whom are you going to the cinema?", "तिमी कोसँग सिनेमा हल जाँदैछौ?", "誰と映画館に行くの？"),
        DialogueTurn("B", "Ich gehe mit meinem Freund (Dativ!).", "I am going with my boyfriend/friend (Dative).", "म मेरो साथीसँग (Dativ) जाँदैछु।", "友達と一緒に（3格！）行きます。"),
        DialogueTurn("A", "Viel Spaß beim Film!", "Have fun at the movie!", "फिल्म हेरेर रमाइलो गर!", "映画楽しんできてね！")
      ),
      vocabulary = listOf(
        VocabularyItem("v_7_1", "Freund", "der", "die Freunde", "[fʁɔɪ̯nt]", "Friend / Boyfriend", "साथी / प्रेमी", "友人 / 彼氏", "Ich helfe dem Freund.", "I help the friend (Dative).", "म साथीलाई मद्दत गर्छु (Dativ)।", "私は友人を助けます（3格）。", "People"),
        VocabularyItem("v_7_2", "Tasche", "die", "die Taschen", "[ˈtaʃə]", "Bag", "झोला", "バッグ / かばん", "Sie kauft eine neue Tasche.", "She buys a new bag (Accusative).", "उनले नयाँ झोला किन्छिन्।", "彼女は新しいバッグを買います。", "Objects"),
        VocabularyItem("v_7_3", "mit", null, null, "[mɪt]", "with (+ Dativ)", "सँग (+ दातिभ)", "〜と一緒に（+3格）", "Kommst du mit mir?", "Are you coming with me?", "के तिमी मसँग आउँदैछौ?", "私と一緒に来る？", "Preposition"),
        VocabularyItem("v_7_4", "zu", null, null, "[tsuː]", "to / towards (+ Dativ)", "तिर / तर्फ (+ दातिभ)", "〜へ（+3格）", "Ich fahre zum (zu + dem) Bahnhof.", "I am driving to the train station.", "म रेल स्टेशनतिर जाँदैछु।", "私は駅へ向かっています。", "Preposition")
      )
    ),
    Lesson(
      id = "lesson_8",
      level = "B1",
      titleDe = "Beruf, Karriere & Konversation",
      titleEn = "Work, Career & Conversation",
      titleNe = "काम, पेशा र दैनिक कुराकानी",
      titleJa = "仕事・キャリア・日常会話",
      descriptionEn = "Professional expressions, discussing jobs, expressing opinions in German",
      descriptionNe = "जर्मनीमा जागिर, अन्तर्वार्ता र आफ्नो विचार व्यक्त गर्ने तरिका",
      descriptionJa = "ドイツでの仕事探し、面接、ビジネス表現、自分の意見の述べ方",
      grammarRuleTitle = "Subordinate Clauses with 'weil' & 'dass'",
      grammarRuleDe = "In Nebensätzen mit 'weil' (weil ich müde bin) oder 'dass' wandert das konjugierte Verb ganz ans ENDE des Satzes.",
      grammarRuleEn = "In German subordinate clauses introduced by conjunctions like 'weil' (because), 'dass' (that), or 'wenn' (if/when), the conjugated verb gets kicked to the very END of the sentence!\n• Example: 'Ich lerne Deutsch, weil ich in Deutschland ARBEITEN MÖCHTE.'",
      grammarRuleNe = "जर्मन भाषामा 'weil' (किनभने) वा 'dass' (कि) जस्ता शब्दहरू प्रयोग गर्दा मुख्य क्रियापद वाक्यको अन्तिममा जान्छ:\n• उदाहरण: 'Ich lerne Deutsch, weil ich in Deutschland studieren will.' (म जर्मन सिक्दैछु किनभने म जर्मनीमा पढ्न चाहन्छु।)",
      grammarRuleJa = "副文の語順ルール：「weil（〜だから）」「dass（〜ということ）」「wenn（〜の時）」で始まる文では、変化する動詞が文の【最後】に移動します！\n• 例：Ich lerne Deutsch, weil ich in Deutschland arbeiten möchte.（ドイツで働きたいので、ドイツ語を学んでいます）",
      cultureTipDe = "Auf dem deutschen Arbeitsmarkt (Fachkräftemangel) sind Kenntnisse der deutschen Sprache auf Niveau B1/B2 der Schlüssel zum Erfolg.",
      cultureTipEn = "Germany has high demand for skilled workers ('Fachkräfte') in IT, healthcare, and engineering. Demonstrating at least B1/B2 German language proficiency drastically boosts career opportunities.",
      cultureTipNe = "जर्मनीमा दक्ष जनशक्ति (IT, इन्जिनियरिङ, स्वास्थ्य क्षेत्र) को ठूलो माग छ। B1/B2 स्तरको जर्मन भाषाले भिसा र रोजगारीको अवसर निकै बढाउँछ।",
      cultureTipJa = "ドイツではITや医療分野を中心に専門人材（Fachkräfte）が強く求められており、B1〜B2レベルのドイツ語力があればキャリアの可能性が大きく広がります。",
      dialogue = listOf(
        DialogueTurn("Interviewer", "Warum möchten Sie in Deutschland arbeiten?", "Why would you like to work in Germany?", "तपाईं जर्मनीमा किन काम गर्न चाहनुहुन्छ?", "なぜドイツで働きたいのですか？"),
        DialogueTurn("Bewerber", "Weil Deutschland führend in Innovation und Technologie ist.", "Because Germany is a leader in innovation and technology.", "किनभने जर्मनी नवप्रवर्तन र प्रविधिमा अग्रणी छ।", "ドイツがイノベーションと技術の世界的リーダーだからです。"),
        DialogueTurn("Interviewer", "Sehr gut! Wir freuen uns auf die Zusammenarbeit.", "Very good! We look forward to working together.", "धेरै राम्रो! हामी मिलेर काम गर्न उत्सुक छौँ।", "素晴らしい！一緒に働けるのを楽しみにしています。")
      ),
      vocabulary = listOf(
        VocabularyItem("v_8_1", "Beruf", "der", "die Berufe", "[bəˈʁuːf]", "Profession / Occupation", "पेशा / व्यवसाय", "職業", "Was sind Sie von Beruf?", "What is your profession?", "तपाईंको पेशा के हो?", "ご職業は何ですか？", "Work"),
        VocabularyItem("v_8_2", "Arbeit", "die", "die Arbeiten", "[ˈʔaʁbaɪ̯t]", "Work / Job", "काम", "仕事", "Die Arbeit macht viel Spaß.", "The work is a lot of fun.", "काम गर्न धेरै रमाइलो लाग्छ।", "仕事はとてもやりがいがあります。", "Work"),
        VocabularyItem("v_8_3", "Bewerbung", "die", "die Bewerbungen", "[bəˈvɛʁbʊŋ]", "Application", "आवेदन", "応募 / 志望", "Ich habe meine Bewerbung abgeschickt.", "I sent my job application.", "मैले मेरो जागिरको आवेदन पठाएँ।", "応募書類を提出しました。", "Career"),
        VocabularyItem("v_8_4", "Erfolg", "der", "die Erfolge", "[ɛɐ̯ˈfɔlk]", "Success", "सफलता", "成功", "Viel Erfolg bei der neuen Stelle!", "Much success in your new position!", "नयाँ पदमा ठूलो सफलताको शुभकामना!", "新しい職場でのご活躍をお祈りします！", "Career")
      )
    )
  )

  // Culture & Traditions rich topics
  val cultureTopics = listOf(
    CultureTopic(
      id = "cult_1",
      titleDe = "Oktoberfest & Bayerische Traditionen",
      titleEn = "Oktoberfest & Bavarian Heritage",
      titleNe = "अक्टोबरफेस्ट र बाभारियन परम्परा",
      titleJa = "オクトーバーフェストとバイエルンの伝統",
      category = "Tradition & Festival",
      drawableRes = R.drawable.ic_oktoberfest,
      badgeText = "München, Bayern",
      summaryEn = "The world's largest folk festival held every autumn in Munich since 1810.",
      summaryNe = "सन् १८१० देखि म्युनिखमा हरेक वर्ष मनाइने संसारकै सबैभन्दा ठूलो लोक उत्सव।",
      summaryJa = "1810年からミュンヘンで開催されている世界最大のビールと民俗のお祭り。",
      fullStoryEn = "The Oktoberfest originally began in October 1810 as a royal wedding celebration for Bavarian Crown Prince Ludwig and Princess Therese of Saxe-Hildburghausen. The fields where it takes place are still called the 'Theresienwiese' (or simply 'die Wiesn'). Today, over 6 million visitors gather to enjoy traditional brass music, hearty Bavarian pretzels (Brezen), roast chicken (Hendl), and specially brewed Oktoberfestbier served in one-liter glass steins called 'die Maß'. Visitors proudly wear traditional folk dress: 'Lederhosen' for men and 'Dirndl' for women.",
      fullStoryNe = "अक्टोबरफेस्ट सुरुमा सन् १८१० को अक्टोबरमा बाभारियाका युवराज लुडविग र राजकुमारी थेरेसको शाही विवाह उत्सवको रूपमा सुरु भएको थियो। आज हरेक वर्ष ६० लाखभन्दा बढी मानिसहरू म्युनिखको थेरेसियनभिजेमा भेला हुन्छन्। मानिसहरू परम्परागत पहिरन 'लेडरहोजन' (Lederhosen) र 'डिर्नड्ल' (Dirndl) लगाएर परम्परागत संगीत, पाउरोटी र परिकारको आनन्द लिन्छन्।",
      fullStoryJa = "オクトーバーフェストは1810年、バイエルン王太子ルートヴィヒとテレーゼ王女の結婚を祝う祝宴として始まりました。現在では毎年600万人以上が訪れ、巨大なテントでバイエルン伝統のブラスバンド音楽を聴きながら、1リットルの特製ジョッキ「Mass（マス）」でビールを乾杯します。民族衣装のレーダーホーゼン（革ズボン）やディアンドルを着用して参加するのが現地の醍醐味です。",
      funFactDe = "Obwohl das Fest 'Oktoberfest' heißt, beginnt es heute wegen des besseren Spätsommerwetters bereits im September!",
      funFactEn = "Even though it is called 'Oktoberfest', the festival actually begins in mid-September to take advantage of warmer late-summer weather!",
      funFactNe = "यसको नाम 'अक्टोबरफेस्ट' भए तापनि राम्रो मौसमको लागि यो उत्सव सेप्टेम्बरको मध्यतिर नै सुरु हुन्छ!",
      funFactJa = "「オクトーバー（10月）」という名ですが、気候の良い晩夏を楽しむため、現代では9月中旬からスタートします！",
      vocabulary = listOf(
        VocabularyItem("cv_1_1", "die Wiesn", "die", null, "[diː ˈviːzn̩]", "Theresienwiese (Oktoberfest festival grounds)", "अक्टोबरफेस्ट मेला लाग्ने मैदान", "オクトーバーフェスト会場の愛称", "Gehen wir heute auf die Wiesn?", "Shall we go to Oktoberfest grounds today?", "के हामी आज अक्टोबरफेस्ट मेला जाने हो?", "今日ヴィースン（会場）に行かない？"),
        VocabularyItem("cv_1_2", "die Maß", "die", "die Maße", "[diː maːs]", "One-liter beer stein", "एक लिटरको बियरको मग", "1リットルのビールジョッキ", "Eine Maß Bier bitte!", "One liter beer please!", "कृपया एक लिटर बियर दिनुहोस्!", "マスビールを1杯ください！"),
        VocabularyItem("cv_1_3", "die Brezel", "die", "die Brezeln", "[diː ˈbʁeːtsl̩]", "Traditional German pretzel", "जर्मन परम्परागत प्रेत्जेल", "伝統的なプレッツェル", "Eine frische Brezel mit Butter.", "A fresh pretzel with butter.", "ताजा प्रेत्जेल र मखन।", "焼きたてのプレッツェルとバター。")
      )
    ),
    CultureTopic(
      id = "cult_2",
      titleDe = "Schloss Neuschwanstein & Romantik",
      titleEn = "Neuschwanstein Castle & The Alps",
      titleNe = "नोइश्वानस्टाइन महल र आल्प्स पर्वत",
      titleJa = "ノイシュヴァンシュタイン城とロマン主義",
      category = "Landmark & Heritage",
      drawableRes = R.drawable.ic_castle,
      badgeText = "Füssen, Bayern",
      summaryEn = "The fairytale castle perched in the Bavarian Alps that inspired Walt Disney.",
      summaryNe = "बाभारियन आल्प्समा अवस्थित परीकथा जस्तो महल, जसबाट वाल्ट डिज्नीले प्रेरणा पाएका थिए।",
      summaryJa = "ディズニーのシンデレラ城のモデルとなった、バイエルン・アルプスの白亜の名城。",
      fullStoryEn = "Commissioned by King Ludwig II of Bavaria in 1869, Neuschwanstein Castle stands majestically against the rugged peaks of the Bavarian Alps. Ludwig was deeply inspired by the operatic mythologies of composer Richard Wagner and built the castle not for defense, but as a romantic retreat into fantasy. Featuring soaring towers, ornate throne rooms, and cutting-edge 19th-century technology (including central heating and telephone lines), Neuschwanstein inspired Walt Disney's iconic Sleeping Beauty Castle and remains one of Germany's most visited cultural treasures.",
      fullStoryNe = "सन् १८६९ मा बाभारियाका राजा लुडविग द्वितीयद्वारा बनाइएको नोइश्वानस्टाइन महल आल्प्स पर्वतको सुन्दर काखमा अवस्थित छ। यो महल युद्धको लागि नभई कला, संगीत र रोमान्टिक सौन्दर्यको लागि बनाइएको थियो। वाल्ट डिज्नीले आफ्नो प्रसिद्ध एनिमेसन महलको डिजाइन यही महलबाट प्रेरित भएर बनाएका थिए।",
      fullStoryJa = "1869年、「狂王」と呼ばれたバイエルン国王ルートヴィヒ2世によって建設が開始されたノイシュヴァンシュタイン城。ワーグナーのオペラ世界を具現化するために造られた白亜の城は、防御目的ではなく純粋な美の追求として建てられました。ウォルト・ディズニーがシンデレラ城のモデルにしたことでも知られ、ドイツで最も愛される名所です。",
      funFactDe = "Der Name 'Neuschwanstein' bedeutet wörtlich übersetzt 'Neuer Schwanenstein'.",
      funFactEn = "The name Neuschwanstein translates literally to 'New Swan Stone', inspired by the medieval Knight of the Swan (Lohengrin).",
      funFactNe = "नोइश्वानस्टाइन (Neuschwanstein) को शाब्दिक अर्थ 'हंसको नयाँ ढुङ्गा' (New Swan Stone) हो।",
      funFactJa = "「ノイシュヴァンシュタイン」は文字通り「新白鳥石」という意味で、中世伝説の白鳥の騎士ローエングリンに由来します。",
      vocabulary = listOf(
        VocabularyItem("cv_2_1", "das Schloss", "das", "die Schlösser", "[das ʃlɔs]", "Castle / Palace", "महल / दरबार", "城 / 宮殿", "Das Schloss liegt auf dem Berg.", "The castle sits atop the mountain.", "महल पहाडको चुचुरोमा छ।", "その城は山の上にあります。"),
        VocabularyItem("cv_2_2", "die Alpen", "die (Pl.)", null, "[diː ˈʔalpn̩]", "The Alps mountain range", "आल्प्स पर्वत शृङ्खला", "アルプス山脈", "Wir wandern in den Alpen.", "We are hiking in the Alps.", "हामी आल्प्स पर्वतमा पदयात्रा गर्दैछौँ।", "私たちはアルプスをハイキングしています。")
      )
    ),
    CultureTopic(
      id = "cult_3",
      titleDe = "Deutsche Brotkultur (UNESCO Kulturerbe)",
      titleEn = "German Bread Culture (UNESCO Heritage)",
      titleNe = "जर्मन पाउरोटी संस्कृति (युनेस्को सम्पदा)",
      titleJa = "ドイツのパン文化（UNESCO無形文化遺産）",
      category = "Culinary & Lifestyle",
      drawableRes = R.drawable.ic_bread,
      badgeText = "UNESCO Heritage",
      summaryEn = "Over 3,200 registered types of artisan bread make Germany the bread capital of the world.",
      summaryNe = "३,२०० भन्दा बढी प्रकारका पाउरोटी उत्पादन गर्ने जर्मनी संसारको पाउरोटी राजधानी हो।",
      summaryJa = "3,200種類以上のパンが登録されている、世界に誇るドイツの食文化。",
      fullStoryEn = "German bread culture ('Deutsche Brotkultur') was officially recognized as Intangible Cultural Heritage by UNESCO in 2014. With over 3,200 recognized varieties of bread, a traditional German bakery (Bäckerei) is a daily sanctuary. Unlike fluffy white toast, authentic German loaves rely heavily on whole grain rye (Roggen), spelt (Dinkel), sourdough fermentation (Natursauerteig), sunflower seeds, and crispy crusts. Even the traditional German evening meal is named after bread: 'Abendbrot' (evening bread), featuring sliced dark artisan bread served with fine cheeses, cold cuts, and pickles.",
      fullStoryNe = "सन् २०१४ मा युनेस्कोले जर्मन पाउरोटी संस्कृतिलाई अमूर्त सांस्कृतिक सम्पदा घोषणा गरेको थियो। जर्मनीमा ३,२०० भन्दा बढी प्रकारका पाउरोटी पाइन्छन्। यहाँको साँझको खानालाई नै 'Abendbrot' (साँझको पाउरोटी) भनिन्छ, जहाँ विभिन्न चीज, बटर र परिकारहरूसँग कालो पाउरोटी खाइन्छ।",
      fullStoryJa = "2014年にユネスコ無形文化遺産に登録されたドイツのパン文化。ライ麦パン（Roggenbrot）や全粒粉パン、プレッツェルなど、3,200種を超えるバラエティを誇ります。ドイツの伝統的な夕食スタイル「Abendbrot（夜のパン）」では、火を使わず、スライスした重厚なパンにチーズやハムをのせて家族とゆっくり味わいます。",
      funFactDe = "In Deutschland gibt es offizielle 'Brot-Sommeliers', die den Geschmack und die Kruste von Brot professionell bewerten!",
      funFactEn = "Germany has certified 'Bread Sommeliers' who undergo rigorous training to evaluate bread aromas, crust textures, and wine pairings!",
      funFactNe = "जर्मनीमा पाउरोटीको गुणस्तर र स्वाद परीक्षण गर्ने आधिकारिक 'Bread Sommeliers' हुन्छन्!",
      funFactJa = "ドイツにはワインソムリエならぬ、パンの香りやクラストの焼き加減を鑑定する国家資格「パン・ソムリエ」が存在します！",
      vocabulary = listOf(
        VocabularyItem("cv_3_1", "das Abendbrot", "das", null, "[das ˈʔaːbn̩tˌbʁoːt]", "Traditional cold evening meal with bread", "परम्परागत साँझको खाना (पाउरोटीसहित)", "ドイツ伝統の夕食（冷たい料理とパン）", "Zum Abendbrot essen wir Vollkornbrot mit Käse.", "For evening bread we eat whole grain bread with cheese.", "साँझको खानामा हामी चीजसँग पाउरोटी खान्छौँ।", "夕食には全粒粉パンとチーズを食べます。"),
        VocabularyItem("cv_3_2", "die Bäckerei", "die", "die Bäckereien", "[diː bɛkəˈʁaɪ̯]", "Bakery shop", "पाउरोटी पसल (बेकरी)", "パン屋", "Ich hole frische Brötchen in der Bäckerei.", "I'm getting fresh rolls at the bakery.", "म बेकरीबाट ताजा पाउरोटी ल्याउँदैछु।", "パン屋さんで焼きたてのパンを買ってきます。")
      )
    ),
    CultureTopic(
      id = "cult_4",
      titleDe = "Weihnachtsmärkte & Winterzauber",
      titleEn = "German Christmas Markets",
      titleNe = "जर्मन क्रिसमस बजार (Weihnachtsmärkte)",
      titleJa = "ドイツのクリスマスマーケット",
      category = "Tradition & Holiday",
      drawableRes = R.drawable.ic_christmas_market,
      badgeText = "Winter Magic",
      summaryEn = "Fairytale wooden huts, warm spiced Glühwein, and handcrafted ornaments across ancient town squares.",
      summaryNe = "चिसो हिउँदमा काठका आकर्षक स्टलहरू, तातो ग्लुवाइन र हातले बनाइएका सामानहरूको जादुई बजार।",
      summaryJa = "歴史ある街の広場を彩る、木造の屋台とホットワインの温もりあふれる冬の風物詩。",
      fullStoryEn = "Dating back to the late Middle Ages (such as Dresden's Striezelmarkt founded in 1434 and Nuremberg's Christkindlesmarkt), German Christmas markets are beloved winter traditions worldwide. Starting in late November during Advent, town squares transform into glowing winter wonderlands. Visitors stroll between charming wooden stalls lit by lanterns, savoring warm spiced hot mulled wine ('Glühwein'), roasted chestnuts, gingerbread ('Lebkuchen'), and potato pancakes ('Reibekuchen') while shopping for handmade wooden Nutcrackers (Nussknacker) from the Erzgebirge mountains.",
      fullStoryNe = "१५औं शताब्दीदेखि सुरु भएको जर्मन क्रिसमस बजार विश्वभर प्रख्यात छ। नोभेम्बरको अन्त्यतिर शहरका मुख्य चोकहरूमा काठका सुन्दर पसलहरू खुल्छन्। मानिसहरू तातो मसलेदार वाइन ('Glühwein'), जिन्जरब्रेड र परम्परागत हस्तकलाका सामानहरू किन्दै रमाइलो गर्छन्।",
      fullStoryJa = "中世（ドレスデンの1434年創業など）に端を発するクリスマスマーケット。アドヴェント（待降節）に入ると、街の中心広場に温かな光が灯り、スパイスの効いたホットワイン「Glühwein（グリューヴァイン）」やレープクーヘン（伝統菓子）の甘い香りが漂います。木製の人形劇や職人手作りのオーナメントが並ぶ、幻想的な空間です。",
      funFactDe = "Der Nürnberger Christkindlesmarkt wird feierlich vom 'Christkind' mit einem traditionellen Prolog eröffnet.",
      funFactEn = "The famous Nuremberg market is opened every year by the angelic 'Christkind', chosen from local youths to recite a historic ceremonial prologue from the cathedral balcony.",
      funFactNe = "न्युरेम्बर्गको क्रिसमस बजार हरेक वर्ष ऐतिहासिक चर्चको कौसीबाट 'Christkind' द्वारा विधिवत उद्घाटन गरिन्छ।",
      funFactJa = "ニュルンベルクのマーケットは毎年、市民から選ばれた少女「クリストキント（幼子キリストの使者）」がバルコニーから口上を述べて幕を開けます。",
      vocabulary = listOf(
        VocabularyItem("cv_4_1", "der Glühwein", "der", null, "[deːɐ̯ ˈɡlyːˌvaɪ̯n]", "Hot spiced mulled wine", "तातो मसलेदार वाइन (ग्लुवाइन)", "ホットワイン / グリューヴァイン", "Ein Becher heißer Glühwein wärmt im Winter.", "A mug of hot Glühwein warms you in winter.", "एक मग तातो ग्लुवाइनले जाडोमा न्यानो बनाउँछ।", "温かいグリューヴァインは冬に体を温めてくれます。"),
        VocabularyItem("cv_4_2", "der Weihnachtsmarkt", "der", "die Weihnachtsmärkte", "[ˈvaɪ̯naxtsˌmaʁkt]", "Christmas market", "क्रिसमस बजार", "クリスマスマーケット", "Wir treffen uns auf dem Weihnachtsmarkt.", "We meet at the Christmas market.", "हामी क्रिसमस बजारमा भेट्नेछौँ।", "クリスマスマーケットで待ち合わせしましょう。")
      )
    )
  )

  // German History Milestones
  val historyMilestones = listOf(
    HistoryMilestone(
      id = "hist_1",
      era = "1522",
      year = "1522 AD",
      titleDe = "Martin Luthers Bibel & Die Deutsche Sprache",
      titleEn = "Martin Luther & Birth of Modern German",
      titleNe = "मार्टिन लुथरको बाइबल र आधुनिक जर्मन भाषा",
      titleJa = "マルティン・ルターと近代ドイツ語の誕生",
      drawableRes = R.drawable.ic_history_scroll,
      overviewEn = "Luther translated the Bible at Wartburg Castle, unifying hundreds of regional dialects into Standard German.",
      overviewNe = "मार्टिन लुथरले भार्टबर्ग दरबारमा बाइबल अनुवाद गरी सयौँ स्थानीय भाषाहरूलाई मानक जर्मनमा एकीकृत गरे।",
      overviewJa = "ルターがヴァルトブルク城で聖書をドイツ語に翻訳し、標準ドイツ語の基礎を築いた歴史的瞬間。",
      detailsEn = "Before the 16th century, the German-speaking territories of the Holy Roman Empire were divided into dozens of regional dialects that could barely understand one another. In 1521-1522, sheltered in Wartburg Castle, Martin Luther translated the New Testament from Greek and Hebrew directly into vivid German vernacular. Utilizing Johannes Gutenberg's revolutionary movable type printing press, Luther's Bible became an unprecedented bestseller, creating a shared vocabulary and grammatical foundation that evolved directly into today's 'Hochdeutsch'.",
      detailsNe = "१६औं शताब्दी अघि जर्मनी सयौँ स-साना राज्य र फरक भाषाहरूमा विभाजित थियो। सन् १५२१-२२ मा मार्टिन लुथरले साधारण जनताले बुझ्ने भाषामा बाइबल अनुवाद गरे। गुटेनबर्गको छापाखानाको मद्दतले यो अनुवाद घर-घरमा पुग्यो र यसैबाट आजको मानक जर्मन भाषा (Hochdeutsch) को जग बस्यो।",
      detailsJa = "16世紀以前のドイツ語圏は無数の方言に分かれ、地域間の意思疎通が困難でした。1522年、マルティン・ルターは民衆が日常で使う生き生きとした表現を用い、聖書をドイツ語に翻訳。グーテンベルクの印刷技術と相まって全土に普及し、これが現在の統一された「標準ドイツ語（Hochdeutsch）」の確固たる土台となりました。",
      languageEvolutionNoteEn = "Linguistic impact: Created modern German vocabulary, idioms like 'ein Buch mit sieben Siegeln' (a mystery), and established standard High German grammar.",
      languageEvolutionNoteNe = "भाषिक प्रभाव: आधुनिक जर्मन शब्दावली, मुहावराहरू र व्याकरणको विकास भयो।",
      languageEvolutionNoteJa = "言語的影響：多くの慣用句や単語が生み出され、現代ドイツ語の文法規範が確立されました。"
    ),
    HistoryMilestone(
      id = "hist_2",
      era = "1871 - 1914",
      year = "1871 - 1914 AD",
      titleDe = "Land der Dichter, Denker & Erfinder",
      titleEn = "Land of Poets, Thinkers & Pioneers",
      titleNe = "कवि, दार्शनिक र आविष्कारकहरूको देश",
      titleJa = "詩人・思想家・発明家たちの黄金時代",
      drawableRes = R.drawable.ic_brandenburg,
      overviewEn = "From Goethe, Schiller, and Kant to Karl Benz's first automobile and Röntgen's X-rays.",
      overviewNe = "गोएथे, कान्टदेखि कार्ल बेन्जको पहिलो मोटरगाडी र रोन्टजेनको एक्सरे आविष्कारसम्म।",
      overviewJa = "ゲーテやカントの哲学から、カール・ベンツの自動車発明、レントゲン博士のX線発見まで。",
      detailsEn = "Germany has long been honored as 'Das Land der Dichter und Denker' (Land of Poets and Thinkers), home to literary titans like Johann Wolfgang von Goethe and Friedrich Schiller, and philosophical giants like Immanuel Kant, Hegel, and Nietzsche. During the 19th-century industrial surge, this intellectual spirit sparked world-changing inventions: Karl Benz patented the first gasoline automobile in 1886, Rudolf Diesel invented the diesel engine, and Wilhelm Röntgen discovered X-rays (Röntgenstrahlen), winning the first Nobel Prize in Physics.",
      detailsNe = "जर्मनीलाई 'कवि र चिन्तकहरूको देश' भनिन्छ। गोएथे र शिलर जस्ता साहित्यकार तथा कान्ट जस्ता दार्शनिकहरूले विश्व चिन्तनलाई नयाँ दिशा दिए। सन् १८८६ मा कार्ल बेन्जले विश्वको पहिलो पेट्रोल कार बनाए, रुडोल्फ डिजेलले डिजेल इन्जिन बनाए र रोन्टजेनले एक्सरे पत्ता लगाए।",
      detailsJa = "ドイツは「詩人と哲学者・思想家の国（Land der Dichter und Denker）」と称され、ゲーテ、シラー、カントらが文化を牽引しました。産業革命期にはカール・ベンツが世界初のガソリン自動車を特許取得（1886年）、ルドルフ・ディーゼルがディーゼル機関を発明、レントゲン博士がX線を発見するなど、世界を変える発明が次々と生まれました。",
      languageEvolutionNoteEn = "Linguistic impact: German became the preeminent global language of physics, chemistry, medicine, and philosophy until mid-20th century.",
      languageEvolutionNoteNe = "भाषिक प्रभाव: जर्मन भाषा विज्ञान, प्रविधि, चिकित्सा र दर्शनशास्त्रको अन्तर्राष्ट्रिय प्रमुख भाषा बन्यो।",
      languageEvolutionNoteJa = "言語的影響：20世紀半ばまで、ドイツ語は物理学、化学、医学、哲学における世界の共通語でした。"
    ),
    HistoryMilestone(
      id = "hist_3",
      era = "1919 - 1933",
      year = "1919 - 1933 AD",
      titleDe = "Bauhaus & Weimarer Republik",
      titleEn = "The Bauhaus Movement & Modern Design",
      titleNe = "बाउहाउस आन्दोलन र आधुनिक डिजाइन",
      titleJa = "バウハウス運動とワイマール文化",
      drawableRes = R.drawable.ic_history_scroll,
      overviewEn = "The revolutionary school founded in Weimar that redefined world architecture, art, and modern minimalism.",
      overviewNe = "भाइमारमा स्थापना भएको क्रान्तिकारी कला विद्यालय, जसले आधुनिक वास्तुकला र डिजाइनको स्वरूप बदल्यो।",
      overviewJa = "「機能が形態に従う」現代デザイン・建築の原点となった伝説的造形学校。",
      detailsEn = "Founded by architect Walter Gropius in Weimar in 1919, the Staatliches Bauhaus was a groundbreaking art school that sought to unite fine arts, craft, and industrial technology. Embracing clean geometric forms, functional utility ('Form follows function'), and accessible mass production, Bauhaus masters like Mies van der Rohe, Wassily Kandinsky, and Paul Klee reshaped global 20th-century architecture, typography, furniture, and product aesthetics, influencing everything from skyscrapers to modern smartphone interfaces.",
      detailsNe = "सन् १९१९ मा आर्किटेक्ट वाल्टर ग्रोपियसद्वारा स्थापित बाउहाउसले कला र प्रविधिलाई एकसाथ ल्यायो। 'फारमले कार्यलाई पछ्याउँछ' (Form follows function) भन्ने सिद्धान्तबाट सुरु भएको यस आन्दोलनले विश्वको आधुनिक भवन, फर्निचर र डिजिटल डिजाइनसम्म ठूरो प्रभाव पारेको छ।",
      detailsJa = "1919年にヴァルター・グロピウスが設立したバウハウス。芸術と産業・技術を融合させ、「機能美（Form follows function）」を徹底追求しました。カンディンスキーやミース・ファン・デル・ローエらが教鞭を執り、現代のビル建築やミニマルな家具、ひいてはスマートフォンのUIデザインにまで多大な影響を与えています。",
      languageEvolutionNoteEn = "Linguistic impact: Introduced precise design vocabulary (Sachlichkeit, Gestaltung, Formgebung) into international lexicon.",
      languageEvolutionNoteNe = "भाषिक प्रभाव: 'Gestaltung', 'Sachlichkeit' जस्ता डिजाइन शब्दावलीहरू अन्तर्राष्ट्रिय रूपमा स्थापित भए।",
      languageEvolutionNoteJa = "言語的影響：デザインや造形に関するドイツ語（Gestaltungなど）が世界中で専門用語として使われるようになりました。"
    ),
    HistoryMilestone(
      id = "hist_4",
      era = "1989 - 1990",
      year = "1989 - 1990 AD",
      titleDe = "Der Fall der Berliner Mauer & Wiedervereinigung",
      titleEn = "Fall of Berlin Wall & German Reunification",
      titleNe = "बर्लिन पर्खालको पतन र जर्मनीको पुनःएकीकरण",
      titleJa = "ベルリンの壁崩壊とドイツ再統一",
      drawableRes = R.drawable.ic_brandenburg,
      overviewEn = "On November 9, 1989, peaceful protests brought down the Wall, reunifying Germany on October 3, 1990.",
      overviewNe = "सन् १९८९ नोभेम्बर ९ मा शान्तिपूर्ण आन्दोलनले बर्लिन पर्खाल ढाल्यो र सन् १९९० अक्टोबर ३ मा जर्मनीको पुनःएकीकरण भयो।",
      overviewJa = "1989年11月9日、東独市民の平和的抗議により壁が崩壊。1990年10月3日に東西ドイツが再統一。",
      detailsEn = "Following World War II, Germany and its capital Berlin were divided into West (Federal Republic) and East (GDR). Built in 1961, the Berlin Wall became the starkest symbol of the Cold War. In autumn 1989, peaceful demonstrations ('Wir sind das Volk!') culminated on November 9, 1989, when the border was opened and overjoyed citizens celebrated atop the Wall at the Brandenburg Gate. On October 3, 1990, Germany officially reunified, celebrated annually as 'Tag der Deutschen Einheit' (German Unity Day).",
      detailsNe = "दोस्रो विश्वयुद्धपछि जर्मनी पूर्वी र पश्चिमी दुई भागमा विभाजित थियो। सन् १९६१ मा बनाइएको बर्लिन पर्खाल शीतयुद्धको सबैभन्दा ठूलो प्रतीक थियो। सन् १९८९ नोभेम्बर ९ मा जनताको शान्तिपूर्ण प्रदर्शनका कारण यो पर्खाल ढल्यो। सन् १९९० अक्टोबर ३ मा दुवै भाग मिलेर एउटै राष्ट्र बने, जसलाई आज जर्मन एकता दिवसका रूपमा मनाइन्छ।",
      detailsJa = "第二次世界大戦後、東西に分断されたドイツとベルリン。1961年に建設されたベルリンの壁は冷戦の象徴でした。1989年秋、東ドイツ市民による平和的なデモ（「Wir sind das Volk! / 我々が人民だ！」）が広がり、同年11月9日に壁がついに開放。1990年10月3日に国家統一が実現し、現在も「ドイツ統一の日」として国民の祝日となっています。",
      languageEvolutionNoteEn = "Linguistic impact: Reunited Eastern and Western linguistic variants; iconic phrases like 'Wir sind ein Volk!' (We are one people) and 'Ostalgie'.",
      languageEvolutionNoteNe = "भाषिक प्रभाव: 'Wir sind ein Volk!' (हामी एक हौं) जस्ता ऐतिहासिक अभिव्यक्तिहरू जर्मन इतिहासमा अमर रहे।",
      languageEvolutionNoteJa = "言語的影響：東西で分断されていた言葉のギャップが埋まり、「Wende（転換点）」「Ostalgie」などの新語が定着しました。"
    )
  )

  // Interactive Quiz questions
  val quizQuestions = listOf(
    QuizQuestion(
      id = "q_1",
      type = QuizType.GENDER_DER_DIE_DAS,
      promptGerman = "Welcher Artikel gehört zum Wort 'Auto'?",
      promptEnglish = "Which article belongs to the noun 'Auto' (Car)?",
      promptNepali = "'Auto' (गाडी) शब्दको सही आर्टिकल कुन हो?",
      promptJapanese = "「Auto（車）」の正しい冠詞はどれですか？",
      options = listOf("der", "die", "das"),
      correctOptionIndex = 2,
      explanationEnglish = "'Auto' is neuter: das Auto. Words of international transport and foreign origin often take 'das'.",
      explanationNepali = "'Auto' नपुंसकलिङ्ग हो: das Auto।",
      explanationJapanese = "「Auto」は中性名詞なので「das Auto」が正解です。"
    ),
    QuizQuestion(
      id = "q_2",
      type = QuizType.MULTIPLE_CHOICE,
      promptGerman = "Wie sagt man 'Good evening' auf Deutsch?",
      promptEnglish = "How do you say 'Good evening' in German?",
      promptNepali = "जर्मन भाषामा 'शुभ सन्ध्या' (Good evening) कसरी भनिन्छ?",
      promptJapanese = "ドイツ語で「こんばんは」は何と言いますか？",
      options = listOf("Guten Morgen", "Guten Tag", "Guten Abend", "Gute Nacht"),
      correctOptionIndex = 2,
      explanationEnglish = "'Guten Abend' means Good evening. Guten Morgen is morning, Guten Tag is day/afternoon, Gute Nacht is goodnight before bed.",
      explanationNepali = "'Guten Abend' को अर्थ शुभ सन्ध्या हो।",
      explanationJapanese = "「Guten Abend」が正解です（Morgen＝朝、Tag＝昼、Nacht＝おやすみ）。"
    ),
    QuizQuestion(
      id = "q_3",
      type = QuizType.GENDER_DER_DIE_DAS,
      promptGerman = "Welcher Artikel gehört zu 'Zeitung' (Newspaper)?",
      promptEnglish = "Which article belongs to 'Zeitung' (Newspaper)?",
      promptNepali = "'Zeitung' (पत्रिका) शब्दको आर्टिकल कुन हो?",
      promptJapanese = "「Zeitung（新聞）」の冠詞はどれですか？",
      options = listOf("der", "die", "das"),
      correctOptionIndex = 1,
      explanationEnglish = "Nouns ending in -ung are 100% feminine: DIE Zeitung!",
      explanationNepali = "-ung मा अन्त्य हुने सबै शब्दहरू स्त्रीलिङ्ग (die) हुन्छन्: die Zeitung!",
      explanationJapanese = "語尾が「-ung」で終わる名詞は100%女性名詞なので「die」です！"
    ),
    QuizQuestion(
      id = "q_4",
      type = QuizType.GRAMMAR_CASE,
      promptGerman = "Ich trinke gerne einen Kaffee mit ____ (der Freund -> Dativ!).",
      promptEnglish = "Fill in: 'Ich trinke gerne einen Kaffee mit ____' (der Freund in Dative)",
      promptNepali = "खाली ठाउँ भर्नुहोस्: 'Ich trinke gerne einen Kaffee mit ____' (der Freund दातिभमा)",
      promptJapanese = "空欄を埋めてください：「Ich trinke gerne einen Kaffee mit ____」（der Freundの3格）",
      options = listOf("den Freund", "dem Freund", "der Freund", "des Freundes"),
      correctOptionIndex = 1,
      explanationEnglish = "After preposition 'mit', masculine 'der' shifts to Dative 'dem': mit dem Freund!",
      explanationNepali = "'mit' पछि पुल्लिङ्ग शब्द Dativ मा 'dem' बन्छ: mit dem Freund!",
      explanationJapanese = "前置詞「mit」の後は必ず3格（Dativ）になるため、「dem Freund」が正解です。"
    ),
    QuizQuestion(
      id = "q_5",
      type = QuizType.LISTENING,
      promptGerman = "Höre zu: Welches Wort bedeutet 'Gemütlichkeit'?",
      promptEnglish = "Listen to audio: What does 'Gemütlichkeit' mean?",
      promptNepali = "उच्चारण सुन्नुहोस्: 'Gemütlichkeit' को अर्थ के हो?",
      promptJapanese = "発音を聴いて回答：「Gemütlichkeit」の意味は？",
      options = listOf("Cozy warmth & comfort", "Speed and rush", "Cold distance", "Anger"),
      correctOptionIndex = 0,
      explanationEnglish = "'Gemütlichkeit' is a quintessential German cultural concept meaning cozy warmth, comfort, and friendliness.",
      explanationNepali = "'Gemütlichkeit' को अर्थ न्यानोपन, आराम र आत्मीयता हो।",
      explanationJapanese = "「Gemütlichkeit」は居心地の良さや温かいアットホーム感を意味するドイツ固有の美徳です。",
      audioToPlay = "Gemütlichkeit"
    ),
    QuizQuestion(
      id = "q_6",
      type = QuizType.MULTIPLE_CHOICE,
      promptGerman = "Was bedeutet die Redewendung 'Übung macht den Meister'?",
      promptEnglish = "What does the German proverb 'Übung macht den Meister' mean?",
      promptNepali = "जर्मन उखान 'Übung macht den Meister' को अर्थ के हो?",
      promptJapanese = "ことわざ「Übung macht den Meister」の意味は？",
      options = listOf("Practice makes perfect", "Early to bed early to rise", "Silence is golden", "Time is money"),
      correctOptionIndex = 0,
      explanationEnglish = "'Übung macht den Meister' literally means 'Practice makes the master' (Practice makes perfect).",
      explanationNepali = "यसको अर्थ 'अभ्यासले नै मानिसलाई दक्ष बनाउँछ' हो।",
      explanationJapanese = "直訳すると「練習が達人を作る」、つまり「習うより慣れろ / 継続は力なり」です。"
    )
  )
}
