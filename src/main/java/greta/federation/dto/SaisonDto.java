package greta.federation.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import greta.federation.entity.Equipe;
import greta.federation.entity.Saison;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class SaisonDto {
    private Integer id;
    private Date annee;
    private int nbBut;
    private int nbEncaisse;
    private String meilleurJoueur;
    private String meilleurButeur;
    private String meilleurPasseur;
    private String meilleurGardien;
    private int nbCartonJaune;
    private int nbCartonRouge;
    @JsonIgnore
    private List<EquipeDto> equipes;
    private CompetitionDto competition;
    public static SaisonDto fromEntity(Saison saison) {
        if (saison == null) {
            return null;
        }
        return SaisonDto.builder()
                .id(saison.getId())
                .annee(saison.getAnnee())
                .nbBut(saison.getNbBut())
                .nbEncaisse(saison.getNbEncaisse())
                .meilleurJoueur(saison.getMeilleurJoueur())
                .meilleurButeur(saison.getMeilleurButeur())
                .meilleurPasseur(saison.getMeilleurPasseur())
                .nbCartonJaune(saison.getNbCartonJaune())
                .nbCartonRouge(saison.getNbCartonRouge())
                .competition(CompetitionDto.fromEntity(saison.getCompetition()))
                .build();
    }

    public static Saison toEntity(SaisonDto saisonDto) {
        if (saisonDto == null) {
            return null;
        }
        Saison saison = new Saison();
        saison.setId(saisonDto.getId());
        saison.setAnnee(saisonDto.getAnnee());
        saison.setNbBut(saisonDto.getNbBut());
        saison.setNbEncaisse(saisonDto.getNbEncaisse());
        saison.setMeilleurJoueur(saisonDto.getMeilleurJoueur());
        saison.setMeilleurButeur(saisonDto.getMeilleurButeur());
        saison.setMeilleurPasseur(saisonDto.getMeilleurPasseur());
        saison.setMeilleurGardien(saisonDto.getMeilleurGardien());
        saison.setNbCartonJaune(saisonDto.getNbCartonJaune());
        saison.setNbCartonRouge(saisonDto.getNbCartonRouge());
        saison.setCompetition(CompetitionDto.toEntity(saisonDto.getCompetition()));
        return saison;
    }


}
