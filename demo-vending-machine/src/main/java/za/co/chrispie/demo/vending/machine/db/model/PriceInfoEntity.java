package za.co.chrispie.demo.vending.machine.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "PRICE_INFO", schema = "PUBLIC", catalog = "TEST")
public class PriceInfoEntity {
    private int priceInfoId;
    private int productId;
    private Date effFrom;
    private Date effTo;
    private BigDecimal price;

    @Id
    @Column(name = "PRICE_INFO_ID")
    public int getPriceInfoId() {
        return priceInfoId;
    }

    public void setPriceInfoId(final int priceInfoId) {
        this.priceInfoId = priceInfoId;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "EFF_FROM")
    public Date getEffFrom() {
        return effFrom;
    }

    public void setEffFrom(final Date effFrom) {
        this.effFrom = effFrom;
    }

    @Basic
    @Column(name = "EFF_TO")
    public Date getEffTo() {
        return effTo;
    }

    public void setEffTo(final Date effTo) {
        this.effTo = effTo;
    }

    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final PriceInfoEntity that = (PriceInfoEntity) o;

        if (priceInfoId != that.priceInfoId) return false;
        if (productId != that.productId) return false;
        if (effFrom != null ? !effFrom.equals(that.effFrom) : that.effFrom != null) return false;
        if (effTo != null ? !effTo.equals(that.effTo) : that.effTo != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = priceInfoId;
        result = 31 * result + productId;
        result = 31 * result + (effFrom != null ? effFrom.hashCode() : 0);
        result = 31 * result + (effTo != null ? effTo.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
