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

public class AddToWishList {

    private final Page page = DriverFactory.getPage();

    @And("the user delete all product from wish list")
    public void theUserDeleteAllProductFromWishList() throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.DeleteAllProductFromWishList();
        Utils.logger.info(" delete add with succ");
    }
    @When("the user choose the category {string}")
    public void theUserChooseTheCategory(String arg0) throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.chooseCategoryForShopping(arg0);
        Utils.logger.info("chose catgory with succ");
    }



    @Then("the user select the subcategory {string}")
    public void theUserSelectTheSubcategory(String arg0) throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.chooseSubCategory(arg0);
        Utils.logger.info("choose subcatgory with succ");

    }


    @And("the user add the product into wish list")
    public void theUserAddTheProductIntoWishList() throws InterruptedException {
        HomePage homePage=new HomePage(page);
        homePage.addToWishList();
        Utils.logger.info("choose subcatgory with succ");
    }

    @Then("the product is successfully added")
    public void theProductIsSuccessfullyAdded() throws InterruptedException {
        HomePage homePage=new HomePage(page);
        Locator locator = homePage.addSucess();
        assertThat(locator).isVisible();
        Utils.logger.info(" subcatgory add with succ");
    }


}

