package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FilterTest {
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
