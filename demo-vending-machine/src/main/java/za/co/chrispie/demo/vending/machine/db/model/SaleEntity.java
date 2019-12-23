package za.co.chrispie.demo.vending.machine.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "SALE", schema = "PUBLIC", catalog = "TEST")
public class SaleEntity {
    private Integer saleId;
    private Integer productId;
    private Date effDate;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;

    public SaleEntity() {
    }

    public SaleEntity(final Integer productId, final BigDecimal price) {
        this.productId = productId;
        this.price = price;
        this.qty = 1;
        this.setEffDate(new Date(new java.util.Date().getTime()));
        this.total = this.price.multiply(new BigDecimal(this.qty));
    }

    @Id
    @Column(name = "SALE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(final Integer saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "EFF_DATE")
    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(final Date effDate) {
        this.effDate = effDate;
    }

    @Basic
    @Column(name = "QTY")
    public Integer getQty() {
        return qty;
    }

    public void setQty(final Integer qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "TOTAL")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(final BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SaleEntity that = (SaleEntity) o;

        if (saleId != that.saleId) return false;
        if (productId != that.productId) return false;
        if (qty != that.qty) return false;
        if (effDate != null ? !effDate.equals(that.effDate) : that.effDate != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = saleId;
        result = 31 * result + productId;
        result = 31 * result + (effDate != null ? effDate.hashCode() : 0);
        result = 31 * result + qty;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
