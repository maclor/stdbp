package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class PriceTest extends BaseTest {

    @Test
    public void testPriceReduction() throws Exception {
        getDriver().get(getBaseUrl() + "/index.php?id_category=8&controller=category");
        assertEquals("Printed Chiffon Dress", getDriver().findElement(By.linkText("Printed Chiffon Dress")).getText());
        assertEquals("$16.40", getDriver().findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span")).getText());
        assertEquals("$20.50", getDriver().findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span[2]")).getText());
        assertEquals("-20%", getDriver().findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span[3]")).getText());
    }

}
