package selenide.pages.webshop;

import com.codeborne.selenide.SelenideElement;
import com.gargoylesoftware.htmlunit.html.ScriptElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class LoginPage {

    private SelenideElement inputEmail = $(By.id("input-email"));
    private SelenideElement inputPassword = $(By.id("input-password"));
    private SelenideElement submit = $(By.xpath(".//input[@type='submit']"));

    public LoginPage enterLogin(String login){
        inputEmail.clear();
        inputEmail.val(login);
        return this;
    }

    public LoginPage enterPassword(String password){
        inputPassword.clear();
        inputPassword.val(password);
        return this;
    }

    public LoginPage submit(){
        submit.click();
        return this;
    }

}
