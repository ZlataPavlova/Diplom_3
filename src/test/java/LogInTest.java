import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import API.CustomerClient;
import API.RestClient;
import API.Customer;
import API.CustomerCredentials;
import API.CustomerGeneration;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.junit.Assert.assertEquals;

public class LogInTest {
    private String accessToken;
    private CustomerClient customerClient;
    private Customer customer;
    private WebDriver driver;

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

    @After
    public void teardown() {
        customerClient.delete(accessToken);
        driver.quit();
    }

    @Before
    public void createUser() {
        customer = CustomerGeneration.getDefault();
        customerClient = new CustomerClient();
        ValidatableResponse response = customerClient.create(customer);
        //логинемся под пользаком чтобы получить его токен
        ValidatableResponse loginResponse = customerClient.logIn(CustomerCredentials.from(customer));
        accessToken = loginResponse.extract().path("accessToken").toString().substring(7);

    }

    @DisplayName("Проверка успешной авторизации через кнопку 'Войти в аккаунт'")
    @Test
    public void checkSuccessfulLogInClickLogInAccountButton() {
        createChromeDriver();
        //createSafariDriver();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogInAccountBottom();
        formLogInPage.waitForLoadFormLogIn();
        successfulLogIn();

    }

    @DisplayName("Проверка успешной авторизации через кнопку 'Войти в личный кабинет'")
    @Test
    public void checkSuccessfulLogInClickPersonalAccountBottom() {
        createChromeDriver();
        //createSafariDriver();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        successfulLogIn();
    }

    @DisplayName("Проверка успешной авторизации через кнопку 'Зарегестрироваться' на форме авторизации")
    @Test
    public void checkSuccessfulLogInClickLogInButtonInFormSignUp() {
       createChromeDriver();
        //createSafariDriver();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormSignUpPage formSignUpPage = new FormSignUpPage(driver);
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        formLogInPage.clickSignUpLink();
        formSignUpPage.clickLogInLink();
        successfulLogIn();
    }

    @DisplayName("Проверка успешной авторизации через кнопку 'Зарегестрироваться' на форме восстановить пароль")
    @Test
    public void checkLogInButtonInFormRecoverPassword() {
        // createSafariDriver();
        createChromeDriver();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormRecoverPasswordPage formRecoverPasswordPage = new FormRecoverPasswordPage(driver);
        formLogInPage.clickRecoverPasswordLink();
        formRecoverPasswordPage.clickLogInLink();
        successfulLogIn();
    }

    public void successfulLogIn() {
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        MainPage mainPage = new MainPage(driver);
        formLogInPage.setEmail(customer.getEmail());
        formLogInPage.setCorrectPassword(customer.getPassword());
        //formLogInPage.scrollToButtonLogIn();
        formLogInPage.clickLogInButton();
        mainPage.waitForLoadMainPage();

        String expectedMainPageName = "Соберите бургер";
        assertEquals(expectedMainPageName, mainPage.getNameMainPage());
    }
}
