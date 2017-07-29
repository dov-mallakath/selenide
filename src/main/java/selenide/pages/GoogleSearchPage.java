package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;
import util.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class GoogleSearchPage extends AbstractPage{

    private SelenideElement search = $(By.name("q"));

    public GoogleSearchPage searchFor(String searchText){
        search.val(searchText);
        return this;
    }

    @Step("Searches for {0} text")
    public GoogleSearchPage searchFor(String searchText, String locator, String type){
        search.val(searchText);
        jsClick(locator,type);
        return this;
    }

    public GoogleSearchPage clickSearch(){
        search.pressEnter();

        return this;
    }

}
