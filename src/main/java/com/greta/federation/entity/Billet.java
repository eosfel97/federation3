package com.greta.federation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Billet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billet extends AbstractEntity {

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "date_achat", nullable = false)
    private LocalDateTime dateAchat;

    @ManyToOne
    @JoinColumn(name = "id_rencontre")
    private Rencontre rencontre;

    @OneToOne
    @JoinColumn(name = "Id_Place", unique = true)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
