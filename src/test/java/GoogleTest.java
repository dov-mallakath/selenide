import org.junit.Ignore;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;
import selenide.pages.GoogleSearchPage;
import selenide.pages.GoogleSearchResultPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-12
 */
public class GoogleTest extends WebDriverTestBase{

    private String google = "http://www.google.com/ncr";
    private String searchText = "selenide";

    @Test
    public void searchInGoogleTest(){
        open(google);
        By searchLocator = By.xpath(".//*[@name='q']");
        $(searchLocator).val(searchText).pressEnter();
        $$("#ires .g").shouldHaveSize(10);
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org")
        );
    }

    @Test
    public void searchInGoogleWithPageObjectTest(){
        given:
        open(google);
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        when:
//        googleSearchPage.searchFor(searchText).clickSearch();
        googleSearchPage.searchFor(searchText,"btnG","name");
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();
        then:
        googleSearchResultPage.getLinkResults().shouldHaveSize(10).first().shouldHave(text("Selenide: concise UI tests in Java"),text("selenide.org"));
    }
}
