package selenide.pages.webshop;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class HomePage {

    private SelenideElement privateRoom = $(By.xpath(".//a[contains(concat('/',@href,'/'),'/my-account/')]"));
    private SelenideElement loginLink = $(By.xpath(".//a[contains(concat('/',@href,'/'),'/login/')]"));

    public SelenideElement getLoginLink() {
        return loginLink;
    }

    public HomePage pressAccounts(){
        privateRoom.click();
        return this;
    }

    public HomePage pressLogin(){
        loginLink.click();
        return this;
    }

}
