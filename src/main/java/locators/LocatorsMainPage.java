package locators;
import org.openqa.selenium.By;

public class LocatorsMainPage {
    //кнопка "Войти в аккаунт"
    public By logInAccountBottom = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Соусы"
    public By sauceBottom = By.xpath(".//div/span[text()='Соусы']");
    //кнопка "Начинки"
    public By toppingBottom = By.xpath(".//div/span[text()='Начинки']");
    //локатор заголовка списка соусов
    public By sauceSectionName = By.xpath(".//div/h2[text()='Соусы']");
    //локатор заголовка списка начинок
    public By toppingSectionName = By.xpath(".//div/h2[text()='Начинки']");
    //кнопка "Булки"
    public By bunsBottom = By.xpath(".//div/span[text()='Булки']");
    //локатор заголовка списка соусов
    public By bunsSectionName = By.xpath(".//div/h2[text()='Булки']");
    //локатор заголовка главной страницы
    public By mainPageName = By.xpath(".//section/h1[text()='Соберите бургер']");
}
