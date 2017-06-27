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

public class LoginTest {
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
    public void validLoginLogoutTest() {
        driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("maciej.lorenc@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("SubmitLogin")).click();
        assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", driver.findElement(By.cssSelector("p.info-account")).getText());

        driver.findElement(By.linkText("Sign out")).click();
        assertEquals("Login - My Store", driver.getTitle());
        assertTrue(isElementPresent(By.linkText("Sign in")));
    }

    @Test
    public void invalidLoginWrongPasswordTest() {
        driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("maciej.lorenc@gmail.com");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("password1");

        driver.findElement(By.id("SubmitLogin")).click();

        assertEquals("Authentication failed.", driver.findElement(By.cssSelector("ol > li")).getText());
    }

    @Test
    public void invalidLoginWrongLoginTest() {
        driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");

        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("password");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("maciej.lorenc@gmail.coma");

        driver.findElement(By.id("SubmitLogin")).click();

        assertEquals("Authentication failed.", driver.findElement(By.cssSelector("ol > li")).getText());
    }

    @After
    public void tearDown() {
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
