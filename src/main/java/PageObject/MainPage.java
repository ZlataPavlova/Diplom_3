package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private By logInAccountBottom = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Соусы"
    private By sauceBottom = By.xpath(".//div/span[text()='Соусы']");
    //кнопка "Начинки"
    private By toppingBottom = By.xpath(".//div/span[text()='Начинки']");
    //локатор заголовка списка соусов
    private By sauceSectionName = By.xpath(".//div/h2[text()='Соусы']");
    //локатор заголовка списка начинок
    private By toppingSectionName = By.xpath(".//div/h2[text()='Начинки']");
    //кнопка "Булки"
    private By bunsBottom = By.xpath(".//div/span[text()='Булки']");
    //локатор заголовка списка соусов
    private By bunsSectionName = By.xpath(".//div/h2[text()='Булки']");
    //локатор заголовка главной страницы
    private By mainPageName = By.xpath(".//section/h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//section/h1[text()='Соберите бургер']")));
    }

    public void clickLogInAccountBottom() {
        driver.findElement(logInAccountBottom).click();
    }

    public void clickSauceBottom() {
        driver.findElement(sauceBottom).click();
    }

    public String getNameSectionSauce() {
        return driver.findElement(sauceSectionName).getText();
    }

    public void clickToppingBottom() {
        driver.findElement(toppingBottom).click();
    }

    public String getNameSectionTopping() {
        return driver.findElement(toppingSectionName).getText();
    }

    public void clickBunsBottom() {
        driver.findElement(bunsBottom).click();
    }

    public String getNameSectionBuns() {
        return driver.findElement(bunsSectionName).getText();
    }

    public String getNameMainPage() {
        return driver.findElement(mainPageName).getText();
    }

}
