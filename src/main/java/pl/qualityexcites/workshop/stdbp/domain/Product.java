package pl.qualityexcites.workshop.stdbp.domain;

/**
 * Created by mlo on 05.07.2017.
 */
public class Product {
    private String name;
    private float price;
    private float fullPrice;
    private int discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Float.compare(product.price, price) != 0) return false;
        if (Float.compare(product.fullPrice, fullPrice) != 0) return false;
        if (discount != product.discount) return false;
        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (fullPrice != +0.0f ? Float.floatToIntBits(fullPrice) : 0);
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", fullPrice=" + fullPrice +
                ", discount=" + discount +
                '}';
    }
}
