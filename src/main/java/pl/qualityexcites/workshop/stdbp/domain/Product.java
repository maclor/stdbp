package pl.qualityexcites.workshop.stdbp.domain;

import pl.qualityexcites.workshop.stdbp.helpers.Color;

import java.util.List;

/**
 * Created by mlo on 05.07.2017.
 */
public class Product {
    private String name;
    private Float price;
    private Float fullPrice;
    private Integer discount;
    private List<Color> availableColors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<Color> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(List<Color> availableColors) {
        this.availableColors = availableColors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (fullPrice != null ? !fullPrice.equals(product.fullPrice) : product.fullPrice != null) return false;
        if (discount != null ? !discount.equals(product.discount) : product.discount != null) return false;
        return !(availableColors != null ? !availableColors.equals(product.availableColors) : product.availableColors != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (fullPrice != null ? fullPrice.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (availableColors != null ? availableColors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", fullPrice=" + fullPrice +
                ", discount=" + discount +
                ", availableColors=" + availableColors +
                '}';
    }
}
