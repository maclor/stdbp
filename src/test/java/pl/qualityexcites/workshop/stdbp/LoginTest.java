package pl.qualityexcites.workshop.stdbp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.qualityexcites.workshop.stdbp.pages.LoginPage;
import pl.qualityexcites.workshop.stdbp.pages.MyAccountPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


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
        MyAccountPage myAccountPage = loginPage.login("maciej.lorenc@gmail.com", "password");

        assertThat(myAccountPage.isPageVisible()).isTrue();

        loginPage = myAccountPage.logout();
        assertThat(loginPage.isPageVisible()).isTrue();
    }

    @Test
    public void invalidLoginWrongPasswordTest() {
        loginPage.open();
        List<String> errors = loginPage.tryLogin("maciej.lorenc@gmail.com", "passwordA");

        assertThat(errors).contains("Authentication failed.");
    }

    @Test
    public void invalidLoginWrongLoginTest() {
        loginPage.open();
        List<String> errors = loginPage.tryLogin("maciej.lorenc@gmail.comA", "password");

        assertThat(errors).contains("Authentication failed.");
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
