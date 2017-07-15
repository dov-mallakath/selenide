package selenide.pages.webshop;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class AccountPage {

    private String logoutLinkXpath = ".//a[contains(concat('/',@href,'/'),'/logout/')]";

    public AccountPage logout(){
        $(By.xpath(logoutLinkXpath)).click();
        return this;
    }

    public SelenideElement getLogoutLink() {
        return $(By.xpath(logoutLinkXpath));
    }
}
