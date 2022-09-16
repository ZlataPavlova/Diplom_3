package locators;
import org.openqa.selenium.By;

public class LocatorsFormLogIn {
    //ссылка на форму регистрации
    public By signUpLink = By.className("Auth_link__1fOlj");
    // локатор ссылки Восстановить пароль
    public By recoverPasswordLink = By.xpath("/html/body/div[1]/div/main/div/div/p[2]/a");
    //локатор поля Password
    public By passwordField = By.xpath(".//input[@name='Пароль']");
    //локатор поля Email
    public By emailField = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    //локатор кнопки Войти
    public By logInButton = By.xpath(".//button[text()='Войти']");

}
