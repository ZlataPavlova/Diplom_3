package locators;

import org.openqa.selenium.By;

public class LocatorsPersonalAccount {
    //локатор абзаца с текстом про персональные данные
    public By textAboutPersonalCredentials = By.xpath(".//nav[@class='Account_nav__Lgali']/p[text()='В этом разделе вы можете изменить свои персональные данные']");
    //кнопка "Выход"
    public By LogOffBottom = By.xpath(".//li/button[text()='Выход']");
}
