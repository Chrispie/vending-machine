package za.co.chrispie.demo.vending.machine.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.chrispie.demo.vending.machine.db.model.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByProductId(final Integer productId);

    @Override
    List<ProductEntity> findAll();
}
