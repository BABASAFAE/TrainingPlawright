package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import static utils.Locators.SelectCountryIcon;

public class CurrencyCheckPLP {
    private Page page;
    public  CurrencyCheckPLP(Page page){
        this.page = page;
    }
    public void removeCookiePopup() throws InterruptedException {

        try {
            Locator BTNACCEPT = page.locator(Locators.btnAcceptAll);
            WebActions.waitUntilElementDisplayed(BTNACCEPT, 20);
            BTNACCEPT.click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        } catch (PlaywrightException e) {
            Utils.logger.info("Exception occurred: " + e.getMessage());
        }

    }
    public void clickcountrylink1() {
        Locator CountryShopping = page.locator(SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 20);
        CountryShopping.click();

    }

    public void chooseCountryForShopping1(String country) throws InterruptedException {


        Locator inputCountryShopping = page.locator(Locators.loginSelectCountry);
        WebActions.waitUntilElementDisplayed(inputCountryShopping, 20);

        Locator chooseCountryShopping = page.locator(String.format(Locators.CountryIcon, country));


        inputCountryShopping.fill(country);
        chooseCountryShopping.click();


    }
    public void validatelink1() throws InterruptedException {
        Locator validateCountryShopping = page.locator(Locators.btnStartShoping);
        WebActions.waitUntilElementDisplayed(validateCountryShopping, 20);
        validateCountryShopping.click();


    }
    public Locator verifyCountrySwitched1() {
        Locator SwitchedCountryShopping = page.locator(Locators.countrytext);

        WebActions.waitUntilElementDisplayed(SwitchedCountryShopping, 30);
        return SwitchedCountryShopping;


    }
    public Locator verifycurrencyswitched1(){
        Locator category = page.locator(Locators.category);
        Locator product = page.locator(Locators.product);
        Locator price = page.locator(Locators.price);
        category.hover();
        WebActions.waitUntilElementDisplayed(product, 30);
        product.click();
        WebActions.waitUntilElementDisplayed(price, 30);
        return price;



    }
}
