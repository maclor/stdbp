package pl.qualityexcites.workshop.stdbp;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationTest {
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
    public void testNavigation() throws Exception {
        driver.findElement(By.cssSelector("a.subcategory-name")).click();
        assertEquals("Printed Dress", driver.findElement(By.linkText("Printed Dress")).getText());
        driver.findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]")).click();
        assertEquals("T-shirts - My Store", driver.getTitle());
        assertTrue(isElementPresent(By.linkText("Faded Short Sleeve T-shirts")));
    }

    @Test
    public void test(){
        driver.get(baseUrl + "/index.php");
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://automationpractice.com/img/c/8-medium_default.jpg')]")).click();
        assertEquals("Dresses - My Store", driver.getTitle());
        assertEquals("Casual Dresses".toUpperCase(), driver.findElement(By.cssSelector("a.subcategory-name")).getText());
        assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Evening Dresses')])[5]")));
        assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Summer Dresses')])[5]")));
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
