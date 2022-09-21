package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FormSignUpPage {

    private WebDriver driver;
    //локатор поля Имя
    private By nameField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]//input[@name='name']");
    //локатор поля Email
    private By emailField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]//input[@name='name']");
    //локатор поля Пароль
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //кнопка Зарегестрироваться
    private By signUpBottom = By.xpath(".//button[text()='Зарегистрироваться']");
    //сообщение о некорректном пароле
    private By wrongMessage = By.xpath(".//p[text()='Некорректный пароль']");
    //локатор ссылки "Войти"
    private By logInLink = By.xpath("//a[text()='Войти']");

    public FormSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setCorrectPassword(String correctPassword) {
        driver.findElement(passwordField).sendKeys(correctPassword);
    }

    public void setIncorrectPassword(String incorrectPassword) {
        driver.findElement(passwordField).sendKeys(incorrectPassword);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpBottom).click();
    }

    public String getWrongMessage() {
        return driver.findElement(wrongMessage).getText();
    }

    public void waitForFinalPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Auth_login__3hAey")));
    }

    public void clickLogInLink() {
        driver.findElement(logInLink).click();
    }

}
