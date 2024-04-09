package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Subscribe {
    private final Page page = DriverFactory.getPage();
    private final HomePage homePage = new HomePage(page);

    @And("the user select the EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) throws InterruptedException {
        Thread.sleep(50);
        homePage.chooseCountryForShopping(arg0);
    }

    @And("the user has accessed the sign-up bloc")
    public void theUserHasAccessedTheSignUpBloc() {
        homePage.UserHasAccessedTheSignUpBloc();
    }

    @When("the user inserts a valid email and attempts to subscribe")
    public void theUserInsertsAValidEmailAndAttemptsToSubscribe() {
        homePage.userInsertsAValidEmailAndAttemptsToSubscribe();
    }

    @And("the user selects the country where they live {}")
    public void theUserSelectsTheCountryWhereTheyLive(String country) {
        homePage.userSelectTheCoubtryWhereLive(country);
    }

    @And("the user selects the most exciting topic from the world of Fortnums {}")
    public void theUserSelectsTheFortnumTopicFromTheWorldOfFortnums(String fortnumTopic) {
    homePage.userSelectTheFortnumTopicFromTheWorldOfFortnums(fortnumTopic);
    }

    @And("the user selects the Fortnums product {} they would take to a desert island")
    public void theUserSelectsTheFortnumsProduct(String product) {
    homePage.userSelectsTheFortnumsProduct(product);
    }

    @And("the user attemps to subscribe")
    public void theUserAttemptsToSubscribe() {
        homePage.attemptToSubscribe();
    }

    @Then("a confirmation popup is displayed")
    public void aConfirmationPopupIsDisplayed() {
        Locator locatorOfPopup = homePage.confirmationPopupIsDisplayed();
        assertThat(locatorOfPopup).isVisible();
    }

    @And("the user is successfully subscribed")
    public void theUserIsSuccessfullySubscribed() {
        Locator messageOfSuccessfullySubscribed = homePage.userIsSuccessfullySubscribed();
        Utils.logger.info("------------------" + messageOfSuccessfullySubscribed.textContent());
        //assertThat(messageOfSuccessfullySubscribed).containsText("Thank you for your subscription.");
        assertThat(messageOfSuccessfullySubscribed).containsText("Thank you for your subscription.");
    }
}
