package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import utils.ConfigReader;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.util.List;
import java.util.Map;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
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


    public void chooseCountryForShopping(String country) throws InterruptedException {
        Locator CountryShopping = page.locator(Locators.SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 20);

        Locator inputCountryShopping = page.locator(Locators.loginSelectCountry);
        Locator chooseCountryShopping = page.locator(Locators.CountryIcon);
        Locator validateCountryShopping = page.locator(Locators.btnStartShoping);
        CountryShopping.click();
        inputCountryShopping.fill(country);
        chooseCountryShopping.click();
        validateCountryShopping.click();

    }


    public void accessToLogin() throws InterruptedException {
        Locator loginIconLocator = page.locator(Locators.loginIcon);

        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();


    }

    public void PageLogin() throws InterruptedException {
        Locator inputemail=page.locator(Locators.EmailField);
        WebActions.waitUntilElementDisplayed(inputemail, 20);
        Locator inputpwd=page.locator(Locators.PwdField);
        Locator inputlog=page.locator(Locators.logbutton);
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            String password = row.get("password");
            WebActions.waitUntilElementDisplayed(inputemail, 10);
            inputemail.fill(emailValid);
            inputpwd.fill(password);
            inputlog.click();
        }


    }
    public Locator SuccesLogin() {
        return page.locator(Locators.TestSucces);
    }
    public void AccountPage(){
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();
    }
    public void clickSearch(){
        Locator searchIconLocator = page.locator(Locators.searchButton);
        WebActions.waitUntilElementDisplayed(searchIconLocator, 20);
        searchIconLocator.click();
    }
    public void Search(String category){

        Locator searchFieldLocator = page.locator(Locators.searchField);
        WebActions.waitUntilElementDisplayed(searchFieldLocator, 5);
        searchFieldLocator.fill(category);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.keyboard().press("Enter");    }
public void searchResult(String category){
    Locator searchResultLocator = page.locator(Locators.searchResult);
    WebActions.waitUntilElementDisplayed(searchResultLocator, 20);
    searchResultLocator.fill(category);
}
}