package greta.federation.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    ARTICLE_ALREADY_IN_USE(1002),

    ACTUALITE_NOT_FOUND(1003),
    ACTUALITE_NOT_VALID(1004),


    CATEGORY_NOT_FOUND(2000),

    CATEGORY_NOT_VALID(2001),
    CATEGORY_ALREADY_IN_USE(2002),
    CATEGORY_FOOTBALL_NOT_FOUND(2003),
    CATEGORY_FOOTBALL_NOT_VALID(2004),

    ROLES_NOT_FOUND(3000),
    ROLES_NOT_VALID(3001),
    ROLES_ALREADY_IN_USE(3002),

    COMMANDE_NOT_FOUND(4000),
    COMMANDE_NOT_VALID(4001),
    COMMANDE_NON_MODIFIABLE(4002),
    COMMANDE_ALREADY_IN_USE(4003),

    ARBITRE_NOT_VALID(5000),
    ARBITRE_NOT_FOUND(5001),

    CLUB_NOT_FOUND(6000),
    CLUB_NOT_VALID(6001),

    JOUEUR_NOT_FOUND(7000),
    JOUEUR_NOT_VALID(7001),
    JOUEUR_ALREADY_IN_USE(7002),

    LIGNE_COMMANDE_NOT_FOUND(8000),


    STADE_NOT_FOUND(11000),
    STADE_NOT_VALID(11001),

    SAISON_NOT_FOUND(11002),
    SAISON_NOT_VALID(11003),

    UTILISATEUR_NOT_FOUND(12000),
    UTILISATEUR_NOT_VALID(12001),
    UTILISATEUR_ALREADY_EXISTS(12002),
    UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID(12003),

    BAD_CREDENTIALS(12003),

    EQUIPE_NOT_FOUND(13000),
    EQUIPE_NOT_VALID(13001),
    EQUIPE_ALREADY_IN_USE(13002),

    // Liste des exception techniques
    UPDATE_PHOTO_EXCEPTION(14000),
    UNKNOWN_CONTEXT(14001)
    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
