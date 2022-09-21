import API.Customer;
import API.CustomerClient;
import API.CustomerCredentials;
import API.CustomerGeneration;
import PageObject.FormLogInPage;
import PageObject.FormSignUpPage;
import PageObject.HeaderPage;
import PageObject.MainPage;
import PageObject.PersonalAccountPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest {
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

    @DisplayName("Проверка успешного перехода в личный кабинет неавторизованного пользователя")
    @Test
    public void checkSuccessfulGoToPersonalAccountWithoutAuthorization() {
        createChromeDriver();
        //createSafariDriver();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка успешного перехода в личный кабинет авторизованного пользователя")
    @Test
    public void checkSuccessfulGoToPersonalAccountWithAuthorization() {
        checkSuccessfulGoToPersonalAccountWithoutAuthorization();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        FormSignUpPage formSignUpPage = new FormSignUpPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        formLogInPage.setEmail(customer.getEmail());
        formLogInPage.setCorrectPassword(customer.getPassword());
        formLogInPage.clickLogInButton();
        mainPage.waitForLoadMainPage();
        headerPage.clickPersonalAccountBottom();
        personalAccountPage.waitPersonalAccountPage();
        String expectedText = "В этом разделе вы можете изменить свои персональные данные";
        assertEquals(expectedText, personalAccountPage.getTextAboutPersonalCredentials());

    }

    @DisplayName("Проверка успешного выхода из личного кабинета авторизованного пользователя")
    @Test
    public void checkSuccessfulLogOffPersonalAccount() {
        checkSuccessfulGoToPersonalAccountWithAuthorization();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogOffBottom();
        FormLogInPage formLogInPage = new FormLogInPage(driver);
        formLogInPage.waitForLoadFormLogIn();
    }

    @DisplayName("Проверка успешного перехода при клике на кнопку 'Конструктор'")
    @Test
    public void checkSuccessfulGoToConstructorClickConstructorButton() {
        checkSuccessfulGoToPersonalAccountWithoutAuthorization();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        headerPage.clickConstructorBottom();
        String expectedMainPageName = "Соберите бургер";
        assertEquals(expectedMainPageName, mainPage.getNameMainPage());
    }

    @DisplayName("Проверка успешного перехода при клике на логотип")
    @Test
    public void checkSuccessfulGoToConstructorClickLogo() {
        checkSuccessfulGoToPersonalAccountWithoutAuthorization();
        HeaderPage headerPage = new HeaderPage(driver);
        MainPage mainPage = new MainPage(driver);
        headerPage.clickLogoBottom();
        String expectedMainPageName = "Соберите бургер";
        assertEquals(expectedMainPageName, mainPage.getNameMainPage());
    }

}
