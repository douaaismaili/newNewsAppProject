# Actualités Pro

Une application Android moderne pour consulter les actualités du monde entier via l'API **NewsAPI.org**.

## 📱 Description

Actualités Pro est une application Android complète et personnalisée qui permet de :
- Consulter les dernières actualités en temps réel
- Rechercher des articles par mot-clé
- Filtrer par pays, langue et source
- Lire les articles complets dans un navigateur intégré (WebView)
- Sauvegarder/supprimer des articles en favoris (Room)
- Partager des articles via les applications du téléphone
- Pull-to-refresh et pagination infinie

L'application existe en **deux versions** :
- Version **Views/XML** (RecyclerView + Fragments)
- Version **Jetpack Compose** (moderne et fluide)

Thème personnalisé **rouge/noir** sombre avec titre blanc, interface 100 % en français.

## 🛠 Technologies utilisées

- **Langage** : Kotlin
- **UI** : Jetpack Compose (version principale) + Views/XML (version alternative)
- **Architecture** : MVVM + Repository Pattern
- **Injection de dépendances** : Dagger Hilt
- **Réseau** : Retrofit + OkHttp (logging) + Gson
- **Base de données locale** : Room
- **Pagination** : Paging 3 + LazyPagingItems
- **Asynchrone** : Coroutines + Flow + StateFlow
- **Images** : Coil Compose
- **Navigation** : Navigation Compose (NavHost)
- **Tâches en arrière-plan** : WorkManager (optionnel)
- **Pull-to-refresh** : Material3 PullRefresh
- **WebView** : AndroidView + WebViewClient (lecture complète des articles)
- **Partage** : Intent.ACTION_SEND
- **Thème** : Material3 personnalisé (rouge/noir, dark mode forcé)
- **Localisation** : strings.xml (100 % français)

## ✨ Fonctionnalités principales

- **Liste des actualités** : Top headlines avec pagination infinie et images (Coil)
- **Recherche** : Barre de recherche avec filtres avancés (pays, langue, source)
- **Favoris** : Sauvegarde locale avec Room + toggle cœur plein/vide
- **Détail article** : WebView intégré pour lire l'article complet sans quitter l'app
- **Partager** : Bouton de partage (WhatsApp, SMS, email, etc.)
- **Pull-to-refresh** : Glisser vers le bas pour actualiser
- **Gestion d'erreurs** : Messages clairs (pas de réseau, pas de données, etc.)
- **Thème personnalisé** : Rouge/noir sombre avec barre du haut rouge et texte blanc
- **Deux implémentations** : Version Compose (moderne) + Version Views/XML (classique)

## 🏗 Architecture

- **UI Layer** : Jetpack Compose (écrans, composants, navigation)
- **Presentation Layer** : ViewModels + StateFlow + Paging
- **Domain Layer** : UseCases (fetch, save, delete)
- **Data Layer** : Remote (Retrofit) + Local (Room) + Repository
- **DI** : Hilt (Application, ViewModel, Repository, Network, Database)

Deux approches de navigation :
- Navigation Compose (NavHost, routes, arguments)
- Navigation XML/Fragment (version Views)

## 📸 Démonstration

*(Ajoute tes captures ici)*

- Écran d'accueil avec liste d'articles
- Écran recherche avec filtres
- Écran détail avec WebView
- Favoris avec swipe-to-delete
- Thème rouge/noir

## 🚀 Installation

1. Cloner le repo :
   ```bash
   git clone https://github.com/amranilara/newNewsAppProject.git
