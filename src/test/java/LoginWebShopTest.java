import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;
import selenide.pages.webshop.AccountPage;
import selenide.pages.webshop.HomePage;
import selenide.pages.webshop.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class LoginWebShopTest extends WebDriverTestBase {

    private String gboShop = "https://gboshop.com/";

    private String login = "mallakath@gmail.com";
    private String password = "zxcvbnm,./";

    @BeforeClass
    public void setupWebDriver(){
        open(gboShop);
    }

    @Test
    public void aGoToLoginPage(){
        new HomePage()
                .pressAccounts()
                .getLoginLink()
                .shouldBe(Condition.visible);
    }

    @Test
    public void bGoToLoginForm(){
        new HomePage()
                .pressLogin();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("login"));
    }

    @Test
    public void cFillAndLogin(){
        new LoginPage()
                .enterLogin(login)
                .enterPassword(password)
                .submit();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("my-account"));
    }

    @Test
    public void dLogoutCheck(){
        new HomePage()
                .pressAccounts();
        new AccountPage()
                .getLogoutLink().shouldBe(Condition.visible);
    }

    @Test
    public void eLogout(){
        new AccountPage()
                .logout();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("logout"));
    }
}
