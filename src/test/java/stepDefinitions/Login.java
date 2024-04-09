package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login {
    private final Page page = DriverFactory.getPage();
    private final HomePage homePage=new HomePage(page);

    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() throws InterruptedException {
        homePage.removeCookiePopup();
        Utils.logger.info("success step");
    }

    @And("the user select the Non EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) throws InterruptedException {
        Thread.sleep(50);
        homePage.chooseCountryForShopping(arg0);
    }

    @And("the user has accessed the login form")
    public void theUserHasAccessedTheLoginForm()  {
       homePage.accessToLoginForm();
    }

    @When("the user attempts to login")
    public void theUserAttemptsToLogin() throws InterruptedException {
       homePage.accessToLogin();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
       Locator locator=homePage.popUpOfSuccessfullyLoged();
        assertThat(locator).isVisible();
        Utils.logger.info("is logged successful");
    }

    @And("the user access to the Account page")
    public void theUserAccessToTheAccountPage() throws InterruptedException {

        Locator loginIconLocator=homePage.accessToAccount();
        loginIconLocator.click();

    }
}
