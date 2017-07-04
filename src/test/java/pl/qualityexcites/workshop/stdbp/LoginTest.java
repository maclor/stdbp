package pl.qualityexcites.workshop.stdbp;

import org.junit.Test;
import pl.qualityexcites.workshop.stdbp.pages.LoginPage;
import pl.qualityexcites.workshop.stdbp.pages.MyAccountPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends BaseTest {


    @Test
    public void validLoginLogoutTest() {
        LoginPage loginPage = new LoginPage(getDriver(), getBaseUrl());
        loginPage.open();
        MyAccountPage myAccountPage = loginPage.login("maciej.lorenc@gmail.com", "password");

        assertThat(myAccountPage.isPageVisible()).isTrue();

        loginPage = myAccountPage.logout();
        assertThat(loginPage.isPageVisible()).isTrue();
    }

    @Test
    public void invalidLoginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver(), getBaseUrl());
        loginPage.open();
        List<String> errors = loginPage.tryLogin("maciej.lorenc@gmail.com", "passwordA");

        assertThat(errors).contains("Authentication failed.");
    }

    @Test
    public void invalidLoginWrongLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver(), getBaseUrl());
        loginPage.open();
        List<String> errors = loginPage.tryLogin("maciej.lorenc@gmail.comA", "password");

        assertThat(errors).contains("Authentication failed.");
    }
}
