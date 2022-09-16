package locators;
import org.openqa.selenium.By;

public class LocatorsFormSignUp {
    //локатор поля Имя
    public By nameField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]//input[@name='name']");
    //локатор поля Email
    public By emailField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]//input[@name='name']");
            //By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/label[text()='Email']");
    //локатор поля Пароль
    public By passwordField = By.xpath(".//input[@name='Пароль']");
    //кнопка Зарегестрироваться
    public By signUpBottom = By.xpath(".//button[text()='Зарегистрироваться']");

    //сообщение о некорректном пароле
    public By wrongMessage = By.xpath(".//p[text()='Некорректный пароль']");
    //локатор ссылки "Войти"
    public By logInLink = By.xpath("/html/body/div[1]/div/main/div/div/p/a");


}
