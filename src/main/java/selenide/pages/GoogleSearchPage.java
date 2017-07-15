package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class GoogleSearchPage {

    private SelenideElement search = $(By.id("lst-ib"));

    public GoogleSearchPage searchFor(String searchText){
        search.val(searchText);
        return this;
    }

    public GoogleSearchPage clickSearch(){
        search.pressEnter();
        return this;
    }

}
