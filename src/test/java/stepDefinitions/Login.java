package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

public class Login {
    private final Page page = DriverFactory.getPage();

    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() throws InterruptedException {
        Utils.logger.info("success step");
    }

    @And("the user select the Non EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) {
        HomePage homePage = new HomePage(page);
        homePage.accessToLogin();
        Utils.logger.info("success step");
    }

    @And("the user has accessed the login form")
    public void theUserHasAccessedTheLoginForm() {
        Utils.logger.info("success step");
    }

    @When("the user attempts to login")
    public void theUserAttemptsToLogin() {
        Utils.logger.info("success step");
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        Utils.logger.info("success step");
    }

    @And("the user access to the Account page")
    public void theUserAccessToTheAccountPage() {
        Utils.logger.info("success step");
    }
}
