package za.co.chrispie.demo.vending.machine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.chrispie.demo.vending.machine.db.model.ProductEntity;
import za.co.chrispie.demo.vending.machine.db.repository.ProductRepository;
import za.co.chrispie.demo.vending.machine.facade.FinanceFacade;
import za.co.chrispie.demo.vending.machine.facade.StockFacade;
import za.co.chrispie.demo.vending.machine.model.UserInteraction;
import za.co.chrispie.demo.vending.machine.util.Messages;

import java.math.BigDecimal;

@Controller
public class VendingController {

    @Autowired
    private UserInteraction userInteraction;

    @Autowired
    private FinanceFacade financeFacade;

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/deposit")
    public String depositMoney(@RequestParam("coinValue") final BigDecimal coinValue, final Model model) {

        if (!financeFacade.isValidCoinType(coinValue)) {
            model.addAttribute("infoMessage", Messages.ERR_MSG_INVALID_COIN_TYPE);
            model.addAttribute("money", userInteraction.getMoneyDeposited());
            refundCoin();
        } else {
            final BigDecimal totalMoneyDeposited = userInteraction.depositMoney(coinValue);
            model.addAttribute("money", totalMoneyDeposited);
        }
        return "index";
    }

    @PostMapping("/refund")
    public String refund(final Model model) {
        reset(model);
        return "index";
    }

    @PostMapping("/select-product")
    public String selectProduct(@RequestParam("productId") final Integer productId, final Model model) {
        BigDecimal moneyDeposited = userInteraction.getMoneyDeposited();


        if (productId <= 0) {
            model.addAttribute("infoMessage", Messages.ERR_MSG_INVALID_PRODUCT);
        } else if (!stockFacade.itemStillAvail(productId)) {
            model.addAttribute("infoMessage", Messages.INFO_MSG_PRODUCT_NOT_AVAILABLE);
        } else {
            if (financeFacade.enoughMoney(productId, moneyDeposited)) {
                financeFacade.buyItem(productId);
                moneyDeposited = userInteraction.getMoneyDeposited();
                model.addAttribute("infoMessage", Messages.INFO_MSG_PRODUCT_DISPENSED);
            } else {
                final ProductEntity product = productRepository.findByProductId(productId);
                final BigDecimal productPrice = financeFacade.obtainCurrentProductPrice(productId);
                model.addAttribute("infoMessage", String.format(Messages.INFO_MSG_INSUFFICIENT_FUNDS, productPrice, product.getDescription()));

            }
        }
        model.addAttribute("money", moneyDeposited);
        return "index";
    }

    public void reset(final Model model) {
        if (userInteraction.getMoneyDeposited().compareTo(BigDecimal.ZERO) > 0) {
            refundCoin();
            userInteraction.reset();
            model.addAttribute("infoMessage", Messages.INFO_MSG_ALL_MONEY_REFUNDED);
            model.addAttribute("money", userInteraction.getMoneyDeposited());
        }
    }

    public void refundCoin() {
        //TODO: implement logic to refund coin - since this is only software in real life this needed to be integrated into some piece of hardware
    }
}
