package homework.openenglish;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class LoginLogout {

    private String login = "shiosaky@gmail.com";
    private String password = "Test123";

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-btn")
    private WebElement loginButton;


    public LoginLogout login(){
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public void loginLogout(){

    }

}
