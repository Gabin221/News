# News

Bienvenue dans l'application **News**, une application Kotlin qui vous permet de rester informé des dernières actualités dans divers domaines. Cette application se compose de trois sections principales, chacune offrant des fonctionnalités uniques pour répondre à vos besoins en matière d'information.

## Fonctionnalités

### 1. Actualités Générales
Cette section utilise l'API "News Data" pour vous fournir les dernières actualités de diverses sources d'information. Vous pouvez consulter les articles récents sur différents sujets, vous permettant ainsi de rester à jour avec les événements mondiaux.

### 2. Actualités du MCU
Pour les fans de l'univers cinématographique Marvel (MCU), cette section est dédiée aux dernières nouvelles concernant les prochains films et projets. Restez informé des nouvelles sorties, annonces et rumeurs sur vos super-héros préférés et leurs aventures.

### 3. Recherche d'Articles Scientifiques
Cette section exploite l'API arXiv pour vous permettre de rechercher et lire des articles scientifiques. Que vous soyez étudiant, chercheur ou simplement curieux, vous pouvez accéder à une vaste base de données d'articles scientifiques couvrant un large éventail de domaines académiques.

## Technologies Utilisées

- **Kotlin** : Langage de programmation principal pour le développement de l'application.
- **API News Data** : Pour récupérer les dernières actualités.
- **API arXiv** : Pour rechercher et lire des articles scientifiques.
- **MCU News Sources** : Intégration de diverses sources pour obtenir des informations sur les prochains films du MCU.

## Installation

Pour cloner et exécuter cette application, assurez-vous d'avoir [Android Studio](https://developer.android.com/studio) installé sur votre machine. Suivez les étapes ci-dessous :

1. Clonez ce dépôt :
    ```sh
    git clone https://github.com/Gabin221/News.git
    ```
2. Ouvrez le projet dans Android Studio.
3. Synchronisez les dépendances et exécutez l'application sur un émulateur ou un appareil physique.

## Configuration

Vous aurez besoin de clés API pour accéder aux services d'actualités et d'arXiv. Suivez les instructions spécifiques de chaque service pour obtenir ces clés et configurez-les dans votre application.

1. **API News Data** :
   - Inscrivez-vous sur [News Data](https://newsdata.io) pour obtenir une clé API.
   - Ajoutez votre clé API dans le fichier de configuration `news_data_config.xml`.

2. **API arXiv** :
   - Aucune clé API n'est requise pour accéder à l'API arXiv, mais assurez-vous de respecter leurs conditions d'utilisation.
