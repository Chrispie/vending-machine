package za.co.chrispie.demo.vending.machine.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.chrispie.demo.vending.machine.db.model.PriceInfoEntity;
import za.co.chrispie.demo.vending.machine.db.model.ProductEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceInfoRepository extends JpaRepository<PriceInfoEntity, Integer> {

    @Query("SELECT p FROM PriceInfoEntity p WHERE p.productId = :productId AND :effDate BETWEEN p.effFrom AND p.effTo")
    PriceInfoEntity getByProductIdAndDate(@Param("productId") final Integer productId, @Param("effDate") final Date effDate);
}
