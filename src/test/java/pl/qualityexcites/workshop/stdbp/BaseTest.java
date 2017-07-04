package pl.qualityexcites.workshop.stdbp;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mlo on 04.07.2017.
 */
public abstract class BaseTest {

    private WebDriver driver = new FirefoxDriver();
    private String baseUrl = "http://automationpractice.com/";

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
