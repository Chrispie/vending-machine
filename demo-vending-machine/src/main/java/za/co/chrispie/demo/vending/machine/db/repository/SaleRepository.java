package za.co.chrispie.demo.vending.machine.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.chrispie.demo.vending.machine.db.model.SaleEntity;
import za.co.chrispie.demo.vending.machine.db.model.StockEntity;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {

    @Override
    List<SaleEntity> findAll();
}