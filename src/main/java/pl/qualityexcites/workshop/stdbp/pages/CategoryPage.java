package pl.qualityexcites.workshop.stdbp.pages;

import org.openqa.selenium.WebDriver;
import pl.qualityexcites.workshop.stdbp.domain.Category;

/**
 * Created by mlo on 05.07.2017.
 */
public class CategoryPage {
    private final WebDriver driver;
    private String url;

    public CategoryPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.url = baseUrl + "/index.php?id_category=%d&controller=category";
    }

    public void open(Category category) {
        driver.get(String.format(url, category.getCategoryNumber()));
    }
}
