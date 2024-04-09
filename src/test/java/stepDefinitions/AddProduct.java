package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;


public class AddProduct {
    private final Page page = DriverFactory.getPage();
    private final HomePage homePage = new HomePage(page);
    static String priceFromPLP;
    static String priceFromBasket;

    static String quantite;

    static double total;


    @When("the user hover the Gategory {string}")
    public void theUserHoverTheGategory(String arg0) throws InterruptedException {
        homePage.userHoverTheCategory(arg0);
        Utils.logger.info("success step");

    }

    @And("the user choose the sub Category {string}")
    public void theUserChooseTheSubCategory(String arg0) throws InterruptedException {
        homePage.userChooseTheSubCategory(arg0);
        Utils.logger.info("success step");
    }

    @Then("the user choose the product {string}")
    public void theUserChooseTheProduct(String arg0) throws InterruptedException {
        priceFromPLP = homePage.retrieveProductPrice(arg0);
        Utils.logger.info("success step");

    }

    @And("the user add product to bag {string}")
    public void theUserAddProductToBag(String arg0) throws InterruptedException {
        homePage.addProduct(arg0);
        Utils.logger.info("success step");
    }


    @And("the user check his basket")
    public void theUserCheckHisBasket() throws InterruptedException {
        priceFromBasket = homePage.checkbag();
        Utils.logger.info("success step");
    }

    @And("the user add quantity")
    public void theUserAddQuantity() {
        homePage.addQuantity();
        Utils.logger.info("success step");

    }

    @Then("the prices should be consistent")
    public void thePricesShouldBeConsistent() throws InterruptedException {
        homePage.checkprices();
        assert (priceFromBasket.equals(priceFromPLP));
        Utils.logger.info("success step");
    }

    @Then("the price should be equal to the total")
    public void thePriceShouldBeEqualToTheTotal() {
        //homePage.checkTotal();
        Utils.logger.info("inside");
        double price = Double.parseDouble(priceFromBasket);
        double quantity = Double.parseDouble(homePage.quantityValue());
        double total = Double.parseDouble(homePage.checkTotal());
        Utils.logger.info("Price" + priceFromBasket);
        //quantite=homePage.quantityValue();
        Utils.logger.info("quantity" + quantite);
        Utils.logger.info("total" + homePage.checkTotal());
        page.waitForTimeout(1000);
        assert (total == price * quantity);
    }
}
