package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChangeCountry {
    private final Page page = DriverFactory.getPage();
    private final HomePage homePage = new HomePage(page);


    @And("the user selects the new country for shopping <newCountry>")
    public void theUserSelectsANewCountry(String newCountry) {
//        homePage.userSelectsANewCountryForShopping(newCountry);
    }

    @And("the user verifies the selection")
    public void theUserVerifiesTheSelection() {
//        homePage.userVerifiesCountrySelection();
    }

    @Then("the user should see the country and currency updated to <newCountry> and <newCurrency>")
    public void theUserShouldSeeTheCountryAndCurrencyUpdated(String newCountry, String newCurrency) {
//        Map<String, Object> mapContentLocatorAndMessageOfUpdateCountry = homePage.UserSuccessfullyChangesCountry(newCountry, newCurrency);
//        assertThat((Locator) mapContentLocatorAndMessageOfUpdateCountry.get("locator"))
//                .containsText((String) mapContentLocatorAndMessageOfUpdateCountry.get("messageOfUpdatedCountry"));
    }

    @And("the user navigates to the PLP page")
    public void theUserNavigatesToThePLPPage() {
//        homePage.navigateToPLPPage();
    }

    @And("the user successfully accesses the PLP page for <newCountry>")
    public void theUserSuccessfullyAccessesThePLPPage(String newCountry) {
//        Locator plpPage = homePage.PLPAccesForTheCountry(newCountry);
//        assertThat(plpPage).isVisible();
    }
}
