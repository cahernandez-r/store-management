package org.devsoft.storemanagement.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.devsoft.storemanagement.common.entities.common.EntityCatalogPrincipal;

@Getter
@Setter
@Entity
@Table(name = "catn_type_product")
public class TypeProduct extends EntityCatalogPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_type_product")
    private Long id;
}
