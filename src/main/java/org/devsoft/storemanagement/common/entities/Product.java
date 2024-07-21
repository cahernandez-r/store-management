package org.devsoft.storemanagement.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.devsoft.storemanagement.common.entities.common.EntityPrincipal;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tbl_product")
public class Product extends EntityPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_product")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "entry_price")
    private BigDecimal entryPrice;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_type_product")
    private TypeProduct typeProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_category")
    private Category category;

}
