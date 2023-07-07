package com.greta.federation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public static final String AUTHORIZATION_HEADER = "Authorization";


    @Bean
    public Docket api() {
        // Création d'une nouvelle instance de Docket
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Federation de foot API documentation")
                                .title("Federation de foot REST API")
                                .build()
                )
                .groupName("REST API V1")
                .securityContexts(Collections.singletonList(securityContext()))  // Ajout du contexte de sécurité
                .securitySchemes(Collections.singletonList(apiKey()))  // Ajout du schéma de sécurité
                .useDefaultResponseMessages(false)  // Désactivation des messages de réponse par défaut
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.greta.federation"))  // Sélection des contrôleurs à documenter
                .paths(PathSelectors.any())  // Tous les chemins seront documentés
                .build();
    }

    //  crée un nouvel ApiKey
    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");  // Création de l'ApiKey avec "JWT" comme clé et "Authorization" comme en-tête
    }

    // Cette méthode crée un nouveau SecurityContext
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    //  crée une liste de SecurityReference
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");  // Création d'un nouveau AuthorizationScope
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;  // Ajout du AuthorizationScope à la liste
        return Collections.singletonList(
                new SecurityReference("JWT", authorizationScopes));  // Retour d'une liste de SecurityReference avec "JWT" comme clé
    }
}
