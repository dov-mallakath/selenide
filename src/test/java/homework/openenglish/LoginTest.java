package homework.openenglish;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class LoginTest extends WebDriverTestBase {

    private String siteURL = "https://learningplatform.stg.openenglish.com";
    private String login = "shiosaky@gmail.com";
    private String incorrectLogin = "test@test.com";
    private String password = "Test123";
    private String incorrectPassword = "Test123";



    @BeforeClass
    public void SetUp(){
        open(siteURL);
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void loginTest(){

    }

}