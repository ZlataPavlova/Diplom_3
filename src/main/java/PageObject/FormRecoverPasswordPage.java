package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormRecoverPasswordPage {
    private WebDriver driver;
    //ссылка на форму входа
    private By logInLink = By.xpath("//a[text()='Войти']");

    public FormRecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInLink() {
        driver.findElement(logInLink).click();
    }

}
