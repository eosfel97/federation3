package greta.federation.dto;



import java.util.List;

public class TypeCompetitionDto {
    private String nom;
    private List<CompetitionDto> competitions;
    //Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<CompetitionDto> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<CompetitionDto> competitions) {
        this.competitions = competitions;
    }
}
