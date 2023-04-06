package greta.federation.dto;

import greta.federation.entity.Image;
import greta.federation.entity.Joueur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoueurDto {
    private Integer id;
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

    public static JoueurDto fromEntity(Joueur joueur) {
        if (joueur == null) {
            return null;
        }
        return JoueurDto.builder()
                .id(joueur.getId())
                .nom(joueur.getNom())
                .prenom(joueur.getPrenom())
                .poids(joueur.getPoids())
                .taille(joueur.getTaille())
                .nbBut(joueur.getNbBut())
                .nbPasseDecisive(joueur.getNbPasseDecisive())
                .nbCartonJaune(joueur.getNbCartonJaune())
                .nbCartonRouge(joueur.getNbCartonRouge())
                .nbButEncaisse(joueur.getNbButEncaisse())
                .poste(PosteDto.fromEntity(joueur.getPoste()))
                .equipe(EquipeDto.fromEntity(joueur.getEquipe()))
                .evenementRencontre(EvenementRencontreDto.fromEntity(joueur.getEvenementRencontre()))
                .build();
    }
    public static Joueur toEntity(JoueurDto joueurDto) {
        if (joueurDto == null) {
            return null;
        }
        Joueur joueur = new Joueur();

                joueur.setId(joueurDto.getId());
                joueur.setNom(joueurDto.getNom());
                joueur.setPrenom(joueurDto.getPrenom());
                joueur.setPoids(joueurDto.getPoids());
                joueur.setTaille(joueurDto.getTaille());
                joueur.setNbBut(joueurDto.getNbBut());
                joueur.setNbPasseDecisive(joueurDto.getNbPasseDecisive());
                joueur.setNbCartonJaune(joueurDto.getNbCartonJaune());
                joueur.setNbCartonRouge(joueurDto.getNbCartonRouge());
                joueur.setNbButEncaisse(joueurDto.getNbButEncaisse());
                joueur.setPoste(PosteDto.toEntity(joueurDto.getPoste()));
                joueur.setEquipe(EquipeDto.toEntity(joueurDto.getEquipe()));
                joueur.setEvenementRencontre(EvenementRencontreDto.toEntity(joueurDto.getEvenementRencontre()));

                         return joueur;
    }

}
