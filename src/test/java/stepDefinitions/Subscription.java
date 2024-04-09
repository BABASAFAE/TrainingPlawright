package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

import java.util.Map;

public class Subscription {
    private final Page page = DriverFactory.getPage();
    @And("the user has accessed the subscription form")
    public void theUserHasAccessedTheSubscriptionForm() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.SubscriptionForm();
        Utils.logger.info("success step");
    }
    @When("the user attempts to subscribe")
    public void theUserAttemptsToSubscribe() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.InsertEmail();
        Utils.logger.info("success step");
    }
    @And("the user selects a country where he lives")
    public void theUserSelectsACountryWhereHeLives() {
        HomePage homePage = new HomePage(page);
        homePage.selectCountry();
        Utils.logger.info("success step");
    }
    @And("The user selects what they are most excited to hear about in the world of Fortnum's")
    public void theUserSelectsWhatTheyAreMostExcitedToHearAboutInTheWorldOfFortnumS() {
        HomePage homePage = new HomePage(page);
        homePage.WorldFortnum();
        Utils.logger.info("success step");
    }
    @And("The user selects a Fortnums product to take to the desert island")
    public void theUserSelectsAFortnumSProductToTakeToTheDesertIsland() {
        HomePage homePage = new HomePage(page);
        homePage.fortnumProduct();
        Utils.logger.info("success step");
    }
    @And("the user clicks on Sign Up")
    public void theUserClicksOnSignUp() {
        HomePage homePage = new HomePage(page);
        homePage.ClickSignUp();
        Utils.logger.info("success step");
    }
    @Then("the user has successfully subscribed")
    public void theUserHasSuccessfullySubscribed() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        Map<String, Locator> stringLocatorMap = homePage.retrievesuccessfullySubscribed();
        PlaywrightAssertions.assertThat(stringLocatorMap.get("popupSuccessSubscribe")).isVisible();
        PlaywrightAssertions.assertThat(stringLocatorMap.get("messageSuccessSubscribe")).isVisible();
        Utils.logger.info("success step");
    }
}
