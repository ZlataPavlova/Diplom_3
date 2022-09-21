package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormLogInPage {

    private WebDriver driver;
    //ссылка на форму регистрации
    private By signUpLink = By.className("Auth_link__1fOlj");
    // локатор ссылки Восстановить пароль
    private By recoverPasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    //локатор поля Password
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //локатор поля Email
    private By emailField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]//input[@name='name']");
    //локатор кнопки Войти
    private By logInButton = By.xpath(".//button[text()='Войти']");

    public FormLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadFormLogIn() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/h2[text()='Вход']")));
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public void clickRecoverPasswordLink() {
        driver.findElement(recoverPasswordLink).click();
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void setCorrectPassword(String correctPassword) {
        driver.findElement(passwordField).sendKeys(correctPassword);
    }


    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }

    public void scrollToButtonLogIn() {

        WebElement element = driver.findElement(logInButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}
