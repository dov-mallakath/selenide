package selenide.pages.webshop;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class LoginPage {

    private String intputEmailId = "input-email";
    private String inputPasswordId = "input-password";
    private String submitXpath = ".//input[@type='submit']";

    public LoginPage enterLogin(String login){
        $(By.id(intputEmailId)).clear();
        $(By.id(intputEmailId)).val(login);
        return this;
    }

    public LoginPage enterPassword(String password){
        $(By.id(inputPasswordId)).clear();
        $(By.id(inputPasswordId)).val(password);
        return this;
    }

    public LoginPage submit(){
        $(By.xpath(submitXpath)).click();
        return this;
    }

}
