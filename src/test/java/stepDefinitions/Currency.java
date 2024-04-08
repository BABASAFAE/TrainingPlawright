package stepDefinitions;

import Factory.DriverFactory;
import Pages.CurrencyCase;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Currency {
    private final Page page = DriverFactory.getPage();
    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() throws InterruptedException {
        CurrencyCase currency = new CurrencyCase(page);
        currency.removeCookiePopup();
        Utils.logger.info("success step");
    }
    @And("the user click on country link")
    public void theUserClickOnCountryLink(){
        CurrencyCase currency = new CurrencyCase(page);
        currency.clickcountrylink();
        Utils.logger.info("success step");
    }
    @And("the user select the Non EU country switcher {}")
    public void theUserSelectTheNonEUCountrySwitcher(String arg0) throws InterruptedException {
        CurrencyCase currency = new CurrencyCase(page);
        currency.chooseCountryForShopping(arg0);
        Utils.logger.info("success step");
    }

    @And("the user validate his choose go to PLP page")
    public void theUserValidateHisChooseGoToPLPPage() throws InterruptedException {
        CurrencyCase currency = new CurrencyCase(page);
        currency.validatelink();
        Utils.logger.info("success step");
    }

    @Then("the user check the chosen country")
    public void theUserCheckTheChosenCountry() {
        CurrencyCase currency = new CurrencyCase(page);
        assertThat(currency.verifyCountrySwitched()).isVisible();
        Utils.logger.info("success step");
    }

    @And("the user check the chosen currency")
    public void theUserCheckTheChosenCurrency() {
        CurrencyCase currency = new CurrencyCase(page);
        assertThat(currency.verifyCurrencySwitched()).isVisible();
        Utils.logger.info("success step");
    }

    @And("the user click on shp now button")
    public void theUserClickOnShpNowButton() {
        CurrencyCase currency = new CurrencyCase(page);
        currency.shopNow();
        Utils.logger.info("success step");

    }

    @And("the user add product to bag")
    public void theUserAddProductToBag() {
        CurrencyCase currency = new CurrencyCase(page);
        currency.addtobag();
        Utils.logger.info("success step");

    }
    @Then("a pop-up is displayed")
    public void aPopUpIsDisplayed() {

        CurrencyCase currency = new CurrencyCase(page);
        assertThat(currency.AddToBagPopup()).isVisible();
        Utils.logger.info("success step");

    }
    @When("the user click to bag icon")
    public void theUserClickToBagIcon() throws InterruptedException {
        CurrencyCase currency = new CurrencyCase(page);
        currency.clicktobagicon();
        Utils.logger.info("success step");


    }

    @And("an error text is displayed on the bag")
    public void anErrorTextIsDisplayedOnTheBag() {
        CurrencyCase currency = new CurrencyCase(page);
        assertThat(currency.verifyErrorText()).containsText("Unfortunately, it looks like one or more products in your basket can't be delivered to your area at the moment.");
        Utils.logger.info("success step");
    }


}
