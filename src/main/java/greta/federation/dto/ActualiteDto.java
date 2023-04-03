package greta.federation.dto;

import java.util.List;

public class ActualiteDto {

    private String titre;


    private String information;


    private List<ImageDto> images;

    //Getters and Setters


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }
}
