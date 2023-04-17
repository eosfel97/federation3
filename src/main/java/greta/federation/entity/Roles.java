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
@Table(name="roles")
public class Roles extends AbstractEntity {



    @Column(name="nom")
    private String nom;


    @OneToMany (mappedBy ="role",cascade=CascadeType.ALL)
    private List<User> users;


}