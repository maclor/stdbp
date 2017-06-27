package pl.qualityexcites.workshop.stdbp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FilterTest {
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
    public void testFilter() throws Exception {
        driver.get(baseUrl + "/index.php?id_category=8&controller=category");
        assertEquals("There are 5 products.", driver.findElement(By.cssSelector("span.heading-counter")).getText());
        driver.findElement(By.id("layered_id_attribute_group_16")).click();
        assertEquals("There are 3 products.", driver.findElement(By.cssSelector("span.heading-counter > span.heading-counter")).getText());
        assertTrue(isElementPresent(By.id("color_19")));
        assertTrue(isElementPresent(By.id("color_31")));
        assertTrue(isElementPresent(By.id("color_34")));
        driver.findElement(By.cssSelector("i.icon-remove")).click();
        assertEquals("There are 5 products.", driver.findElement(By.cssSelector("span.heading-counter > span.heading-counter")).getText());
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

}
