import API.Customer;
import API.CustomerClient;
import API.CustomerCredentials;
import API.CustomerGeneration;
import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.junit.Assert.assertEquals;

public class SignUpTest {
    private WebDriver driver;
    private String accessToken;
    private CustomerClient customerClient;
    private Customer customer;
    private Customer customerWithIncorrectPassword;

    public void createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    public void createSafariDriver() {
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Before
    public void createUser() {
        customer = CustomerGeneration.getDefault();
        customerWithIncorrectPassword = CustomerGeneration.getIncorrectPassword();
        customerClient = new CustomerClient();
    }

    @After
    public void teardown() {
        ValidatableResponse loginResponse = customerClient.logIn(CustomerCredentials.from(customer));
        accessToken = loginResponse.extract().path("accessToken");
        if (accessToken != null) {
            accessToken = loginResponse.extract().path("accessToken").toString().substring(7);
            customerClient.delete(accessToken);
        } else {
            accessToken = "";
        }
        driver.quit();
    }

    @DisplayName("Проверка успешного перехода на форму авторизации через кнопку Войти в аккаунт")
    @Test
    public void checkLogInAccountBottom() {
        createChromeDriver();
        //createSafariDriver();
        MainPage mainPage = new MainPage(driver);
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickLogInAccountBottom();
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка успешного перехода на форму авторизации через кнопку Войти в личный кабинет")
    @Test
    public void checkPersonalAccountBottom() {
        createChromeDriver();
        //createSafariDriver();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка успешной регистрации пользователя через кнопку Войти в аккаунт")
    @Test
    public void checkSuccessfulSignUpInLogInAccountBottom() {
        checkLogInAccountBottom();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormSignUpPage formSignUpPage = new FormSignUpPage(driver);
        formLogInPage.waitForLoadFormLogIn();
        formLogInPage.clickSignUpLink();
        formSignUpPage.setName(customer.getName());
        formSignUpPage.setEmail(customer.getEmail());
        formSignUpPage.setCorrectPassword(customer.getPassword());
        formSignUpPage.clickSignUpButton();
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка успешной регистрации пользователя через кнопку Войти в личный кабинет")
    @Test
    public void checkSuccessfulSignUpInPersonalAccountBottom() {
        checkPersonalAccountBottom();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormSignUpPage formSignUpPage = new FormSignUpPage(driver);
        formLogInPage.waitForLoadFormLogIn();
        formLogInPage.clickSignUpLink();
        formSignUpPage.setName(customer.getName());
        formSignUpPage.setEmail(customer.getEmail());
        formSignUpPage.setCorrectPassword(customer.getPassword());
        formSignUpPage.clickSignUpButton();
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка появления сообщения об ошибке при некорректном вводе пароля")
    @Test
    public void incorrectPasswordErrorAssertion() {
        createChromeDriver();
        //createSafariDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickLogInAccountBottom();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormSignUpPage formSignUpPage = new FormSignUpPage(driver);
        formLogInPage.waitForLoadFormLogIn();
        formLogInPage.clickSignUpLink();
        formSignUpPage.setName(customerWithIncorrectPassword.getName());
        formSignUpPage.setEmail(customerWithIncorrectPassword.getEmail());
        formSignUpPage.setIncorrectPassword(customerWithIncorrectPassword.getPassword());
        formSignUpPage.clickSignUpButton();

        String actualMessage = formSignUpPage.getWrongMessage();

        assertEquals("Некорректный пароль", actualMessage);
    }


}
