package pl.qualityexcites.workshop.stdbp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PriceTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://automationpractice.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testPricereduction() throws Exception {
        driver.get(baseUrl + "/index.php?id_category=8&controller=category");
        assertEquals("Printed Chiffon Dress", driver.findElement(By.linkText("Printed Chiffon Dress")).getText());
        assertEquals("$16.40", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span")).getText());
        assertEquals("$20.50", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span[2]")).getText());
        assertEquals("-20%", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[5]/div/div[2]/div/span[3]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
