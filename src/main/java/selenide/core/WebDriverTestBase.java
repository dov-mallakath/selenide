package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.WebDriverRunner.CHROME;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class WebDriverTestBase {

    private String browser = System.getProperty("browser",CHROME);

    @BeforeClass
    public void setUp(){
        switch (browser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.INTERNET_EXPLORER:
                InternetExplorerDriverManager.getInstance().setup();
                break;

        }
        Configuration.browser = browser;
        //Configuration.holdBrowserOpen = true;
    }

    @AfterClass
    public void tearDown(){

    }
}
