package PageObject;

import locators.LocatorsFormSignUp;
import locators.LocatorsPersonalAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    LocatorsPersonalAccount LocatorsPersonalAccount = new LocatorsPersonalAccount();

    public String getTextAboutPersonalCredentials() {
        return driver.findElement(LocatorsPersonalAccount.textAboutPersonalCredentials).getText();
    }

    public void waitPersonalAccountPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//nav[@class='Account_nav__Lgali']/p[text()='В этом разделе вы можете изменить свои персональные данные']")));
    }
    public void clickLogOffBottom() {
        driver.findElement(LocatorsPersonalAccount.LogOffBottom).click();
    }

}
