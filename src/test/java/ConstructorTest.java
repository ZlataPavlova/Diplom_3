import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    private WebDriver driver;
    public void createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    public void createSafariDriver() {
        driver = new SafariDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }


    @After
    public void teardown() {
        driver.quit();
    }

    @DisplayName("Проверка перехода к разделу 'Соусы'")
    @Test
    public void checkGoToSauce() {
        createChromeDriver();
        //createSafariDriver();
        MainPage mainPage = new MainPage (driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickSauceBottom();

        String expectedNameSection="Соусы";
        assertEquals(expectedNameSection, mainPage.getNameSectionSauce());
    }

    @DisplayName("Проверка перехода к разделу 'Начинки'")
    @Test
    public void checkGoToTopping() {
        createChromeDriver();
        //createSafariDriver();
        MainPage mainPage = new MainPage (driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickToppingBottom();

        String expectedNameSection="Начинки";
        assertEquals(expectedNameSection,  mainPage.getNameSectionTopping());
    }

    @DisplayName("Проверка перехода к разделу 'Булки'")
    @Test
    public void checkGoToBuns() {
        createChromeDriver();
        //createSafariDriver();
        MainPage mainPage = new MainPage (driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickToppingBottom();
        mainPage.clickBunsBottom();

        String expectedNameSection="Булки";
        assertEquals(expectedNameSection,  mainPage.getNameSectionBuns());

    }


}
