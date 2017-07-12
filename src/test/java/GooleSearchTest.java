import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-05
 */
public class GooleSearchTest extends WebDriverTestBase {

    private String googleSearch = "http://www.google.com.ua/";
    private String searchTest = "Selenium";

    @Test
    public void searchTest(){
        //webDriver = new FirefoxDriver();
        System.setProperty("log4j.debug", "");
        webDriver.get(googleSearch);
        By searchLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchTest);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        //By linksLocator = By.ByTagName.tagName("a");
        By linksLocator = By.xpath(".//*[@class='r']");
        List<WebElement> links = webDriver.findElements(linksLocator);

        assertTrue(!links.isEmpty());
        System.out.println(links.size());
        for (WebElement linkE : links) {
            if(linkE.isDisplayed()&&(linkE.getText().contains("selenium")||linkE.getText().contains("Selenium"))){
                System.out.println(linkE.getText());
            }
        }


        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchTest));
    }


}
