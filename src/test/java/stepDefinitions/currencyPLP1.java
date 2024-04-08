package stepDefinitions;

import Factory.DriverFactory;
import Pages.CurrencyCheckPLP;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class currencyPLP1 {
    private final Page page = DriverFactory.getPage();
    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() throws InterruptedException {
        CurrencyCheckPLP c=new CurrencyCheckPLP(page);
        c.removeCookiePopup();
        Utils.logger.info("success step");

    }

    @And("the user click on country link")
    public void theUserClickOnCountryLink() {


    }

    @And("the user select the Non EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) throws InterruptedException {
        CurrencyCheckPLP c=new CurrencyCheckPLP(page);
        c.chooseCountryForShopping1(arg0);
        Utils.logger.info("success step");

    }



    @And("the user validate his choose go to PLP page")
    public void theUserValidateHisChooseGoToPLPPage() throws InterruptedException {
        CurrencyCheckPLP c=new CurrencyCheckPLP(page);
        c.validatelink1();
        Utils.logger.info("success step");

    }

    @Then("the chosen country should be the same as the country selected")
    public void theChosenCountryShouldBeTheSameAsTheCountrySelected() {
        CurrencyCheckPLP c=new CurrencyCheckPLP(page);
        assertThat(c.verifyCountrySwitched1()).isVisible();
        Utils.logger.info("success step");

    }

    @And("the chosen currency should be the same as the currency selected")
    public void theChosenCurrencyShouldBeTheSameAsTheCurrencySelected() {
        CurrencyCheckPLP c=new CurrencyCheckPLP(page);
        assertThat(c.verifycurrencyswitched1()).isVisible();
        Utils.logger.info("success step");
    }



}
