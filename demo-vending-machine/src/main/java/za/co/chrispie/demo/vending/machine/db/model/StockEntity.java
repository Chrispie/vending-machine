package za.co.chrispie.demo.vending.machine.db.model;

import javax.persistence.*;

@Entity
@Table(name = "STOCK", schema = "PUBLIC", catalog = "TEST")
public class StockEntity {
    private int productId;
    private int qty;

    @Id
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "QTY")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (productId != that.productId) return false;
        if (qty != that.qty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + qty;
        return result;
    }
}
