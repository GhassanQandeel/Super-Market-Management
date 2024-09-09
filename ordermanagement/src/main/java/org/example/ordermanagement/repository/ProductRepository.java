package org.example.ordermanagement.repository;

import org.example.ordermanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """

SELECT p.id
FROM order_sc.product INNER JOIN order_sc.price p on p.id = product.price_id
WHERE product.id=:id;

""",nativeQuery = true)
    public Long getProductPrice(Long id);

}
