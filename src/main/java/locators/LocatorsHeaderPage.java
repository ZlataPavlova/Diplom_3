package locators;

import org.openqa.selenium.By;

public class LocatorsHeaderPage {
    //ссылка на Личный кабинет
    public By personalAccountBottom = By.xpath("/html/body/div[1]/div/header/nav/a");
    //кнопка Конструктор
    public By constructorBottom = By.xpath("/html/body/div[1]/div/header/nav/ul/li[1]/a");
    //значок лого
    public By logoBottom = By.xpath("/html/body/div[1]/div/header/nav/div/a");
}
