package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import pl.qualityexcites.workshop.stdbp.domain.Category;
import pl.qualityexcites.workshop.stdbp.domain.Product;
import pl.qualityexcites.workshop.stdbp.helpers.Color;
import pl.qualityexcites.workshop.stdbp.pages.CategoryPage;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest extends BaseTest {

    @Test
    public void printedChiffonDressPriceShouldBeReduced() {

        Product printedChiffonDress = new Product();
        printedChiffonDress.setName("Printed Chiffon Dress");
        printedChiffonDress.setPrice(16.4f);
        printedChiffonDress.setFullPrice(20.5f);
        printedChiffonDress.setDiscount(20);
        printedChiffonDress.setAvailableColors(Arrays.asList(Color.GREEN, Color.YELLOW));

        CategoryPage categoryPage = new CategoryPage(getDriver(), getBaseUrl());
        categoryPage.open(Category.DRESSES);
        List<Product> products = categoryPage.getProducts();

        assertThat(products).contains(printedChiffonDress);
    }

    @Test
    public void checkIfAllPromotionsCalculatedCorrectly() {
        CategoryPage categoryPage = new CategoryPage(getDriver(), getBaseUrl());
        categoryPage.open(Category.DRESSES);
        List<Product> products = categoryPage.getProducts();

        products.stream().filter(product -> !isNull(product.getDiscount())).forEach(product -> {
            int discountCalculated = Math.round(100 * (product.getFullPrice() - product.getPrice()) / product.getFullPrice());
            assertThat(product.getDiscount()).isEqualTo(discountCalculated);
        });

    }

}
