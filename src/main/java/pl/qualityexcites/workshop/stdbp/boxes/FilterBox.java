package pl.qualityexcites.workshop.stdbp.boxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.qualityexcites.workshop.stdbp.helpers.Color;

/**
 * Created by mlo on 09.07.2017.
 */
public class FilterBox {
    private WebDriver driver;

    private final By filtersBox = By.id("layered_block_left");
    private final String colorFilterPattern = ".//*[contains(@class,'color-option') and contains(@style,'%s')]/parent::li";

    public FilterBox(WebDriver driver) {
        this.driver = driver;
    }

    public void filterByColor(Color color) {
        // TODO
        // Not every click causes filtering
        driver.findElement(filtersBox).findElement(By.xpath(String.format(colorFilterPattern, color.getHex()))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
