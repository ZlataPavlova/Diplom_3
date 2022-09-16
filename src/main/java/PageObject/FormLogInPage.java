package PageObject;
import locators.LocatorsFormLogIn;
import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormLogInPage {

    private WebDriver driver;
    TestUsersGeneration testUsersGeneration = new TestUsersGeneration();

    public FormLogInPage(WebDriver driver){
        this.driver = driver;
    }

    LocatorsFormLogIn LocatorsFormLogIn = new LocatorsFormLogIn();
    public void waitForLoadFormLogIn(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/h2[text()='Вход']")));
    }

    public void clickSignUpLink() {
        driver.findElement(LocatorsFormLogIn.signUpLink).click();
    }

    public void clickRecoverPasswordLink() {
        driver.findElement(LocatorsFormLogIn.recoverPasswordLink).click();
    }
    public void setEmail(String email) {
        driver.findElement(LocatorsFormLogIn.emailField).sendKeys(email);
    }


    public void setCorrectPassword(String correctPassword) {
        driver.findElement(LocatorsFormLogIn.passwordField).sendKeys(correctPassword);
    }


    public void clickLogInButton() {
        driver.findElement(LocatorsFormLogIn.logInButton).click();
    }

    public void scrollToButtonLogIn() {

        WebElement element = driver.findElement(LocatorsFormLogIn.logInButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}
