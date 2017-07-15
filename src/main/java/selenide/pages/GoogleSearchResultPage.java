package selenide.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-07-15
 */
public class GoogleSearchResultPage {

    private ElementsCollection linkResults =  $$("#ires .g");

    public ElementsCollection getLinkResults() {
        return linkResults;
    }
}
