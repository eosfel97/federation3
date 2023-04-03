package greta.federation.dto;

public class JoueurDto {
    private String prenom;
    private String nom;
    private String poids;
    private String taille;
    private int nbBut;
    private int nbPasseDecisive;
    private int nbCartonJaune;
    private int nbCartonRouge;
    private int nbButEncaisse;
    private PosteDto poste;
    private EquipeDto equipe;
    private EvenementRencontreDto evenementRencontre;
    //Getters and Setters

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getNbBut() {
        return nbBut;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public int getNbPasseDecisive() {
        return nbPasseDecisive;
    }

    public void setNbPasseDecisive(int nbPasseDecisive) {
        this.nbPasseDecisive = nbPasseDecisive;
    }

    public int getNbCartonJaune() {
        return nbCartonJaune;
    }

    public void setNbCartonJaune(int nbCartonJaune) {
        this.nbCartonJaune = nbCartonJaune;
    }

    public int getNbCartonRouge() {
        return nbCartonRouge;
    }

    public void setNbCartonRouge(int nbCartonRouge) {
        this.nbCartonRouge = nbCartonRouge;
    }

    public int getNbButEncaisse() {
        return nbButEncaisse;
    }

    public void setNbButEncaisse(int nbButEncaisse) {
        this.nbButEncaisse = nbButEncaisse;
    }

    public PosteDto getPoste() {
        return poste;
    }

    public void setPoste(PosteDto poste) {
        this.poste = poste;
    }

    public EquipeDto getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeDto equipe) {
        this.equipe = equipe;
    }

    public EvenementRencontreDto getEvenementRencontre() {
        return evenementRencontre;
    }

    public void setEvenementRencontre(EvenementRencontreDto evenementRencontre) {
        this.evenementRencontre = evenementRencontre;
    }
}
