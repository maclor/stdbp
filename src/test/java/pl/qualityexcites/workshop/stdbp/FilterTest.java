package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilterTest extends BaseTest {

    @Test
    public void testFilter() throws Exception {
        getDriver().get(getBaseUrl() + "/index.php?id_category=8&controller=category");
        assertEquals("There are 5 products.", getDriver().findElement(By.cssSelector("span.heading-counter")).getText());
        getDriver().findElement(By.id("layered_id_attribute_group_16")).click();
        assertEquals("There are 3 products.", getDriver().findElement(By.cssSelector("span.heading-counter > span.heading-counter")).getText());
        assertTrue(isElementPresent(By.id("color_19")));
        assertTrue(isElementPresent(By.id("color_31")));
        assertTrue(isElementPresent(By.id("color_34")));
        getDriver().findElement(By.cssSelector("i.icon-remove")).click();
        assertEquals("There are 5 products.", getDriver().findElement(By.cssSelector("span.heading-counter > span.heading-counter")).getText());
    }

    private boolean isElementPresent(By by) {
        try {
            getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
