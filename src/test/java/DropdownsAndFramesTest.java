import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-19
 */
public class DropdownsAndFramesTest extends WebDriverTestBase {

    final static private String URL = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";

    private SelenideElement iframe = $(By.xpath(".//*[@name=\"iframeResult\"]"));
    private SelenideElement select = $(By.xpath("html/body/select"));

    @BeforeClass
    public void SetUpClass(){
        open(URL);
    }

    @Test
    public void testDropdown(){
        String volvo = "Volvo";
        String opel = "Opel";
        //webDriver.switchTo().frame(iframe);
        switchTo().frame(iframe);
        //webDriver.switchTo().frame("iframeResult");
        select.selectOption(volvo);
        select.getSelectedOption().shouldHave(text(volvo));
        select.selectOption(opel);
        select.getSelectedOption().shouldHave(text(opel));
        //Select select = new Select($(By.xpath("html/body/select")));
//        for(WebElement option:select){
//            System.out.printf(option.getText());
//        }



    }

}