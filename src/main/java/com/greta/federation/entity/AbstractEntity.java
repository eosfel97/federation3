package com.greta.federation.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class  AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

}
