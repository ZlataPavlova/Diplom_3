package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;
    //локатор абзаца с текстом про персональные данные
    private By textAboutPersonalCredentials = By.xpath(".//nav[@class='Account_nav__Lgali']/p[text()='В этом разделе вы можете изменить свои персональные данные']");
    //кнопка "Выход"
    private By LogOffBottom = By.xpath(".//li/button[text()='Выход']");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextAboutPersonalCredentials() {
        return driver.findElement(textAboutPersonalCredentials).getText();
    }

    public void waitPersonalAccountPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//nav[@class='Account_nav__Lgali']/p[text()='В этом разделе вы можете изменить свои персональные данные']")));
    }

    public void clickLogOffBottom() {
        driver.findElement(LogOffBottom).click();
    }

}
