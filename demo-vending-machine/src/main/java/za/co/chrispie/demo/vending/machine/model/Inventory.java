package za.co.chrispie.demo.vending.machine.model;

import java.math.BigDecimal;

public class Inventory {

    private int productId;
    private String description;
    private int qty;
    private BigDecimal price;

    public Inventory() {
    }

    public Inventory(final int productId, final String description, final int qty, final BigDecimal price) {
        this.productId = productId;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(final int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
}
