package za.co.chrispie.demo.vending.machine.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Domain model to indicate what sales was done.
 */
public class Sales {

    private Integer saleId;
    private Integer productId;
    private String description;
    private Date effDate;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;

    public Sales() {
    }

    public Sales(final Integer saleId, final Integer productId, final String description, final Date effDate, final Integer qty, final BigDecimal price, final BigDecimal total) {
        this.saleId = saleId;
        this.productId = productId;
        this.description = description;
        this.effDate = effDate;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(final Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(final Date effDate) {
        this.effDate = effDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(final Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}