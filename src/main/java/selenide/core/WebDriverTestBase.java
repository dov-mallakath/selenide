package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.PHANTOMJS;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class WebDriverTestBase {

//    private String browser = System.getProperty("browser",PHANTOMJS);
    private String browser = System.getProperty("browser","external");
    protected WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        switch (browser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.INTERNET_EXPLORER:
                InternetExplorerDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.PHANTOMJS:
                PhantomJsDriverManager.getInstance().setup();
                break;
            case "external":
                ChromeDriverManager.getInstance().setup();
                System.setProperty("webdriver.chrome.driver", ChromeDriverManager.getInstance().getBinaryPath());

                DesiredCapabilities capabillities = DesiredCapabilities.chrome();
                capabillities.setBrowserName("chrome");
                capabillities.setPlatform(Platform.ANY);
                try {
                    webDriver = new RemoteWebDriver(new URL("http://172.17.0.1:32768/wd/hub/"), capabillities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        if (browser.equals("external")) {
            Configuration.browser = CHROME;
            WebDriverRunner.setWebDriver(webDriver);
            WebDriverRunner.getAndCheckWebDriver();
        } else {
            Configuration.browser = browser;
            webDriver = WebDriverRunner.getWebDriver();
        }
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}
