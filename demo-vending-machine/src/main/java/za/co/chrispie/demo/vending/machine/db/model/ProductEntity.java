package za.co.chrispie.demo.vending.machine.db.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", schema = "PUBLIC", catalog = "TEST")
public class ProductEntity {
    private int productId;
    private String description;
    private int qty;

    @Id
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ProductEntity that = (ProductEntity) o;

        if (productId != that.productId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
