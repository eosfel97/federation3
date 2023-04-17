package greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actualite")
public class Actualite extends AbstractEntity {

    @Column(name = "titre", nullable = false, length = 150)
    private String titre;

    @Column(name = "information", columnDefinition = "TEXT")
    private String information;

    @Column(name = "photo")
    private String photo;

}