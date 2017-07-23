import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class AlertBoxSelenideTest extends WebDriverTestBase {

    private SelenideElement tryItButton = $(By.xpath("html/body/button"));
    private SelenideElement fieldResult = $(By.id("demo"));

    String webPageForW3 = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    @BeforeClass
    public void SetUpClass(){
        open(webPageForW3);
    }

    @Test
    public void testToAlert() {
        switchTo().frame("iframeResult");
        tryItButton.click();
        switchTo().alert().dismiss();

        assertTrue(fieldResult.getText().equals("You pressed Cancel!"));
    }

}
