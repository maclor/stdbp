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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTest {
    private WebDriver driver;
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

        assertThat(loginPage.getErrorMessages()).contains("Authentication failed.");
    }

    @Test
    public void invalidLoginWrongLoginTest() {
        loginPage.open();
        loginPage.login("maciej.lorenc@gmail.comA", "password");

        assertThat(loginPage.getErrorMessages()).contains("Authentication failed.");
    }

    @After
    public void tearDown() {
        driver.quit();
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
