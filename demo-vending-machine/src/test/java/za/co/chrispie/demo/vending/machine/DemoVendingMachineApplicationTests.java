package za.co.chrispie.demo.vending.machine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.chrispie.demo.vending.machine.db.model.StockEntity;
import za.co.chrispie.demo.vending.machine.db.repository.StockRepository;
import za.co.chrispie.demo.vending.machine.facade.StockFacade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoVendingMachineApplicationTests {

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private StockRepository stockRepository;

    @Test
    public void testPersistenceLayer() throws Exception {
        //given that the stock is still avail
        boolean stillAvail = stockFacade.itemStillAvail(1);
        //verify
        StockEntity stock = stockRepository.findByProductId(1);

        assertTrue(stillAvail);
        assertEquals(10, stock.getQty());

        //sell an item
        stockFacade.decreaseStock(1);

        //verify that stock was decreased
        //given that the stock is still avail
        stillAvail = stockFacade.itemStillAvail(1);
        //verify
        stock = stockRepository.findByProductId(1);

        Assert.assertTrue(stillAvail);
        Assert.assertEquals(9, stock.getQty());
    }

}
