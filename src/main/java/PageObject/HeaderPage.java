package PageObject;

import locators.LocatorsHeaderPage;
import locators.LocatorsMainPage;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }

    LocatorsHeaderPage LocatorsHeaderPage = new LocatorsHeaderPage();

    public void clickPersonalAccountBottom() {
        driver.findElement(LocatorsHeaderPage.personalAccountBottom).click();
    }
    public void clickConstructorBottom() {
        driver.findElement(LocatorsHeaderPage.constructorBottom).click();
    }

    public void clickLogoBottom() {
        driver.findElement(LocatorsHeaderPage.logoBottom).click();
    }
}
