package pl.qualityexcites.workshop.stdbp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mlo on 27.06.2017.
 */
public class LoginPage {

    private final WebDriver driver;
    private final String url;

    private By emailInputBy = By.id("email");
    private By passwordInputBy = By.id("passwd");
    private By submitLoginFormButtonBy = By.id("SubmitLogin");

    public LoginPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.url = baseUrl + "/index.php?controller=authentication&back=my-account";
    }

    public void open() {
        driver.get(url);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputBy);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submitLoginForm() {
        WebElement submitLoginFormButton = driver.findElement(submitLoginFormButtonBy);
        submitLoginFormButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        submitLoginForm();
    }
}
