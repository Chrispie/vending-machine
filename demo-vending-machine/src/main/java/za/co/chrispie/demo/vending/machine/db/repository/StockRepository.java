package za.co.chrispie.demo.vending.machine.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.chrispie.demo.vending.machine.db.model.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {

    StockEntity findByProductId(final Integer productId);

}