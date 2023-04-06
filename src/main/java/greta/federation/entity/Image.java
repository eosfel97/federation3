package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="image")
public class Image extends AbstractEntity{


    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_actualite")
    private Actualite actualite;


}
