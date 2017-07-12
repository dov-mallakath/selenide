package selenium.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class WebDriverTestBase {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 60);
        webDriver.manage().timeouts().implicitlyWait(15, SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}
