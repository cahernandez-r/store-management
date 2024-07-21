package org.devsoft.storemanagement.common.repositories;
import org.devsoft.storemanagement.common.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Page<Product> findAll(Specification<Product> spec, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.code = ?1 and p.typeProduct.code = ?2")
    Product findCodeActive(String code, String type);
}
