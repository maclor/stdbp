package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigation() throws Exception {
        getDriver().findElement(By.cssSelector("a.subcategory-name")).click();
        assertEquals("Printed Dress", getDriver().findElement(By.linkText("Printed Dress")).getText());
        getDriver().findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]")).click();
        assertEquals("T-shirts - My Store", getDriver().getTitle());
        assertTrue(isElementPresent(By.linkText("Faded Short Sleeve T-shirts")));
    }

    @Test
    public void test() {
        getDriver().get(getBaseUrl() + "/index.php");
        getDriver().findElement(By.linkText("Women")).click();
        getDriver().findElement(By.xpath("//img[contains(@src,'http://automationpractice.com/img/c/8-medium_default.jpg')]")).click();
        assertEquals("Dresses - My Store", getDriver().getTitle());
        assertEquals("Casual Dresses".toUpperCase(), getDriver().findElement(By.cssSelector("a.subcategory-name")).getText());
        assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Evening Dresses')])[5]")));
        assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Summer Dresses')])[5]")));
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
