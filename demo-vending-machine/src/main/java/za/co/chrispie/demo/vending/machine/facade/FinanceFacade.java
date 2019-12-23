package za.co.chrispie.demo.vending.machine.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import za.co.chrispie.demo.vending.machine.db.model.PriceInfoEntity;
import za.co.chrispie.demo.vending.machine.db.model.SaleEntity;
import za.co.chrispie.demo.vending.machine.db.repository.PriceInfoRepository;
import za.co.chrispie.demo.vending.machine.db.repository.SaleRepository;
import za.co.chrispie.demo.vending.machine.model.UserInteraction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class FinanceFacade {

    private static final BigDecimal FIFTY_CENT_COIN = new BigDecimal(0.5);
    private static final BigDecimal ONE_EURO_COIN = BigDecimal.ONE;

    @Autowired
    private UserInteraction userInteraction;

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private PriceInfoRepository priceInfoRepository;

    @Autowired
    private SaleRepository saleRepository;

    public boolean isValidCoinType(final BigDecimal coinValue) {
        return (FIFTY_CENT_COIN.equals(coinValue) || ONE_EURO_COIN.equals(coinValue) );
    }

    public BigDecimal obtainCurrentProductPrice(final Integer productId) {
        final PriceInfoEntity currentPrice = priceInfoRepository.getByProductIdAndDate(productId, new Date());
        return currentPrice.getPrice();
    }

    public Boolean enoughMoney(final Integer productId, final BigDecimal money) {
        return (obtainCurrentProductPrice(productId).compareTo(money) <= 0);
    }

    public Boolean buyItem(final Integer productId) {
        final BigDecimal productPrice = obtainCurrentProductPrice(productId);
        userInteraction.deductPurchaseAmount(productPrice);
        stockFacade.decreaseStock(productId);

        final SaleEntity sale = new SaleEntity(productId, productPrice);
        saleRepository.save(sale);
        saleRepository.flush();
        return true;
    }
}
