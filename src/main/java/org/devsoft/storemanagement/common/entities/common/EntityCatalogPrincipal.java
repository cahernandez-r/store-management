package org.devsoft.storemanagement.common.entities.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntityCatalogPrincipal extends EntityPrincipal {

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;
}
