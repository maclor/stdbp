package pl.qualityexcites.workshop.stdbp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by mlo on 03.07.2017.
 */
public class MyAccountPage {
    private final WebDriver driver;
    private final String WELCOME_MESSAGE = "Welcome to your account. Here you can manage all of your personal information and orders.";
    private By welcomeMessageBy = By.cssSelector("p.info-account");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageVisible() {
        try {
            WebElement welcomeMessage = driver.findElement(welcomeMessageBy);
            return welcomeMessage.getText().equals(WELCOME_MESSAGE);
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
