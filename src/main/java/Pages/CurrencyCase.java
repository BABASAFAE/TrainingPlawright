/*package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import static Factory.DriverFactory.page;
import static utils.Locators.SelectCountryIcon;

public class CurrencyCase {
    private Page page;

    public CurrencyCase(Page page) {
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

    public void clickcountrylink() {
        Locator CountryShopping = page.locator(SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 20);
        CountryShopping.click();

    }

    public void chooseCountryForShopping(String country) throws InterruptedException {


        Locator inputCountryShopping = page.locator(Locators.loginSelectCountry);
        WebActions.waitUntilElementDisplayed(inputCountryShopping, 20);
        Locator chooseCountryShopping = page.locator(String.format(Locators.CountryIcon, country));


        inputCountryShopping.fill(country);
        chooseCountryShopping.click();


    }

    public void validatelink() throws InterruptedException {
        Locator validateCountryShopping = page.locator(Locators.btnStartShoping);
        WebActions.waitUntilElementDisplayed(validateCountryShopping, 20);
        validateCountryShopping.click();


    }

    public Locator verifyCountrySwitched() {
        Locator SwitchedCountryShopping = page.locator(Locators.countryswitcher);

        WebActions.waitUntilElementDisplayed(SwitchedCountryShopping, 30);
        return SwitchedCountryShopping;


    }

    public Locator verifyCurrencySwitched(){
        Locator switchedCurrencyShopping = page.locator(Locators.currencyheader);

        WebActions.waitUntilElementDisplayed(switchedCurrencyShopping, 30);
        return switchedCurrencyShopping;



    }
    public void shopNow(){
        Locator btnshopnow = page.locator(Locators.shopnow);

        WebActions.waitUntilElementDisplayed(btnshopnow, 30);
        btnshopnow.click();

    }
    public void addtobag(){
        Locator btnAddToBag = page.locator(Locators.btnaddtobag);

        WebActions.waitUntilElementDisplayed(btnAddToBag, 20);
        btnAddToBag.click();

    }
    public Locator AddToBagPopup(){
        Locator addtobagpopup = page.locator(Locators.popupproductadded);

        WebActions.waitUntilElementDisplayed(addtobagpopup, 20);
        return addtobagpopup;

    }
    public void clicktobagicon() throws InterruptedException {
        Locator IconBag = page.locator(Locators.iconbag);

        WebActions.waitUntilElementDisplayed(IconBag, 20);
        IconBag.click();


    }

    public Locator verifyErrorText(){
        Locator ErrorText = page.locator(Locators.errortext);

        WebActions.waitUntilElementDisplayed(ErrorText, 20);
        return ErrorText;

    }
}

*/
