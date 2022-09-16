package PageObject;
import locators.LocatorsFormSignUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FormSignUpPage {

    private WebDriver driver;


    public FormSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    LocatorsFormSignUp LocatorsFormSignUp = new LocatorsFormSignUp();

    //public void waitForLoadFormSignUp(){
    //     new WebDriverWait(driver, 3)
    //         .until(ExpectedConditions.visibilityOfElementLocated(By.className("App_componentContainer__2JC2W")));
    //}



    public void setName(String name) {
       driver.findElement(LocatorsFormSignUp.nameField).sendKeys(name);
   }

   public void setEmail(String email) {
        driver.findElement(LocatorsFormSignUp.emailField).sendKeys(email);
    }


   public void setCorrectPassword(String correctPassword) {
        driver.findElement(LocatorsFormSignUp.passwordField).sendKeys(correctPassword);
    }
    public void setIncorrectPassword(String incorrectPassword) {
       driver.findElement(LocatorsFormSignUp.passwordField).sendKeys(incorrectPassword);
    }

   public void clickSignUpButton() {
        driver.findElement(LocatorsFormSignUp.signUpBottom).click();
    }

    public String getWrongMessage() {
       return driver.findElement(LocatorsFormSignUp.wrongMessage).getText();
    }

    public void waitForFinalPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Auth_login__3hAey")));
    }
    public void clickLogInLink() {
        driver.findElement(LocatorsFormSignUp.logInLink).click();
    }

}
