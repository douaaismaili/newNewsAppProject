package com.douaamohamed.newsapp.common

import com.douaamohamed.newsapp.BuildConfig
import com.douaamohamed.newsapp.data.model.Country
import com.douaamohamed.newsapp.data.model.Language

object Const {

    const val SEARCH_NEWS_TIME_DELAY = 500L           // Délai de recherche (ms)
    const val DEFAULT_QUERY_PAGE_SIZE = 20            // Nombre d'articles par page
    const val DEFAULT_PAGE_NUM = 1                    // Page de départ
    const val DEFAULT_COUNTRY = "fr"                  // France par défaut
    const val DEFAULT_LANGUAGE = "fr"                 // Français par défaut
    const val DEFAULT_SOURCE = "le-monde"             // Source française par défaut (exemple)
    const val API_KEY = BuildConfig.API_KEY
    const val BASE_URL = "https://newsapi.org/v2/"
    const val DB_NAME = "article_db"

    // WorkManager et Notifications
    const val UNIQUE_WORK_NAME = "newsAppPeriodicWork"
    const val MORNING_UPDATE_TIME = 8                 // Mise à jour matinale à 8h
    const val NOTIFICATION_ID = 1
    const val NOTIFICATION_CHANNEL_ID = "news_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Actualités"
    const val NOTIFICATION_CONTENT_TITLE = "Nouvelles actualités"
    const val NOTIFICATION_CONTENT_TEXT = "Découvrez les dernières nouvelles..."

    // Liste des pays (triée alphabétiquement en français)
    val countryList: List<Country> = listOf(
        Country("Afrique du Sud", "za"),
        Country("Allemagne", "de"),
        Country("Arabie saoudite", "sa"),
        Country("Argentine", "ar"),
        Country("Australie", "au"),
        Country("Autriche", "at"),
        Country("Belgique", "be"),
        Country("Brésil", "br"),
        Country("Bulgarie", "bg"),
        Country("Canada", "ca"),
        Country("Chine", "cn"),
        Country("Colombie", "co"),
        Country("Corée du Sud", "kr"),
        Country("Cuba", "cu"),
        Country("Égypte", "eg"),
        Country("Émirats arabes unis", "ae"),
        Country("Espagne", "es"),
        Country("États-Unis", "us"),
        Country("France", "fr"),
        Country("Grèce", "gr"),
        Country("Hong Kong", "hk"),
        Country("Hongrie", "hu"),
        Country("Inde", "in"),
        Country("Indonésie", "id"),
        Country("Irlande", "ie"),
        Country("Israël", "il"),
        Country("Italie", "it"),
        Country("Japon", "jp"),
        Country("Lettonie", "lv"),
        Country("Lituanie", "lt"),
        Country("Malaisie", "my"),
        Country("Maroc", "ma"),
        Country("Mexique", "mx"),
        Country("Nigeria", "ng"),
        Country("Norvège", "no"),
        Country("Nouvelle-Zélande", "nz"),
        Country("Pays-Bas", "nl"),
        Country("Philippines", "ph"),
        Country("Pologne", "pl"),
        Country("Portugal", "pt"),
        Country("République tchèque", "cz"),
        Country("Roumanie", "ro"),
        Country("Royaume-Uni", "gb"),
        Country("Russie", "ru"),
        Country("Serbie", "rs"),
        Country("Singapour", "sg"),
        Country("Slovaquie", "sk"),
        Country("Suède", "se"),
        Country("Suisse", "ch"),
        Country("Taïwan", "tw"),
        Country("Thaïlande", "th"),
        Country("Turquie", "tr"),
        Country("Ukraine", "ua"),
        Country("Venezuela", "ve")
    )

    // Liste des langues (triée alphabétiquement)
    val languageList = listOf(
        Language("Allemand", "de"),
        Language("Anglais", "en"),
        Language("Arabe", "ar"),
        Language("Chinois", "zh"),
        Language("Espagnol", "es"),
        Language("Français", "fr"),
        Language("Hébreu", "he"),
        Language("Italien", "it"),
        Language("Néerlandais", "nl"),
        Language("Norvégien", "no"),
        Language("Portugais", "pt"),
        Language("Russe", "ru"),
        Language("Suédois", "sv")
    )
}