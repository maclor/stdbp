package pl.qualityexcites.workshop.stdbp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.qualityexcites.workshop.stdbp.domain.Category;
import pl.qualityexcites.workshop.stdbp.domain.Product;
import pl.qualityexcites.workshop.stdbp.domain.helper.ProductBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlo on 05.07.2017.
 */
public class CategoryPage {
    private final WebDriver driver;
    private String url;
    private By productTileBy = By.cssSelector(".product_list li.ajax_block_product");

    public List<WebElement> getProductTileElements() {
        return driver.findElements(productTileBy);
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        List<WebElement> productTileElements = getProductTileElements();
        for (WebElement productElement : productTileElements) {
            Product product = ProductBuilder.buildProductFromHtml(productElement);
            products.add(product);
        }
        return products;
    }

    public CategoryPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.url = baseUrl + "/index.php?id_category=%d&controller=category";
    }

    public void open(Category category) {
        driver.get(String.format(url, category.getCategoryNumber()));
    }
}