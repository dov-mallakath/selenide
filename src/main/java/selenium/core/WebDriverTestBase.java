package selenium.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static util.PropertiesCache.getProperty;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */

@Listeners({TestListener.class})
public class WebDriverTestBase {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public DesiredCapabilities setDesiredCapabilities(String platform, String browserName){
        DesiredCapabilities caps = new DesiredCapabilities();
        if(platform.equalsIgnoreCase("LINUX")){
            caps.setPlatform(Platform.LINUX);
            caps.setBrowserName(browserName);
        }
        return caps;
    }

    @Parameters({"platform","browser"})
    @BeforeClass
    public void setUp(String platform, String browserName){
//        ChromeDriverManager.getInstance().setup();
//        Configuration.browser = WebDriverRunner.CHROME;
//        webDriver = new ChromeDriver();

//        DesiredCapabilities capabillities = DesiredCapabilities.chrome();
//        capabillities.setBrowserName("chrome");
//        capabillities.setPlatform(Platform.ANY);



        try {
            webDriver = new RemoteWebDriver(new URL("http://172.17.0.1:32768/wd/hub/"), setDesiredCapabilities(platform,browserName));
        }catch (Exception e){e.printStackTrace();}



//        PhantomJsDriverManager.getInstance().setup();
//        Configuration.browser = WebDriverRunner.PHANTOMJS;
//        webDriver = new PhantomJSDriver();
        wait = new WebDriverWait(webDriver, Integer.valueOf(getProperty("wait.explicit")));
        webDriver.manage().timeouts().implicitlyWait(Integer.valueOf(getProperty("wait.implicit")), SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(Integer.valueOf(getProperty("wait.pageLoad")), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Integer.valueOf(getProperty("wait.script")), TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}
