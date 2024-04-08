package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;
import com.microsoft.playwright.Locator;
import utils.WebActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Login {
    private final Page page = DriverFactory.getPage();
    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.removeCookiePopup();
        Utils.logger.info("success step");
    }
    @And("the user select the Non EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.chooseCountryForShopping(arg0);
        Utils.logger.info("success step");
    }
    @And("the user has accessed the login form")
    public void theUserHasAccessedTheLoginForm() throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.accessToLogin();
        Utils.logger.info("success step");
    }
    @When("the user attempts to login")
    public void theUserAttemptsToLogin() throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.PageLogin();
        Utils.logger.info("success step");
    }
    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        HomePage homePage=new HomePage(page);
        Locator locator=homePage.SuccesLogin();
        WebActions.waitUntilElementDisplayed(locator, 5);
        assertThat(locator).isVisible();
        Utils.logger.info("is logged successful");
    }
    @And("the user access to the Account page")
    public void theUserAccessToTheAccountPage() {
        HomePage homePage=new HomePage(page);
        homePage.AccountPage();
        Utils.logger.info("success step");
    }
}