package PageObject;

import locators.LocatorsFormRecoverPassword;
import locators.LocatorsFormSignUp;
import org.openqa.selenium.WebDriver;

public class FormRecoverPasswordPage {
    private WebDriver driver;


    public FormRecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    LocatorsFormRecoverPassword LocatorsFormRecoverPassword= new LocatorsFormRecoverPassword();
    public void clickLogInLink() {
        driver.findElement(LocatorsFormRecoverPassword.logInLink).click();
    }

}
