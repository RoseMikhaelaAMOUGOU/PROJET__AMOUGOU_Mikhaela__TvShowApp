
# TvShowApp

## Objectif

Développer une application mobile Android affichant une liste de séries TV populaires sous forme de grille, en consommant l’API suivante :  
`https://www.episodate.com/api/most-popular?page=1`  

L'application est conçue avec l’architecture MVVM, Jetpack Compose, Retrofit, Dagger-Hilt, Coil et Coroutines.

---

## Fonctionnalités Principales

- Affichage d'une grille de séries TV.
- Chaque carte de série contient :
  - Une image (chargée avec Coil).
  - Le titre de la série.
- Navigation vers une page de détails de la série.
- Support du thème clair et sombre avec un bouton de bascule.
- Chargement des données via Retrofit et gestion de l'état avec ViewModel + StateFlow.

---

## Architecture Utilisée

- MVVM (Model - View - ViewModel)
- Jetpack Compose pour l'UI déclarative
- Repository pattern pour l'accès aux données
- Dagger-Hilt pour l'injection de dépendances
- Coroutines pour les appels asynchrones
- StateFlow pour l'observation de l'état

---

## Technologies et Bibliothèques

- Jetpack Compose
- Retrofit
- Coil
- Dagger-Hilt
- Coroutines
- Kotlin
- StateFlow

---

## Structure du Projet

```

com.example.tvshowapp
├── di                 → Injection des dépendances (Retrofit, etc.)
├── model
│   ├── data          → Modèles de données (TV Show)
│   ├── repository    → Repository accédant à l'API
│   └── service       → Interface Retrofit
├── ui.theme          → Définition des thèmes, couleurs et typographies
├── view
│   ├── TopBar.kt
│   ├── BottomNavBar.kt
│   ├── TvShowGrid.kt
│   ├── TvShowListScreen.kt
│   ├── TvShowDetailScreen.kt
│   └── TvShowAppNav.kt → Navigation Compose
├── viewmodel
│   └── TvShowViewModel.kt
└── MainActivity.kt

````

---

## Fonctionnalités Avancées

- Système de thème clair/sombre intégré via `rememberSaveable` et `TopBar`.
- Navigation entre la liste et les détails via `NavHost` et `composable`.

---

## Installation et Lancement

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/tvshowapp.git
````

2. Ouvrir le projet dans Android Studio.

3. Assurez-vous d’avoir les dépendances suivantes dans votre `build.gradle` (niveau app) :

    * Retrofit
    * Coil
    * Compose
    * Dagger-Hilt
    * Coroutines
    * Navigation Compose

4. Compiler et lancer l'application sur un émulateur ou un appareil Android.

---

## Décisions Architecturales

* Utilisation de **StateFlow** pour exposer les états de l'UI.
* **Dagger-Hilt** est utilisé pour rendre l'injection de dépendances plus propre.
* **Jetpack Compose** permet une interface moderne et réactive.
* Séparation stricte des responsabilités avec le pattern MVVM.

---

## Améliorations Possibles

* Ajout de la pagination pour charger plus de pages.
* Gestion des erreurs réseau et affichage de messages d’erreur.
* Ajout de tests unitaires et d’instrumentation.
* Favoris et persistance locale avec Room.

---

## Auteur

Projet réalisé dans le cadre d’un exercice de développement Android sous 2 semaines.


