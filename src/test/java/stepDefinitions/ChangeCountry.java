package stepDefinitions;

import Factory.DriverFactory;
import Pages.BasketPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChangeCountry {
    private final Page page = DriverFactory.getPage();
    private final BasketPage basketPage = new BasketPage(page);


    @And("the user hovers over the category {}")
    public void theUserHoversOverTheCategory(String category) {
        basketPage.hoversEverTheCategory(category);
    }

    @And("the user chooses a subcategory {}")
    public void theUserChoosesSubcategory(String subcategory) {
        basketPage.chooseSubCategory(subcategory);
    }

    @And("the user adds a product to the bag")
    public void theUserAddProductToTheBag() {
        basketPage.addProdcutToTheBag();
    }

    @And("the user go to the bag")
    public void theUserGoToTheBag() {
        basketPage.userGoToTheBag();
    }

    @And("the user selects the new country {} for shopping from the the dropdown in basket")
    public void theUserVerifiesTheSelection(String country) {
        basketPage.selectNewCountryFromDropDown(country);
    }

    @Then("the user verifies the selected product with the error message stating that the product can't be delivered to the selected country")
    public void theUserVerifiesTheSelectedProductWithTheErrorMessage() {
        basketPage.messageOfCantDeliver();
    }

    @And("the header displays the updated country and currency")
    public void theHeaderDisplaysTheUpdatedCountryAndCurrency() {
    }

    @When("the user accesses the country and currency switcher")
    public void theUserAccessesTheCountryAndCurrencySwitcher() {
    }

    @And("chooses another country Australia and currency United States \\/ $ USD")
    public void choosesAnotherCountryAustraliaAndCurrencyUSD() {
    }

    @And("validates the selection")
    public void validatesTheSelection() {
    }

    @And("navigates to the PLP page")
    public void navigatesToThePLPPage() {
    }

    @Then("the PLP page displays the chosen country Australia and currency United States \\/ $ USD")
    public void theChosenCountryAustraliaAndCurrencyUSD() {
    }
}
