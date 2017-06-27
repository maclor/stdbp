package pl.qualityexcites.workshop.stdbp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.qualityexcites.workshop.stdbp.pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LoginTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        String baseUrl = "http://automationpractice.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver, baseUrl);
    }

    @Test
    public void validLoginLogoutTest() {
        loginPage.open();
        loginPage.login("maciej.lorenc@gmail.com", "password");

        assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", driver.findElement(By.cssSelector("p.info-account")).getText());

        driver.findElement(By.linkText("Sign out")).click();
        assertEquals("Login - My Store", driver.getTitle());
        assertTrue(isElementPresent(By.linkText("Sign in")));
    }

    @Test
    public void invalidLoginWrongPasswordTest() {
        loginPage.open();
        loginPage.login("maciej.lorenc@gmail.com", "passwordA");

        assertEquals("Authentication failed.", driver.findElement(By.cssSelector("ol > li")).getText());
    }

    @Test
    public void invalidLoginWrongLoginTest() {
        loginPage.open();
        loginPage.login("maciej.lorenc@gmail.comA", "password");

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
