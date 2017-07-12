import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class LoginTestWebShop {

    private WebDriverWait wait;

    private String gboShop = "https://gboshop.com/";
    private String login = "mallakath@gmail.com";
    private String password = "zxcvbnm,./";

    private String privateRoomXpath = ".//a[contains(concat('/',@href,'/'),'/my-account/')]";
    private String loginLinkXpath = ".//a[contains(concat('/',@href,'/'),'/login/')]";
    private String logoutLinkXpath = ".//a[contains(concat('/',@href,'/'),'/logout/')]";

    @BeforeClass
    public void setupWebDriver(){
        //ChromeDriverManager.getInstance().version("2.29").setup();
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        open(gboShop);
    }

    @Test
    public void aGoToLoginPage(){
        $(By.xpath(privateRoomXpath)).click();
        $(By.xpath(loginLinkXpath)).shouldBe(Condition.visible);
    }

    @Test
    public void bGoToLoginForm(){
        $(By.xpath(loginLinkXpath)).click();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("login"));
    }

    @Test
    public void cFillAndLogin(){
        $(By.id("input-email")).clear();
        $(By.id("input-password")).clear();
        $(By.id("input-email")).val(login);
        $(By.id("input-password")).val(password);
        $(By.xpath(".//input[@type='submit']")).click();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("my-account"));
    }

    @Test
    public void dLogoutCheck(){
        $(By.xpath(privateRoomXpath)).click();
        $(By.xpath(logoutLinkXpath)).shouldBe(Condition.visible);
    }

    @Test
    public void eLogout(){
        $(By.xpath(logoutLinkXpath)).click();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("logout"));
    }
}
