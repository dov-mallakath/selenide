package selenide.pages.webshop;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class HomePage {

    private String privateRoomXpath = ".//a[contains(concat('/',@href,'/'),'/my-account/')]";
    private String loginLinkXpath = ".//a[contains(concat('/',@href,'/'),'/login/')]";

    public SelenideElement getLoginLink() {
        return $(By.xpath(loginLinkXpath));
    }

    public HomePage pressAccounts(){
        $(By.xpath(privateRoomXpath)).click();
        return this;
    }

    public HomePage pressLogin(){
        $(By.xpath(loginLinkXpath)).click();
        return this;
    }

}
