import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class StylusSmartphoneSearch {

    private WebDriver webDriver;

    private String link = "http://stylus.com.ua/";
    private String searchInputXpath = ".//input[@name='q']";
    private String searchButtonXpath = ".//input[@type='submit']";
    private List<WebElement> links = new ArrayList<>();
    private List<WebElement> linksMatched = new ArrayList<>();
    private String linksXpath = ".//a[@class='product-link']";

    private String queryString = "Sony Z2";

    @BeforeClass
    public void setupWebDriver(){
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(15, SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(link);
    }

    @AfterClass
    public void quitWebDriver(){
        webDriver.quit();
    }

    @Test
    public void aOpenStylusPage(){
        By inputField = By.xpath(searchInputXpath);
        assertTrue(webDriver.findElement(inputField).isDisplayed());
    }

    @Test
    public void bEnterTheSearchQuery(){
        By inputField = By.xpath(searchInputXpath);
        webDriver.findElement(inputField).sendKeys(queryString);
        assertTrue(webDriver.findElement(By.xpath(searchInputXpath)).getAttribute("value").equals(queryString));
    }

    @Test
    public void cSearchTheQuery(){
        By searchButton = By.xpath(searchButtonXpath);
        webDriver.findElement(searchButton).click();
        assertTrue(webDriver.getCurrentUrl().contains(queryString.split(" ")[0]));
    }

    @Test
    public void dFindLinks(){
        By linksLocator = By.xpath(linksXpath);
        links = webDriver.findElements(linksLocator);
        assertTrue(!links.isEmpty());
        for (WebElement linkE : links) {
            if(linkE.isDisplayed()&&(linkE.getText().contains(queryString.split(" ")[0])&&linkE.getText().contains(queryString.split(" ")[1]))){
                linksMatched.add(linkE);
            }
        }
        assertTrue(!linksMatched.isEmpty());
    }

    @Test
    public void dFollowFirstLink(){
        linksMatched.get(0).click();
        assertTrue(webDriver.findElement(By.xpath(".//h1")).getText().contains(queryString.split(" ")[0]));
        assertTrue(webDriver.findElement(By.xpath(".//h1")).getText().contains(queryString.split(" ")[1]));
    }
}
