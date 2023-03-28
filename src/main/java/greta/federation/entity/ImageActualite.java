package greta.federation.entity;



import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name = "image_actualite")
public class ImageActualite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image_actualite")
    private Integer idImageActualite;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actualite", nullable = false)
    private Actualite actualite;

    // constructeurs

    public ImageActualite() {
        super();
    }
    public ImageActualite(Integer idImageActualite, String nom, String description, Actualite actualite) {
        this.idImageActualite = idImageActualite;
        this.nom = nom;
        this.description = description;
        this.actualite = actualite;
    }


    // getters et setters

    public Integer getIdImageActualite() {
        return idImageActualite;
    }

    public void setIdImageActualite(Integer idImageActualite) {
        this.idImageActualite = idImageActualite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Actualite getActualite() {
        return actualite;
    }

    public void setActualite(Actualite actualite) {
        this.actualite = actualite;
    }
}