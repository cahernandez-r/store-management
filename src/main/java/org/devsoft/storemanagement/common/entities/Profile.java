package org.devsoft.storemanagement.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.devsoft.storemanagement.common.entities.common.EntityPrincipal;

@Getter
@Setter
@Entity
@Table(name = "tbl_profile")
public class Profile extends EntityPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_profile")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

}
