package greta.federation.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_club")
    private int idClub;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "numero_rue")
    private int numeroRue;

    @Column(name = "nom_rue", nullable = false, length = 100)
    private String nomRue;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "code_postal")
    private int codePostal;

    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;

    @Column(name = "nom_etablissement_etat", nullable = false, length = 50)
    private String nomEtablissementEtat;

    @Column(name = "nom_assurance", nullable = false, length = 50)
    private String nomAssurance;

    @Column(name = "rib", nullable = false, length = 50)
    private String rib;

    @Column(name = "attestation_assurance", nullable = false, length = 50)
    private String attestationAssurance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stade", referencedColumnName = "id_stade")
    private Stade stade;
    //constructeurs

    public Club() {
    }

    public Club(int idClub, String nom, int numeroRue, String nomRue, String ville, int codePostal, Date dateCreation, String nomEtablissementEtat, String nomAssurance, String rib, String attestationAssurance, User user, Stade stade) {
        this.idClub = idClub;
        this.nom = nom;
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.dateCreation = dateCreation;
        this.nomEtablissementEtat = nomEtablissementEtat;
        this.nomAssurance = nomAssurance;
        this.rib = rib;
        this.attestationAssurance = attestationAssurance;
        this.user = user;
        this.stade = stade;
    }
        // getters and setters

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNomEtablissementEtat() {
        return nomEtablissementEtat;
    }

    public void setNomEtablissementEtat(String nomEtablissementEtat) {
        this.nomEtablissementEtat = nomEtablissementEtat;
    }

    public String getNomAssurance() {
        return nomAssurance;
    }

    public void setNomAssurance(String nomAssurance) {
        this.nomAssurance = nomAssurance;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getAttestationAssurance() {
        return attestationAssurance;
    }

    public void setAttestationAssurance(String attestationAssurance) {
        this.attestationAssurance = attestationAssurance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }
}