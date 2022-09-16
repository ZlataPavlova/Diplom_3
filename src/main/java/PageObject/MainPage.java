package PageObject;
import locators.LocatorsFormLogIn;
import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    LocatorsMainPage LocatorsMainPage = new LocatorsMainPage();

    public void waitForLoadMainPage(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//section/h1[text()='Соберите бургер']")));
    }

    public void clickLogInAccountBottom() {
        driver.findElement(LocatorsMainPage.logInAccountBottom).click();
    }

    public void clickSauceBottom() {
        driver.findElement(LocatorsMainPage.sauceBottom).click();
    }
    public String getNameSectionSauce() {
        return driver.findElement(LocatorsMainPage.sauceSectionName).getText();
    }

    public void clickToppingBottom() {
        driver.findElement(LocatorsMainPage.toppingBottom).click();
    }

    public String getNameSectionTopping() {
        return driver.findElement(LocatorsMainPage.toppingSectionName).getText();
    }
    public void clickBunsBottom() {
        driver.findElement(LocatorsMainPage.bunsBottom).click();
    }
    public String getNameSectionBuns() {
        return driver.findElement(LocatorsMainPage.bunsSectionName).getText();
    }
    public String getNameMainPage() {
        return driver.findElement(LocatorsMainPage.mainPageName).getText();
    }

}
