package za.co.chrispie.demo.vending.machine.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import za.co.chrispie.demo.vending.machine.db.model.StockEntity;
import za.co.chrispie.demo.vending.machine.db.repository.StockRepository;

@Controller
public class StockFacade {

    @Autowired
    private StockRepository stockRepository;

    public boolean itemStillAvail(final Integer productId) {
        final StockEntity stock = stockRepository.findByProductId(productId);
        return stock.getQty() > 0;
    }

    public boolean decreaseStock(final Integer productId) {
        final StockEntity stockToUpdate = stockRepository.findByProductId(productId);
        if (stockToUpdate.getQty() > 0) {
            stockToUpdate.setQty(stockToUpdate.getQty() - 1);
            stockRepository.save(stockToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean increaseStock(final Integer productId) {
        final StockEntity stockToUpdate = stockRepository.findByProductId(productId);
        stockToUpdate.setQty(stockToUpdate.getQty() + 1);
        stockRepository.save(stockToUpdate);
        return true;
    }
}
