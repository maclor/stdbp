package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import pl.qualityexcites.workshop.stdbp.domain.Category;
import pl.qualityexcites.workshop.stdbp.domain.Product;
import pl.qualityexcites.workshop.stdbp.pages.CategoryPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest extends BaseTest {

    @Test
    public void printedChiffonDressPriceShouldBeReduced() {

        Product printedChiffonDress = new Product();
        printedChiffonDress.setName("Printed Chiffon Dress");
        printedChiffonDress.setPrice(16.4f);
        printedChiffonDress.setFullPrice(20.5f);
        printedChiffonDress.setDiscount(20);

        CategoryPage categoryPage = new CategoryPage(getDriver(), getBaseUrl());
        categoryPage.open(Category.DRESSES);
        List<Product> products = categoryPage.getProducts();

        assertThat(products).contains(printedChiffonDress);
    }

}
