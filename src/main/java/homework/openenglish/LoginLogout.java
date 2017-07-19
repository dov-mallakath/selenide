package homework.openenglish;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class LoginLogout {

    private String login = "shiosaky@gmail.com";
    private String password = "Test123";

    private SelenideElement usernameInput = $(By.id("username"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("login-btn"));


    public LoginLogout login(){
        usernameInput.val(login);
        passwordInput.val(password);
        loginButton.click();
        return this;
    }

    public void loginLogout(){
        login();

    }

}
