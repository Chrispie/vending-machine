package za.co.chrispie.demo.vending.machine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.chrispie.demo.vending.machine.db.model.PriceInfoEntity;
import za.co.chrispie.demo.vending.machine.db.model.ProductEntity;
import za.co.chrispie.demo.vending.machine.db.model.SaleEntity;
import za.co.chrispie.demo.vending.machine.db.model.StockEntity;
import za.co.chrispie.demo.vending.machine.db.repository.PriceInfoRepository;
import za.co.chrispie.demo.vending.machine.db.repository.ProductRepository;
import za.co.chrispie.demo.vending.machine.db.repository.SaleRepository;
import za.co.chrispie.demo.vending.machine.db.repository.StockRepository;
import za.co.chrispie.demo.vending.machine.facade.StockFacade;
import za.co.chrispie.demo.vending.machine.model.Inventory;
import za.co.chrispie.demo.vending.machine.model.Sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceInfoRepository priceInfoRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/admin")
    public String depositMoney(final Model model) {
        model.addAttribute("inventories", buildInventory());
        model.addAttribute("sales", buildSales());
        return "admin";
    }

    @PostMapping("/increase-inventory")
    public String selectProduct(@RequestParam("productId") final Integer productId, final Model model) {
        stockFacade.increaseStock(productId);
        model.addAttribute("inventories", buildInventory());
        model.addAttribute("sales", buildSales());
        return "admin";
    }

    private List<Inventory> buildInventory() {
        final List<Inventory> inventories = new ArrayList<>();

        final List<ProductEntity> allProducts = productRepository.findAll();
        for (ProductEntity p : allProducts) {
            final Inventory inventory = new Inventory();
            inventory.setProductId(p.getProductId());
            inventory.setDescription(p.getDescription());

            final PriceInfoEntity priceInfo = priceInfoRepository.getByProductIdAndDate(p.getProductId(), new Date());
            inventory.setPrice(priceInfo.getPrice());

            final StockEntity stock = stockRepository.findByProductId(p.getProductId());
            inventory.setQty(stock.getQty());
            inventories.add(inventory);
        }

        return inventories;
    }

    private List<Sales> buildSales() {
        final List<Sales> allSales = new ArrayList<>();

        for (SaleEntity sale : saleRepository.findAll()) {
            final ProductEntity product = productRepository.findByProductId(sale.getProductId());
            allSales.add(new Sales(sale.getSaleId(), sale.getProductId(), product.getDescription(), sale.getEffDate(), sale.getQty(), sale.getPrice(),sale.getTotal()));
        }

        return allSales;
    }


}