package greta.federation.entity;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actualite")
public class Actualite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actualite")
    private Integer idActualite;

    @Column(name = "titre", nullable = false, length = 150)
    private String titre;

    @Column(name = "information", columnDefinition = "TEXT")
    private String information;

    @OneToMany(mappedBy="actualite", cascade=CascadeType.ALL)
    private List<Image> images;

    // constructeurs

    public Actualite() {
        super();
    }

    public Actualite(Integer idActualite, String titre, String information, List<Image> images) {
        this.idActualite = idActualite;
        this.titre = titre;
        this.information = information;
        this.images = images;
    }

// getters et setters

    public Integer getIdActualite() {
        return idActualite;
    }

    public void setIdActualite(Integer idActualite) {
        this.idActualite = idActualite;
    }

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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}