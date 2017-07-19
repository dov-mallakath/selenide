import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertTrue;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class AlertBoxSelenide extends WebDriverTestBase {

    @FindBy(xpath = "html/body/button")
            private WebElement tryItButton;
    @FindBy(id = "demo")
            private WebElement fieldResult;

    String webPageForW3 = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    @BeforeClass
    public void SetUpClass(){
        open(webPageForW3);
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void testToAlert() {
        open(webPageForW3);
        switchTo().frame("iframeResult");
        tryItButton.click();
        switchTo().alert().dismiss();

        assertTrue(fieldResult.getText().equals("You pressed Cancel!"));
    }

}
