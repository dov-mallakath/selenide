import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-05
 */
public class GooleSearchTest {

    private WebDriver webDriver;

    private String googleSearch = "http://www.google.com.ua/";
    private String searchTest = "Selenium";

    @Test
    public void searchTest(){
        //webDriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","/media/innos/WebDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(googleSearch);
        By searchLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchTest);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchTest));
        webDriver.quit();
        webDriver.close();
    }


}