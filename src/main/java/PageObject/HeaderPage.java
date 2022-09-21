package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;
    //ссылка на Личный кабинет
    private By personalAccountBottom = By.xpath(".//a/p[text()='Личный Кабинет']");
    //кнопка Конструктор
    private By constructorBottom = By.xpath(".//a/p[text()='Конструктор']");
    //значок лого
    private By logoBottom = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAccountBottom() {
        driver.findElement(personalAccountBottom).click();
    }

    public void clickConstructorBottom() {
        driver.findElement(constructorBottom).click();
    }

    public void clickLogoBottom() {
        driver.findElement(logoBottom).click();
    }
}
