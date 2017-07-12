import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class GoogleTest extends WebDriverTestBase{

    private WebDriverWait wait;

    private String google = "http://www.google.com/ncr";
    private String searchText = "selenide";

    @Test
    public void searchInGoogle(){
        open(google);
        By searchLocator = By.id("lst-ib");
        $(searchLocator).val(searchText).pressEnter();
        $$("#ires .g").shouldHaveSize(10);
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org")
        );
    }
}
