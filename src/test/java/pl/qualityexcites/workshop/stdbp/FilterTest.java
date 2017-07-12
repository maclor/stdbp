package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import pl.qualityexcites.workshop.stdbp.domain.Category;
import pl.qualityexcites.workshop.stdbp.domain.Product;
import pl.qualityexcites.workshop.stdbp.helpers.Color;
import pl.qualityexcites.workshop.stdbp.pages.CategoryPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends BaseTest {

    @Test
    public void testFilterProductsByColor() throws Exception {
        CategoryPage categoryPage = new CategoryPage(getDriver(), getBaseUrl());
        categoryPage.open(Category.DRESSES);

        List<Product> productsBeforeFiltering = categoryPage.getProducts();

        categoryPage.getFilterBox().filterByColor(Color.YELLOW);

        List<Product> productsAfterFiltering = categoryPage.getProducts();

        assertThat(productsAfterFiltering.size()).isLessThanOrEqualTo(productsBeforeFiltering.size());
        for (Product product : productsAfterFiltering) {
            assertThat(product.getAvailableColors()).contains(Color.YELLOW);
        }

    }
}
