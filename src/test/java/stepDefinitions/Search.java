package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Locators;
import utils.Utils;
import com.microsoft.playwright.Locator;
import utils.WebActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Search {
    private final Page page = DriverFactory.getPage();

    @Given("the user is on the Fortnums and mason homepage")
    public void theUserIsOnTheFortnumsAndmasonHomepage() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.removeCookiePopup();
        Utils.logger.info("success step");
    }

    @And("the user click on search button")
    public void theUserClickOnSearchButton() {
        HomePage homePage = new HomePage(page);
        homePage.clickSearch();
        Utils.logger.info("success step");
    }

    @When("the user fill the search field by {}")
    public void theUserFillTheSearchFieldByCategory(String arg0) {
        HomePage homePage = new HomePage(page);
        homePage.Search(arg0);
        Utils.logger.info("success step");
    }

    @Then("the value searched should be the same as the value entered {}")
    public void theValueSearchedShouldBeTheSameAsTheValueEnteredCategory(String arg0) {
        Locator loc = page.locator(Locators.searchResult);
        WebActions.waitUntilElementDisplayed(loc, 2);
        PlaywrightAssertions.assertThat(loc).containsText(arg0);
    }
}
 


