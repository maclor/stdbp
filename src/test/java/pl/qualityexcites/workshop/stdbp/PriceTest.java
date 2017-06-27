package pl.qualityexcites.workshop.stdbp;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PriceTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
