

## Description
 Federation3 est une application Java basée sur Spring Boot, conçue pour gérer des fédérations sportives, leurs événements, compétitions, équipes et utilisateurs. Elle utilise Hibernate pour la gestion des données, Spring Security pour la gestion de l'authentification, Swagger pour la documentation API, Stripe pour les paiements en ligne, et Flickr pour la gestion des images.

## Technologies principales
- Java 11
- Spring Boot 2.5.6
- Spring Security
- Hibernate (Spring Data JPA)
- Swagger (Springfox 3.0.0)
- JWT pour l'authentification
- Flickr4Java (3.0.4)
- Stripe (22.23.1)
- MySQL (8.0.28)
- Lombok

## Prérequis
- Java 11 ou supérieur
- Maven
- MySQL (ou autre base de données relationnelle compatible)

## Structure du projet
```
eosfel97-federation3/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── src/
│   ├── main/
│   │   ├── java/com/greta/federation/
│   │   │   ├── FederationApplication.java (Classe principale)
│   │   │   ├── config/ (Configuration des filtres, sécurité, Swagger)
│   │   │   ├── controller/ (Contrôleurs REST)
│   │   │   ├── dto/ (Objets de transfert de données)
│   │   │   ├── entity/ (Entités JPA)
│   │   │   ├── exception/ (Exceptions personnalisées)
│   │   │   ├── handlers/ (Gestion des exceptions REST)
│   │   │   ├── repository/ (Interfaces de persistence)
│   │   │   ├── services/ (Services métier)
│   │   │   ├── utils/ (Utilitaires, JWT)
│   │   │   └── validator/ (Validation des entités et DTOs)
│   │   └── resources/
│   │       ├── application.yml (Configuration de l'application)
│   │       └── static/css/ (Feuilles de style CSS)
│   └── test/ (Tests unitaires)
├── logs/ (Fichiers de logs archivés)
└── .mvn/ (Wrapper Maven)
```

## Installation
1. Clonez le dépôt :
```shell
git clone <url-de-votre-repo>
```

2. Accédez au répertoire du projet :
```shell
cd eosfel97-federation3
```

3. Compilez le projet avec Maven :
```shell
./mvnw clean install
```

4. Configurez la base de données dans `application.yml`.

5. Lancez l'application :
```shell
./mvnw spring-boot:run
```

## Documentation de l'API
La documentation Swagger est accessible à :
```
http://localhost:8080/swagger-ui.html
```

## Tests
Les tests unitaires sont situés dans :
```
src/test/java/com/greta/federation/
```
Exécutez les tests avec :
```shell
./mvnw test
```

## Logs
Les logs archivés sont disponibles dans :
```
logs/
```




